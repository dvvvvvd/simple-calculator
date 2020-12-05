package com.service;

import org.springframework.stereotype.Component;

/**
 * A SimpleCalculator with implements basic arithmetic for two
 * integer parameters and returns the result as a double.
 *
 * @author  Daan van Driel
 * @version 1.0
 * @since   2020-12-05
 */
@Component
public class SimpleCalculator {

    public double add(int leftHand, int rightHand) {
        return (double) leftHand + (double) rightHand;
    }

    public double subtract(int leftHand, int rightHand) {
        return (double) leftHand - (double) rightHand;
    }

    public double multiply(int leftHand, int rightHand) {
        return (double) leftHand * (double) rightHand;
    }

    public double divide(int leftHand, int rightHand) {
        return (double) leftHand / (double) rightHand;
    }
}
