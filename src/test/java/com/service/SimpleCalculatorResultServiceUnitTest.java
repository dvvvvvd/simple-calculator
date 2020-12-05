package com.service;

import com.helper.factory.FakeSimpleCalculationDtoFactory;
import com.helper.factory.FakeSimpleCalculationResultDtoFactory;
import com.rest.SimpleCalculationController;
import com.rest.dto.SimpleCalculationDto;
import com.rest.dto.SimpleCalculationResultFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SimpleCalculatorResultServiceUnitTest {

    private static final int LEFT_HAND = 10;
    private static final int RIGHT_HAND = 20;

    private static final double ADDITION_RESULT = 1.0d;
    private static final double SUBTRACTION_RESULT = 2.0d;
    private static final double MULTIPLICATION_RESULT = 3.0d;
    private static final double DIVISION_RESULT = 4.0d;

    private static final SimpleCalculationDto SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(LEFT_HAND, RIGHT_HAND);

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
        when(simpleCalculatorMock.add(LEFT_HAND, RIGHT_HAND)).thenReturn(ADDITION_RESULT);
        when(simpleCalculatorMock.subtract(LEFT_HAND, RIGHT_HAND)).thenReturn(SUBTRACTION_RESULT);
        when(simpleCalculatorMock.divide(LEFT_HAND, RIGHT_HAND)).thenReturn(DIVISION_RESULT);
        when(simpleCalculatorMock.multiply(LEFT_HAND, RIGHT_HAND)).thenReturn(MULTIPLICATION_RESULT);

        when(simpleCalculationResultFactoryMock.create(anyDouble()))
                .thenReturn(SIMPLE_CALCULATION_RESULT);
    }


}
