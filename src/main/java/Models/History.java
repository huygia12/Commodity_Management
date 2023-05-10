/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.Cautions;
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
    @SerializedName("ctions")
    @Expose
    final Cautions ctions = new Cautions();
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

    public Order containOrder(String ID) {
        for (Shift shift : this.shiftHistory) {
            for (Order order : shift.getOrderHisPerShift()) {
                if (order.getID().equals(ID)) {
                    return order;
                }
            }
        }
        return null;
    }

    public ImportedGoods containImportedGoods(String ID) {
        for (Shift shift : this.shiftHistory) {
            for (ImportedGoods importGoods : shift.getImportGoodsHis().getGoodsList()) {
                if (importGoods.getID().equals(ID)) {
                    return importGoods;
                }
            }
        }
        return null;
    }

    public Shift containShift(String ID) {
        for (Shift shift : this.shiftHistory) {
            if (shift.getID().equals(ID)) {
                return shift;
            }
        }
        return null;
    }

    public Order searchOrder(Scanner sc) {
        // tra ve null neu nguoi dung nhap 'back', nguoc lai, tra ve 1 order duoc tim kiem
        if (this.getShiftHistory().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
            return null;
        }
        String inputStr;
        boolean completed = false;
        Order searchingOrder = null;
        do {
            try {
                System.out.print("Input orderID to search or BACK to go back: ");
                inputStr = sc.nextLine();
                if ("back".equalsIgnoreCase(inputStr)) {
                    return null;
                }
                int searchingKey = Integer.parseInt(inputStr);
                searchingOrder = containOrder(inputStr);
                if (searchingOrder == null) {
                    System.out.println("Your input ID doesnt exist.");
                    continue;
                }
                completed = true;
            } catch (NumberFormatException nfe) {
                ctions.wrInput();
            }
        } while (!completed);
        return searchingOrder;
    }
    
    public ImportedGoods searchImportGoods(Scanner sc) {
        // tra ve null neu nguoi dung nhap 'back', nguoc lai, tra ve 1 importGoods duoc tim kiem
        if (this.getShiftHistory().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
            return null;
        }
        String inputStr;
        boolean completed = false;
        ImportedGoods searchingImportGoods = null;
        do {
            try {
                System.out.print("Input goodsID to search or BACK to go back: ");
                inputStr = sc.nextLine();
                if ("back".equalsIgnoreCase(inputStr)) {
                    return null;
                }
                int searchingKey = Integer.parseInt(inputStr);
                searchingImportGoods = containImportedGoods(inputStr);
                if (searchingImportGoods == null) {
                    System.out.println("Your input ID doesnt exist.");
                    continue;
                }
                completed = true;
            } catch (NumberFormatException nfe) {
                ctions.wrInput();
            }
        } while (!completed);
        return searchingImportGoods;
    }
    
    public Shift searchShift(Scanner sc) {
        // tra ve null neu nguoi dung nhap 'back', nguoc lai, tra ve 1 Shift duoc tim kiem
        if (this.getShiftHistory().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
            return null;
        }
        String inputStr;
        boolean completed = false;
        Shift searchingShift = null;
        do {
            try {
                System.out.print("Input shiftID to search or BACK to go back: ");
                inputStr = sc.nextLine();
                if ("back".equalsIgnoreCase(inputStr)) {
                    return null;
                }
                int searchingKey = Integer.parseInt(inputStr);
                searchingShift = containShift(inputStr);
                if (searchingShift == null) {
                    System.out.println("Your input ID doesnt exist.");
                    continue;
                }
                completed = true;
            } catch (NumberFormatException nfe) {
                ctions.wrInput();
            }
        } while (!completed);
        return searchingShift;
    }
    
}
