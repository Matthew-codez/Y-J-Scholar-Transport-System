package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.TripScholar;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.TripScholarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip-scholars")
public class TripScholarController {
    private final TripScholarService service;

    public TripScholarController(TripScholarService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TripScholar>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("TripScholars retrieved successfully", service.getAllTripScholars()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TripScholar>> getById(@PathVariable Integer id) {
        TripScholar entity = service.getTripScholarById(id)
                .orElseThrow(() -> new RuntimeException("TripScholar not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("TripScholar retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TripScholar>> create(@Valid @RequestBody TripScholar entity) {
        return new ResponseEntity<>(ApiResponse.success("TripScholar created successfully", service.createTripScholar(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TripScholar>> update(@PathVariable Integer id, @Valid @RequestBody TripScholar entity) {
        return ResponseEntity.ok(ApiResponse.success("TripScholar updated successfully", service.updateTripScholar(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteTripScholar(id);
        return ResponseEntity.ok(ApiResponse.success("TripScholar deleted successfully", null));
    }
}
