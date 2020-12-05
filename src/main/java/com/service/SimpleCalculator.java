package com.service;

import org.springframework.stereotype.Component;

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
