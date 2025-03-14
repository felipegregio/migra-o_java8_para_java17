package com.example.dummyjson.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Teste para o controlador de saúde.
 * Verifica se o endpoint /health retorna a resposta correta.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HealthControllerTest {

    @Autowired
    private WebTestClient webTestClient; // WebTestClient para testar endpoints HTTP

    @Test
    public void testHealthEndpoint() {
        // Realizando uma requisição GET para o endpoint /health
        webTestClient.get().uri("/health")
                .exchange()  // Executa a requisição
                .expectStatus().isOk()  // Verifica se o status é 200 OK
                .expectBody(String.class)  // Espera que a resposta seja uma String
                .value(response -> {
                    assertEquals("OK", response);  // Verifica se a resposta é "OK"
                });
    }
}
