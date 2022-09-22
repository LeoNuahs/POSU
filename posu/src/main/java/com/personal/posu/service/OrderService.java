package com.personal.posu.service;

import com.personal.posu.entity.menu.Menu;
import com.personal.posu.entity.order.Delivery;
import com.personal.posu.entity.order.Dine;
import com.personal.posu.entity.order.Order;
import com.personal.posu.entity.order.Pickup;
import com.personal.posu.exception.DatabaseException;
import com.personal.posu.helper.DatabaseHelper;
import com.personal.posu.model.order.DeliveryRequest;
import com.personal.posu.model.order.DineRequest;
import com.personal.posu.model.order.EditOrderRequest;
import com.personal.posu.model.order.PickupRequest;
import com.personal.posu.repository.MenuRepository;
import com.personal.posu.repository.OrderRepository;
import com.personal.posu.types.ExceptionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {
    private OrderRepository orderRepository;
    private MenuRepository menuRepository;
    private NextSequenceService nextSequenceService;
    private DatabaseHelper databaseHelper;

    public List<Order> getPendingOrders() {
        return orderRepository.findPendingOrders();
    }

    public Order saveOrder(DineRequest dineInRequest) throws DatabaseException {
        List<Integer> itemIds = dineInRequest.getContents();
        List<Menu> items = databaseHelper.checkItemsExist(itemIds, menuRepository);
        double total = databaseHelper.getOrderTotal(items);

        try {
            Dine order = new Dine(
                    nextSequenceService.getNextSequence("OrderSequence"),
                    dineInRequest.getCustomer(),
                    items,
                    total,
                    LocalDateTime.now(),
                    false,
                    false,
                    false,
                    dineInRequest.getTableNo()
            );
            return orderRepository.save(order);
        } catch (Exception ex) {
            throw new DatabaseException(
                    ex,
                    ExceptionType.SAVE_ORDER_EXCEPTION
            );
        }
    }

    public Order saveOrder(DeliveryRequest deliveryRequest) throws DatabaseException {
        List<Integer> itemIds = deliveryRequest.getContents();
        List<Menu> items = databaseHelper.checkItemsExist(itemIds, menuRepository);
        double total = databaseHelper.getOrderTotal(items);

        try {
            Delivery order = new Delivery(
                    nextSequenceService.getNextSequence("OrderSequence"),
                    deliveryRequest.getCustomer(),
                    items,
                    total,
                    LocalDateTime.now(),
                    false,
                    false,
                    false,
                    deliveryRequest.getAddress(),
                    deliveryRequest.getMethod()
            );

            return orderRepository.save(order);
        } catch (Exception ex) {
            throw new DatabaseException(
                    ex,
                    ExceptionType.SAVE_ORDER_EXCEPTION
            );
        }
    }

    public Order saveOrder(PickupRequest pickUpRequest) throws DatabaseException {
        List<Integer> itemIds = pickUpRequest.getContents();
        List<Menu> items = databaseHelper.checkItemsExist(itemIds, menuRepository);
        double total = databaseHelper.getOrderTotal(items);

        try {
            Pickup order = new Pickup(
                    nextSequenceService.getNextSequence("OrderSequence"),
                    pickUpRequest.getCustomer(),
                    items,
                    total,
                    LocalDateTime.now(),
                    false,
                    false,
                    false,
                    pickUpRequest.getPhoneNo(),
                    pickUpRequest.getEstimatedTime().minusMinutes(LocalTime.now().getMinute())
            );

            return orderRepository.save(order);
        } catch (Exception ex) {
            throw new DatabaseException(
                    ex,
                    ExceptionType.SAVE_ORDER_EXCEPTION
            );
        }
    }

    public Order editOrder(int id, EditOrderRequest editOrderRequest) throws DatabaseException {
        Order order = orderRepository.findById(id).orElseThrow(() -> new DatabaseException(
                String.valueOf(id),
                ExceptionType.ORDER_NOT_FOUND_EXCEPTION
        ));
        List<Integer> itemIds = editOrderRequest.getContents();
        List<Menu> items = databaseHelper.checkItemsExist(itemIds, menuRepository);

        order.setCustomer(editOrderRequest.getCustomer());
        order.setContents(items);
        order.setPrice(databaseHelper.getOrderTotal(items));
        order.setDate(LocalDateTime.now());
        order.setPaid(editOrderRequest.isPaid());
        order.setServed(editOrderRequest.isServed());
        order.setCanceled(editOrderRequest.isCanceled());

        return orderRepository.save(order);
    }
}
