package com.rest;

import com.rest.dto.SimpleCalculationDto;
import com.rest.exception.EmptyInputException;
import com.rest.exception.InvalidInputException;
import com.service.OperatorEnum;
import org.springframework.stereotype.Component;

@Component
public class InputValidator {

    public void validate(SimpleCalculationDto simpleCalculationDto) throws EmptyInputException, InvalidInputException {
        if (simpleCalculationDto.getLeftHand() == null || simpleCalculationDto.getRightHand() == null) {
            throw new EmptyInputException("Missing input for simple calculation");
        }

        if (simpleCalculationDto.getOperator().equals(OperatorEnum.DIVIDE.name()) &&
            simpleCalculationDto.getRightHand() == 0) {
            throw new InvalidInputException("Unable to divide by zero");
        }
    }
}
