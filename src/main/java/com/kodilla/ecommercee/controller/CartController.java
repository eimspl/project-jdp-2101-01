package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.CartDatabase;
import com.kodilla.ecommercee.service.OrderDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collections;

@RestController
@RequestMapping("/v1/Cart")
@CrossOrigin("*")
public class CartController {

    private final CartDatabase cartDatabase;
    private final CartMapper cartMapper;
    private final OrderDatabase orderDatabase;
    private final OrderMapper orderMapper;

    @Autowired
    public CartController(CartDatabase cartDatabase, CartMapper cartMapper, OrderDatabase orderDatabase, OrderMapper orderMapper) {
        this.cartDatabase = cartDatabase;
        this.cartMapper = cartMapper;
        this.orderDatabase = orderDatabase;
        this.orderMapper = orderMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getNewCart")
    public void saveCart(@RequestBody CartDto cartDto) {
        cartDatabase.saveCart(cartMapper.mapToCart(cartDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public CartDto getProductsFromCart(@RequestParam Long cartId) {
        return cartMapper.mapToCartDto(cartDatabase.getCart(cartId));
    }

     ///////Zastanawiam sie jak to poczynić... będzie pewnie potrzebny mapper do produktu?
  /*  @RequestMapping(method = RequestMethod.POST, value = "addProducts")
    public ProductDto addProduct(@RequestParam Long cartId) {
        return new ProductDto(2L,"Added Product","Added description",60.60, "szt.", 6L);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestParam Long productId) {
        itemService.deleteByCartAndItem(cartDatabase.getCart(cartId), productDatabase.getProduct(productId));
    }
    */

    @PostMapping(value = "createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return orderMapper.mapToOrderDto(orderDatabase.saveOrder(orderMapper.mapToOrder(orderDto)));
    }
}
