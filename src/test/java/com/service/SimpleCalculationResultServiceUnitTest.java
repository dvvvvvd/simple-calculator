package com.service;

import com.helper.factory.FakeSimpleCalculationResultDtoFactory;
import com.rest.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SimpleCalculationResultServiceUnitTest {

    private static final int LEFT_HAND = 10;
    private static final int RIGHT_HAND = 20;

    private static final double ADDITION_RESULT = 1.0d;
    private static final double SUBTRACTION_RESULT = 2.0d;
    private static final double MULTIPLICATION_RESULT = 3.0d;
    private static final double DIVISION_RESULT = 4.0d;

    private static final SimpleCalculationResult SIMPLE_CALCULATION_RESULT
            = FakeSimpleCalculationResultDtoFactory.create();

    @Mock
    private SimpleCalculator simpleCalculatorMock;
    @Mock
    private SimpleCalculationResultFactory simpleCalculationResultFactoryMock;

    @InjectMocks
    private SimpleCalculationResultService simpleCalculationResultService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);

        when(simpleCalculatorMock.add(LEFT_HAND, RIGHT_HAND)).thenReturn(ADDITION_RESULT);
        when(simpleCalculatorMock.subtract(LEFT_HAND, RIGHT_HAND)).thenReturn(SUBTRACTION_RESULT);
        when(simpleCalculatorMock.divide(LEFT_HAND, RIGHT_HAND)).thenReturn(DIVISION_RESULT);
        when(simpleCalculatorMock.multiply(LEFT_HAND, RIGHT_HAND)).thenReturn(MULTIPLICATION_RESULT);

        when(simpleCalculationResultFactoryMock.create(anyDouble()))
                .thenReturn(SIMPLE_CALCULATION_RESULT);
    }

    @Test
    public void createResultShouldCallSimpleCalculatorAddForAddOperator() throws InvalidInputException {
        simpleCalculationResultService.createResult(LEFT_HAND, RIGHT_HAND, OperatorEnum.ADD.name());

        verify(simpleCalculatorMock).add(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createResultShouldCallSimpleCalculatorDivideForSubtractOperator() throws InvalidInputException {
        simpleCalculationResultService.createResult(LEFT_HAND, RIGHT_HAND, OperatorEnum.SUBTRACT.name());

        verify(simpleCalculatorMock).subtract(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createResultShouldCallSimpleCalculatorMultiplyForMultiplyOperator() throws InvalidInputException {
        simpleCalculationResultService.createResult(LEFT_HAND, RIGHT_HAND, OperatorEnum.MULTIPLY.name());

        verify(simpleCalculatorMock).multiply(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createResultShouldCallSimpleCalculatorDivideForDivideOperator() throws InvalidInputException {
        simpleCalculationResultService.createResult(LEFT_HAND, RIGHT_HAND, OperatorEnum.DIVIDE.name());

        verify(simpleCalculatorMock).divide(LEFT_HAND, RIGHT_HAND);
    }

    @Test(expected = InvalidInputException.class)
    public void createResultShouldThrowExceptionForInvalidOperator() throws InvalidInputException {
        simpleCalculationResultService.createResult(LEFT_HAND, RIGHT_HAND, "test");

        verify(simpleCalculatorMock).multiply(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createResultFromAdditionShouldCallSimpleCalculator() {
        simpleCalculationResultService.createResultFromAddition(LEFT_HAND, RIGHT_HAND);

        verify(simpleCalculatorMock).add(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createResultFromAdditionShouldCallSimpleCalculationResultFactory() {
        simpleCalculationResultService.createResultFromAddition(LEFT_HAND, RIGHT_HAND);

        verify(simpleCalculationResultFactoryMock).create(ADDITION_RESULT);
    }

    @Test
    public void createResultFromSubtractionShouldCallSimpleCalculator() {
        simpleCalculationResultService.createResultFromSubtraction(LEFT_HAND, RIGHT_HAND);

        verify(simpleCalculatorMock).subtract(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createResultFromSubtractionShouldCallSimpleCalculationResultFactory() {
        simpleCalculationResultService.createResultFromSubtraction(LEFT_HAND, RIGHT_HAND);

        verify(simpleCalculationResultFactoryMock).create(SUBTRACTION_RESULT);
    }

    @Test
    public void createResultFromDivisionShouldCallSimpleCalculator() {
        simpleCalculationResultService.createResultFromDivision(LEFT_HAND, RIGHT_HAND);

        verify(simpleCalculatorMock).divide(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createResultFromDivisionShouldCallSimpleCalculationResultFactory() {
        simpleCalculationResultService.createResultFromDivision(LEFT_HAND, RIGHT_HAND);

        verify(simpleCalculationResultFactoryMock).create(DIVISION_RESULT);
    }

    @Test
    public void createResultFromMultiplicationShouldCallSimpleCalculator() {
        simpleCalculationResultService.createResultFromMultiplication(LEFT_HAND, RIGHT_HAND);

        verify(simpleCalculatorMock).multiply(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createResultFromMultiplicationShouldCallSimpleCalculationResultFactory() {
        simpleCalculationResultService.createResultFromMultiplication(LEFT_HAND, RIGHT_HAND);

        verify(simpleCalculationResultFactoryMock).create(MULTIPLICATION_RESULT);
    }
}
