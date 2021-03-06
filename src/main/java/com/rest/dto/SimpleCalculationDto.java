package com.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleCalculationDto {

    private Integer leftHand;
    private Integer rightHand;
    private String operator;
}
