package com.personal.posu.entity.payment;

import com.personal.posu.entity.order.Order;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Data
@Document(collection = "Payments")
@NoArgsConstructor
public class Payment{
    @Id
    private int id;
    @DocumentReference(collection = "Orders")
    private Order order;
    private double amount;
    private double change;
    @CreatedDate
    private LocalDateTime time;

    public Payment(int id, Order order, double amount, double change) {
        this.id = id;
        this.order = order;
        this.amount = amount;
        this.change = change;
        this.time = LocalDateTime.now();
    }
}
