package com.davidbelfort.order_management_api.repositories;

import com.davidbelfort.order_management_api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
