/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author FPTSHOP
 */
public class History {

    @SerializedName("shiftHistory")
    @Expose
    private Stack<Shift> shiftHistory = new Stack<>();
    @SerializedName("importHistory")
    @Expose
    private List<Goods> importGoodsList = new ArrayList<>();
    
    public History(Stack<Shift> shiftHistory) {
        this.shiftHistory = shiftHistory;
    }

    public History() {
    }

    public Stack<Shift> getShiftHistory() {
        return this.shiftHistory;
    }

    public void setShiftHistory(Stack<Shift> shiftHistory) {
        this.shiftHistory = shiftHistory;
    }

    public List<Goods> getImportGoodsList() {
        return importGoodsList;
    }

    public void setImportGoodsList(List<Goods> importGoodsList) {
        this.importGoodsList = importGoodsList;
    }
    
    
}
