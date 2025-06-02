package com.sample.rest.WebApi.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.rest.Domain.Entities.Product;
import com.sample.rest.Domain.Interfaces.IProductRepository;
import com.sample.rest.WebApi.DTO.ProductsGet;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    @Autowired
    private final IProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductsGet>> index() {
        var productsList = productRepository.findAllProductsGetDto();

        return ResponseEntity.status(200).body(productsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable UUID id) {
        var product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

        System.out.println(String.format("UUID -> %s and this is the output", id));
        
        return ResponseEntity.status(200).body(product);
    }
}
