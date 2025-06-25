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

    @PostMapping("/add-json")
    public CalculatorResult addJson(@RequestBody CalculationRequest request) {
        int x = request.getX();
        int y = request.getY();
        int result = x + y;
        return new CalculatorResult("add", x, y, result);
    }

    @PostMapping("/subtract-json")
    public CalculatorResult subtractJson(@RequestBody CalculationRequest request) {
        int x = request.getX();
        int y = request.getY();
        int result = x - y;
        return new CalculatorResult("subtract", x, y, result);
    }

    @PostMapping("/multiply-json")
    public CalculatorResult multiplyJson(@RequestBody CalculationRequest request) {
        int x = request.getX();
        int y = request.getY();
        int result = x * y;
        return new CalculatorResult("multiply", x, y, result);
    }

    @PostMapping("/divide-json")
    public CalculatorResult divideJson(@RequestBody CalculationRequest request) {
        int x = request.getX();
        int y = request.getY();
        double result = y != 0 ? (double) x / y : Double.NaN;
        return new CalculatorResult("divide", x, y, result);
    }

}
