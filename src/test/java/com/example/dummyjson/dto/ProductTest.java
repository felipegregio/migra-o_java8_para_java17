package com.example.dummyjson.dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import jakarta.validation.constraints.NotNull;

@RunWith(MockitoJUnitRunner.class)
public class ProductTest {

    @Test
    public void testGetAndSetter() {
        Long expectId = 1L;
        String expectedTitle = "A dummy title";
        String expectedDescription = "A dummy description";
        Double expectedPrice = 2.1; // Tipo primitivo para Double

        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("A dummy title");
        product1.setDescription("A dummy description");
        product1.setPrice(2.1); // Usando tipo primitivo para Double

        Assert.assertEquals(expectId, product1.getId());
        Assert.assertEquals(expectedTitle, product1.getTitle());
        Assert.assertEquals(expectedDescription, product1.getDescription());
        Assert.assertEquals(expectedPrice, product1.getPrice(), 0.001); // Comparação com margem de erro para valores de ponto flutuante
    }
}
