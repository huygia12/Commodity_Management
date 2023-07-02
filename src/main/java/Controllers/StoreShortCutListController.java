/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.StoreShortedCut;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class StoreShortCutListController {
    private List<StoreShortedCut> storeList;
    
    public StoreShortCutListController() {
    }

    public StoreShortCutListController(List<StoreShortedCut> storeList) {
        this.storeList = storeList;
    }
    
    public StoreShortedCut containEmail(String email){
        for (StoreShortedCut store : storeList) {
            if(store.getEmail().equals(email)){
                return store;
            }
        }
        return null;
    }
}
