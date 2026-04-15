package com.davidbelfort.order_management_api.services;

import com.davidbelfort.order_management_api.entities.Order;

public interface OrderService {
    Order create (Order order);
    Order read (Long id);
    Order update (Long id, Order order);
    void delete (Long id);
}
