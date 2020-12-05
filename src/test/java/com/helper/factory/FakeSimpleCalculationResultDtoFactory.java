package com.helper.factory;

import com.service.SimpleCalculationResult;

public class FakeSimpleCalculationResultDtoFactory {

    public static SimpleCalculationResult create() {
        return new SimpleCalculationResult(1.0d);
    }
}
