package com.ywshuttle.transport.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class FuelExpense {
    @Id
    private Integer expenseId;
    private Date date;
    private double cost;
    protected FuelExpense(){}
}
