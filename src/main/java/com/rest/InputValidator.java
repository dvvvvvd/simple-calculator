package com.rest;

import com.rest.dto.SimpleCalculationDto;
import com.rest.exception.EmptyInputException;
import org.springframework.stereotype.Component;

@Component
public class InputValidator {

    public void validate(SimpleCalculationDto simpleCalculationDto) throws EmptyInputException {
        if (simpleCalculationDto.getLeftHand() == null || simpleCalculationDto.getRightHand() == null) {
            throw new EmptyInputException("Missing input for simple calculation");
        }
    }
}
