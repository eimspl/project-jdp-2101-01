package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cart_id", referencedColumnName = "order_id")
//    private Cart cart;

    @Column
    private String orderStatus;

    @Column
    private String paymentMethod;

    @Column
    private Double totalValue;

    @Column
    private java.sql.Timestamp paymentDate;

    @Column
    private java.sql.Timestamp realisationDate;

    @Column
    private boolean isPaid;
}


