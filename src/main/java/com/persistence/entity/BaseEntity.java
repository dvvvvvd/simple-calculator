package com.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    @Column(name = "ID")
    private int id;
}
