package com.rest.dto;

import org.springframework.stereotype.Component;

@Component
public class SimpleCalculationResultFactory {

    public SimpleCalculationResultDto create(double result) {
        return new SimpleCalculationResultDto(result);
    }
}
