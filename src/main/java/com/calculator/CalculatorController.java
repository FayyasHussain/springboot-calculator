package com.calculator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @GetMapping("/add")
    public CalculatorResult add(@RequestParam int x, @RequestParam int y) {
        int result = x + y;
        return new CalculatorResult("add", x, y, result);
    }

    @GetMapping("/subtract")
    public CalculatorResult subtract(@RequestParam int x, @RequestParam int y) {
        int result = x - y;
        return new CalculatorResult("subtract", x, y, result);
    }

    @GetMapping("/multiply")
    public CalculatorResult multiply(@RequestParam int x, @RequestParam int y) {
        int result = x * y;
        return new CalculatorResult("multiply", x, y, result);
    }

    @GetMapping("/divide")
    public CalculatorResult divide(@RequestParam int x, @RequestParam int y) {
        if (y == 0) {
            return new CalculatorResult("divide", x, y, Double.NaN);  // or throw error later
        }
        double result = (double) x / y;
        return new CalculatorResult("divide", x, y, result);
    }
}
