package com.spring.datajpa.springboot.repository;

import com.spring.datajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //create product
        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("Product 1 description");
        product.setSku("ABCD1234");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("https://www.google.com");
        //save product
        Product savedProject = productRepository.save(product);
        //display product info
        System.out.println(savedProject.getId());
        System.out.println(savedProject.toString());
    }

    @Test
    void updateUsingSaveMethod(){
        //find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();


        //update the entity with new values
        product.setName("Product 1 updated");
        product.setDescription("Product 1 description updated");
        //save the entity
        Product updatedProduct = productRepository.save(product);

    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        System.out.println(product.toString());
    }

    @Test
    void saveAllMethod(){
        //create product
        Product product = new Product();
        product.setName("Product 2");
        product.setDescription("Product 2 description");
        product.setSku("ABCD1235");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product2.png");

        //create product
        Product product2 = new Product();
        product2.setName("Product 3");
        product2.setDescription("Product 3 description");
        product2.setSku("ABCD1236");
        product2.setPrice(new BigDecimal(300));
        product2.setActive(true);
        product2.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product, product2));
    }

    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();
        products.forEach(product -> System.out.println(product.toString()));
    }

    @Test
    void deleteByIdMethod(){
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        //find or retrieve an entity by id
        Long id = 3L;
        Product product = productRepository.findById(id).get();
        //delete entity
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
//        productRepository.deleteAll();

        Product product = productRepository.findById(6L).get();
        Product product1 = productRepository.findById(7L).get();

        productRepository.deleteAll(List.of(product, product1));
    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod(){
        Long id = 10L;
        boolean exists = productRepository.existsById(id);
        System.out.println(exists);
    }

}