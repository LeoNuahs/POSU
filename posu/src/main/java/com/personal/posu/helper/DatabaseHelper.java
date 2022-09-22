package com.personal.posu.helper;

import com.personal.posu.entity.menu.Menu;
import com.personal.posu.entity.order.Order;
import com.personal.posu.exception.DatabaseException;
import com.personal.posu.exception.PaymentException;
import com.personal.posu.repository.MenuRepository;
import com.personal.posu.types.ExceptionType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseHelper {
    /**
     * Checks if the list of items exist in the collection.
     * @param itemIds List of Integers
     * @param itemRepository MongoRepository
     * @return list of items from the collection
     * @throws DatabaseException 10002L
     */
    public List<Menu> checkItemsExist(List<Integer> itemIds, MenuRepository itemRepository) throws DatabaseException {
        List<Menu> items = new ArrayList<>();

        for (Integer itemId : itemIds) {
            if (itemRepository.findItem(itemId).isEmpty()) {
                throw new DatabaseException(
                        itemId.toString(),
                        ExceptionType.ITEM_NOT_FOUND_EXCEPTION
                );
            }

            items.add(itemRepository.returnNotOptional(itemId));
        }

        return items;
    }

    /**
     * Calculates the total price of the items.
     * @param items List of Items
     * @return total amount
     */
    public double getOrderTotal(List<Menu> items) {
        double total = 0;

        for (Menu menu : items) {
            total += menu.getPrice();
        }

        return total;
    }

    /**
     *
     * @param order Order
     * @param change double
     * @throws PaymentException 30001L, 30002L
     */
    public void paymentErrorCheck(Order order, double change) throws PaymentException {
        if (order.isPaid()) throw new PaymentException(
                String.valueOf(order.getOrderId()),
                ExceptionType.PAYMENT_ALREADY_MADE_EXCEPTION
        );

        if (change < 0) throw new PaymentException(
                ExceptionType.PAYMENT_INSUFFICIENT_EXCEPTION
        );
    }
}
