package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.DriverRouteAssignment;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.DriverRouteAssignmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver-route-assignments")
public class DriverRouteAssignmentController {
    private final DriverRouteAssignmentService service;

    public DriverRouteAssignmentController(DriverRouteAssignmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DriverRouteAssignment>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("DriverRouteAssignments retrieved successfully", service.getAllDriverRouteAssignments()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DriverRouteAssignment>> getById(@PathVariable Integer id) {
        DriverRouteAssignment entity = service.getDriverRouteAssignmentById(id)
                .orElseThrow(() -> new RuntimeException("DriverRouteAssignment not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("DriverRouteAssignment retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DriverRouteAssignment>> create(@Valid @RequestBody DriverRouteAssignment entity) {
        return new ResponseEntity<>(ApiResponse.success("DriverRouteAssignment created successfully", service.createDriverRouteAssignment(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DriverRouteAssignment>> update(@PathVariable Integer id, @Valid @RequestBody DriverRouteAssignment entity) {
        return ResponseEntity.ok(ApiResponse.success("DriverRouteAssignment updated successfully", service.updateDriverRouteAssignment(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteDriverRouteAssignment(id);
        return ResponseEntity.ok(ApiResponse.success("DriverRouteAssignment deleted successfully", null));
    }
}
