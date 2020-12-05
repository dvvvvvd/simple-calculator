package com.service;

import com.rest.dto.SimpleCalculationResultFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SimpleCalculationResultService {

    private final SimpleCalculationResultFactory simpleCalculationResultFactory;
    private final SimpleCalculator simpleCalculator;

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
