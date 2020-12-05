package com.rest;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.helper.factory.FakeSimpleCalculationDtoFactory;
import com.helper.factory.FakeSimpleCalculationResultDtoFactory;
import com.helper.utility.MvcJsonResultConverter;
import com.rest.dto.SimpleCalculationDto;
import com.service.SimpleCalculationResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/SimpleCalculatorApp-servlet-test.xml")
@WebAppConfiguration
public class SimpleCalculatorControllerIntegrationTest {

    private static final String POST_ADDITION_PATH = "/calculation/add";
    private static final String POST_SUBTRACTION_PATH = "/calculation/subtract";
    private static final String POST_DIVISION_PATH = "/calculation/division";
    private static final String POST_MULTIPLICATION_PATH = "/calculation/multiplication";

    private static final int LEFT_HAND = 10;
    private static final int RIGHT_HAND = 20;

    private static final SimpleCalculationDto SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(LEFT_HAND, RIGHT_HAND);

    private static final SimpleCalculationResult ADDITION_RESULT
            = FakeSimpleCalculationResultDtoFactory.create(30.0d);

    private static final SimpleCalculationResult SUBTRACTION_RESULT
            = FakeSimpleCalculationResultDtoFactory.create(-10.0d);

    private static final SimpleCalculationResult MULTIPLICATION_RESULT
            = FakeSimpleCalculationResultDtoFactory.create(200.0d);

    private static final SimpleCalculationResult DIVISION_RESULT
            = FakeSimpleCalculationResultDtoFactory.create(0.5d);


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
        RequestBuilder requestBuilder = buildRequestForPostDtoForPath(POST_ADDITION_PATH);

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    public void postSimpleCalculationAdditionShouldReturnExpectedResult() throws Exception {
        RequestBuilder requestBuilder = buildRequestForPostDtoForPath(POST_ADDITION_PATH);

        MvcResult mvcResult = this.mockMvc.perform(requestBuilder).andReturn();
        SimpleCalculationResult simpleCalculationResult = MvcJsonResultConverter
                .convert(mvcResult, SimpleCalculationResult.class);

        assertEquals(ADDITION_RESULT, simpleCalculationResult);
    }

    @Test
    public void postSimpleCalculationSubtractionShouldReturnStatusOk() throws Exception {
        RequestBuilder requestBuilder = buildRequestForPostDtoForPath(POST_SUBTRACTION_PATH);

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    public void postSimpleCalculationSubtractionShouldReturnExpectedResult() throws Exception {
        RequestBuilder requestBuilder = buildRequestForPostDtoForPath(POST_SUBTRACTION_PATH);

        MvcResult mvcResult = this.mockMvc.perform(requestBuilder).andReturn();

        SimpleCalculationResult simpleCalculationResult = MvcJsonResultConverter
                .convert(mvcResult, SimpleCalculationResult.class);

        assertEquals(SUBTRACTION_RESULT, simpleCalculationResult);
    }

    @Test
    public void postSimpleCalculationDivisionShouldReturnStatusOk() throws Exception {
        RequestBuilder requestBuilder = buildRequestForPostDtoForPath(POST_DIVISION_PATH);

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    public void postSimpleCalculationDivisionShouldReturnExpectedResult() throws Exception {
        RequestBuilder requestBuilder = buildRequestForPostDtoForPath(POST_DIVISION_PATH);

        MvcResult mvcResult = this.mockMvc.perform(requestBuilder).andReturn();

        SimpleCalculationResult simpleCalculationResult = MvcJsonResultConverter
                .convert(mvcResult, SimpleCalculationResult.class);

        assertEquals(DIVISION_RESULT, simpleCalculationResult);
    }

    @Test
    public void postSimpleCalculationMultiplicationShouldReturnStatusOk() throws Exception {
        RequestBuilder requestBuilder = buildRequestForPostDtoForPath(POST_MULTIPLICATION_PATH);

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    public void postSimpleCalculationMultiplicationShouldReturnExpectedResult() throws Exception {
        RequestBuilder requestBuilder = buildRequestForPostDtoForPath(POST_MULTIPLICATION_PATH);

        MvcResult mvcResult = this.mockMvc.perform(requestBuilder).andReturn();

        SimpleCalculationResult simpleCalculationResult = MvcJsonResultConverter
                .convert(mvcResult, SimpleCalculationResult.class);

        assertEquals(MULTIPLICATION_RESULT, simpleCalculationResult);
    }


    private RequestBuilder buildRequestForPostDtoForPath(String path) {
        return MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(SIMPLE_CALCULATION_DTO))
                .accept(MediaType.APPLICATION_JSON);
    }
}
