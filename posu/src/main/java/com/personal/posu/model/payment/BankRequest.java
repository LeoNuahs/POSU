package com.personal.posu.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankRequest {
    @NotNull(message = "Please provide an order ID")
    private Integer orderId;

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    @NotNull(message = "Account number cannot be null")
    @Size(min = 10, max = 16, message = "Please input a valid account number")
    private String accountNo;

    @NotNull(message = "Bank name cannot be null")
    private String bankName;

    @NotNull(message = "Contact number cannot be null")
    @Size(min = 11, max = 11, message = "Please input a valid contact number")
    private String contactNo;
}
