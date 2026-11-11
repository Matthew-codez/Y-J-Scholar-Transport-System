package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.Parent;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.ParentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
public class ParentController {
    private final ParentService service;

    public ParentController(ParentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Parent>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Parents retrieved successfully", service.getAllParents()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Parent>> getById(@PathVariable Integer id) {
        Parent entity = service.getParentById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("Parent retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Parent>> create(@Valid @RequestBody Parent entity) {
        return new ResponseEntity<>(ApiResponse.success("Parent created successfully", service.createParent(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Parent>> update(@PathVariable Integer id, @Valid @RequestBody Parent entity) {
        return ResponseEntity.ok(ApiResponse.success("Parent updated successfully", service.updateParent(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteParent(id);
        return ResponseEntity.ok(ApiResponse.success("Parent deleted successfully", null));
    }
}
