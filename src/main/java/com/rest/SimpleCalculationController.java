package com.rest;

import com.rest.dto.SimpleCalculationDto;
import com.service.SimpleCalculationResult;
import com.service.SimpleCalculationResultService;
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
        return simpleCalculationResultService.createResultFromSubtraction(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }

    @PostMapping("divide")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationDivision(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        return simpleCalculationResultService.createResultFromDivision(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }

    @PostMapping("multiply")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationMultiplication(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        return simpleCalculationResultService.createResultFromMultiplication(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }
}
