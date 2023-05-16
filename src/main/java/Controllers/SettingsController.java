/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Settings;
import Models.Shift;
import View.SettingsView;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class SettingsController {
    
    private final SettingsView settingsView = new SettingsView();
    final Scanner sc = new Scanner(System.in);
    final StoreController storeCtr = new StoreController();
    
    public SettingsController() {
    }

    public SettingsView getSettingsView() {
        return this.settingsView;
    }

    public void SettingsManagement(Shift currentShift, Settings settings) {
        String choice;
        do {
            this.settingsView.menuOfSettings();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    storeCtr.getStoreView().showStoreInfor(settings.getMyStore());
                    break;
                case "2":
                    storeCtr.setStoreInfor(currentShift, settings.getMyStore());
                    break;
                case "3":
                    pointsExchangeMechanism(settings);
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->4!");
                    break;
            }
        } while (!choice.equalsIgnoreCase("4"));
    }
    
    private void pointsExchangeMechanism(Settings settings){
        String choice;
        do {
            this.settingsView.menuOfPointsExchangeMechanism();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    this.settingsView.typeInAmountForOnePoint(settings);
                    break;
                case "2":
                    this.settingsView.typeInPointsForOneVND(settings);
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
