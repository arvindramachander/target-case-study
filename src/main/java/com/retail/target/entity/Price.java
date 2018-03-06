package com.retail.target.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.retail.target.serializer.PriceSerializer;
import org.springframework.data.annotation.Id;

@JsonSerialize(using = PriceSerializer.class)
public class Price {
    @Id
    private String productId;
    private double price;
    private String currency;

    public Price(String productId, double price, String currency) {
        this.productId = productId;
        this.price = price;
        this.currency = currency;
    }

    public double getValue() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
