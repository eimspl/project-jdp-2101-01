package com.kodilla.ecommercee.TestDao;

import com.kodilla.ecommercee.repository.OrderRepository;
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
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;
import static org.junit.Assert.*;

@EnableTransactionManagement
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
        Set<Cart> set = new HashSet<>();
        User user1 = new User("Marcin","Alamakota","Marcin11@gmail.com");
        Order order = new Order("Status testowy", "Metoda testowa", 500.0,
                new Timestamp(12345678900L), new Timestamp(12345900000L), false );
        Cart cart= new Cart(order , user1, new Timestamp(12345678900L),new Timestamp(12345900000L),false, set);
        System.out.println("");
        System.out.println("CART_ID= "+cart.getCartId()+" DateOfReservation= "+cart.getDateOfReservation()+" DateOfEnd= "
                +cart.getTermOfEndReservation()+" Ordered= "+cart.getIsOrdered());
        System.out.println("OrderID="+order.getOrderId()+" status="+order.getOrderStatus()+" metoda="
                +order.getPaymentMethod()+" value="+order.getTotalValue()+" date1="+order.getRealisationDate()+" date2="
                +order.getPaymentDate()+" isordered="+order.isPaid());
        System.out.println(" userId="+user1.getUserId()+" name="+user1.getUserName()+" password="+user1.getPassword()+" email="+user1.getEmailAddress());
        System.out.println("");
       cart.setCartId(1000L);
       // order.setOrderId(1000L);
        Long cartId = cart.getCartId();
        System.out.println("cartId="+cartId);
        //When
        cartRepository.save(cart);
        //Then
        Optional<Cart> readCart = cartRepository.findById(1000L);
       // Optional<Cart> readCart = cartRepository.findCartByDateOfReservation(new Timestamp(12345678900L));
        assertTrue(readCart.isPresent()); // NIE PRZECHODZI TEST OBECNOSCI REKORDU W BAZIE DANYCH
        //CleanUp
        try {
            cartRepository.deleteById(cartId);
        }catch (Exception e){
            System.out.println("Nie kasuje");
        }
    }
    @Test
    public void TestCartDaoCreate(){
        //Give
        Set<Cart> set = new HashSet<>();
        Order order = new Order();
        User user1 = new User("Marcin","Alamakota","Marcin11@gmail.com");
        Cart cart = new Cart(order, user1, new Timestamp(12345678900L), new Timestamp(12345900000L) ,true, set );
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
        Set<Cart> set = new HashSet<>();
        Order order = new Order();
        User user1 = new User("Marcin","Alamakota","Marcin11@gmail.com");
        Cart cart1 = new Cart(order, user1, new Timestamp(12345678900L), new Timestamp(12345900000L) ,false, set );
        System.out.println("ID= "+ cart1.getCartId()+" DateOfRezervation= "+cart1.getDateOfReservation()+" DateOfEnd= "
                +cart1.getTermOfEndReservation()+" Ordered= "+cart1.getIsOrdered());
        //When
        Cart cartS = cartRepository.save(cart1);
        System.out.println("ID= "+cartS.getCartId()+" DateOfReservation= "+cartS.getDateOfReservation()+" DateOfEnd= "
                +cartS.getTermOfEndReservation()+" Ordered= "+cartS.getIsOrdered());
        //Then
        Optional<Cart> readCart1 = cartRepository.findById(3000L);
        assertTrue(readCart1.isPresent());
        Cart cart2 = new Cart(order, user1, new Timestamp(15345678900L), new Timestamp(15345900000L) ,true, set );
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
        Set<Cart> set = new HashSet<>();
        Product product = new Product();
        product.setDescription("test");
        product.setProductId(1L);
        product.setName("Test");
        Order order = new Order();
        order.setOrderId(1L);
        User user1 = new User("Marcin","Alamakota","Marcin11@gmail.com");
        Cart cart1 = new Cart(order,  user1, new Timestamp(12345678900L), new Timestamp(12345900000L) ,false, set );
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

