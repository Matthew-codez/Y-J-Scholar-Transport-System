package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.Attendance;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.AttendanceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {
    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Attendance>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Attendances retrieved successfully", service.getAllAttendances()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Attendance>> getById(@PathVariable Integer id) {
        Attendance entity = service.getAttendanceById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("Attendance retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Attendance>> create(@Valid @RequestBody Attendance entity) {
        return new ResponseEntity<>(ApiResponse.success("Attendance created successfully", service.createAttendance(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Attendance>> update(@PathVariable Integer id, @Valid @RequestBody Attendance entity) {
        return ResponseEntity.ok(ApiResponse.success("Attendance updated successfully", service.updateAttendance(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deleteAttendance(id);
        return ResponseEntity.ok(ApiResponse.success("Attendance deleted successfully", null));
    }
}
