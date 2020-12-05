package com.rest;

import com.helper.factory.FakeSimpleCalculationDtoFactory;
import com.rest.dto.SimpleCalculationDto;
import com.service.SimpleCalculationResultService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class SimpleCalculatorControllerUnitTest {

    private static final int LEFT_HAND = 10;
    private static final int RIGHT_HAND = 20;

    private static final SimpleCalculationDto SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(LEFT_HAND, RIGHT_HAND);

    @Mock
    private SimpleCalculationResultService simpleCalculationResultServiceMock;

    @InjectMocks
    private SimpleCalculationController simpleCalculationController;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void  postSimpleCalculationAdditionShouldCallSimpleCalculationResultService() {
        simpleCalculationController
                .postSimpleCalculationAddition(SIMPLE_CALCULATION_DTO);

        verify(simpleCalculationResultServiceMock)
                .createResultFromAddition(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void  postSimpleCalculationSubtractionShouldCallSimpleCalculationResultService() {
        simpleCalculationController
                .postSimpleCalculationSubtraction(SIMPLE_CALCULATION_DTO);

        verify(simpleCalculationResultServiceMock)
                .createResultFromSubtraction(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void  postSimpleCalculationDivisionShouldCallSimpleCalculationResultService() {
        simpleCalculationController
                .postSimpleCalculationDivision(SIMPLE_CALCULATION_DTO);

        verify(simpleCalculationResultServiceMock)
                .createResultFromDivision(LEFT_HAND, RIGHT_HAND);
    }

    @Test
    public void  postSimpleCalculationMultiplicationShouldCallSimpleCalculationResultService() {
        simpleCalculationController
                .postSimpleCalculationMultiplication(SIMPLE_CALCULATION_DTO);

        verify(simpleCalculationResultServiceMock)
                .createResultFromMultiplication(LEFT_HAND, RIGHT_HAND);
    }
}
