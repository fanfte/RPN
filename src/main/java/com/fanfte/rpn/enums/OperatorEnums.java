package com.fanfte.rpn.enums;

public enum OperatorEnums {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    SQRT("sqrt"),
    UNDO("undo"),
    CLEAR("clear")
    ;

    private String operator;

    OperatorEnums(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public static boolean effective(String operator) {
        for (OperatorEnums operatorEnum : OperatorEnums.values()) {
            if (operator.equals(operatorEnum.getOperator())) {
                return true;
            }
        }
        return false;
    }
}
