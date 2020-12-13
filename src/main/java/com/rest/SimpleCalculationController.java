package com.rest;

import com.persistence.entity.SimpleCalculationDAO;
import com.persistence.repositories.SimpleCalculationRepository;
import com.rest.dto.SimpleCalculationDto;
import com.service.SimpleCalculationResult;
import com.service.SimpleCalculationResultService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping
    @ResponseBody
    public List<SimpleCalculationResult> postCalculations
            (@Validated @RequestBody List<SimpleCalculationDto> dtoList) throws Exception {
        LOGGER.info("received POST request for /calculation");

        List<SimpleCalculationResult> results = new ArrayList<>();

        for (SimpleCalculationDto dto : dtoList) {
            inputValidator.validate(dto);
            results.add(simpleCalculationResultService
                    .createResult(dto.getLeftHand(), dto.getRightHand(), dto.getOperator()));
        }

        return results;
    }
}
