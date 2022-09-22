package com.personal.posu.entity.payment;

import com.personal.posu.entity.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Bank extends Payment{
    private String accountNo;
    private String bankName;
    private String contactNo;

    public Bank(int id, Order order, double amount, double change, String accountNo, String bankName, String contactNo) {
        super(id, order, amount, change);
        this.accountNo = accountNo;
        this.bankName = bankName;
        this.contactNo = contactNo;
    }
}
