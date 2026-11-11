package com.ywshuttle.transport.controller;

import com.ywshuttle.transport.domain.Payment;
import com.ywshuttle.transport.helper.ApiResponse;
import com.ywshuttle.transport.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Payment>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Payments retrieved successfully", service.getAllPayments()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> getById(@PathVariable Integer id) {
        Payment entity = service.getPaymentById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        return ResponseEntity.ok(ApiResponse.success("Payment retrieved successfully", entity));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Payment>> create(@Valid @RequestBody Payment entity) {
        return new ResponseEntity<>(ApiResponse.success("Payment created successfully", service.createPayment(entity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> update(@PathVariable Integer id, @Valid @RequestBody Payment entity) {
        return ResponseEntity.ok(ApiResponse.success("Payment updated successfully", service.updatePayment(id, entity)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.deletePayment(id);
        return ResponseEntity.ok(ApiResponse.success("Payment deleted successfully", null));
    }
}
