package com.kodilla.ecommercee.TestDAO;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CartTestSuite {
    @Autowired
    private CartRepository cartRepository;

    @Test
    void TestCartDaoSave(){
        //Given
        User user1 = new User("Marcin","Alamakota","Marcin11@gmail.com");
        Cart cart = new Cart(1000L, user1, new Date(1234567890), new Date(1234567891) ,false );
        //When
        cartRepository.save(cart);
        //Then
        Optional<Cart> readCart = cartRepository.findById(1000L);
        assertTrue(readCart.isPresent());
        //CleanUp
        cartRepository.deleteById(1000L);
    }
}
