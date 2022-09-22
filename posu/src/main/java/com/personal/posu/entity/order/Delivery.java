package com.personal.posu.entity.order;

import com.personal.posu.entity.menu.Menu;
import com.personal.posu.types.DeliveryMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Delivery extends Order{
    private String address;
    private DeliveryMethod deliveryMethod;

    public Delivery(int orderId, String customer, List<Menu> contents, double price, LocalDateTime date, boolean paid, boolean served, boolean canceled, String address, DeliveryMethod deliveryMethod) {
        super(orderId, customer, contents, price, date, paid, served, canceled);
        this.address = address;
        this.deliveryMethod = deliveryMethod;
    }
}
