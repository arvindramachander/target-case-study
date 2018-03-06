package com.retail.target.service;

import com.retail.target.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    String productId;

    @Before
    public void setUp() throws Exception {
        productId = "13860428";
    }

    @Test
    public void shouldReturnProductWithValidId() {
        Optional<Product> optionalProduct = productService.getProduct(productId);
        assertTrue(optionalProduct.isPresent());
    }

    @Test
    public void shouldReturnEmptyOptionalForInvalidId() {
        Optional<Product> optionalProduct = productService.getProduct("invalid");
        assertFalse(optionalProduct.isPresent());
    }

    @Test
    public void shouldReturnProductWithValidTitle() {
        Optional<Product> optionalProduct = productService.getProduct(productId);
        String expected = "The Big Lebowski (Blu-ray)";
        String actual = optionalProduct.isPresent() ? optionalProduct.get().getTitle() : null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnProductWithAPrice() {
        Optional<Product> optionalProduct = productService.getProduct(productId);
        Product expected = optionalProduct.orElse(null);
        assertNotNull(expected);
    }

    @Test
    public void shouldReturnProductWithAValidPrice() {
        Optional<Product> optionalProduct = productService.getProduct(productId);
        Double expected = optionalProduct.get().getPrice().getValue();
        double actual = 100.0;
        double delta = 0.001;

        assertEquals(expected, actual, delta);
    }
}