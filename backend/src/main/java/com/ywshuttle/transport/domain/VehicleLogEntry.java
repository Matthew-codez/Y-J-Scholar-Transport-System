package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class VehicleLogEntry {
    @Id
    private Integer logEntryId;
    private Date date;
    private Time time;
    private double openingKm, closingKm, totalBusinessKm;

    protected VehicleLogEntry(){}
}
