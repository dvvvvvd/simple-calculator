package com.rest;

import com.helper.factory.FakeSimpleCalculationDtoFactory;
import com.rest.dto.SimpleCalculationDto;
import com.service.SimpleCalculationResultService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

public class SimpleCalculatorControllerUnitTest {

    private static final int LEFT_HAND = 10;
    private static final int RIGHT_HAND = 20;
    private static final String OPERATOR = "ADD";

    private static final SimpleCalculationDto SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(LEFT_HAND, RIGHT_HAND, OPERATOR);

    private static final List<SimpleCalculationDto> SIMPLE_CALCULATION_DTO_LIST
            = Collections.singletonList(SIMPLE_CALCULATION_DTO);

    @Mock
    private SimpleCalculationResultService simpleCalculationResultServiceMock;

    @Mock
    private InputValidator inputValidatorMock;

    @InjectMocks
    private SimpleCalculationController simpleCalculationController;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void postCalculationsShouldCallCalculationResultService() throws Exception {
        simpleCalculationController
                .postCalculations(SIMPLE_CALCULATION_DTO_LIST);

        verify(simpleCalculationResultServiceMock)
                .createResult(LEFT_HAND, RIGHT_HAND, OPERATOR);
    }

    @Test
    public void postSimpleCalculationsShouldCallInputValidator() throws Exception {
        simpleCalculationController
                .postCalculations(SIMPLE_CALCULATION_DTO_LIST);

        verify(inputValidatorMock)
                .validate(SIMPLE_CALCULATION_DTO);
    }
}
