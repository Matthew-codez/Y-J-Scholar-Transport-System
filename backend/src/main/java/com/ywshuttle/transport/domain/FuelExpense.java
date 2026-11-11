package com.ywshuttle.transport.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fuel_expenses")
public class FuelExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Integer expenseId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    protected FuelExpense() {}

    public FuelExpense(LocalDate date, Double cost, Vehicle vehicle) {
        this.date = date;
        this.cost = cost;
        this.vehicle = vehicle;
    }

    public Integer getExpenseId() { return expenseId; }
    public void setExpenseId(Integer expenseId) { this.expenseId = expenseId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Double getCost() { return cost; }
    public void setCost(Double cost) { this.cost = cost; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
