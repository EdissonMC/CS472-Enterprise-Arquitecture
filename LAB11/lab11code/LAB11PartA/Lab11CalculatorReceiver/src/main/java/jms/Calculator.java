package jms;

public class Calculator {
    private double result;

    public void add(double value) {
        result = result + value;
    }

    public void subtract(double value) {
        result = result - value;
    }


    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Calculator {" +
                "result=" + result +
                '}';
    }
}
