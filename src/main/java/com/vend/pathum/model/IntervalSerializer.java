package com.vend.pathum.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import sun.jvm.hotspot.utilities.Interval;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class IntervalSerializer extends JsonSerializer {




    @Override
    public void serialize(Object value, JsonGenerator jGen, SerializerProvider serializers) throws IOException {
        jGen.writeStartObject();
        jGen.writeString("price" + value);
        jGen.writeEndObject();
    }


}