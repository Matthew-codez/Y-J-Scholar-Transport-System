package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.Payment;
import com.ywshuttle.transport.repository.PaymentRepository;
import com.ywshuttle.transport.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment createPayment(Payment entity) {
        return repository.save(entity);
    }

    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Payment updatePayment(Integer id, Payment entityDetails) {
        Payment entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deletePayment(Integer id) {
        Payment entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
        repository.delete(entity);
    }
}
