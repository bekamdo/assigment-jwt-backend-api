package com.bekamdo.bootstrap;

import com.bekamdo.customer.Customer;
import com.bekamdo.customer.CustomerRepository;
import com.bekamdo.products.Products;
import com.bekamdo.products.ProductsRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BootStrap implements CommandLineRunner {
    private final ProductsRepository productsRepository;
    private final CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        // Generate 20 customers
        for (int i = 0; i < 20; i++) {
            Customer customer = Customer.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .phoneNumber(faker.phoneNumber().phoneNumber())
                    .build();

            customerRepository.save(customer);
        }

        // Generate 20 products
        for (int i = 0; i < 20; i++) {
            Products product = Products.builder()
                    .name(faker.commerce().productName())
                    .description(faker.commerce().material())
                    .price(faker.commerce().price())
                    .build();

            productsRepository.save(product);
        }
    }
}

