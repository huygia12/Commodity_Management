/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Goods;
import Models.GoodsList;
import Models.Shipment;

/**
 *
 * @author FPTSHOP
 */
public class RepositoryController extends GoodsListController{
    public final int BY_SHIPMENT = 1;
    public final int BY_GOODS = 0;    
    
    public RepositoryController() {
    }
    
    public boolean dupIDCheck(GoodsList<Goods> goodsList, String id, int type){
        if(type == BY_GOODS){
            for (Goods goods : goodsList.getList()) {
                if(goods.getID().equals(id)){
                    return true;
                }
            }
        }else if(type == BY_SHIPMENT){
            for (Goods goods : goodsList.getList()) {
                for (Shipment shipment : goods.getShipments()) {
                    if(shipment.getID().equals(id)){
                        return true;
                    }
                }
            }
        }
        return false;
    } 
}
