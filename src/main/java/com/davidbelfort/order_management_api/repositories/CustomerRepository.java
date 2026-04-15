package com.davidbelfort.order_management_api.repositories;

import com.davidbelfort.order_management_api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName (String name);
}
