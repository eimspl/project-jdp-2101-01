package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/order")
public class OrderController {
    private final Database database;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(Database database, OrderMapper orderMapper) {
        this.database = database;
        this.orderMapper = orderMapper;
    }


    @GetMapping("/showAllOrders")
    public List<OrderDto> showAllOrders() {
        return new ArrayList<>();
    }

    @PostMapping(value = "/addNewOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order addNewOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        return database.addOrder(order);

    }

    @GetMapping("/showOrder/{orderId}")
    public OrderDto showOrder(@PathVariable("orderId") Long orderId) {
        return new OrderDto(1L, "test_order", "", 200.0, new Timestamp(20020202122202L), new Timestamp(20010203092302L), true );
    }

    @PutMapping("/updateOrder/{orderId}")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, "test_order", "", 200.0, new Timestamp(20020202122202L), new Timestamp(20010203092302L), true );
    }

    @DeleteMapping("/removeOrder/{orderId}")
    public void removeOrder(@RequestParam("orderId") Long orderId) {
    }
}
