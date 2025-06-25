package com.calculator;

public class CalculatorResult {

    private String operation;
    private int x;
    private int y;
    private double result;

    public CalculatorResult(String operation, int x, int y, double result) {
        this.operation = operation;
        this.x = x;
        this.y = y;
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }

}
