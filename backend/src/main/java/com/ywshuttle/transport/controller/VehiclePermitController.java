package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.VehiclePermit;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.VehiclePermitService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-permits")
public class VehiclePermitController {
    private final VehiclePermitService service;

    public VehiclePermitController(VehiclePermitService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<VehiclePermit>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("VehiclePermits retrieved successfully", service.getAllVehiclePermits()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VehiclePermit>> getById(@PathVariable Integer id) {
        VehiclePermit entity = service.getVehiclePermitById(id)
                .orElseThrow(() -> new RuntimeException("VehiclePermit not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("VehiclePermit retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VehiclePermit>> create(@Valid @RequestBody VehiclePermit entity) {
        return new ResponseEntity<>(ApiResponse.success("VehiclePermit created successfully", service.createVehiclePermit(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<VehiclePermit>> update(@PathVariable Integer id, @Valid @RequestBody VehiclePermit entity) {
        return ResponseEntity.ok(ApiResponse.success("VehiclePermit updated successfully", service.updateVehiclePermit(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteVehiclePermit(id);
        return ResponseEntity.ok(ApiResponse.success("VehiclePermit deleted successfully", null));
    }
}
