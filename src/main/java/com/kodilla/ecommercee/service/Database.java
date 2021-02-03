package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.OrderRepository;
import com.kodilla.ecommercee.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Database {

    @Autowired
    private final OrderRepository repository;

    public Order addOrder(final Order order){
        return repository.save(order);
    }
}
