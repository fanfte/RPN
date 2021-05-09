package com.fanfte.rpn.strategy;


import com.fanfte.rpn.CalculatedProcess;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class AddStrategy extends AbstractCalculateStrategy {


    public AddStrategy(Deque<String> stack, Deque<Deque<String>> snapShots) {
        super(stack, snapShots);
    }

    @Override
    public BigDecimal calculate(List<BigDecimal> nums) {
        BigDecimal result = nums.get(0).add(nums.get(1));
        stack.offerLast(result.toString());
        snapShots.offerLast(new LinkedList<>(stack));
        return result;
    }

    @Override
    public int getNumCount() {
        return 2;
    }
}
