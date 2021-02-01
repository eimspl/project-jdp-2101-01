package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/Product")
@CrossOrigin("*")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getAllProducts")
    public List<ProductDto> getAllProducts() {
        return new ArrayList<>();
    }

    @GetMapping("/getProduct/{id}")
    public ProductDto getProduct(@RequestParam("id") Long productId) {
        return new ProductDto(1L, "Name of product", "Description of product", 200, 2L);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct")
    public void addProduct(@RequestBody ProductDto productDto) {
        System.out.println("Adding new product.");
    }

    @PutMapping("/updateProduct/{id}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return new ProductDto(1L, "New name of product", "New description of product", 678.9, 5L);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@RequestParam("id") Long productId) {
        System.out.println("Deleting product.");
    }
}
