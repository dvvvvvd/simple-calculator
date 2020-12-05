package com.rest;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.helper.factory.FakeSimpleCalculationDtoFactory;
import com.helper.factory.FakeSimpleCalculationResultDtoFactory;
import com.rest.dto.SimpleCalculationDto;
import com.rest.dto.SimpleCalculationResultDto;
import com.rest.dto.SimpleCalculationResultFactory;
import com.service.SimpleCalculator;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class SimpleCalculatorControllerTest {

    private static final int LEFT_HAND = 10;
    private static final int RIGHT_HAND = 20;

    private static final double ADDITION_RESULT = 1.0d;
    private static final double SUBTRACTION_RESULT = 2.0d;
    private static final double MULTIPLICATION_RESULT = 3.0d;
    private static final double DIVISION_RESULT = 4.0d;

    private static final SimpleCalculationDto SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(LEFT_HAND, RIGHT_HAND);

    private static final SimpleCalculationResultDto SIMPLE_CALCULATION_RESULT_DTO
            = FakeSimpleCalculationResultDtoFactory.create();

    @Mock
    private SimpleCalculator simpleCalculator;

    @Mock
    private SimpleCalculationResultFactory simpleCalculationResultFactory;

    @InjectMocks
    private SimpleCalculationController simpleCalculationController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(simpleCalculationController).build();

        when(simpleCalculator.add(LEFT_HAND, RIGHT_HAND)).thenReturn(ADDITION_RESULT);
        when(simpleCalculator.subtract(LEFT_HAND, RIGHT_HAND)).thenReturn(SUBTRACTION_RESULT);
        when(simpleCalculator.divide(LEFT_HAND, RIGHT_HAND)).thenReturn(DIVISION_RESULT);
        when(simpleCalculator.multiply(LEFT_HAND, RIGHT_HAND)).thenReturn(MULTIPLICATION_RESULT);

        when(simpleCalculationResultFactory.create(anyDouble()))
                .thenReturn(SIMPLE_CALCULATION_RESULT_DTO);

    }
}
