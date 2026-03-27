package com.davidbelfort.order_management_api.entities;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
    private Integer integer;
    private Double price;


}
