package com.fanfte.rpn;

import com.fanfte.rpn.enums.OperatorEnums;
import com.fanfte.rpn.strategy.*;
import com.fanfte.rpn.utils.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Calculator {

    private final Deque<String> stack;

    private Deque<Deque<String>> snapShots;

    private final Map<String, AbstractCalculateStrategy> operatorStrategyMap;

    public Deque<String> getStack() {
        return stack;
    }

    public Calculator() {
        stack = new LinkedList<>();

        snapShots = new LinkedList<>();

        operatorStrategyMap = new HashMap<>();
        operatorStrategyMap.put(OperatorEnums.ADD.getOperator(), new AddStrategy(stack, snapShots));
        operatorStrategyMap.put(OperatorEnums.SUBTRACT.getOperator(), new SubtractStrategy(stack, snapShots));
        operatorStrategyMap.put(OperatorEnums.MULTIPLY.getOperator(), new MultiplyStrategy(stack, snapShots));
        operatorStrategyMap.put(OperatorEnums.DIVIDE.getOperator(), new DivideStrategy(stack, snapShots));
        operatorStrategyMap.put(OperatorEnums.SQRT.getOperator(), new SqrtStrategy(stack, snapShots));
        operatorStrategyMap.put(OperatorEnums.UNDO.getOperator(), new UndoStrategy(stack, snapShots));
        operatorStrategyMap.put(OperatorEnums.CLEAR.getOperator(), new ClearStrategy(stack, snapShots));
    }

    public void calculate(String[] elements) {
        for (int i = 0; i < elements.length; i++) {
            if (NumberUtils.isNumeric(elements[i])) {
                // deal with nums
                stack.offerLast(elements[i]);
                snapShots.offerLast(new LinkedList<>(stack));
            } else {
                // deal with operator
                doCalculateWithOperator(elements[i], i);
            }
        }
        printStackResult();
    }

    private void doCalculateWithOperator(String operator, int index) {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException();
        }

        AbstractCalculateStrategy strategy = operatorStrategyMap.get(operator);
        if (strategy == null) {
            throw new IllegalArgumentException("Operator not supported.");
        }
        int operatorNums = strategy.getNumCount();

        if (operatorNums > stack.size()) {
            String warning = String.format("operator %s (position: %d): insufficient parameters", operator, index);
            System.out.println(warning);
            throw new IllegalArgumentException("No more elements.");
        }

        List<BigDecimal> nums = buildOperateNums(operatorNums);

        strategy.calculate(nums);
    }

    private List<BigDecimal> buildOperateNums(int operatorNums) {
        List<BigDecimal> nums = new LinkedList<>();
        for (int i = 0; i < operatorNums; i ++ ) {
            if (stack.isEmpty()) {
                throw new IllegalArgumentException("No more elements.");
            }
            String aim = stack.pollLast();
            if (!NumberUtils.isNumeric(aim)) {
                throw new IllegalArgumentException("Operator not supported.");
            }
            nums.add(0, new BigDecimal(aim));
        }
        return nums;
    }

    /**
     * print elements in the stack
     */
    private void printStackResult() {
        System.out.print("stack: ");
        if (stack.isEmpty()) {
            System.out.print("");
        }
        for (String next : stack) {
            if (next.contains(".") && NumberUtils.isNumeric(next)) {
                System.out.print(new BigDecimal(next).setScale(10, RoundingMode.FLOOR) + " ");
            } else {
                System.out.print(next + " ");
            }
        }
        System.out.println();
    }

}
