package com.calculator.calculator_homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
    @RestController
    @RequestMapping("/calculator")
    public class CalculatorController {
        @Autowired
        private CalculatorService calculatorService;

        @GetMapping
        public String greeting() {
            return "Добро пожаловать в калькулятор";
        }

        @GetMapping("/plus")
        public String add(@RequestParam(value = "num1", required = true) Integer num1,
                          @RequestParam(value = "num2", required = true) Integer num2) {
            int result = calculatorService.add(num1, num2);
            return String.format("%d + %d = %d", num1, num2, result);
        }

        @GetMapping("/minus")
        public String subtract(@RequestParam(value = "num1", required = true) Integer num1,
                               @RequestParam(value = "num2", required = true) Integer num2) {
            int result = calculatorService.subtract(num1, num2);
            return String.format("%d - %d = %d", num1, num2, result);
        }

        @GetMapping("/multiply")
        public String multiply(@RequestParam(value = "num1", required = true) Integer num1,
                               @RequestParam(value = "num2", required = true) Integer num2) {
            int result = calculatorService.multiply(num1, num2);
            return String.format("%d * %d = %d", num1, num2, result);
        }

        @GetMapping("/divide")
        public String divide(@RequestParam(value = "num1", required = true) Integer num1,
                             @RequestParam(value = "num2", required = true) Integer num2) {
            try {
                double result = calculatorService.divide(num1, num2);
                return String.format("%d / %d = %f", num1, num2, result);
            } catch (ArithmeticException e) {
                return "Ошибка: " + e.getMessage();
            }
        }
    }

