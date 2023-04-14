/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sourcecode;

import java.util.Comparator;

/**
 *
 * @author FPTSHOP
 */
public class quantityCoparator implements Comparator<Goods>{
    @Override
    public int compare(Goods o1, Goods o2){
        return Integer.compare(o1.getTotalQuantity(), o2.getTotalQuantity());
    }
}
