/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class History {

    
    private List<Shift> shiftHistory;

    public History(List<Shift> shiftHistory) {
        this.shiftHistory = shiftHistory;
    }

    public History() {
    }

    public List<Shift> getShiftHistory() {
        return shiftHistory;
    }

    public void setShiftHistory(List<Shift> shiftHistory) {
        this.shiftHistory = shiftHistory;
    }
    
}
