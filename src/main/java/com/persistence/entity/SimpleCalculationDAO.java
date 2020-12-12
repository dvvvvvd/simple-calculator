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
    private Integer result;

    @Column(name = "EXPRESSION")
    private String expression;
}
