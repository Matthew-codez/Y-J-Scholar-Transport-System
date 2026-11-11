package com.ywshuttle.transport.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "driver_route_assignments")
public class DriverRouteAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private Integer assignmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    protected DriverRouteAssignment() {}

    public DriverRouteAssignment(Driver driver, Route route, LocalDate startDate, LocalDate endDate) {
        this.driver = driver;
        this.route = route;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getAssignmentId() { return assignmentId; }
    public void setAssignmentId(Integer assignmentId) { this.assignmentId = assignmentId; }
    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }
    public Route getRoute() { return route; }
    public void setRoute(Route route) { this.route = route; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}
