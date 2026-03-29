package com.davidbelfort.order_management_api.repositories;

import com.davidbelfort.order_management_api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
