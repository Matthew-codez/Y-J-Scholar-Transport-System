package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment createPayment( Payment entity );

    List<Payment> getAllPayments();

    Optional<Payment> getPaymentById(Integer id);

    Payment updatePayment(Integer id, Payment entityDetails);

    void deletePayment(Integer id);
}
