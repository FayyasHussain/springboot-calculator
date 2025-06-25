package com.calculator;

public class CalculationRequest {
    private int x;
    private int y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public CalculationRequest (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Needed by Spring's JSON converter
    public CalculationRequest() {
        // Default constructor
    }

}
