package com.example.jpareference.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private Integer zip;
    private String country;
    private String phoneNumber;

}
