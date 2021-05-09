package com.fanfte.rpn.strategy;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SqrtStrategy extends AbstractCalculateStrategy {

    public SqrtStrategy(Deque<String> stack, Deque<Deque<String>> snapShots) {
        super(stack, snapShots);
    }

    @Override
    public BigDecimal calculate(List<BigDecimal> nums) {
        BigDecimal result = new BigDecimal(String.valueOf(Math.sqrt(nums.get(0).doubleValue())));
        stack.offerLast(result.toString());
        snapShots.offerLast(new LinkedList<>(stack));
        return result;
    }

    @Override
    public int getNumCount() {
        return 1;
    }
}
