package com.kodilla.ecommercee.mapper;


import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order mapToOrder(final OrderDto orderDto){
        return new Order(
                orderDto.getOrderId(),
                orderDto.getOrderStatus(),
                orderDto.getPaymentMethod(),
                orderDto.getTotalValue(),
                orderDto.getPaymentDate(),
                orderDto.getRealisationDate(),
                orderDto.isPaid()
        );
    }
}

