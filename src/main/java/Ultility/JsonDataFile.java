/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultility;

import View.CommodityManagement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonDataFile {
    public GsonBuilder gsonBuilder = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
    public Gson gson =  gsonBuilder.setPrettyPrinting().create();
    
    public JsonDataFile() {
    }

    public<T extends Object> void save( Path dataPath, T o) {
        try ( PrintWriter pw = new PrintWriter(Files.newBufferedWriter(dataPath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            gson.toJson(o, pw);
        } catch (IOException ex) {
            Logger.getLogger(CommodityManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public<T extends Object> T load(Path dataPath, Type type, T o) {
        try ( BufferedReader br = new BufferedReader(Files.newBufferedReader(dataPath))) {
            o = gson.fromJson(br, type);
        } catch (IOException ex) {
            Logger.getLogger(CommodityManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }
}
