package com.rest;

import com.rest.dto.SimpleCalculationDto;
import com.service.SimpleCalculationResult;
import com.service.SimpleCalculationResultService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/calculation", consumes = "application/json", produces = "application/json")
@AllArgsConstructor
@CrossOrigin
public class SimpleCalculationController {

    private final SimpleCalculationResultService simpleCalculationResultService;

    @PostMapping("/add")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationAddition(@RequestBody SimpleCalculationDto simpleCalculationDto) {
        System.out.println("received HTTP request for /calculation/add");
        return simpleCalculationResultService.createResultFromAddition(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }

    @PostMapping("subtract")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationSubtraction(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        System.out.println("received HTTP request for /calculation/subtract");
        return simpleCalculationResultService.createResultFromSubtraction(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }

    @PostMapping("divide")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationDivision(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        System.out.println("received HTTP request for /calculation/divide");
        return simpleCalculationResultService.createResultFromDivision(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }

    @PostMapping("multiply")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationMultiplication(
            @RequestBody SimpleCalculationDto simpleCalculationDto) {
        System.out.println("received HTTP request for /calculation/multiply");
        return simpleCalculationResultService.createResultFromMultiplication(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }
}
