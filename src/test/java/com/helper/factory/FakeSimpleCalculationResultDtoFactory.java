package com.helper.factory;

import com.rest.dto.SimpleCalculationDto;
import com.rest.dto.SimpleCalculationResultDto;

public class FakeSimpleCalculationResultDtoFactory {

    public static SimpleCalculationResultDto create() {
        return new SimpleCalculationResultDto(1.0d);
    }
}
