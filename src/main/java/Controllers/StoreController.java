/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Shift;
import Models.Store;
import Models.StoreShortedCut;
import View.StoreView;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class StoreController {
    final StoreView storeView = new StoreView();

    public StoreController() {
    }

    public StoreView getStoreView() {
        return storeView;
    }
    
    public void setStoreInfor(Shift currentShift, Store store) {
        String choice;
        do {
            this.storeView.menuOfChangeStoreInfor();
            choice = "";
            switch (choice) {
                case "1":
                    if (this.storeView.typeInStoreName(store) == 0) {
                        return;
                    }
                    break;
                case "2":
                    if (this.storeView.typeInEmail(store) == 0) {
                        return;
                    }
                    break;
                case "3":
                    if (this.storeView.typeInAndress(store) == 0) {
                        return;
                    }
                    break;
                case "4":
                    if (this.storeView.typeInPhoneNumber(store) == 0) {
                        return;
                    }
                    break;
                case "5":
                    if(currentShift != null){
                        System.out.println("This current Shift is not over yet, change cannot be performed!");
                        break;
                    }
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->6!");
                    break;
            }
        } while (!choice.equalsIgnoreCase("6"));
    }
    
    public StoreShortedCut containEmail(List<StoreShortedCut> storeList, String email){
        for (StoreShortedCut store : storeList) {
            if(store.getEmail().equals(email)){
                return store;
            }
        }
        return null;
    }
}
