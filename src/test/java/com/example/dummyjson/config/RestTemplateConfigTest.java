package com.example.dummyjson.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RestTemplateConfigTest {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Test
    public void testWebClientConfig() {
        // Verifica se o WebClient.Builder foi injetado corretamente
        assertNotNull(webClientBuilder);

        // Verifica se o WebClient pode ser construído
        WebClient webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
        assertNotNull(webClient); // Confirma se o WebClient foi criado com sucesso
    }
}
