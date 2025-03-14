package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class ProductService {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    // Retorna Flux para permitir emissão de múltiplos produtos de forma assíncrona
    public Flux<Product> getAllProducts() {
        return webClientBuilder.baseUrl("https://dummyjson.com")
                               .build()
                               .get()
                               .uri("/products")
                               .retrieve()
                               .bodyToFlux(Product.class); // Flux não bloqueia, emite produtos conforme chega
    }

    // Retorna Mono para permitir emissão de um único produto de forma assíncrona
    public Mono<Product> getProductById(Long productId) {
        return webClientBuilder.baseUrl("https://dummyjson.com")
                               .build()
                               .get()
                               .uri("/products/{id}", productId)
                               .retrieve()
                               .bodyToMono(Product.class); // Mono para um único produto
    }
}
