package com.kodilla.ecommercee.TestDAO;

import com.kodilla.ecommercee.domain.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {
/*    @Autowired
//    private CartRepository cartRepository;

    @Test
    public void TestCartDaoSave(){
        //Given
        // User user1 = new user("marcin","alamakota","marcin11@gmail.com");
        Cart cart = new Cart(1L, new Date(1234567890), new Date(1234567891), false );
        //When
//        cartRepository.save(cart);
        //Then
        Optional<Cart> readCart = cartRepository.findById(1L);
        assertTrue(readCart.isPresent());
        //CleanUp
        cartRepository.deleteById(1L);
    }               */
}