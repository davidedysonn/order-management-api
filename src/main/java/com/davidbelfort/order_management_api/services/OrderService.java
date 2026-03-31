package com.davidbelfort.order_management_api.services;

import com.davidbelfort.order_management_api.entities.Order;

public interface OrderService {
    Order create (Order order);
    Order read (Long id);
    Order readName (String name);
    Order update (Long id);
    Void delete (Long id);
}
