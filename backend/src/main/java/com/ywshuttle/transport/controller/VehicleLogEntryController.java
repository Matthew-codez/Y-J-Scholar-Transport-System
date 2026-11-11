package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.VehicleLogEntry;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.VehicleLogEntryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-log-entries")
public class VehicleLogEntryController {
    private final VehicleLogEntryService service;

    public VehicleLogEntryController(VehicleLogEntryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<VehicleLogEntry>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("VehicleLogEntrys retrieved successfully", service.getAllVehicleLogEntrys()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VehicleLogEntry>> getById(@PathVariable Integer id) {
        VehicleLogEntry entity = service.getVehicleLogEntryById(id)
                .orElseThrow(() -> new RuntimeException("VehicleLogEntry not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("VehicleLogEntry retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VehicleLogEntry>> create(@Valid @RequestBody VehicleLogEntry entity) {
        return new ResponseEntity<>(ApiResponse.success("VehicleLogEntry created successfully", service.createVehicleLogEntry(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<VehicleLogEntry>> update(@PathVariable Integer id, @Valid @RequestBody VehicleLogEntry entity) {
        return ResponseEntity.ok(ApiResponse.success("VehicleLogEntry updated successfully", service.updateVehicleLogEntry(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteVehicleLogEntry(id);
        return ResponseEntity.ok(ApiResponse.success("VehicleLogEntry deleted successfully", null));
    }
}
