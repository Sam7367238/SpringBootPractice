package com.playground.springbootpractice.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "price", nullable = false, precision = 9, scale = 2)
    @NonNull
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}