/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author FPTSHOP
 */
public class ImportedGoods extends Goods{
    @SerializedName("importDateTime")
    @Expose
    private String importDateTime;
    @SerializedName("totalAmountImport")
    @Expose
    private BigDecimal totalAmountImport = BigDecimal.ZERO;

    public ImportedGoods(){
    }
    
    public ImportedGoods(Goods goods) {
        super(goods.getGoodsName(), 
                goods.getManufacture(), 
                goods.getListPrice(), 
                goods.getID(),
                goods.getUnit());
        this.importDateTime = LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
    
    public void setImportDateTime(String importDateTime){
        this.importDateTime = importDateTime;
    }

    public String getImportDateTime() {
        return this.importDateTime;
    }

    public void setTotalAmountImport(BigDecimal totalAmountImport){
        this.totalAmountImport = totalAmountImport;
    }
    
    public BigDecimal getTotalAmountImport(){
        return this.totalAmountImport;
    }
}
