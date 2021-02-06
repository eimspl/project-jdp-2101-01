package com.kodilla.ecommercee.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "CARTS")
public class Cart {

    private Long id;
    private Date dateOfReservation;
    private Date termOfEndReservation;
    private Boolean isOrdered;
    private User user;
    //private List<Product> listOfProducts;


    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "CART_ID",unique = true)
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name="USER")
    public User getUser() {
        return user;
    }

    @Column
    public Date getDateOfReservation() {
        return dateOfReservation;
    }

    @Column
    public Date getTermOfEndReservation() {
        return termOfEndReservation;
    }

    @Column
    public Boolean getIsOrdered() {
        return isOrdered;
    }

    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Product_Carts",
            joinColumns = {@JoinColumn(name = "CART_ID",referencedColumnName = "CART_ID")},
            inverseJoinColumns = {@JoinColumn(name = "")} //tutaj czekam na encję product

    )
    public List<Product> getListOfProducts() {
        return listOfProducts;
     }
     */



    public void setId(Long id) {
        this.id = id;
    }

    public void setDateOfReservation(Date dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public void setTermOfEndReservation(Date termOfEndReservation) {
        this.termOfEndReservation = termOfEndReservation;
    }

    public void setIsOrdered(Boolean ordered) {
        isOrdered = ordered;
    }

    public void setUser(User user) {
        this.user = user;
    }


    /* public void setListOfProducts(List<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    } */
}
