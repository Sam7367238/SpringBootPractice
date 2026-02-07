package com.playground.springbootpractice.services;

import com.playground.springbootpractice.entities.Product;
import com.playground.springbootpractice.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void saveProduct() {
        Product product = new Product("Product 1", BigDecimal.valueOf(10.99));

        repository.save(product);
    }

    public void findProduct(Long id) {
        Product product = repository.findById(id).orElseThrow();

        System.out.println("Fetched Product: " + product.getName());
    }

    public void findProducts() {
        List<Product> products = repository.findAll();

        products.forEach(product -> System.out.println("Product: " + product.getName()));
    }

    public void paginateProducts(int pageNumber, int limit) {
        PageRequest pageRequest = PageRequest.of(pageNumber, limit);

        Page<Product> page = repository.findAll(pageRequest);

        List<Product> products = page.getContent();

        System.out.printf("| Page %s (%d) |\n", pageNumber, page.getTotalElements());

        products.forEach(product -> System.out.println("- " + product.getName()));
    }
}
