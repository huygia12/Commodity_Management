/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Goods;
import View.GoodsView;

/**
 *
 * @author FPTSHOP
 */
public class GoodsController {

    final private GoodsView goodsView = new GoodsView();
    private Goods goodsModel;

    public GoodsController() {
    }

    public GoodsController(Goods goods) {
        this.goodsModel = goods;
    }

    
    public Goods getGoods() {
        return goodsModel;
    }

    public void setGoods(Goods goods) {
        this.goodsModel = goods;
    }

    public GoodsView getView() {
        return goodsView;
    }
    
}
