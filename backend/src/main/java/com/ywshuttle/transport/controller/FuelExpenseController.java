package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.FuelExpense;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.FuelExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuel-expenses")
public class FuelExpenseController {
    private final FuelExpenseService service;

    public FuelExpenseController(FuelExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<FuelExpense>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("FuelExpenses retrieved successfully", service.getAllFuelExpenses()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<FuelExpense>> getById(@PathVariable Integer id) {
        FuelExpense entity = service.getFuelExpenseById(id)
                .orElseThrow(() -> new RuntimeException("FuelExpense not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("FuelExpense retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<FuelExpense>> create(@Valid @RequestBody FuelExpense entity) {
        return new ResponseEntity<>(ApiResponse.success("FuelExpense created successfully", service.createFuelExpense(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<FuelExpense>> update(@PathVariable Integer id, @Valid @RequestBody FuelExpense entity) {
        return ResponseEntity.ok(ApiResponse.success("FuelExpense updated successfully", service.updateFuelExpense(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteFuelExpense(id);
        return ResponseEntity.ok(ApiResponse.success("FuelExpense deleted successfully", null));
    }
}
