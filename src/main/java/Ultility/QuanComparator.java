/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ultility;

import Controllers.GoodsController;
import Models.Goods;
import java.util.Comparator;

/**
 *
 * @author FPTSHOP
 */
public class QuanComparator implements Comparator<Goods>{
    final GoodsController goodsCtr = new GoodsController();
    
    @Override
    public int compare(Goods o1, Goods o2){
        return goodsCtr.getTotalQuanByShipments(o1)
                .compareTo(goodsCtr.getTotalQuanByShipments(o2));
    }
}
