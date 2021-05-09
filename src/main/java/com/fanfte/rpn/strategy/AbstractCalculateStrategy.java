package com.fanfte.rpn.strategy;

import com.fanfte.rpn.CalculatedProcess;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public abstract class AbstractCalculateStrategy {

    public AbstractCalculateStrategy(Deque<String> stack, Deque<Deque<String>> snapShots) {
        this.stack = stack;
        this.snapShots = snapShots;
    }

    protected Deque<String> stack;

    protected Deque<Deque<String>> snapShots;

    public abstract BigDecimal calculate(List<BigDecimal> nums);

    public abstract int getNumCount();
}
