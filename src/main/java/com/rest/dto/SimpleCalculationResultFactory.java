package com.rest.dto;

import com.service.SimpleCalculationResult;
import org.springframework.stereotype.Component;

@Component
public class SimpleCalculationResultFactory {

    public SimpleCalculationResult create(double result) {
        return new SimpleCalculationResult(result);
    }
}
