package com.ywshuttle.transport.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "pickup_area", nullable = false)
    private String pickupArea;

    @Column(name = "dropoff_area", nullable = false)
    private String dropoffArea;

    @Column(name = "monthly_fee", nullable = false)
    private BigDecimal monthlyFee;

    @Column(nullable = false)
    private Double distance;

    @OneToMany(mappedBy = "route")
    private List<Scholar> scholars = new ArrayList<>();

    protected Route() {}

    public Route(String pickupArea, String dropoffArea, BigDecimal monthlyFee, Double distance) {
        this.pickupArea = pickupArea;
        this.dropoffArea = dropoffArea;
        this.monthlyFee = monthlyFee;
        this.distance = distance;
    }

    public Integer getRouteId() { return routeId; }
    public void setRouteId(Integer routeId) { this.routeId = routeId; }
    public String getPickupArea() { return pickupArea; }
    public void setPickupArea(String pickupArea) { this.pickupArea = pickupArea; }
    public String getDropoffArea() { return dropoffArea; }
    public void setDropoffArea(String dropoffArea) { this.dropoffArea = dropoffArea; }
    public BigDecimal getMonthlyFee() { return monthlyFee; }
    public void setMonthlyFee(BigDecimal monthlyFee) { this.monthlyFee = monthlyFee; }
    public Double getDistance() { return distance; }
    public void setDistance(Double distance) { this.distance = distance; }
    public List<Scholar> getScholars() { return scholars; }
    public void setScholars(List<Scholar> scholars) { this.scholars = scholars; }
}
