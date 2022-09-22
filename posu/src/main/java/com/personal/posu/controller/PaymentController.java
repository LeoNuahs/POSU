package com.personal.posu.controller;

import com.personal.posu.entity.payment.Payment;
import com.personal.posu.exception.DatabaseException;
import com.personal.posu.exception.PaymentException;
import com.personal.posu.model.payment.BankRequest;
import com.personal.posu.model.payment.CreditRequest;
import com.personal.posu.model.payment.MobileRequest;
import com.personal.posu.model.payment.PaymentRequest;
import com.personal.posu.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/pay")   // Port 8080
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/cash")
    public ResponseEntity<Payment> saveOrder(@RequestBody @Valid PaymentRequest paymentRequest) throws DatabaseException, PaymentException {
        return new ResponseEntity<>(paymentService.savePayment(paymentRequest), HttpStatus.CREATED);
    }

    @PostMapping("/credit")
    public ResponseEntity<Payment> saveOrder(@RequestBody @Valid CreditRequest creditRequest) throws DatabaseException, PaymentException {
        return new ResponseEntity<>(paymentService.savePayment(creditRequest), HttpStatus.CREATED);
    }

    @PostMapping("/bank")
    public ResponseEntity<Payment> saveOrder(@RequestBody @Valid BankRequest bankRequest) throws DatabaseException, PaymentException {
        return new ResponseEntity<>(paymentService.savePayment(bankRequest), HttpStatus.CREATED);
    }

    @PostMapping("/e-wallet")
    public ResponseEntity<Payment> saveOrder(@RequestBody @Valid MobileRequest mobileRequest) throws DatabaseException, PaymentException {
        return new ResponseEntity<>(paymentService.savePayment(mobileRequest), HttpStatus.CREATED);
    }
}
