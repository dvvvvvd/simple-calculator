package com.rest;

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
