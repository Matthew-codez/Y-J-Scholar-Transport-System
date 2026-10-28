package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class VehiclePermit {
    @Id
    private Integer permitId;
    private int permitNo;
    private Date issueDate, expiryDate;

    protected VehiclePermit(){}
}
