package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        List<Order> orders = database.getAllOrders();
        return orderMapper.mapToOrderDtoList(orders);
    }

    @GetMapping("/showOrder/{orderId}")
    public Order showOrder(@PathVariable("orderId") Long orderId) throws  OrderNotFoundException {
        Optional<Order> order = database.getOrder(orderId);
        return order.orElseThrow(OrderNotFoundException::new);
    }

    @PutMapping(value = "/updateOrder/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        Order existingOrder = database.saveOrder(orderMapper.mapToOrder(orderDto));
        return orderMapper.mapToOrderDto(existingOrder);
    }

    @DeleteMapping("/removeOrder/{orderId}")
    public void removeOrder(@RequestParam("orderId") Long orderId) {
        database.deleteOrder(orderId);
    }
}
