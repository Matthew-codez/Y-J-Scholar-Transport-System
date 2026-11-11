package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.VehicleMaintenance;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.VehicleMaintenanceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-maintenances")
public class VehicleMaintenanceController {
    private final VehicleMaintenanceService service;

    public VehicleMaintenanceController(VehicleMaintenanceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<VehicleMaintenance>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("VehicleMaintenances retrieved successfully", service.getAllVehicleMaintenances()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VehicleMaintenance>> getById(@PathVariable Integer id) {
        VehicleMaintenance entity = service.getVehicleMaintenanceById(id)
                .orElseThrow(() -> new RuntimeException("VehicleMaintenance not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("VehicleMaintenance retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VehicleMaintenance>> create(@Valid @RequestBody VehicleMaintenance entity) {
        return new ResponseEntity<>(ApiResponse.success("VehicleMaintenance created successfully", service.createVehicleMaintenance(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<VehicleMaintenance>> update(@PathVariable Integer id, @Valid @RequestBody VehicleMaintenance entity) {
        return ResponseEntity.ok(ApiResponse.success("VehicleMaintenance updated successfully", service.updateVehicleMaintenance(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteVehicleMaintenance(id);
        return ResponseEntity.ok(ApiResponse.success("VehicleMaintenance deleted successfully", null));
    }
}
