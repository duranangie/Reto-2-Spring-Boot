package com.calculator.main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.calculator.main.Service.CalculatorService;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @GetMapping("/add")
    public double add(@RequestParam double operand1, @RequestParam double operand2) {
        double result = calculatorService.addAndSaveOperation("Addition", operand1, operand2);
        return result;
    }
//    @GetMapping("/add")
//    public double add(@RequestParam double operand1, @RequestParam double operand2) {
//        return CalculatorService.add(operand1, operand2);
//    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double operand1, @RequestParam double operand2) {
        double result = calculatorService.subtractAndSaveOperation("Subtraction", operand1, operand2);
        return result;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double operand1, @RequestParam double operand2) {
        double result = calculatorService.multiplyAndSaveOperation("Multiplication", operand1, operand2);
        return result;
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double operand1, @RequestParam double operand2) {
        double result = calculatorService.divideAndSaveOperation("Division", operand1, operand2);
        return result;
    }

}