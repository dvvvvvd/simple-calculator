package com.rest;

import com.rest.dto.SimpleCalculationDto;
import com.rest.exception.EmptyInputException;
import com.rest.exception.InvalidInputException;
import org.springframework.stereotype.Component;

@Component
public class InputValidator {

    public void validate(SimpleCalculationDto simpleCalculationDto) throws EmptyInputException {
        if (simpleCalculationDto.getLeftHand() == null || simpleCalculationDto.getRightHand() == null) {
            throw new EmptyInputException("Missing input for simple calculation");
        }
    }

    public void validateForDivision(SimpleCalculationDto simpleCalculationDto)
            throws InvalidInputException, EmptyInputException {
        validate(simpleCalculationDto);
        if (simpleCalculationDto.getRightHand() == 0) {
            throw new InvalidInputException("Unable to divide by zero");
        }
    }
}
