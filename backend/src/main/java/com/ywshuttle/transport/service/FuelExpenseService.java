package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.FuelExpense;

import java.util.List;
import java.util.Optional;

public interface FuelExpenseService {
    FuelExpense createFuelExpense( FuelExpense entity );

    List<FuelExpense> getAllFuelExpenses();

    Optional<FuelExpense> getFuelExpenseById(Integer id);

    FuelExpense updateFuelExpense(Integer id, FuelExpense entityDetails);

    void deleteFuelExpense(Integer id);
}
