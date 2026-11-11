package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "trip_scholars")
public class TripScholar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_scholar_id")
    private Integer tripScholarId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scholar_id")
    private Scholar scholar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;

    protected TripScholar() {}

    public TripScholar(Scholar scholar, Route route) {
        this.scholar = scholar;
        this.route = route;
    }

    public Integer getTripScholarId() { return tripScholarId; }
    public void setTripScholarId(Integer tripScholarId) { this.tripScholarId = tripScholarId; }
    public Scholar getScholar() { return scholar; }
    public void setScholar(Scholar scholar) { this.scholar = scholar; }
    public Route getRoute() { return route; }
    public void setRoute(Route route) { this.route = route; }
}
