package com.fanfte.rpn.strategy;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.List;

public class UndoStrategy extends AbstractCalculateStrategy {

    public UndoStrategy(Deque<String> stack, Deque<Deque<String>> snapShots) {
        super(stack, snapShots);
    }

    @Override
    public BigDecimal calculate(List<BigDecimal> nums) {
        snapShots.removeLast();
        stack.clear();
        stack.addAll(snapShots.getLast());
        return null;
    }

    @Override
    public int getNumCount() {
        return 0;
    }
}
