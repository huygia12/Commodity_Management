/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigDecimal;

/**
 *
 * @author FPTSHOP
 */
public class SoldGoods extends Goods{
    private BigDecimal soldPrice = BigDecimal.ZERO;
    private BigDecimal totalAmountSold = BigDecimal.ZERO;

    public SoldGoods() {
    }
    
    public SoldGoods(Goods goods){
        super(goods.getGoodsName(), 
                goods.getManufacture(), 
                goods.getListPrice(),
                goods.getID(),
                goods.getUnit());
        this.soldPrice = goods.getListPrice();
    }

    public BigDecimal getSoldPrice() {
        return this.soldPrice;
    }

    public void setSoldPrice(int VAT, int discount) {
        this.getListPrice()
                .multiply(new BigDecimal(1.0-(discount*1.0)/100+(VAT*1.0)/100));
    }

    public BigDecimal getTotalAmountSold() {
        return totalAmountSold;
    }

    public void setTotalAmountSold(BigDecimal totalAmountSold) {
        this.totalAmountSold = totalAmountSold;
    }

}
