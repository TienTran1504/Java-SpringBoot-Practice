package net.javaguides.springbootsearchrestapi.service;

import net.javaguides.springbootsearchrestapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
