package com.rest;

import com.google.gson.Gson;
import com.helper.IntegrationTest;
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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SimpleCalculatorControllerIntegrationTest extends IntegrationTest  {

    private static final String POST_CALCULATIONS_PATH = "/calculation";

    private static final int LEFT_HAND = 10;
    private static final int RIGHT_HAND = 20;
    private static final String OPERATOR = "ADD";

    private static final SimpleCalculationDto SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(LEFT_HAND, RIGHT_HAND, OPERATOR);

    private static final SimpleCalculationDto FAULTY_LEFTHAND_SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(null, RIGHT_HAND);

    private static final SimpleCalculationResult ADDITION_RESULT
            = FakeSimpleCalculationResultDtoFactory.create(30.0d);

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final Gson gson = new Gson();

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void postSimpleCalculationsShouldReturnStatusOk() throws Exception {
        RequestBuilder requestBuilder =
                buildRequestForPostDtoSingleListForPath(POST_CALCULATIONS_PATH, SIMPLE_CALCULATION_DTO);

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    public void postSimpleCalculationsShouldReturnStatusStatusBadRequestForFaultyDto() throws Exception {
        RequestBuilder requestBuilder =
                buildRequestForPostDtoSingleListForPath(POST_CALCULATIONS_PATH, FAULTY_LEFTHAND_SIMPLE_CALCULATION_DTO);

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest());
    }

    @Test
    public void postSimpleCalculationsShouldReturnExpectedResult() throws Exception {
        RequestBuilder requestBuilder =
                buildRequestForPostDtoSingleListForPath(POST_CALCULATIONS_PATH, SIMPLE_CALCULATION_DTO);

        MvcResult mvcResult = this.mockMvc.perform(requestBuilder).andReturn();

        List<SimpleCalculationResult> results = MvcJsonResultConverter
                .convertFromJsonArray(mvcResult, SimpleCalculationResult.class);

        assertEquals(ADDITION_RESULT, results.get(0));
    }

    private RequestBuilder buildRequestForPostDtoSingleListForPath(String path, SimpleCalculationDto dto) {
        List<SimpleCalculationDto> dtoList = Collections.singletonList(dto);

        String content = gson.toJson(dtoList);

        System.out.println(content);

        return MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .accept(MediaType.APPLICATION_JSON);
    }

    private RequestBuilder buildRequestForPostDtoForPath(String path) {
        return MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(SIMPLE_CALCULATION_DTO))
                .accept(MediaType.APPLICATION_JSON);
    }

    private RequestBuilder buildFaultyRequestForPostDtoForPath(String path) {
        return MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(FAULTY_LEFTHAND_SIMPLE_CALCULATION_DTO))
                .accept(MediaType.APPLICATION_JSON);
    }
}
