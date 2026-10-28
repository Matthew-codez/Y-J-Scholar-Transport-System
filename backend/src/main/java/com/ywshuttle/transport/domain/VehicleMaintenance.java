package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class VehicleMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maintenanceId;
    private Date date;
    private double cost;
    private String type, description;

    protected VehicleMaintenance(){}
}
