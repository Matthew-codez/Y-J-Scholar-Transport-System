package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.Scholar;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.ScholarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scholars")
public class ScholarController {
    private final ScholarService service;

    public ScholarController(ScholarService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Scholar>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Scholars retrieved successfully", service.getAllScholars()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Scholar>> getById(@PathVariable Integer id) {
        Scholar entity = service.getScholarById(id)
                .orElseThrow(() -> new RuntimeException("Scholar not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("Scholar retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Scholar>> create(@Valid @RequestBody Scholar entity) {
        return new ResponseEntity<>(ApiResponse.success("Scholar created successfully", service.createScholar(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Scholar>> update(@PathVariable Integer id, @Valid @RequestBody Scholar entity) {
        return ResponseEntity.ok(ApiResponse.success("Scholar updated successfully", service.updateScholar(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteScholar(id);
        return ResponseEntity.ok(ApiResponse.success("Scholar deleted successfully", null));
    }
}
