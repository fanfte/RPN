package com.fanfte.rpn.strategy;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DivideStrategy extends AbstractCalculateStrategy {

    public DivideStrategy(Deque<String> stack, Deque<Deque<String>> snapShots) {
        super(stack, snapShots);
    }

    @Override
    public BigDecimal calculate(List<BigDecimal> nums) {
        BigDecimal result = nums.get(0).divide(nums.get(1), BigDecimal.ROUND_FLOOR).setScale(15, BigDecimal.ROUND_FLOOR);
        stack.offerLast(result.toString());
        snapShots.offerLast(new LinkedList<>(stack));
        return result;
    }

    @Override
    public int getNumCount() {
        return 2;
    }
}
