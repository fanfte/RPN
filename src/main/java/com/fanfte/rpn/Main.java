package com.fanfte.rpn;

import com.fanfte.rpn.enums.OperatorEnums;
import com.fanfte.rpn.utils.NumberUtils;

import java.util.Scanner;

/**
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.trim().length() == 0) {
                continue;
            }
            String[] strList = s.split(" ");

            for (String string : strList) {
                if (NumberUtils.isNumeric(string) || OperatorEnums.effective(string)) {
                } else {
                    throw new IllegalArgumentException("Arguments invalid.");
                }
            }
            calculator.calculate(strList);
        }
    }
}
