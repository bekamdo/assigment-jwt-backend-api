package com.bekamdo.products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductsRepository productsRepository;

    public List<Products> getAllProducts(){
     return   productsRepository.findAll();
    }
}
