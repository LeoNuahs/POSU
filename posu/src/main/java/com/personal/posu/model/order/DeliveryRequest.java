package com.personal.posu.model.order;

import com.personal.posu.types.DeliveryMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRequest {
    @NotNull(message = "Customer name cannot be null")
    @Size(min = 2, message = "Please input a customer name")
    private String customer;

    @NotEmpty(message = "Please provide a list of items")
    private List<Integer> contents;

    @NotNull(message = "Address cannot be null")
    @Size(min = 1, message = "Please input an address")
    private String address;

    @NotNull(message = "Please provide a delivery method")
    private DeliveryMethod method;
}
