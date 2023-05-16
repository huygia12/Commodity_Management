/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;

/**
 *
 * @author s1rja
 */
public class Repository extends GoodsList<Goods> {

    public Repository() {
    }

    public Repository(List<Goods> repoGoodsList) {
        super(repoGoodsList);
    }
}
