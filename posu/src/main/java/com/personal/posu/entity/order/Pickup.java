package com.personal.posu.entity.order;

import com.personal.posu.entity.menu.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Pickup extends Order{
    private String phoneNo;
    private int estimatedTime;

    public Pickup(int orderId, String customer, List<Menu> contents, double price, LocalDateTime date, boolean paid, boolean served, boolean canceled, String phoneNo, LocalTime estimatedTime) {
        super(orderId, customer, contents, price, date, paid, served, canceled);
        this.phoneNo = phoneNo;
        this.estimatedTime = estimatedTime.getMinute();
    }
}
