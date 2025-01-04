package Ultility;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeSerializer implements JsonSerializer< LocalDateTime >{
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
    
    @Override
    public JsonElement serialize(LocalDateTime t, Type type, JsonSerializationContext jsc) {
        return new JsonPrimitive(formatter.format(t));
    }
}
