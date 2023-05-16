/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Ultility.Cautions;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class History {

    @SerializedName("shiftHistory")
    @Expose
    private List<Shift> shiftHistory = new ArrayList<>();

    public History(List<Shift> shiftHistory) {
        this.shiftHistory = shiftHistory;
    }

    public History() {
    }

    public List<Shift> getShiftHistory() {
        return this.shiftHistory;
    }

    public void setShiftHistory(List<Shift> shiftHistory) {
        this.shiftHistory = shiftHistory;
    }
}
