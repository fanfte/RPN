package com.fanfte.rpn.strategy;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SubtractStrategy extends AbstractCalculateStrategy {

    public SubtractStrategy(Deque<String> stack, Deque<Deque<String>> snapShots) {
        super(stack, snapShots);
    }

    @Override
    public BigDecimal calculate(List<BigDecimal> nums) {
        BigDecimal result = nums.get(0).subtract(nums.get(1));
        stack.offerLast(result.toString());
        snapShots.offerLast(new LinkedList<>(stack));
        return result;
    }

    @Override
    public int getNumCount() {
        return 2;
    }
}
