package com.service;

import com.persistence.entity.SimpleCalculationDAO;
import com.persistence.factory.SimpleCalculationDAOFactory;
import com.persistence.repositories.SimpleCalculationRepository;
import com.rest.exception.InvalidInputException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Intermediate service for applying arithmetic using the SimpleCalculator
 * and persisting the result
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
    private final SimpleCalculationRepository simpleCalculationRepository;
    private final SimpleCalculationDAOFactory simpleCalculationDAOFactory;

    public SimpleCalculationResult createAndSaveResult(int leftHand, int rightHand, String operator)
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

        SimpleCalculationDAO simpleCalculationDAO = simpleCalculationDAOFactory
                .create(leftHand, rightHand, operator, result);

        simpleCalculationRepository.save(simpleCalculationDAO);

        return simpleCalculationResultFactory.create(result);
    }
}
