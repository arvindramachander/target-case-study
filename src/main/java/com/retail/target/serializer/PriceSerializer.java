package com.retail.target.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.retail.target.entity.Price;

import java.io.IOException;

public class PriceSerializer extends StdSerializer<Price> {
    public PriceSerializer() {
        this(null);
    }

    public PriceSerializer(Class<Price> t) {
        super(t);
    }

    @Override
    public void serialize(Price price, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeNumberField("value", price.getValue());
        jgen.writeStringField("currency_code", price.getCurrency());
        jgen.writeEndObject();
    }

}
