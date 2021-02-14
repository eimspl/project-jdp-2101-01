package com.kodilla.ecommercee.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "CARTS")
public class Cart {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID",unique = true)
    private Long id;

   // @ManyToOne
   // @JoinColumn(name="USER")
   // private User user;

    @Column(name = "DATE_OF_RESERVATION")
    private Date dateOfReservation;

    @Column(name = "TERM_OF_END_RESERVATION")
    private Date termOfEndReservation;

    @Column(name = "IS_ORDERED")
    private Boolean isOrdered;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Product_Carts",
            joinColumns = {@JoinColumn(name = "CART_ID",referencedColumnName = "CART_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID",referencedColumnName = "PRODUCT_ID")} //tutaj czekam na encję product

    )
    private List<Product> listOfProducts;


}
