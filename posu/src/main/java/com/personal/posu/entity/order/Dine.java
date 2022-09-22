package com.personal.posu.entity.order;

import com.personal.posu.entity.menu.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Dine extends Order{
    private int tableNo;

    public Dine(int orderId, String customer, List<Menu> contents, double price, LocalDateTime date, boolean paid, boolean served, boolean canceled, int tableNo) {
        super(orderId, customer, contents, price, date, paid, served, canceled);
        this.tableNo = tableNo;
    }
}
