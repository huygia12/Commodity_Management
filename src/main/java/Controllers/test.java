/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





/**
 *
 * @author FPTSHOP
 */
public class test {
    static  Map<String, Integer> staticalList = new HashMap<>();
    
    public static void main(String[] args) {
        testSetting();
    }
    
    public static void testSetting(){
        staticalList.put("huy", 1);
        staticalList.put("huy", 2);
        staticalList.put("ha", 5);
        
        List<Integer> list = new ArrayList<>(staticalList.values());
        for (Map.Entry<String, Integer> entry : staticalList.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        list.stream().forEach(x->System.out.print(x+" "));
    }
}
