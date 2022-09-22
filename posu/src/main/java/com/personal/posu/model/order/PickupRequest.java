package com.personal.posu.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PickupRequest {
    @NotNull(message = "Please input a customer name")
    @Size(min = 2, message = "Please input a customer name")
    private String customer;

    @NotEmpty(message = "Please provide a list of items")
    private List<Integer> contents;

    @NotNull(message = "Phone number cannot be null")
    @Size(min = 11, max = 11, message = "Please input a valid phone number")
    private String phoneNo;

    @Future(message = "Please enter a valid time")
    @NotNull(message = "Time cannot be null")
    private LocalTime estimatedTime;
}
