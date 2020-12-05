package com.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimpleCalculationDto {

    private int leftHand;
    private int rightHand;
}
