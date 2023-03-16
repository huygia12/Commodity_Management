/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SourceCode;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author s1rja
 */
public class Repository {

    List<Goods> goodsList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public Goods searchGoods() {
        //search(Goods) : null neu nhap BACK/ 1 Goods neu tim kiem thanh cong 
        if(goodsList.isEmpty()){
            System.out.println("No product found in the repository.");
            return null;
        }
        sc.nextLine();
        String input = new String();
        boolean completed = false;
        Goods result = null;
        do {
            try {
                System.out.print("Input productID to search(Type name for suggestion) or Back to go back: ");
                input = sc.nextLine();
                int searchingKey = Integer.parseInt(input);
                for (Goods goods1 : goodsList) {
                    if (goods1.getGoodsID().equals(input)) {
                        result = goods1;
                    }
                }
                if(result == null){
                    System.out.println("Your input ID doesnt exist.");
                    continue;
                }
                completed = true;
            } catch (NumberFormatException nfe) {
                if (input.equalsIgnoreCase("back")) {
                    break;
                }
                List<Goods> bucket = new ArrayList<>();
                for (Goods goods2 : goodsList) {
                    String nameToLowerCase = goods2.getGoodsName().toLowerCase();
                    String inputToLowerCase = input.toLowerCase();
                    if (nameToLowerCase.contains(inputToLowerCase)) {
                        bucket.add(goods2);
                    }
                }
                if (bucket.isEmpty()) {
                    System.out.println("No product match with your input!");
                } else {
                    System.out.print("\nSearching : \"" + input + "\"");
                    showGoodsList(bucket);
                }
            }
        } while (!completed);
        return result;
    }

    private int shipmentCompare(Shipment shipment, Goods goods) {
        // return -1 if shipments in goods not contain shipment
        // != 0 if shipments in goods contain shipment and is the index of shipment in
        // goods'sshipments
        int i = 0;
        int length = goods.getShipments().size();
        for (i = 0; i < length; i++) {
            Shipment temp = goods.getShipments().get(i);
            if (temp.getImportPrice() == shipment.getImportPrice()
                    && temp.getHsd().equals(shipment.getHsd())
                    && temp.getNsx().equals(shipment.getNsx())) {
                break;
            }
        }
        if (i == length)
            return -1;
        return i;
    }

    private void menuOfRepoManagement() {
        System.out.println("\n********************************");
        System.out.println("* 1. Add New Goods             *");
        System.out.println("* 2. Import Goods              *");
        System.out.println("* 3. Change Goods Infor        *");
        System.out.println("* 4. Delete Goods              *");
        System.out.println("* 5. Show Repository           *");
        System.out.println("* 6. Make a filter             *");
        System.out.println("* 7. Back                      *");
        System.out.println("********************************");
        System.out.print("Option => ");
    }

