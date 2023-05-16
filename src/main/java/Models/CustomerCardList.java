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
 */
public class CustomerCardList {
    @SerializedName("cardList")
    @Expose
    private List<CustomerCard> cardList = new ArrayList<>();
            
    public CustomerCardList() {
    }

    public CustomerCardList(List<CustomerCard> cardList) {
        this.cardList = cardList;
    }

    public List<CustomerCard> getList() {
        return cardList;
    }

    public void setList(List<CustomerCard> cardList) {
        this.cardList = cardList;
    }

}
