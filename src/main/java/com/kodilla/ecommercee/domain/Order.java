package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ORDER_ID")
    private Long orderId;

    @OneToOne(mappedBy = "order" ,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cart cart;

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

    public Order( String orderStatus, String paymentMethod, Double totalValue, Timestamp paymentDate,
                  Timestamp realisationDate,  boolean isPaid){
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
        this.totalValue = totalValue;
        this.paymentDate = paymentDate;
        this.realisationDate = realisationDate;
        this.isPaid = isPaid;
    }
}