    // function 1
    private void addNewGoods() {
        sc.nextLine();
        Goods good = new Goods();
        int n = 1;
        String input;
        while (n != 3) {
            switch (n) {
                case 1:
                    System.out.print("Input product name or type EXIT to exit: ");
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        return;
                    } else if ("".equals(input)) {
                        System.out.println("Input is required!");
                        continue;
                    } else {
                        good.setGoodsName(input);
                    }
                case 2:
                    System.out.print("Input product manufacturer or type BACK/EXIT to go back/exit: ");
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        return;
                    } else if (input.equalsIgnoreCase("back")) {
                        continue;
                    } else if ("".equals(input)) {
                        System.out.println("Input is required!");
                        n = 2;
                        continue;
                    } else {
                        good.setProvider(input);
                    }
                case 3:
                    n = 2;
                    boolean completed = false;
                    boolean chooseBack = false;
                    while (!completed) {
                        System.out.print("Input listed price or type BACK/EXIT to go back/exit: ");
                        input = sc.nextLine();
                        if (input.equalsIgnoreCase("exit")) {
                            return;
                        } else if (input.equalsIgnoreCase("back")) {
                            chooseBack = true;
                            break;
                        } else {
                            try {
                                int listPrice = Integer.parseInt(input);
                                if (listPrice < 0) {
                                    System.out.println("List price must be a positive number!");
                                    continue;
                                }
                                good.setListPrice(listPrice);
                                completed = true;
                            } catch (NumberFormatException nfe) {
                                if ("".equals(input)) {
                                    System.out.println("Input is required!");
                                } else {
                                    System.out.println("Wrong input!");
                                }
                            }
                        }
                    }
                    if (chooseBack) {
                        continue;
                    }
                    n = 3;
            }
        }
        goodsList.add(good);
        good.setGoodsID(String.format("%06d", goodsList.indexOf(good)));
    }

    // function 2
    private void importGoods(Goods goods) {
        int n = 1;
        String input;
        Shipment shipment = new Shipment();
        Date nsx = new Date();
        Date hsd = new Date();
        while (n != 4) {
            switch (n) {
                case 1:
                    boolean completed = false;
                    while (!completed) {
                        System.out.print("Input product quantity or type EXIT to exit: ");
                        input = sc.nextLine();
                        if (input.equalsIgnoreCase("exit")) {
                            return;
                        } else {
                            try {
                                int quantity = Integer.parseInt(input);
                                shipment.setQuantity(quantity);
                                completed = true;
                            } catch (NumberFormatException nfe) {
                                if ("".equals(input)) {
                                    System.out.println("Input is required!");
                                } else {
                                    System.out.println("Wrong input!");
                                }
                            }
                        }
                    }
                case 2:
                    completed = false;
                    boolean chooseBack = false;
                    while (!completed) {
                        System.out.print("Input product import price or type BACK/EXIT to go back/exit: ");
                        input = sc.nextLine();
                        if (input.equalsIgnoreCase("exit")) {
                            return;
                        } else if (input.equalsIgnoreCase("back")) {
                            chooseBack = true;
                            break;
                        } else {
                            try {
                                int importPrice = Integer.parseInt(input);
                                if (importPrice < 0) {
                                    System.out.println("List price must be a positive number!");
                                    continue;
                                }
                                shipment.setImportPrice(importPrice);
                                completed = true;
                            } catch (NumberFormatException nfe) {
                                if ("".equals(input)) {
                                    System.out.println("Input is required!");
                                } else {
                                    System.out.println("Wrong input!");
                                }
                            }
                        }
                    }
                    if (chooseBack) {
                        continue;
                    }
                case 3:
                    n = 2;
                    completed = false;
                    boolean chooseBack2 = false;
                    while (!completed) {
                        System.out.print("Input production date or type BACK/EXIT to go back/exit: ");
                        input = sc.nextLine();
                        if (input.equalsIgnoreCase("exit")) {
                            return;
                        } else if (input.equalsIgnoreCase("back")) {
                            chooseBack2 = true;
                            break;
                        } else {
                            try {
                                nsx = df.parse(input);
                                shipment.setNsx(nsx);
                                completed = true;
                            } catch (ParseException pe) {
                                System.out.println("Wrong input!");
                            }
                        }
                    }
                    if (chooseBack2) {
                        break;
                    }
                case 4:
                    completed = false;
                    chooseBack = false;
                    while (!completed) {
                        System.out.print("Input expiration Date or type BACK/EXIT to go back/exit: ");
                        input = sc.nextLine();
                        if (input.equalsIgnoreCase("exit")) {
                            return;
                        } else if (input.equalsIgnoreCase("back")) {
                            chooseBack = true;
                            break;
                        } else {
                            try {
                                hsd = df.parse(input);
                                shipment.setHsd(hsd);
                                if (hsd.before(nsx)) {
                                    System.out.println("Invalid Date, must be equal or greater than production date!");
                                } else {
                                    completed = true;
                                }
                            } catch (ParseException pe) {
                                System.out.println("Wrong input!");
                            }
                        }
                    }
                    if (chooseBack) {
                        break;
                    }
                    n = 4;
            }
        }
        // check if shipment already exists
        int shipmentIndex = shipmentCompare(shipment, goods);
        if (shipmentIndex != -1 && goods.getShipments().isEmpty() == false) {
            int sumQuantity = goods.getShipments().get(shipmentIndex).getQuantity() + shipment.getQuantity();
            goods.getShipments().get(shipmentIndex).setQuantity(sumQuantity);
        } else {
            // check if one of the shipments became default to reuse the ID
            boolean checkSoldOut = false;
            for (Shipment temp : goods.getShipments()) {
                if (temp.getQuantity() == 0) {
                    checkSoldOut = true;
                    temp.setQuantity(shipment.getQuantity());
                    temp.setHsd(shipment.getHsd());
                    temp.setNsx(shipment.getNsx());
                    break;
                }
            }
            if (checkSoldOut == false) {
                shipment.setShipmentID(String.format("%06d", goods.getShipments().size()));
                goods.getShipments().add(shipment);
            }
        }
    }

    // function 3
    private void changeGoodsInfor() {
        // Undeveloped
    }

    // function 4
    private void deleteAGoods() {
        int input;
        
        do {
            System.out.println("********************************");
            System.out.println("* 1. Delete a good             *");
            System.out.println("* 2. Delete a shipment         *");
            System.out.println("* 3. Back                      *");
            System.out.println("********************************");
            System.out.print("Option => ");
            try {
                input = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
                input = -1;
                sc.next();
            }
        } while (input != 3);
        
        switch (input) {
            case 1:
            case 2:
            case 3:
            default:
                System.out.println("Back...");
                break;
        }
    }

    // function 5
    public void showGoodsList(List<Goods> goodsList) {
        if (goodsList.isEmpty()) {
            System.out.println("No product found in the repository.");
            return;
        }
        System.out.println();
        System.out.printf("|%-12s|%-15s|%-15s|%-12s|%-15s|%-12s|%-18s|%-18s|%-12s|%-10s|\n",
                "Product ID", "Name", "Provider", "List Price", "Total Quantity", "Shipment ID",
                "Production Date", "Expiration Date", "Import Price", "Quantity");
        System.out.println("|" + "-".repeat(148) + "|");
        for (Goods goods : goodsList) {
            System.out.printf("|%-12s|%-15s|%-15s|%-12s|%-15s|",
                    goods.getGoodsID(),
                    goods.getGoodsName(),
                    goods.getProvider(),
                    goods.getListPrice(),
                    goods.getTotalQuantity());
            if (!goods.getShipments().isEmpty()) {
                Shipment shipment = goods.getShipments().get(0);
                System.out.printf("%-12s|%-18s|%-18s|%-12s|%-10s|\n", shipment.getShipmentID(),
                        df.format(shipment.getNsx()),
                        df.format(shipment.getHsd()),
                        shipment.getImportPrice(),
                        shipment.getQuantity());
                for (int i = 1; i < goods.getShipments().size(); i++) {
                    shipment = goods.getShipments().get(i);
                    System.out.printf("|%-73s|%-12s|%-18s|%-18s|%-12s|%-10s|\n", "", shipment.getShipmentID(),
                            df.format(shipment.getNsx()),
                            df.format(shipment.getHsd()),
                            shipment.getImportPrice(),
                            shipment.getQuantity());
                }
            } else {
                System.out.printf("%-12s|%-18s|%-18s|%-12s|%-10s|\n", "", "", "", "", "", "");
            }
            System.out.println("|" + "-".repeat(148) + "|");
        }
    }

    // function 6
    private void makeAFilter() {
        // Undeveloped
    }

    public void repositoryManagement() {
        // Huy
        int choice;
        do {
            try {
                menuOfRepoManagement();
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addNewGoods();
                        break;
                    case 2:
                        Goods goods = searchGoods();
                        if(goods == null){
                            break;
                        }
                        importGoods(goods);
                        break;
                    case 3:
                        changeGoodsInfor();
                        break;
                    case 4:
                        deleteAGoods();
                        break;
                    case 5:
                        showGoodsList(goodsList);
                        break;
                    case 6:
                        makeAFilter();
                        break;
                    case 7:
                        System.out.println("Back...");
                        break;
                    default:
                        System.out.println("Wrong input, Please type from 1->7!");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
                choice = -1;
                sc.next();
            }
        } while (choice != 7);
    }
}
