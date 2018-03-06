package com.retail.target.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.retail.target.deserializer.ProductDeserializer;
import com.retail.target.serializer.ProductSerializer;

@JsonSerialize(using = ProductSerializer.class)
@JsonDeserialize(using = ProductDeserializer.class)
public class Product {
    private String id;
    private String title;
    private Price price;

    public Product(String id, String title, Price price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Price getPrice() {
        return price;
    }
}
