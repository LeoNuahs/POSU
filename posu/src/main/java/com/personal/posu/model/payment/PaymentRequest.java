package com.personal.posu.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    @NotNull(message = "Please provide an order ID")
    private Integer orderId;

    @NotNull(message = "Amount cannot be null")
    private Double amount;
}
