/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Employee;
import Models.Settings;
import Models.Shift;
import Models.ShiftState;
import Ultility.CustomPair;
import Ultility.JsonDataFile;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author FPTSHOP
 */
public class test {

    static Map<String, Integer> staticalList = new HashMap<>();

    public static void main(String[] args) {
        Employee e = new Employee();
        System.out.println(e.toString().equals("n"));
    }


    public static void testSetting() {
        staticalList.put("huy", 1);
        staticalList.put("huy", 2);
        staticalList.put("ha", 5);

        List<Integer> list = new ArrayList<>(staticalList.values());
        for (Map.Entry<String, Integer> entry : staticalList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        list.stream().forEach(x -> System.out.print(x + " "));
    }
}
