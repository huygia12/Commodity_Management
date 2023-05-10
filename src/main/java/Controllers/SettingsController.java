/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Shift;
import Models.Store;
import View.SettingsView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class SettingsController {

    @SerializedName("settingsView")
    @Expose
    private final SettingsView settingsView = new SettingsView();
    @SerializedName("myStore")
    @Expose
    private Store myStore;

    public SettingsController() {
    }

    public SettingsController(Store myStore) {
        this.myStore = myStore;
    }

    public Store getMyStore() {
        return myStore;
    }

    public void setMyStore(Store myStore) {
        this.myStore = myStore;
    }

    public SettingsView getSettingsView() {
        return this.settingsView;
    }

    public void SettingsManagement(Shift currentShift, Scanner sc) {
        String choice;
        do {
            this.settingsView.menuOfSettings();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    this.myStore.showStoreInfor();
                    break;
                case "2":
                    this.myStore.setStoreInfor(settingsView, currentShift, sc);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->3!");
                    break;
            }
        } while (!choice.equalsIgnoreCase("3"));
    }
}
