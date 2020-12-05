package com.rest;

import com.rest.dto.SimpleCalculationDto;
import com.rest.dto.SimpleCalculationResultDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SimpleCalculationController {

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
