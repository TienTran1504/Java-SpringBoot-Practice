package com.spring.datajpa.springboot.repository;

import com.spring.datajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        String name = "Product 2";
        Product product = productRepository.findByName(name);
        System.out.println(product.toString());
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        System.out.println(product.toString());
    }

    @Test
    void findByNameOrDescriptionMethod(){
        String name = "Product 3";
        String description = "Product 2 description";
        productRepository.findByNameOrDescription(name, description).forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findByNameAndDescriptionMethod(){
        String name = "Product 3";
        String description = "Product 2 description";
        productRepository.findByNameAndDescription(name, description).forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findDistinctByNameMethod(){
        String name = "Product 3";
        Product product = productRepository.findDistinctByName(name);
        System.out.println(product.toString());
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product>products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product>products = productRepository.findByPriceLessThan(new BigDecimal(400));
        products.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findByNameContainingMethod(){
        String name = "Product";
        List<Product>products = productRepository.findByNameContaining(name);
        products.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findByNameLikeMethod(){
        String name = "Product%";
        List<Product>products = productRepository.findByNameLike(name);
        products.forEach(product -> {
            System.out.println(product.toString());
        });
    }
    @Test
    void findByPriceBetweenMethod(){
        List<Product>products = productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(300));
        products.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){
        LocalDateTime startDate= LocalDateTime.of(2022,02,13,17,48,33);
        LocalDateTime endDate= LocalDateTime.of(2022,02,13,18,48,33);
        List<Product>products = productRepository.findByDateCreatedBetween(startDate, endDate);
//        List<Product>products = productRepository.findByDateCreatedBetween(LocalDateTime.now().minusDays(1), LocalDateTime.now());
        products.forEach(product -> {
            System.out.println(product.toString());
        });

    }

    @Test
    void findByNameInMethod(){
        List<String> names = List.of("Product 2", "Product ");
        List<Product>products = productRepository.findByNameIn(names);
        products.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product>products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach(product -> {
            System.out.println(product.toString());
        });
    }
}
