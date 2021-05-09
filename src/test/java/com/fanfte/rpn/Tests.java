package com.fanfte.rpn;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {

    private Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void test1() {
        System.out.println("Example 1");
        String[] strs = new String[] {"5", "2"};
        calculator.calculate(strs);

        Assert.check(calculator.getStack().size() == 2);
    }

    @Test
    public void test2() {
        System.out.println("Example 2");
        String[] strs = new String[] {"2", "sqrt"};
        calculator.calculate(strs);

        strs = new String[] {"clear", "9", "sqrt"};

        calculator.calculate(strs);
    }

    @Test
    public void test3() {
        System.out.println("Example 3");
        String[] strs = new String[] {"5", "2", "-"};
        calculator.calculate(strs);

        strs = new String[] {"3", "-"};
        calculator.calculate(strs);

        strs = new String[] {"clear"};
        calculator.calculate(strs);
    }

    @Test
    public void test4() {
        System.out.println("Example 4");
        String[] strs = new String[] {"5", "4", "3", "2"};
        calculator.calculate(strs);
        strs = new String[] {"undo", "undo", "*"};
        calculator.calculate(strs);
        strs = new String[] {"5", "*"};
        calculator.calculate(strs);
        strs = new String[] {"undo"};
        calculator.calculate(strs);

    }

    @Test
    public void test5() {
        System.out.println("Example 5");
        String[] strs = new String[] {"7", "12", "2", "/"};
        calculator.calculate(strs);
        strs = new String[] {"*"};
        calculator.calculate(strs);
        strs = new String[] {"4", "/"};
        calculator.calculate(strs);
    }

    @Test
    public void test6() {
        System.out.println("Example 6");
        String[] strs = new String[] {"1", "2", "3", "4", "5"};
        calculator.calculate(strs);
        strs = new String[] {"*"};
        calculator.calculate(strs);
        strs = new String[] {"clear", "3", "4", "-"};
        calculator.calculate(strs);
    }

    @Test
    public void test7() {
        System.out.println("Example 7");
        String[] strs = new String[] {"1", "2", "3", "4", "5"};
        calculator.calculate(strs);
        strs = new String[] {"*", "*", "*", "*"};
        calculator.calculate(strs);
    }

    @Test
    public void test8() {
        System.out.println("Example 8");
        String[] strs = new String[] {"1", "2", "3", "*", "5", "+", "*", "*", "6", "5"};
        try {
            calculator.calculate(strs);
        } catch (Exception e) {
            System.out.println("insufficient parameters");
        }
    }
}
