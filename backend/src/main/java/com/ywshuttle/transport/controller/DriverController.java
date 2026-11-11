package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.Driver;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Driver>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Drivers retrieved successfully", service.getAllDrivers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Driver>> getById(@PathVariable Integer id) {
        Driver entity = service.getDriverById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("Driver retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Driver>> create(@Valid @RequestBody Driver entity) {
        return new ResponseEntity<>(ApiResponse.success("Driver created successfully", service.createDriver(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Driver>> update(@PathVariable Integer id, @Valid @RequestBody Driver entity) {
        return ResponseEntity.ok(ApiResponse.success("Driver updated successfully", service.updateDriver(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteDriver(id);
        return ResponseEntity.ok(ApiResponse.success("Driver deleted successfully", null));
    }
}
