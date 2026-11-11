package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.FuelExpense;
import com.ywshuttle.transport.repository.FuelExpenseRepository;
import com.ywshuttle.transport.service.FuelExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuelExpenseServiceImpl implements FuelExpenseService {
    private final FuelExpenseRepository repository;

    public FuelExpenseServiceImpl(FuelExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public FuelExpense createFuelExpense(FuelExpense entity) {
        return repository.save(entity);
    }

    @Override
    public List<FuelExpense> getAllFuelExpenses() {
        return repository.findAll();
    }

    @Override
    public Optional<FuelExpense> getFuelExpenseById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public FuelExpense updateFuelExpense(Integer id, FuelExpense entityDetails) {
        FuelExpense entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("FuelExpense not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteFuelExpense(Integer id) {
        FuelExpense entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("FuelExpense not found with id: " + id));
        repository.delete(entity);
    }
}
