package com.service;

import com.rest.exception.InvalidInputException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Intermediate service for applying arithmetic using the SimpleCalculator
 * and transforming it to a SimpleCalculationResult using the factory pattern.
 *
 * @author  Daan van Driel
 * @version 1.0
 * @since   2020-12-05
 */

@Component
@AllArgsConstructor
public class SimpleCalculationResultService {

    private final SimpleCalculationResultFactory simpleCalculationResultFactory;
    private final SimpleCalculator simpleCalculator;

    public SimpleCalculationResult createResult(int leftHand, int rightHand, String operator)
            throws InvalidInputException {
        double result;

        switch (operator) {
            case "ADD":
                result = simpleCalculator.add(leftHand, rightHand);
                break;
            case "SUBTRACT":
                result = simpleCalculator.subtract(leftHand, rightHand);
                break;
            case "MULTIPLY":
                result = simpleCalculator.multiply(leftHand, rightHand);
                break;
            case "DIVIDE":
                result = simpleCalculator.divide(leftHand, rightHand);
                break;
            default:
                throw new InvalidInputException("Invalid operator provided");
        }

        return simpleCalculationResultFactory.create(result);
    }
}
