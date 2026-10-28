package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

@Entity
public class Scholar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scholarId;
    private String name, pickupLocation, dropoffLocation;

    protected Scholar(){}
}
