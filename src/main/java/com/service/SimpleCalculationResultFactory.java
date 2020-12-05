package com.service;

import org.springframework.stereotype.Component;

@Component
public class SimpleCalculationResultFactory {

    public SimpleCalculationResult create(double result) {
        return new SimpleCalculationResult(result);
    }
}
