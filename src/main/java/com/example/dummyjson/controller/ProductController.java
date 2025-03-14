package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Retorna um Flux para permitir uma resposta assíncrona com uma lista de produtos
    @GetMapping
    public Flux<Product> getAllProducts() {
        return productService.getAllProducts(); // Flux permite resposta reativa de uma lista
    }

    // Retorna um Mono para permitir uma resposta assíncrona com um único produto
    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable @NotNull Long id) {
        return productService.getProductById(id); // Mono permite resposta reativa de um único produto
    }
}
