package com.rest;

import com.rest.dto.SimpleCalculationDto;
import com.rest.dto.SimpleCalculationResultDto;
import com.service.SimpleCalculator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/calculation", consumes = "application/json", produces = "application/json")
@AllArgsConstructor
public class SimpleCalculationController {

    private final SimpleCalculator simpleCalculator;

    @PostMapping("add")
    @ResponseBody
    public SimpleCalculationResultDto postSimpleCalculationAddition(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        return null;
    }

    @PostMapping("subtract")
    @ResponseBody
    public SimpleCalculationResultDto postSimpleCalculationSubtraction(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        return null;
    }

    @PostMapping("divide")
    @ResponseBody
    public SimpleCalculationResultDto postSimpleCalculationDivision(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        return null;
    }

    @PostMapping("multiply")
    @ResponseBody
    public SimpleCalculationResultDto postSimpleCalculationMultiplication(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        return null;
    }
}
