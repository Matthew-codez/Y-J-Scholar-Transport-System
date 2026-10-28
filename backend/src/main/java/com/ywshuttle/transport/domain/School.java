package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schoolId;
    private String name, pickupLocation, dropoffLocation;

    protected School(){}
}
