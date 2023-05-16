/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOP
 * @param <T>
 */
public class GoodsList <T extends Goods>{
    @SerializedName("myGoodsList")
    @Expose
    private List<T> myGoodsList = new ArrayList<>();

    public GoodsList() {}

    public GoodsList(List<T> goodsList) {
        this.myGoodsList = goodsList;
    }
    
    public List<T> getGoodsList() {
        return myGoodsList;
    }

    public void setGoodsList(List<T> goodsList) {
        this.myGoodsList = goodsList;
    }
}
