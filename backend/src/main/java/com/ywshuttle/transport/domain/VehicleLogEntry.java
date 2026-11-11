package com.ywshuttle.transport.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "vehicle_log_entries")
public class VehicleLogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_entry_id")
    private Integer logEntryId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(name = "opening_km", nullable = false)
    private Double openingKm;

    @Column(name = "closing_km", nullable = false)
    private Double closingKm;

    @Column(name = "total_business_km", nullable = false)
    private Double totalBusinessKm;

    @Column(name = "total_personal_km")
    private Double totalPersonalKm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    protected VehicleLogEntry() {}

    public VehicleLogEntry(LocalDate date, LocalTime time, Double openingKm, Double closingKm, Double totalBusinessKm, Double totalPersonalKm, Vehicle vehicle) {
        this.date = date;
        this.time = time;
        this.openingKm = openingKm;
        this.closingKm = closingKm;
        this.totalBusinessKm = totalBusinessKm;
        this.totalPersonalKm = totalPersonalKm;
        this.vehicle = vehicle;
    }

    public Integer getLogEntryId() { return logEntryId; }
    public void setLogEntryId(Integer logEntryId) { this.logEntryId = logEntryId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }
    public Double getOpeningKm() { return openingKm; }
    public void setOpeningKm(Double openingKm) { this.openingKm = openingKm; }
    public Double getClosingKm() { return closingKm; }
    public void setClosingKm(Double closingKm) { this.closingKm = closingKm; }
    public Double getTotalBusinessKm() { return totalBusinessKm; }
    public void setTotalBusinessKm(Double totalBusinessKm) { this.totalBusinessKm = totalBusinessKm; }
    public Double getTotalPersonalKm() { return totalPersonalKm; }
    public void setTotalPersonalKm(Double totalPersonalKm) { this.totalPersonalKm = totalPersonalKm; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
