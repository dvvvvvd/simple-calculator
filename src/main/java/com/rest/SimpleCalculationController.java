package com.rest;

import com.rest.dto.SimpleCalculationDto;
import com.service.SimpleCalculationResult;
import com.rest.dto.SimpleCalculationResultFactory;
import com.service.SimpleCalculationResultService;
import com.service.SimpleCalculator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/calculation", consumes = "application/json", produces = "application/json")
@AllArgsConstructor
public class SimpleCalculationController {

    private final SimpleCalculationResultService simpleCalculationResultService;

    @PostMapping("/add")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationAddition(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        return simpleCalculationResultService.createResultFromAddition(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }

    @PostMapping("subtract")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationSubtraction(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        return null;
    }

    @PostMapping("divide")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationDivision(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        return null;
    }

    @PostMapping("multiply")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationMultiplication(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        return null;
    }
}
