package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
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