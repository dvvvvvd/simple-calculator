package com.helper.factory;

import com.rest.dto.SimpleCalculationDto;

public class FakeSimpleCalculationDtoFactory {

    public static SimpleCalculationDto create(Integer leftHand, Integer rightHand) {
        return new SimpleCalculationDto(leftHand, rightHand, "DEFAULT");
    }

    public static SimpleCalculationDto create(Integer leftHand, Integer rightHand, String operator) {
        return new SimpleCalculationDto(leftHand, rightHand, operator);
    }
}
