package com.example.dummyjson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de saúde do microsserviço.
 * Este endpoint será acessado para verificar a saúde do sistema.
 */
@RestController
public class HealthController {

    /**
     * Endpoint de saúde do microsserviço.
     * Retorna a resposta OK para indicar que o sistema está funcionando.
     */
    @GetMapping("/health")
    public String checkHealth() {
        return "OK"; // Simplesmente retorna 'OK' quando o microsserviço está saudável.
    }
}
