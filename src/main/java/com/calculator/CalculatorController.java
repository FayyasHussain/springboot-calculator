package com.calculator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @GetMapping("/add")
    public String add(@RequestParam int x, @RequestParam int y) {
        int result = x + y;
        return "Result: " + result;
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam int x, @RequestParam int y) {
        int result = x - y;
        return "Result: " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int x, @RequestParam int y) {
        int result = x * y;
        return "Result: " + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam int x, @RequestParam int y) {
        if (y == 0) {
            return "❌ Cannot divide by zero";
        }
        double result = (double) x / y;
        return "Result: " + result;
    }
}
