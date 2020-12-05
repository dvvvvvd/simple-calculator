package com.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SimpleCalculatorTest {

    private final SimpleCalculator simpleCalculator = new SimpleCalculator();

    @Test
    public void addShouldPerformAdditionForTwoPositiveNumbers() {
        double result = simpleCalculator.add(1, 1);
        assertEquals(2.0d, result, 0.0d);
    }

    @Test
    public void addShouldPerformAdditionForTwoNegativeNumbers() {
        double result = simpleCalculator.add(-1, -1);
        assertEquals(-2.0d, result, 0.0d);
    }

    @Test
    public void addShouldPerformAdditionForOnePositiveAndOneNegativeNumbers() {
        double result = simpleCalculator.add(1, 1);
        assertEquals(0.0d, result, 0.0d);
    }

    @Test
    public void subtractShouldPerformSubtractionForTwoPositiveNumbers() {
        double result = simpleCalculator.subtract(1, 1);
        assertEquals(0.0d, result, 0.0d);
    }

    @Test
    public void subtractShouldPerformSubtractionForTwoNegativeNumbers() {
        double result = simpleCalculator.add(-1, -1);
        assertEquals(0.0d, result, 0.0d);
    }

    @Test
    public void subtractShouldPerformSubtractionForOnePositiveAndOneNegativeNumbers() {
        double result = simpleCalculator.add(1, -1);
        assertEquals(2.0d, result, 0.0d);
    }
}
