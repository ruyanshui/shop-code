package com.example.commoncore.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateSerializer extends JsonObjectSerializer<Date> {

    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    protected void serializeObject(Date date, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        String value = dateFormat.format(date);
        jgen.writeString(value);
    }
}
