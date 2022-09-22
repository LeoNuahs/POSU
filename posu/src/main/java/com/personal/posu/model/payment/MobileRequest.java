package com.personal.posu.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileRequest {
    @NotNull(message = "Please provide an order ID")
    private Integer orderId;

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    @NotNull(message = "Mobile number cannot be null")
    @Size(min = 11, max = 11, message = "Please input a valid mobile number")
    private String mobileNo;
}
