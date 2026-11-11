package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.Vehicle;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Vehicle>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Vehicles retrieved successfully", service.getAllVehicles()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Vehicle>> getById(@PathVariable Integer id) {
        Vehicle entity = service.getVehicleById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("Vehicle retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Vehicle>> create(@Valid @RequestBody Vehicle entity) {
        return new ResponseEntity<>(ApiResponse.success("Vehicle created successfully", service.createVehicle(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Vehicle>> update(@PathVariable Integer id, @Valid @RequestBody Vehicle entity) {
        return ResponseEntity.ok(ApiResponse.success("Vehicle updated successfully", service.updateVehicle(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteVehicle(id);
        return ResponseEntity.ok(ApiResponse.success("Vehicle deleted successfully", null));
    }
}
