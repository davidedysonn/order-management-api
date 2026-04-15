package com.davidbelfort.order_management_api.services.impl;

import com.davidbelfort.order_management_api.entities.Customer;
import com.davidbelfort.order_management_api.repositories.CustomerRepository;
import com.davidbelfort.order_management_api.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer custumer) {

            if( custumer.getName() == null || custumer.getName().isBlank() ){
                throw new RuntimeException("Name is required!");
            }

            if( custumer.getEmail() == null || custumer.getEmail().isBlank() ){
                throw new RuntimeException("Email is required!");
            }
            return customerRepository.save(custumer);
    }

    @Override
    public Customer read(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer with id:" + id + " not found"));
    }

    @Override
    public Customer readName(String name) {
            return customerRepository.findByName(name)
                    .orElseThrow(()-> new RuntimeException("Customer not fund with name: "+ name + ", plese try again or other name." ));
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer cust  = customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not fund with id: " + id + ", plese try again or other id."));
        if( !(customer.getName() == null || customer.getName().isBlank()) ){
            cust.setName(customer.getName());
        }
        if(!(customer.getEmail() ==  null || customer.getEmail().isBlank()) ){
            cust.setEmail(customer.getEmail());
        }

        return customerRepository.save(cust);
    }

    @Override
    public void delete(Long id) {
        Customer customer = customerRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Customer not found!"));

        customerRepository.delete(customer);
    }
}
