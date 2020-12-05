package com.rest;

import com.google.gson.Gson;
import com.helper.factory.FakeSimpleCalculationDtoFactory;
import com.rest.dto.SimpleCalculationDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/SimpleCalculatorApp-servlet-test.xml")
@WebAppConfiguration
public class SimpleCalculatorControllerTest {

    private static final String POST_ADDITION_PATH = "/calculation/add";

    private static final int LEFT_HAND = 10;
    private static final int RIGHT_HAND = 20;

    private static final SimpleCalculationDto SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(LEFT_HAND, RIGHT_HAND);

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final Gson gson = new Gson();

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void postSimpleCalculationAdditionShouldReturnStatusOk() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(POST_ADDITION_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(SIMPLE_CALCULATION_DTO))
                .accept(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }
}
