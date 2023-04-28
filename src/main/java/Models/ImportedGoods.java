/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author FPTSHOP
 */
public class ImportedGoods extends Goods{
    private String importDateTime;

    public ImportedGoods(){
    }
    
    public ImportedGoods(Goods goods) {
        super(goods.getGoodsName(), 
                goods.getManufacture(), 
                goods.getListPrice(), 
                goods.getID());
        this.importDateTime = LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String getImportDateTime() {
        return this.importDateTime;
    }

}
