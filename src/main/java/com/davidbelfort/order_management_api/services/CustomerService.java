package com.davidbelfort.order_management_api.services;


import com.davidbelfort.order_management_api.entities.Customer;

public interface CustomerService {
    Customer create (Customer custumer);
    Customer read (Long id);
    Customer readName (String name);
    Customer update (Long id, Customer customer);
    Void delete (Long id);
}
