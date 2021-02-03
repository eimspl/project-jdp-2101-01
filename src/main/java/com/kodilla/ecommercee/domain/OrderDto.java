package com.kodilla.ecommercee.domain;

import lombok.*;

@Getter
@AllArgsConstructor
public class OrderDto {
    private Long orderId;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cart_id", referencedColumnName = "order_id")
//    private Cart cart;

    private String orderStatus;

    private String paymentMethod;

    private Double totalValue;

    private java.sql.Timestamp paymentDate;

    private java.sql.Timestamp realisationDate;

    private boolean isPaid;
}
