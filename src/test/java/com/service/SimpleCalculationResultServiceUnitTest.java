package com.service;

import com.helper.factory.FakeSimpleCalculationDAOFactory;
import com.helper.factory.FakeSimpleCalculationResultDtoFactory;
import com.persistence.entity.SimpleCalculationDAO;
import com.persistence.factory.SimpleCalculationDAOFactory;
import com.persistence.repositories.SimpleCalculationRepository;
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

    private static final String OPERATOR = "ADD";

    private static final int LEFT_HAND = 10;
    private static final int RIGHT_HAND = 20;

    private static final double ADDITION_RESULT = 30.0d;
    private static final double SUBTRACTION_RESULT = 2.0d;
    private static final double MULTIPLICATION_RESULT = 3.0d;
    private static final double DIVISION_RESULT = 4.0d;

    private static final SimpleCalculationDAO SIMPLE_CALCULATION_DAO
            = FakeSimpleCalculationDAOFactory.create();

    private static final SimpleCalculationResult SIMPLE_CALCULATION_RESULT
            = FakeSimpleCalculationResultDtoFactory.create();

    @Mock
    private SimpleCalculator simpleCalculatorMock;
    @Mock
    private SimpleCalculationDAOFactory simpleCalculationDAOFactoryMock;
    @Mock
    private SimpleCalculationRepository simpleCalculationRepositoryMock;
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

        when(simpleCalculationDAOFactoryMock.create(LEFT_HAND, RIGHT_HAND, OPERATOR, ADDITION_RESULT))
                .thenReturn(SIMPLE_CALCULATION_DAO);
    }

    @Test
    public void createAndSaveResultShouldCallSimpleCalculatorAddForAddOperator() throws InvalidInputException {
        simpleCalculationResultService.createAndSaveResult(LEFT_HAND, RIGHT_HAND, OperatorEnum.ADD.name());

        verify(simpleCalculatorMock).add(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createAndSaveResultShouldCallSimpleCalculatorDivideForSubtractOperator() throws InvalidInputException {
        simpleCalculationResultService.createAndSaveResult(LEFT_HAND, RIGHT_HAND, OperatorEnum.SUBTRACT.name());

        verify(simpleCalculatorMock).subtract(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createAndSaveResultShouldCallSimpleCalculatorMultiplyForMultiplyOperator() throws InvalidInputException {
        simpleCalculationResultService.createAndSaveResult(LEFT_HAND, RIGHT_HAND, OperatorEnum.MULTIPLY.name());

        verify(simpleCalculatorMock).multiply(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createAndSaveResultShouldCallSimpleCalculatorDivideForDivideOperator() throws InvalidInputException {
        simpleCalculationResultService.createAndSaveResult(LEFT_HAND, RIGHT_HAND, OperatorEnum.DIVIDE.name());

        verify(simpleCalculatorMock).divide(LEFT_HAND, RIGHT_HAND);
    }

    @Test(expected = InvalidInputException.class)
    public void createAndSaveResultShouldThrowExceptionForInvalidOperator() throws InvalidInputException {
        simpleCalculationResultService.createAndSaveResult(LEFT_HAND, RIGHT_HAND, "test");

        verify(simpleCalculatorMock).multiply(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void createAndSaveResultShouldCallSimpleCalculationDAOFactory() throws InvalidInputException {
        simpleCalculationResultService.createAndSaveResult(LEFT_HAND, RIGHT_HAND, OperatorEnum.ADD.name());

        verify(simpleCalculationDAOFactoryMock).create(LEFT_HAND, RIGHT_HAND, OPERATOR, ADDITION_RESULT);
    }

    @Test
    public void createAndSaveResultShouldCallSimpleCalculationRepository() throws InvalidInputException {
        simpleCalculationResultService.createAndSaveResult(LEFT_HAND, RIGHT_HAND, OperatorEnum.ADD.name());

        verify(simpleCalculationRepositoryMock).save(SIMPLE_CALCULATION_DAO);
    }
}
