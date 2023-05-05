/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Store;
import View.SettingsView;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class SettingsController {

    final Scanner sc = new Scanner(System.in);
    private final SettingsView settingsView = new SettingsView();
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

    public void SettingsManagement() {
        String choice;
        do {
            this.settingsView.menuOfSettings();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    this.myStore.showStoreInfor();
                    break;
                case "2":
                    this.myStore.setStoreInfor(settingsView);
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
