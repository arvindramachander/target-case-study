package com.retail.target.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.retail.target.entity.Price;
import com.retail.target.entity.Product;

import java.io.IOException;

public class ProductDeserializer extends JsonDeserializer<Product> {
    @Override
    public Product deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String productId;
        String title;
        Double value;
        String currency;

        try {
            JsonNode node = p.getCodec().readTree(p);
            productId = node.get("id").textValue();
            title = node.get("name").textValue();
            JsonNode priceNode = node.get("current_price");
            value = priceNode.get("value").doubleValue();
            currency = priceNode.get("currency_code").textValue();
        } catch (Exception e) { // To generic ** revisit **
            return null;
        }

        Price price = new Price(productId, value, currency);
        return new Product(productId, title, price);
    }
}
