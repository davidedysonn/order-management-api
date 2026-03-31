package com.davidbelfort.order_management_api.services;

import com.davidbelfort.order_management_api.entities.OrderItem;

public interface OrderItemService {
    OrderItem create (OrderItem orderItem);
    OrderItem read (Long id);
    OrderItem readName (String name);
    OrderItem update (Long id);
    Void delete (Long id);
}
