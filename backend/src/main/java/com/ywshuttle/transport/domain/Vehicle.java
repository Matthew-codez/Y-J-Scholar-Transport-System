package com.ywshuttle.transport.domain;

import com.ywshuttle.transport.domain.enums.VehicleStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Integer vehicleId;

    @Column(name = "reg_no", nullable = false)
    private Integer regNo;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    protected Vehicle() {}

    public Vehicle(Integer regNo, Integer capacity, String type, VehicleStatus status, Driver driver) {
        this.regNo = regNo;
        this.capacity = capacity;
        this.type = type;
        this.status = status;
        this.driver = driver;
    }

    public Integer getVehicleId() { return vehicleId; }
    public void setVehicleId(Integer vehicleId) { this.vehicleId = vehicleId; }
    public Integer getRegNo() { return regNo; }
    public void setRegNo(Integer regNo) { this.regNo = regNo; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public VehicleStatus getStatus() { return status; }
    public void setStatus(VehicleStatus status) { this.status = status; }
    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }
}
