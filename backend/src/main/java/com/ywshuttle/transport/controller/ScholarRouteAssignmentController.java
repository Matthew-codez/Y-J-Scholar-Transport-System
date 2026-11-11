package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.ScholarRouteAssignment;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.ScholarRouteAssignmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scholar-route-assignments")
public class ScholarRouteAssignmentController {
    private final ScholarRouteAssignmentService service;

    public ScholarRouteAssignmentController(ScholarRouteAssignmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ScholarRouteAssignment>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("ScholarRouteAssignments retrieved successfully", service.getAllScholarRouteAssignments()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ScholarRouteAssignment>> getById(@PathVariable Integer id) {
        ScholarRouteAssignment entity = service.getScholarRouteAssignmentById(id)
                .orElseThrow(() -> new RuntimeException("ScholarRouteAssignment not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("ScholarRouteAssignment retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ScholarRouteAssignment>> create(@Valid @RequestBody ScholarRouteAssignment entity) {
        return new ResponseEntity<>(ApiResponse.success("ScholarRouteAssignment created successfully", service.createScholarRouteAssignment(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ScholarRouteAssignment>> update(@PathVariable Integer id, @Valid @RequestBody ScholarRouteAssignment entity) {
        return ResponseEntity.ok(ApiResponse.success("ScholarRouteAssignment updated successfully", service.updateScholarRouteAssignment(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteScholarRouteAssignment(id);
        return ResponseEntity.ok(ApiResponse.success("ScholarRouteAssignment deleted successfully", null));
    }
}
