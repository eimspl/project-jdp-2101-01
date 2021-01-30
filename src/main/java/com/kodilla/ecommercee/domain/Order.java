package com.kodilla.ecommercee.domain;

import lombok.Getter;
import javax.persistence.*;

@Getter
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "order_status")
    private String status;
}


