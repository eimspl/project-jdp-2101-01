package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/v1/Cart")
@CrossOrigin("*")
public class CartController {
    private Cart cart;

    @RequestMapping(method = RequestMethod.GET, value = "getNewCart")
    public CartDto createNewCart(@RequestParam Long userId) {
        return new CartDto(1L,"first cart");
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public ProductDto getProducts(@RequestParam Long cartId) {
        return new ProductDto(1L,"New Product","New description",20.20, "szt.", 5L);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProducts")
    public ProductDto addProduct(@RequestParam Long cartId) {
        return new ProductDto(2L,"Added Product","Added description",60.60, "szt.", 6L);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public ProductDto deleteProduct(@RequestParam Long cartId) {
        return new ProductDto(3L,"Deleted product","Deleted description",100.100, "szt.", 10L);
    }

    @PostMapping(value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {

        return new OrderDto(1L, cart,"New order", "card", 2.0, new Timestamp(20200525123420L), new Timestamp(20200423142304L), true);
    }
}
