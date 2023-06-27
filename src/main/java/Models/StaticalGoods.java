/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.opencsv.bean.CsvBindByPosition;
import java.math.BigDecimal;

/**
 *
 * @author FPTSHOP
 */
public class StaticalGoods extends Goods {
    @CsvBindByPosition(position = 4)
    private BigDecimal revenue = BigDecimal.ZERO;
    @CsvBindByPosition(position = 5)
    private BigDecimal ratio = BigDecimal.ZERO;

    public StaticalGoods(Goods goods, BigDecimal quantity, BigDecimal revenue, BigDecimal ratio) {
        super(goods.getGoodsName(), goods.getManufacture(),
                goods.getListPrice(), goods.getID(), goods.getUnit());
        this.revenue = revenue;
        this.ratio = ratio;
    }

    public StaticalGoods(Goods goods) {
        super(goods.getGoodsName(), goods.getManufacture(),
                goods.getListPrice(), goods.getID(), goods.getUnit());
    }

    public StaticalGoods() {
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return getID() + ","+ getGoodsName() + ","+ getManufacture()+ ","+ getUnit()+ "," + String.format("%.1f", revenue) + "," + ratio;
    }
}
