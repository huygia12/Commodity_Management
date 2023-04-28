/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Goods;
import java.util.Comparator;

/**
 *
 * @author FPTSHOP
 */
public class NameComparator implements Comparator<Goods>{
    @Override
    public int compare(Goods o1, Goods o2){
        return o1.getGoodsName().compareToIgnoreCase(o2.getGoodsName());
    }
}
