package com.davidbelfort.order_management_api.repositories;

import com.davidbelfort.order_management_api.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
