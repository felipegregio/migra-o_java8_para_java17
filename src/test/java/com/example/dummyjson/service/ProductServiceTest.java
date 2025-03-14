package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Teste de integração para o serviço de produtos. Aqui, estamos verificando se o
 * endpoint da API retorna corretamente os dados de um produto.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Inicia o servidor em uma porta aleatória para testes
public class ProductServiceTest {

    @Value("${local.server.port}")
    private int port; // Injeta a porta do servidor para usar na URL da requisição

    @Autowired
    private ProductService productService; // Serviço real para testar o comportamento real da aplicação

    @Autowired
    private WebTestClient webTestClient; // Usado para testar endpoints HTTP em vez de mocks

    /**
     * Teste para garantir que o produto seja retornado corretamente pela API.
     * A requisição GET é feita para o endpoint /products/{id}.
     */
    @Test
    public void testGetProduct() {
        // URL completa com a porta aleatória atribuída para o servidor
        String url = "http://localhost:" + port + "/products/1"; 

        // Fazendo a requisição GET ao endpoint e verificando a resposta
        webTestClient.get().uri(url)
                .exchange()  // Executa a requisição
                .expectStatus().isOk()  // Verifica se o status da resposta é 200 (OK)
                .expectBody(Product.class)  // Espera que o corpo da resposta seja um objeto Product
                .value(product -> {
                    assertNotNull(product); // Verifica que o produto retornado não é nulo
                    assertEquals(1L, product.getId()); // Verifica se o ID do produto é o esperado
                    assertEquals("Test Product", product.getTitle()); // Verifica se o título do produto é o esperado
                    assertEquals(100.0, product.getPrice()); // Verifica se o preço do produto é o esperado
                });
    }
}

// Comentários explicativos:
// - Estamos usando @SpringBootTest para inicializar o contexto do Spring e executar o servidor de teste.
// - WebTestClient é uma ferramenta moderna do Spring para realizar testes de integração de endpoints HTTP.
// - O teste foca em garantir que a API de produtos retorne os dados corretos para o produto requisitado.
// - A URL é construída com a porta dinâmica para simular uma requisição real ao servidor.
// - As asserções verificam se o produto retornado tem os atributos corretos.
