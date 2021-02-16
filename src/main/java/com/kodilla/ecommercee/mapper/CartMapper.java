package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;


public class CartMapper {
    OrderMapper orderMapper;
    UserMapper userMapper;
    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(
                cartDto.getCartId(),
                orderMapper.mapToOrder(cartDto.getOrderDto()),
                userMapper.mapToUser(cartDto.getUserDto()),
                cartDto.getDateOfReservation(),
                cartDto.getTermOfEndReservation(),
                cartDto.getIsOrdered(),
                cartDto.getListOfProducts()
        );
    }

    public CartDto mapToCartDto(final Cart cart){
        return new CartDto(
                cart.getCartId(),
                orderMapper.mapToOrderDto(cart.getOrder()),
                userMapper.mapToUserDto(cart.getUser()),
                cart.getDateOfReservation(),
                cart.getTermOfEndReservation(),
                cart.getIsOrdered(),
                cart.getListOfProducts()
        );
    }
}
