package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @GetMapping("/showAllOrders")
    public List<OrderDto> showAllOrders() {
        return new ArrayList<>();
    }

    @PostMapping("/addNewOrder")
    public void addNewOrder(@RequestBody OrderDto orderDto) {

    }

    @GetMapping("/showOrder/{orderId}")
    public OrderDto showOrder(@PathVariable("orderId") Long orderId) {
        return new OrderDto(1L, "test_order");
    }

    @PutMapping("/updateOrder/{orderId}")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, "test order edited");
    }

    @DeleteMapping("/removeOrder/{orderId}")
    public void removeOrder(@RequestParam("orderId") Long orderId) {
    }

}
