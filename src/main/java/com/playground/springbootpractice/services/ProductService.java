package com.playground.springbootpractice.services;

import com.playground.springbootpractice.entities.Product;
import com.playground.springbootpractice.entities.User;
import com.playground.springbootpractice.repositories.ProductRepository;
import com.playground.springbootpractice.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public void saveProduct() {
        Product product = new Product("Product 1", BigDecimal.valueOf(10.99));

        productRepository.save(product);
    }

    public Product findProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();

        return product;
    }

    public void findProducts() {
        List<Product> products = productRepository.findAll();

        products.forEach(product -> System.out.println("Product: " + product.getName()));
    }

    public void paginateProducts(int pageNumber, int limit) {
        PageRequest pageRequest = PageRequest.of(pageNumber, limit);

        Page<Product> page = productRepository.findAll(pageRequest);

        List<Product> products = page.getContent();

        System.out.printf("| Page %s (%d) |\n", pageNumber, page.getTotalElements());

        products.forEach(product -> System.out.println("- " + product.getName()));
    }

    @Transactional
    public void saveUser() {
        User user = new User("Dummy");

        userRepository.save(user);

        Product product = new Product("Random Product", BigDecimal.valueOf(10.00));

        user.addProduct(product);
    }
}
