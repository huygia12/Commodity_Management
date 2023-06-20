/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class Settings {
    @SerializedName("myStore")
    @Expose
    private Store myStore = new Store();
    @SerializedName("priceAmountList")
    @Expose
    private List<String> priceAmountList = new ArrayList<>();
    
    public Settings() {
    }
    public void save() {
        // Convert Settings to JSON string using Gson library
        Gson gson = new Gson();
        String json = gson.toJson(this);
        
        try (FileWriter writer = new FileWriter("settings.json")) {
            // Save JSON string to file
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Settings saved!");
    }



    public Store getStore() {
        return myStore;
    }

    public void setStore(Store myStore) {
        this.myStore = myStore;
    }

    public List<String> getPriceAmountList() {
        return priceAmountList;
    }

    public void setPriceAmountList(List<String> priceAmountList) {
        this.priceAmountList = priceAmountList;
    }
}
