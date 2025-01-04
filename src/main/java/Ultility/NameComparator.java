package Ultility;

import Models.Goods;
import java.util.Comparator;

public class NameComparator implements Comparator<Goods>{
    @Override
    public int compare(Goods o1, Goods o2){
        return o1.getGoodsName().compareToIgnoreCase(o2.getGoodsName());
    }
}
