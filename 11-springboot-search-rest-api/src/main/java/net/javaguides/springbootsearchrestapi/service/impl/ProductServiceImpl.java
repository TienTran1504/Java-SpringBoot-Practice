package net.javaguides.springbootsearchrestapi.service.impl;

import net.javaguides.springbootsearchrestapi.entity.Product;
import net.javaguides.springbootsearchrestapi.repository.ProductRepository;
import net.javaguides.springbootsearchrestapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> searchProducts(String query) {
        return productRepository.searchProducts(query);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
