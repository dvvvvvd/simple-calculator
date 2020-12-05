package com.rest;

import com.rest.dto.SimpleCalculationDto;
import com.rest.dto.SimpleCalculationResultDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SimpleCalculationController {

    @PostMapping("add")
    @ResponseBody
    public SimpleCalculationResultDto postSimpleCalculationAddition(SimpleCalculationDto simpleCalculationDto) {
        return null;
    }

    @PostMapping("subtract")
    @ResponseBody
    public SimpleCalculationResultDto postSimpleCalculationSubtraction(SimpleCalculationDto simpleCalculationDto) {
        return null;
    }

    @PostMapping("divide")
    @ResponseBody
    public SimpleCalculationResultDto postSimpleCalculationDivision(SimpleCalculationDto simpleCalculationDto) {
        return null;
    }

    @PostMapping("multiply")
    @ResponseBody
    public SimpleCalculationResultDto postSimpleCalculationMultiplication(SimpleCalculationDto simpleCalculationDto) {
        return null;
    }
}
