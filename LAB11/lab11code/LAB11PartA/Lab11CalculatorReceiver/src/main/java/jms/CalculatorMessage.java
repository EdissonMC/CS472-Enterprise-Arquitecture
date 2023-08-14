package jms;

import java.io.Serializable;

public class CalculatorMessage implements Serializable {

    private String operator;
    private double value;

    public CalculatorMessage(String operator, double value) {
        this.operator = operator;
        this.value = value;
    }


    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
