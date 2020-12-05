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
        double result = simpleCalculator.add(1, -1);
        assertEquals(0.0d, result, 0.0d);
    }

    @Test
    public void subtractShouldPerformSubtractionForTwoPositiveNumbers() {
        double result = simpleCalculator.subtract(1, 1);
        assertEquals(0.0d, result, 0.0d);
    }

    @Test
    public void subtractShouldPerformSubtractionForTwoNegativeNumbers() {
        double result = simpleCalculator.subtract(-1, -1);
        assertEquals(0.0d, result, 0.0d);
    }

    @Test
    public void subtractShouldPerformSubtractionForOnePositiveAndOneNegativeNumbers() {
        double result = simpleCalculator.subtract(1, -1);
        assertEquals(2.0d, result, 0.0d);
    }

    @Test
    public void divideShouldPerformDivisionForTwoPositiveNumbers() {
        double result = simpleCalculator.divide(1, 1);
        assertEquals(1.0d, result, 0.0d);
    }

    @Test
    public void divideShouldPerformDivisionForTwoNegativeNumbers() {
        double result = simpleCalculator.divide(-1, -1);
        assertEquals(1.0d, result, 0.0d);
    }

    @Test
    public void divideShouldPerformDivisionForOnePositiveAndOneNegativeNumbers() {
        double result = simpleCalculator.divide(1, -1);
        assertEquals(-1.0d, result, 0.0d);
    }


    @Test
    public void multiplyShouldPerformMultiplicationForTwoPositiveNumbers() {
        double result = simpleCalculator.multiply(1, 1);
        assertEquals(1.0d, result, 0.0d);
    }

    @Test
    public void multiplyShouldPerformMultiplicationForTwoNegativeNumbers() {
        double result = simpleCalculator.multiply(-1, -1);
        assertEquals(1.0d, result, 0.0d);
    }

    @Test
    public void multiplyShouldPerformMultiplicationForOnePositiveAndOneNegativeNumbers() {
        double result = simpleCalculator.multiply(1, -1);
        assertEquals(-1.0d, result, 0.0d);
    }
}
