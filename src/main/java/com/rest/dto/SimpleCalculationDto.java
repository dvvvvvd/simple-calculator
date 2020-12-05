package com.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleCalculationDto {
    private int leftHand;
    private int rightHand;
}
