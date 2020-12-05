package com.rest;

import com.helper.factory.FakeSimpleCalculationDtoFactory;
import com.helper.factory.FakeSimpleCalculationResultDtoFactory;
import com.rest.dto.SimpleCalculationDto;
import com.rest.dto.SimpleCalculationResultDto;
import com.service.SimpleCalculator;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class SimpleCalculatorControllerTest {

    private static final double ADDITION_RESULT = 1.0d;
    private static final double SUBTRACTION_RESULT = 1.0d;
    private static final double MULTIPLICATION_RESULT = 1.0d;
    private static final double DIVISION_RESULT = 1.0d;

    private static final SimpleCalculationDto SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create();
    private static final SimpleCalculationResultDto SIMPLE_CALCULATION_RESULT_DTO
            = FakeSimpleCalculationResultDtoFactory.create();

    @Mock
    private SimpleCalculator simpleCalculator;

    @InjectMocks
    private SimpleCalculationController simpleCalculationController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(simpleCalculationController).build();
    }
}
