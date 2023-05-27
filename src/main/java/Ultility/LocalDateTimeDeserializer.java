/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultility;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author FPTSHOP
 */
public class LocalDateTimeDeserializer implements JsonDeserializer <LocalDateTime>{
    @Override
    public LocalDateTime deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        return LocalDateTime.parse(je.getAsString(),
            DateTimeFormatter.ofPattern("d/M/y").withLocale(Locale.ENGLISH));
    }
    
}
