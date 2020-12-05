package com.helper.factory;

import com.rest.dto.SimpleCalculationDto;

public class FakeSimpleCalculationDtoFactory {

    public static SimpleCalculationDto create() {
        return new SimpleCalculationDto(1, 2);
    }
}
