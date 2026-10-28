package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleId;
    private int regNo, capacity;
    private String type, status;

    protected Vehicle(){}
}
