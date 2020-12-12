package com.service;

import com.persistence.repositories.SimpleCalculationRepository;
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

    public SimpleCalculationResult createResult(int leftHand, int rightHand, String operator) {
        return null;
    }

    public SimpleCalculationResult createResultFromAddition(int leftHand, int rightHand) {
        double resultFromAddition = simpleCalculator.add(leftHand, rightHand);

        return simpleCalculationResultFactory.create(resultFromAddition);
    }

    public SimpleCalculationResult createResultFromSubtraction(int leftHand, int rightHand) {
        double resultFromSubtraction = simpleCalculator.subtract(leftHand, rightHand);

        return simpleCalculationResultFactory.create(resultFromSubtraction);
    }

    public SimpleCalculationResult createResultFromDivision(int leftHand, int rightHand) {
        double resultFromDivision = simpleCalculator.divide(leftHand, rightHand);

        return simpleCalculationResultFactory.create(resultFromDivision);
    }

    public SimpleCalculationResult createResultFromMultiplication(int leftHand, int rightHand) {
        double resultFromMultiplication = simpleCalculator.multiply(leftHand, rightHand);

        return simpleCalculationResultFactory.create(resultFromMultiplication);
    }
}
