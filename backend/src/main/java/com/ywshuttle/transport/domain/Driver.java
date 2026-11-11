package com.ywshuttle.transport.domain;

import com.ywshuttle.transport.domain.enums.EmploymentStatus;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Integer driverId;

    @Column(nullable = false)
    private String name;

    @Column(name = "phone_no")
    private String phoneNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "employment_status")
    private EmploymentStatus employmentStatus;

    @OneToMany(mappedBy = "driver")
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "driver")
    private List<Attendance> attendances = new ArrayList<>();

    protected Driver() {}

    public Driver(String name, String phoneNo, EmploymentStatus employmentStatus) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.employmentStatus = employmentStatus;
    }

    public Integer getDriverId() { return driverId; }
    public void setDriverId(Integer driverId) { this.driverId = driverId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public EmploymentStatus getEmploymentStatus() { return employmentStatus; }
    public void setEmploymentStatus(EmploymentStatus employmentStatus) { this.employmentStatus = employmentStatus; }
    public List<Vehicle> getVehicles() { return vehicles; }
    public void setVehicles(List<Vehicle> vehicles) { this.vehicles = vehicles; }
    public List<Attendance> getAttendances() { return attendances; }
    public void setAttendances(List<Attendance> attendances) { this.attendances = attendances; }
}
