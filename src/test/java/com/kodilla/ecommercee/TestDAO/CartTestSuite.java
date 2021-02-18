package com.kodilla.ecommercee.TestDAO;
import com.kodilla.ecommercee.OrderRepository;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void TestCartDaoSave(){
        //Give
        Set<Product> set = new HashSet<>();
        Product product = new Product();
        product.setDescription("test");
        product.setProductId(1L);
        product.setName("Test");
        set.add(product);
        Order order = new Order();
        order.setOrderId(1L);
        User user1 = new User("Marcin","Alamakota","Marcin11@gmail.com");
        Cart cart= new Cart(1000L,order , user1, new Timestamp(12345678900L),new Timestamp(12345900000L),false, set);
        System.out.println("CART_ID= "+cart.getCartId()+" DateOfReservation= "+cart.getDateOfReservation()+" DateOfEnd= "
                +cart.getTermOfEndReservation()+" Ordered= "+cart.getIsOrdered());
        //When
        cartRepository.save(cart);
        //Then
        Optional<Cart> readCart = cartRepository.findById(1000L);
        assertTrue(readCart.isPresent()); // NIE PRZECHODZI TEST OBECNOSCI REKORDU W BAZIE DANYCH
        //CleanUp
        try {
            cartRepository.deleteById(1000L);
        }catch (Exception e){
            System.out.println("Nie kasuje");
        }
    }
    @Test
    public void TestCartDaoCreate(){
        //Give
        Set<Product> set = new HashSet<>();
        Product product = new Product();
        product.setDescription("test");
        product.setProductId(1L);
        product.setName("Test");
        set.add(product);
        Order order = new Order();
        User user1 = new User("Marcin","Alamakota","Marcin11@gmail.com");
        Cart cart = new Cart(2000L ,order, user1, new Timestamp(12345678900L), new Timestamp(12345900000L) ,true, set );
        System.out.println("ID= "+ cart.getCartId()+" DateOfRezervation= "+cart.getDateOfReservation()+" DateOfEnd= "
                +cart.getTermOfEndReservation()+" Ordered= "+cart.getIsOrdered());
        //When
        Cart cartS = cartRepository.save(cart);
        System.out.println("ID= "+cartS.getCartId()+" DateOfReservation= "+cartS.getDateOfReservation()+" DateOfEnd= "
                +cartS.getTermOfEndReservation()+" Ordered= "+cartS.getIsOrdered());
        //Then
        Optional<Cart> readCart = cartRepository.findById(2000L);
        assertEquals( new Timestamp(12345678900L), readCart.map(Cart::getDateOfReservation).orElse(new Timestamp(1L)));
        assertEquals( new Timestamp(12345900000L), readCart.map(Cart::getTermOfEndReservation).orElse(new Timestamp(1L)));
        assertEquals(true , readCart.map(Cart::getIsOrdered).orElse(false));
        //CleanUp
        try {
            cartRepository.deleteById(2000L);
        }catch (Exception e){
            System.out.println("Nie kasuje");
        }
    }
    @Test
    public void TestCartDaoModification(){
        //Give
        Set<Product> set = new HashSet<>();
        Product product = new Product();
        product.setDescription("test");
        product.setProductId(1L);
        product.setName("Test");
        set.add(product);
        Order order = new Order();
        User user1 = new User("Marcin","Alamakota","Marcin11@gmail.com");
        Cart cart1 = new Cart(3000L,order, user1, new Timestamp(12345678900L), new Timestamp(12345900000L) ,false, set );
        System.out.println("ID= "+ cart1.getCartId()+" DateOfRezervation= "+cart1.getDateOfReservation()+" DateOfEnd= "
                +cart1.getTermOfEndReservation()+" Ordered= "+cart1.getIsOrdered());
        //When
        Cart cartS = cartRepository.save(cart1);
        System.out.println("ID= "+cartS.getCartId()+" DateOfReservation= "+cartS.getDateOfReservation()+" DateOfEnd= "
                +cartS.getTermOfEndReservation()+" Ordered= "+cartS.getIsOrdered());
        //Then
        Optional<Cart> readCart1 = cartRepository.findById(3000L);
        assertTrue(readCart1.isPresent());
        Cart cart2 = new Cart(3000L,order, user1, new Timestamp(15345678900L), new Timestamp(15345900000L) ,true, set );
        cartRepository.save(cart2);
        Optional<Cart> readCart2 = cartRepository.findById(3000L);
        assertEquals( new Timestamp(15345678900L), readCart2.map(Cart::getDateOfReservation).orElse(new Date(1L)));
        assertEquals( new Timestamp(15345900000L), readCart2.map(Cart::getTermOfEndReservation).orElse(new Date(1L)));
        assertEquals(true , readCart2.map(Cart::getIsOrdered).orElse(false));
        //CleanUp
        try {
            cartRepository.deleteById(3000L);
        }catch (Exception e){
            System.out.println("Nie kasuje");
        }
    }
    @Test
    public void TestCartDaoDelete() {
        //Give
        Set<Product> set = new HashSet<>();
        Product product = new Product();
        product.setDescription("test");
        product.setProductId(1L);
        product.setName("Test");
        set.add(product);
        Order order = new Order();
        order.setOrderId(1L);
        User user1 = new User("Marcin","Alamakota","Marcin11@gmail.com");
        Cart cart1 = new Cart(4000L,order,  user1, new Timestamp(12345678900L), new Timestamp(12345900000L) ,false, set );
        //When
        cartRepository.save(cart1);
        Optional<Cart> readCart1 = cartRepository.findById(4000L);
        //Then
        assertTrue(readCart1.isPresent());
        try {
            cartRepository.delete(readCart1.get());
        } catch (Exception e){
            System.out.println("Nie może skasować");
            assertTrue(false);
        }
        Optional<Cart> readCart2 = cartRepository.findById(4000L);
        assertFalse(readCart2.isPresent());
        Optional<Order> readOrder = orderRepository.findById(1L);
        assertFalse(readOrder.isPresent());
        Optional<User> readUser = userRepository.findUserByEmailAddress("Marcin11@gmail.com");
        assertTrue(readUser.isPresent());
    }
}
