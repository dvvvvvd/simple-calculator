package com.rest;

import com.rest.dto.SimpleCalculationDto;
import com.rest.exception.EmptyInputException;
import com.rest.exception.InvalidInputException;
import com.service.SimpleCalculationResult;
import com.service.SimpleCalculationResultService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * A REST controller implementing several REST endpoints for receiving
 * DTOs, applying basic arithmetic and returning the result. A different endpoint
 * has been created for each kind of arithmetic.
 *
 * @author  Daan van Driel
 * @version 1.0
 * @since   2020-12-05
 */

@RestController
@RequestMapping(value = "/calculation", consumes = "application/json", produces = "application/json")
@AllArgsConstructor
@CrossOrigin
public class SimpleCalculationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleCalculationController.class);

    private final SimpleCalculationResultService simpleCalculationResultService;
    private final InputValidator inputValidator;

    @PostMapping("/add")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationAddition
            (@Validated @RequestBody SimpleCalculationDto simpleCalculationDto) throws EmptyInputException {
        LOGGER.info("received HTTP request for /calculation/add");

        inputValidator.validate(simpleCalculationDto);
        return simpleCalculationResultService.createResultFromAddition(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }

    @PostMapping("subtract")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationSubtraction(
            @RequestBody SimpleCalculationDto simpleCalculationDto) throws EmptyInputException {
        LOGGER.info("received HTTP request for /calculation/subtract");
        inputValidator.validate(simpleCalculationDto);
        return simpleCalculationResultService.createResultFromSubtraction(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }

    @PostMapping("divide")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationDivision(
            @RequestBody SimpleCalculationDto simpleCalculationDto) throws EmptyInputException, InvalidInputException {
        LOGGER.info("received HTTP request for /calculation/divide");
        inputValidator.validateForDivision(simpleCalculationDto);
        return simpleCalculationResultService.createResultFromDivision(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }

    @PostMapping("multiply")
    @ResponseBody
    public SimpleCalculationResult postSimpleCalculationMultiplication(
            @RequestBody SimpleCalculationDto simpleCalculationDto) throws EmptyInputException {
        LOGGER.info("received HTTP request for /calculation/multiply");
        inputValidator.validate(simpleCalculationDto);
        return simpleCalculationResultService.createResultFromMultiplication(
                simpleCalculationDto.getLeftHand(), simpleCalculationDto.getRightHand());
    }
}
