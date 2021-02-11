package com.kodilla.ecommercee.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "cart_id", unique = true)
    private Long cartId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "order_id")
    private Order order;


    @ManyToOne
    @JoinColumn(name = "USER")
    private User user;

    @Column(name = "DATE_OF_RESERVATION")
    private Date dateOfReservation;

    @Column(name = "TERM_OF_END_RESERVATION")
    private Date termOfEndReservation;

    @Column(name = "IS_ORDERED")
    private Boolean isOrdered;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "Product_Carts",
//            joinColumns = {@JoinColumn(name = "cart_id")},
//            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID")}
//
//    )
//    private Set<Cart> listOfProducts;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Product_Carts",
            joinColumns = {@JoinColumn(name = "CART_ID",referencedColumnName = "CART_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID",referencedColumnName = "PRODUCT_ID")} //tutaj czekam na encję product

    )
    private List<Product> listOfProducts;

}
