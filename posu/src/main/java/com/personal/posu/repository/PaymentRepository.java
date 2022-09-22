package com.personal.posu.repository;

import com.personal.posu.entity.payment.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, Integer> {
}
