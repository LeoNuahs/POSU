package com.personal.posu.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditRequest {
    @NotNull(message = "Please provide an order ID")
    private Integer orderId;

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    @NotNull(message = "Card number cannot be null")
    @Size(min = 16, max = 16, message = "Please input a valid card number")
    private String cardNo;
}
