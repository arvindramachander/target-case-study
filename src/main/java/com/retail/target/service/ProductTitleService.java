package com.retail.target.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ProductTitleService {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    private String url = "http://redsky.target.com/v2/pdp/tcin/{productId}";

    Optional<String> getTitle(String productId) {
        JSONObject json;
        String productName = null;
        try {
            ResponseEntity<String> response
                    = restTemplate.getForEntity(url, String.class, productId);

            json = new JSONObject(response.getBody());
            productName = json.getJSONObject("product").getJSONObject("item").getJSONObject("product_description").getString("title");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productName == null ? Optional.empty() : Optional.of(productName);
    }
}