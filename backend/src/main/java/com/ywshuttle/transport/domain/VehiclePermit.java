package com.ywshuttle.transport.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vehicle_permits")
public class VehiclePermit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permit_id")
    private Integer permitId;

    @Column(name = "permit_no", nullable = false)
    private Integer permitNo;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    protected VehiclePermit() {}

    public VehiclePermit(Integer permitNo, LocalDate issueDate, LocalDate expiryDate, Vehicle vehicle) {
        this.permitNo = permitNo;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.vehicle = vehicle;
    }

    public Integer getPermitId() { return permitId; }
    public void setPermitId(Integer permitId) { this.permitId = permitId; }
    public Integer getPermitNo() { return permitNo; }
    public void setPermitNo(Integer permitNo) { this.permitNo = permitNo; }
    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
