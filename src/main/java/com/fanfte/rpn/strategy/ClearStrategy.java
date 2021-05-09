package com.fanfte.rpn.strategy;

import com.fanfte.rpn.CalculatedProcess;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ClearStrategy extends AbstractCalculateStrategy {


    public ClearStrategy(Deque<String> stack, Deque<Deque<String>> snapShots) {
        super(stack, snapShots);
    }

    @Override
    public BigDecimal calculate(List<BigDecimal> nums) {
        stack.clear();
        snapShots.offerLast(new LinkedList<>(stack));
        return null;
    }

    @Override
    public int getNumCount() {
        return 0;
    }
}
