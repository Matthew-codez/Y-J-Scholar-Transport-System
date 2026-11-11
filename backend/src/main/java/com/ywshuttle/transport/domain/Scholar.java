package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "scholars")
public class Scholar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scholar_id")
    private Integer scholarId;

    @Column(nullable = false)
    private String name;

    @Column(name = "pickup_address")
    private String pickupAddress;

    @Column(name = "dropoff_address")
    private String dropoffAddress;

    @Column(name = "scholar_status")
    private String scholarStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;

    protected Scholar() {}

    public Scholar(String name, String pickupAddress, String dropoffAddress, String scholarStatus, Parent parent, School school, Route route) {
        this.name = name;
        this.pickupAddress = pickupAddress;
        this.dropoffAddress = dropoffAddress;
        this.scholarStatus = scholarStatus;
        this.parent = parent;
        this.school = school;
        this.route = route;
    }

    public Integer getScholarId() { return scholarId; }
    public void setScholarId(Integer scholarId) { this.scholarId = scholarId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(String pickupAddress) { this.pickupAddress = pickupAddress; }
    public String getDropoffAddress() { return dropoffAddress; }
    public void setDropoffAddress(String dropoffAddress) { this.dropoffAddress = dropoffAddress; }
    public String getScholarStatus() { return scholarStatus; }
    public void setScholarStatus(String scholarStatus) { this.scholarStatus = scholarStatus; }
    public Parent getParent() { return parent; }
    public void setParent(Parent parent) { this.parent = parent; }
    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }
    public Route getRoute() { return route; }
    public void setRoute(Route route) { this.route = route; }
}
