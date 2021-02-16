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
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue
    @NotNull
    @Column
    private Long cartId;

    @OneToOne
    @MapsId
    private Order order;


    @ManyToOne
    @JoinColumn(name = "ID")
    private User user;

    @Column(name = "DATE_OF_RESERVATION")
    private Date dateOfReservation;

    @Column(name = "TERM_OF_END_RESERVATION")
    private Date termOfEndReservation;

    @Column(name = "IS_ORDERED")
    private Boolean isOrdered;

    @ManyToMany
    @JoinTable
    private Set<Product> listOfProducts;        //MUSI BYC PRODUCT a nie CART
}
