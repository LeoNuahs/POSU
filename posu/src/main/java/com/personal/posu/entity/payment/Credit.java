package com.personal.posu.entity.payment;

import com.personal.posu.entity.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Credit extends Payment{
    private String cardNo;

    public Credit(int id, Order order, double amount, double change, String cardNo) {
        super(id, order, amount, change);
        this.cardNo = cardNo;
    }
}
