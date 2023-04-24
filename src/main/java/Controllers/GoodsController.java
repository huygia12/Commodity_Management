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

    private Goods goodsModel;
    private GoodsView goodsView;

    public GoodsController() {
    }

    public GoodsController(Goods goods, GoodsView view) {
        this.goodsModel = goods;
        this.goodsView = view;
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

    public void setView(GoodsView view) {
        this.goodsView = view;
    }
    
}
