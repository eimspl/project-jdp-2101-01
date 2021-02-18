package com.kodilla.ecommercee.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
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
    @Column
    private Long cartId;

    @OneToOne
    @MapsId
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

    @ManyToMany
    @JoinTable
    private Set<Cart> listOfProducts;

    public Cart(Order order, User user, Date dateOfReservation, Date termOfEndReservation, Boolean isOrdered, Set<Cart> listOfProducts ){
        this.order = order;
        this.user = user;
        this.dateOfReservation = dateOfReservation;
        this.termOfEndReservation = termOfEndReservation;
        this.isOrdered = isOrdered;
        this.listOfProducts = listOfProducts;
    }
}