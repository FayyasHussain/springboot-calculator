package com.calculator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @GetMapping("/add")
    public CalculationResult add(@RequestParam int x, @RequestParam int y) {
        int result = x + y;
        return new CalculationResult("add", x, y, result);
    }

    @GetMapping("/subtract")
    public CalculationResult subtract(@RequestParam int x, @RequestParam int y) {
        int result = x - y;
        return new CalculationResult("subtract", x, y, result);
    }

    @GetMapping("/multiply")
    public CalculationResult multiply(@RequestParam int x, @RequestParam int y) {
        int result = x * y;
        return new CalculationResult("multiply", x, y, result);
    }

    @GetMapping("/divide")
    public CalculationResult divide(@RequestParam int x, @RequestParam int y) {
        if (y == 0) {
            return new CalculationResult("divide", x, y, Double.NaN);  // or throw error later
        }
        double result = (double) x / y;
        return new CalculationResult("divide", x, y, result);
    }

    @PostMapping("/add-json")
    public CalculationResult addJson(@RequestBody CalculationRequest request) {
        int x = request.getX();
        int y = request.getY();
        int result = x + y;
        return new CalculationResult("add", x, y, result);
    }

    @PostMapping("/subtract-json")
    public CalculationResult subtractJson(@RequestBody CalculationRequest request) {
        int x = request.getX();
        int y = request.getY();
        int result = x - y;
        return new CalculationResult("subtract", x, y, result);
    }

    @PostMapping("/multiply-json")
    public CalculationResult multiplyJson(@RequestBody CalculationRequest request) {
        int x = request.getX();
        int y = request.getY();
        int result = x * y;
        return new CalculationResult("multiply", x, y, result);
    }

    @PostMapping("/divide-json")
    public CalculationResult divideJson(@RequestBody CalculationRequest request) {
        int x = request.getX();
        int y = request.getY();
        double result = y != 0 ? (double) x / y : Double.NaN;
        return new CalculationResult("divide", x, y, result);
    }

    @GetMapping("/cause-error")
    public String causeError() {
        throw new RuntimeException("Intentional internal server error!");
    }

    @GetMapping("/null-error")
    public String nullError() {
        String str = null;
        return str.toLowerCase(); // NullPointerException
    }

}
