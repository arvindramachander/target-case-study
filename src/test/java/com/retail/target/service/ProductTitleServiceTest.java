package com.retail.target.service;

import com.retail.target.service.ProductTitleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTitleServiceTest {

    @Autowired
    ProductTitleService client;

    String productId;

    @Before
    public void setUp() throws Exception {
        productId = "13860428";
    }

    @Test
    public void shouldGetTheTitleGivenAValidProductId() {
        Optional<String> expected = client.getTitle(productId);
        assertTrue(expected.isPresent());
    }

    @Test
    public void shouldReturnEmptyForInvalidProductID() {
        Optional<String> expected = client.getTitle("invalid");
        assertFalse(expected.isPresent());
    }
}