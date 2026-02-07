package com.playground.springbootpractice;

import com.playground.springbootpractice.entities.Product;
import com.playground.springbootpractice.entities.User;
import com.playground.springbootpractice.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootPracticeApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootPracticeApplication.class, args);

        ProductService service = context.getBean(ProductService.class);

        Product product = service.findProduct(2L);
        User user = product.getUser();

        System.out.println(user.getUsername());
    }
}
