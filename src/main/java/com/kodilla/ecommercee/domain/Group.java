package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GROUPS_OF_PRODUCTS")
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    /*    //do zaimplementowania po dodaniu przez inną osobę klasy Product do maina
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = " ",
            cascade = CasadeType.REMOVE,
            fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList();
     */
}