package com.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SIMPLE_CALCULATION")
public class SimpleCalculationDAO extends BaseEntity {

    @Column(name = "RESULT")
    private Double result;

    @Column(name = "LEFT_HAND")
    private Integer leftHand;

    @Column(name = "RIGHT_HAND")
    private Integer rightHand;

    @Column(name = "OPERATOR")
    private String operator;
}
