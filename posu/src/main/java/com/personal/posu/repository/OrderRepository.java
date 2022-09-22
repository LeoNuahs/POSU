package com.personal.posu.repository;

import com.personal.posu.entity.order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Integer> {
    @Query("{$and: [ {$or: [ {'paid': false}, {'served': false} ]}, {'canceled': false} ]}")
    List<Order> findPendingOrders();
}
