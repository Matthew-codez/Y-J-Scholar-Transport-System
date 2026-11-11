package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.School;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.SchoolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    private final SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<School>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Schools retrieved successfully", service.getAllSchools()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<School>> getById(@PathVariable Integer id) {
        School entity = service.getSchoolById(id)
                .orElseThrow(() -> new RuntimeException("School not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("School retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<School>> create(@Valid @RequestBody School entity) {
        return new ResponseEntity<>(ApiResponse.success("School created successfully", service.createSchool(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<School>> update(@PathVariable Integer id, @Valid @RequestBody School entity) {
        return ResponseEntity.ok(ApiResponse.success("School updated successfully", service.updateSchool(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteSchool(id);
        return ResponseEntity.ok(ApiResponse.success("School deleted successfully", null));
    }
}
