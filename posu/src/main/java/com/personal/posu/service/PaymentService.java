package com.personal.posu.service;

import com.personal.posu.entity.order.Order;
import com.personal.posu.entity.payment.Bank;
import com.personal.posu.entity.payment.Credit;
import com.personal.posu.entity.payment.Mobile;
import com.personal.posu.entity.payment.Payment;
import com.personal.posu.exception.DatabaseException;
import com.personal.posu.exception.PaymentException;
import com.personal.posu.helper.DatabaseHelper;
import com.personal.posu.model.payment.BankRequest;
import com.personal.posu.model.payment.CreditRequest;
import com.personal.posu.model.payment.MobileRequest;
import com.personal.posu.model.payment.PaymentRequest;
import com.personal.posu.repository.OrderRepository;
import com.personal.posu.repository.PaymentRepository;
import com.personal.posu.types.ExceptionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    private OrderRepository orderRepository;
    private NextSequenceService nextSequenceService;
    private DatabaseHelper databaseHelper;

    public Payment savePayment(PaymentRequest paymentRequest) throws DatabaseException, PaymentException {
        Order order = orderRepository.findById(paymentRequest.getOrderId()).orElseThrow(() -> new DatabaseException(
                paymentRequest.getOrderId().toString(),
                ExceptionType.ORDER_NOT_FOUND_EXCEPTION
        ));
        double change = paymentRequest.getAmount() - order.getPrice();

        databaseHelper.paymentErrorCheck(order, change);

        try {
            Payment payment = new Payment(
                    nextSequenceService.getNextSequence("PaymentSequence"),
                    order,
                    paymentRequest.getAmount(),
                    change
            );

            order.setPaid(true);
            orderRepository.save(order);

            return paymentRepository.save(payment);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Payment savePayment(CreditRequest creditRequest) throws DatabaseException, PaymentException {
        Order order = orderRepository.findById(creditRequest.getOrderId()).orElseThrow(() -> new DatabaseException(
                creditRequest.getOrderId().toString(),
                ExceptionType.ORDER_NOT_FOUND_EXCEPTION
        ));
        double change = creditRequest.getAmount() - order.getPrice();

        databaseHelper.paymentErrorCheck(order, change);

        try {
            Payment payment = new Credit(
                    nextSequenceService.getNextSequence("PaymentSequence"),
                    order,
                    creditRequest.getAmount(),
                    change,
                    creditRequest.getCardNo()
            );

            order.setPaid(true);
            orderRepository.save(order);

            return paymentRepository.save(payment);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Payment savePayment(BankRequest bankRequest) throws DatabaseException, PaymentException {
        Order order = orderRepository.findById(bankRequest.getOrderId()).orElseThrow(() -> new DatabaseException(
                bankRequest.getOrderId().toString(),
                ExceptionType.ORDER_NOT_FOUND_EXCEPTION
        ));
        double change = bankRequest.getAmount() - order.getPrice();

        databaseHelper.paymentErrorCheck(order, change);

        try {
            Payment payment = new Bank(
                    nextSequenceService.getNextSequence("PaymentSequence"),
                    order,
                    bankRequest.getAmount(),
                    change,
                    bankRequest.getAccountNo(),
                    bankRequest.getBankName(),
                    bankRequest.getContactNo()
            );

            order.setPaid(true);
            orderRepository.save(order);

            return paymentRepository.save(payment);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Payment savePayment(MobileRequest mobileRequest) throws DatabaseException, PaymentException {
        Order order = orderRepository.findById(mobileRequest.getOrderId()).orElseThrow(() -> new DatabaseException(
                mobileRequest.getOrderId().toString(),
                ExceptionType.ORDER_NOT_FOUND_EXCEPTION
        ));
        double change = mobileRequest.getAmount() - order.getPrice();

        databaseHelper.paymentErrorCheck(order, change);

        try {
            Payment payment = new Mobile(
                    nextSequenceService.getNextSequence("PaymentSequence"),
                    order,
                    mobileRequest.getAmount(),
                    change,
                    mobileRequest.getMobileNo()
            );

            order.setPaid(true);
            orderRepository.save(order);

            return paymentRepository.save(payment);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
