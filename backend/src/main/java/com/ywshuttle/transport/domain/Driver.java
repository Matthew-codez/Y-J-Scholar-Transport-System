package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

@Entity
public class Driver {
    @Id
    private Integer driverId;
    private String name, phoneNo, employmentStatus;

    protected Driver(){}
}
