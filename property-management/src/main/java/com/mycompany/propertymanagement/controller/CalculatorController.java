package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    // http://localhost:8080/add?n1=1&n2=2
    @GetMapping("/add")
    public Double add(@RequestParam("n1") Double n1,
                      @RequestParam("n2") Double n2) {
        return n1 + n2;
    }

    @GetMapping("/subtract/{n1}/{n2}")
    public Double subtract(@PathVariable Double n1,
                           @PathVariable Double n2) {
        if (n1 > n2) return n1 - n2;
        else return n2 - n1;
    }

    @PostMapping("/multiply")
    public Double multiply(@RequestBody CalculatorDTO calculatorDTO) {
        return calculatorDTO.getN1() * calculatorDTO.getN2();
    }
}
