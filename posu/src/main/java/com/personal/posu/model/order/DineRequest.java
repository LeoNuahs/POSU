package com.personal.posu.model.order;

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
public class DineRequest {
    @NotNull(message = "Please input a customer name")
    @Size(min = 2, message = "Please input a customer name")
    private String customer;

    @NotEmpty(message = "Please provide a list of items")
    private List<Integer> contents;

    @NotNull(message = "Please provide a table number")
    private int tableNo;
}
