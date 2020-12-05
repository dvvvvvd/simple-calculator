package com.helper.factory;

import com.rest.dto.SimpleCalculationDto;

public class FakeSimpleCalculationDtoFactory {

    public static SimpleCalculationDto create(int leftHand, int rightHand) {
        return new SimpleCalculationDto(leftHand, rightHand);
    }
}
