package com.personal.posu.controller;

import com.personal.posu.entity.order.Order;
import com.personal.posu.exception.DatabaseException;
import com.personal.posu.model.order.DeliveryRequest;
import com.personal.posu.model.order.DineRequest;
import com.personal.posu.model.order.EditOrderRequest;
import com.personal.posu.model.order.PickupRequest;
import com.personal.posu.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/order") // Port 8080
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping()
    public ResponseEntity<List<Order>> getPendingOrders() {
        return ResponseEntity.ok(orderService.getPendingOrders());
    }

    @PostMapping("/add/dine")
    public ResponseEntity<Order> saveOrder(@RequestBody @Valid DineRequest dineRequest) throws DatabaseException {
        return new ResponseEntity<>(orderService.saveOrder(dineRequest), HttpStatus.CREATED);
    }

    @PostMapping("/add/delivery")
    public ResponseEntity<Order> saveOrder(@RequestBody @Valid DeliveryRequest deliveryRequest) throws DatabaseException {
        return new ResponseEntity<>(orderService.saveOrder(deliveryRequest), HttpStatus.CREATED);
    }

    @PostMapping("/add/pickup")
    public ResponseEntity<Order> saveOrder(@RequestBody @Valid PickupRequest pickupRequest) throws DatabaseException {
        return new ResponseEntity<>(orderService.saveOrder(pickupRequest), HttpStatus.CREATED);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Order> editOrder(@PathVariable int id, @RequestBody @Valid EditOrderRequest editOrderRequest) throws DatabaseException {
        return new ResponseEntity<>(orderService.editOrder(id, editOrderRequest), HttpStatus.OK);
    }
}
