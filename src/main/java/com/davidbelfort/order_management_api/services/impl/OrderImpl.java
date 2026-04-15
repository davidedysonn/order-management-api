package com.davidbelfort.order_management_api.services.impl;

import com.davidbelfort.order_management_api.entities.Customer;
import com.davidbelfort.order_management_api.entities.Order;
import com.davidbelfort.order_management_api.entities.OrderItem;
import com.davidbelfort.order_management_api.entities.Product;
import com.davidbelfort.order_management_api.repositories.CustomerRepository;
import com.davidbelfort.order_management_api.repositories.OrderRepository;
import com.davidbelfort.order_management_api.repositories.ProductRepository;
import com.davidbelfort.order_management_api.services.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class OrderImpl implements OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    public OrderImpl(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order create(Order order) {
        Customer customer = customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order newOrder = new Order();
        newOrder.setCustomer(customer);
        newOrder.setOrderDate(LocalDateTime.now());

        BigDecimal total = BigDecimal.ZERO;

        for (OrderItem item : order.getOrderItems()) {

            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock");
            }

            product.setStock(product.getStock() - item.getQuantity());

            item.setOrder(newOrder);
            item.setProduct(product);
            item.setPrice(product.getPrice());

            total = total.add(
                    product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
            );
        }

        newOrder.setOrderItems(order.getOrderItems());
        newOrder.setTotalAmount(total);

        return orderRepository.save(newOrder);
    }

    @Override
    public Order read(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order with id: "+ id + " not fund"));
    }

    @Override
    public Order update(Long id, Order order) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order with id: "+ id+ " not fund"));

        if ( order.getCustomer() != null && order.getCustomer().getId() != null ){
            existingOrder.setCustomer( customerRepository.findById(order.getCustomer().getId())
                    .orElseThrow(()-> new RuntimeException("Customer in order not founded")));
        }

        existingOrder.setOrderItems(order.getOrderItems());
//        r.setOrderDate(LocalDateTime.now());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setTotalAmount(order.getTotalAmount());

        return orderRepository.save(existingOrder);
    }

    @Override
    public void delete(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }
}
