package com.kodilla.ecommercee.TestDAO;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTestSuite {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void TestProductDtoSave(){

        //Given
        Product product = new Product(1L, "Product", "Description", 12.34, "szt.", new Group(), new ArrayList<Cart>());

        //When
        productRepository.save(product);

        //Then
/*        Optional<Product> read = productRepository.findById(1L);
        assertTrue(read.isPresent());

        //CleanUp
        productRepository.deleteById(1L);               */

    }
}