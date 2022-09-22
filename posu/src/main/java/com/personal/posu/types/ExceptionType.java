package com.personal.posu.types;

import lombok.Getter;

@Getter
public enum ExceptionType {
    SAVE_ITEM_EXCEPTION(
            10001L,
            "Unable to save item."
    ),

    ITEM_NOT_FOUND_EXCEPTION(
            10002L,
            "No item found: "
    ),

    EMPTY_ITEM_CATEGORY_EXCEPTION(
            10003L,
            "Category is empty: "
    ),

    ITEM_ALREADY_DELETED_EXCEPTION(
            10004L,
            "Item already deleted: "
    ),

    SAVE_ORDER_EXCEPTION(
            20001L,
            "Unable to save order."
    ),

    ORDER_NOT_FOUND_EXCEPTION(
            20002L,
            "No order found: "
    ),

    PAYMENT_ALREADY_MADE_EXCEPTION(
            30001L,
            "Order already paid: "
    ),

    PAYMENT_INSUFFICIENT_EXCEPTION(
            30002L,
            "Insufficient amount paid."
    )
    ;
    private final Long id;
    private final String message;

    ExceptionType(long id, String message) {
        this.id = id;
        this.message = message;
    }
}
