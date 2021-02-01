package com.kodilla.ecommercee.domain;

import lombok.Getter;
import javax.persistence.*;

@Getter
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Integer user_id;

    private Integer cart_id;

    @Column(columnDefinition = "VARCHAR(20)")
    private String orderStatus;

    @Column(columnDefinition = "VARCHAR(15)")
    private String paymentMethod;

    private Double totalValue;

    private java.sql.Date paymentDate;

    private java.sql.Date realisationDate;

    private boolean isPaid;
}


