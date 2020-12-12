package com.rest;

import com.helper.factory.FakeSimpleCalculationDtoFactory;
import com.rest.dto.SimpleCalculationDto;
import com.rest.exception.EmptyInputException;
import com.rest.exception.InvalidInputException;
import com.service.OperatorEnum;
import org.junit.Test;

public class InputValidatorUnitTest {

    private static final int LEFT_HAND = 10;
    private static final int RIGHT_HAND = 20;

    private static final SimpleCalculationDto SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(LEFT_HAND, RIGHT_HAND);

    private static final SimpleCalculationDto FAULTY_LEFTHAND_SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(null, RIGHT_HAND);

    private static final SimpleCalculationDto FAULTY_RIGHTHAND_SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(RIGHT_HAND, null);

    private static final SimpleCalculationDto FAULTY_DIVISION_SIMPLE_CALCULATION_DTO
            = FakeSimpleCalculationDtoFactory.create(LEFT_HAND, 0, OperatorEnum.DIVIDE.name());

    private final InputValidator inputValidator = new InputValidator();

    @Test
    public void validateShouldNotThrowExceptionForValidDto() throws EmptyInputException, InvalidInputException {
        inputValidator.validate(SIMPLE_CALCULATION_DTO);
    }

    @Test(expected = EmptyInputException.class)
    public void validateShouldThrowEmptyInputExceptionForMissingLeftHandInDto() throws EmptyInputException, InvalidInputException {
        inputValidator.validate(FAULTY_LEFTHAND_SIMPLE_CALCULATION_DTO);
    }

    @Test(expected = EmptyInputException.class)
    public void validateShouldThrowEmptyInputExceptionForMissingRightHandInDto() throws EmptyInputException, InvalidInputException {
        inputValidator.validate(FAULTY_RIGHTHAND_SIMPLE_CALCULATION_DTO);
    }

    @Test(expected = InvalidInputException.class)
    public void validateForDivisionShouldThrowInvalidInputExceptionForMissingRightHandInDto()
            throws EmptyInputException, InvalidInputException {
        inputValidator.validate(FAULTY_DIVISION_SIMPLE_CALCULATION_DTO);
    }
}
