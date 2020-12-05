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
        return null;
    }

    public SimpleCalculationResult createResultFromSubtraction(int leftHand, int rightHand) {
        return null;
    }

    public SimpleCalculationResult createResultFromDivision(int leftHand, int rightHand) {
        return null;
    }

    public SimpleCalculationResult createResultFromMultiplication(int leftHand, int rightHand) {
        return null;
    }
}
