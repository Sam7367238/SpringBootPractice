package com.playground.springbootpractice.repositories;

import com.playground.springbootpractice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
