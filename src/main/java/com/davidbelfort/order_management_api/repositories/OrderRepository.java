package com.davidbelfort.order_management_api.repositories;

import com.davidbelfort.order_management_api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
