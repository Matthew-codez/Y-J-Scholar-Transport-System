package com.ywshuttle.transport.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "scholar_route_assignments")
public class ScholarRouteAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private Integer assignmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scholar_id")
    private Scholar scholar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    protected ScholarRouteAssignment() {}

    public ScholarRouteAssignment(Scholar scholar, Route route, LocalDate startDate, LocalDate endDate) {
        this.scholar = scholar;
        this.route = route;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getAssignmentId() { return assignmentId; }
    public void setAssignmentId(Integer assignmentId) { this.assignmentId = assignmentId; }
    public Scholar getScholar() { return scholar; }
    public void setScholar(Scholar scholar) { this.scholar = scholar; }
    public Route getRoute() { return route; }
    public void setRoute(Route route) { this.route = route; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}
