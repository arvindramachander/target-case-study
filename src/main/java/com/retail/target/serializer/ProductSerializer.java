package com.retail.target.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.retail.target.entity.Product;

import java.io.IOException;

public class ProductSerializer extends StdSerializer<Product> {
    public ProductSerializer() {
        this(null);
    }

    public ProductSerializer(Class<Product> t) {
        super(t);
    }

    @Override
    public void serialize(Product product, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeStringField("id", product.getId());
        jgen.writeStringField("name", product.getTitle());
        jgen.writeObjectField("current_price", product.getPrice());
        jgen.writeEndObject();
    }
}
