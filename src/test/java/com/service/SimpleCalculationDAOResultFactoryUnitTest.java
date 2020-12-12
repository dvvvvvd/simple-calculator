package com.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleCalculationDAOResultFactoryUnitTest {

    private static final double RESULT = 1.0d;

    private final SimpleCalculationResultFactory simpleCalculationResultFactory
            = new SimpleCalculationResultFactory();

    @Test
    public void createShouldReturnSimpleCalculationResultWithExpectedValues() {
        SimpleCalculationResult simpleCalculationResult =
                simpleCalculationResultFactory.create(RESULT);

        assertEquals(RESULT, simpleCalculationResult.getResult(), 0.0d);
    }
}
