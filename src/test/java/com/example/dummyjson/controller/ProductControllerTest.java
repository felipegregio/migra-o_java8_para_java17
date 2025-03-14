package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    void testGetAllProducts() {
        // Criando um Flux de produtos mockados
        Product product1 = new Product(1L, "Product 1", "Description 1", 100.0);
        Product product2 = new Product(2L, "Product 2", "Description 2", 200.0);
        
        // Flux.just cria um Flux com os produtos mockados
        Flux<Product> productFlux = Flux.just(product1, product2);

        // Configurando o mock para retornar Flux
        when(productService.getAllProducts()).thenReturn(productFlux);

        // Testando o método do controller
        Flux<Product> result = productController.getAllProducts();

        // Verificando o resultado
        assertNotNull(result);  // Verificando se o resultado não é nulo
        assertEquals(2, result.collectList().block().size());  // Coletando os elementos do Flux e verificando a quantidade
    }

    @Test
    void testGetProductById() {
        // Criando um produto mockado
        Product product = new Product(1L, "Product 1", "Description 1", 100.0);
        
        // Mono.just cria um Mono com o produto mockado
        Mono<Product> productMono = Mono.just(product);

        // Configurando o mock para retornar Mono
        when(productService.getProductById(1L)).thenReturn(productMono);

        // Testando o método do controller
        Mono<Product> result = productController.getProductById(1L);

        // Verificando o resultado
        assertNotNull(result);  // Verificando se o resultado não é nulo
        //assertEquals("Product 1", result.block().getName());  // Verificando o nome do produto retornado pelo Mono
        assertEquals("Product 1", result.block().getTitle());  // Verificando o nome do produto retornado pelo Mono
    }
}
