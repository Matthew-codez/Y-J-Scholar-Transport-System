package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;
    private String pickupArea;
    private double monthlyFee, distance;

    protected Route(){}
}
