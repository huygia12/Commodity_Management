package Ultility;

import Controllers.GoodsController;
import Models.Goods;
import java.util.Comparator;

public class QuanComparator implements Comparator<Goods>{
    final GoodsController goodsCtr = new GoodsController();
    
    @Override
    public int compare(Goods o1, Goods o2){
        return goodsCtr.getTotalQuanByShipments(o1)
                .compareTo(goodsCtr.getTotalQuanByShipments(o2));
    }
}
