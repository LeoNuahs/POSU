package com.personal.posu.entity.payment;

import com.personal.posu.entity.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Mobile extends Payment{
    private String mobileNo;

    public Mobile(int id, Order order, double amount, double change, String mobileNo) {
        super(id, order, amount, change);
        this.mobileNo = mobileNo;
    }
}
