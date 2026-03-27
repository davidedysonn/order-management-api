package com.davidbelfort.order_management_api.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
//    private String customer;
    private LocalDateTime orderDate;
    private String status;
    private Integer items;
    private Double totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany
    private OrderItem orderItem;



    public Order() {
    }

    public Order(Long id, LocalDateTime orderDate, String status, Integer items, Double totalAmount, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.status = status;
        this.items = items;
        this.totalAmount = totalAmount;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer='" + customer + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
