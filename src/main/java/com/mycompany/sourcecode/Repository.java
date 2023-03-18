/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sourcecode;

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
        // search(Goods) : null neu nhap BACK/ 1 Goods neu tim kiem thanh cong
        if (goodsList.isEmpty()) {
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
                if (result == null) {
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
        if (i == length) {
            return -1;
        }
        return i;
    }

    private int goodsCompare(Goods goods) {
        int i = 0;
        if (goodsList == null) {
            return 0;
        } else {
            for (Goods goodNeedCompare : goodsList) {
                if (goodNeedCompare.getGoodsName().equalsIgnoreCase(goods.getGoodsName())
                        && goodNeedCompare.getProvider().equalsIgnoreCase(goods.getProvider())) {
                    i = 1;
                } else {
                    i = 0;
                }
            }
            return i;
        }
    }

    private void menuOfRepoManagement() {
        System.out.println("\n**********************************");
        System.out.println("* 1. Add New Goods                *");
        System.out.println("* 2. Import Goods                 *");
        System.out.println("* 3. Change Goods||Shipment Infor *");
        System.out.println("* 4. Delete Goods                 *");
        System.out.println("* 5. Show Repository              *");
        System.out.println("* 6. Make a filter                *");
        System.out.println("* 7. Back                         *");
        System.out.println("***********************************");
        System.out.print("Option => ");
    }

    private void menuOfChangeInfor() {
        System.out.println("\n***************************************");
        System.out.println("* 1. Change goods Informations         *");
        System.out.println("* 2. Change shipment Information       *");
        System.out.println("* 3. Back                              *");
        System.out.println("****************************************");
        System.out.print("Option => ");
    }

    private void menuOfChangGoodsInfor() {
        System.out.println("\n***************************************");
        System.out.println("* 1. Change product Name              *");
        System.out.println("* 2. Change goods List price          *");
        System.out.println("* 3. Change goods Manufacture         *");
        System.out.println("* 4. Back                             *");
        System.out.println("***************************************");
        System.out.print("Option => ");
    }

    private void menuOfChangShipmentsInfor() {
        System.out.println("\n***************************************");
        System.out.println("* 1. Change shipment Import Price     *");
        System.out.println("* 2. Change shipment Production Date  *");
        System.out.println("* 3. Change shipment Expiration Date  *");
        System.out.println("* 4. Change shipment Quantity         *");
        System.out.println("* 5. Back                             *");
        System.out.println("***************************************");
        System.out.print("Option => ");
    }

    private Shipment searchShipments(Goods goods) {
        // tra ve 0 neu khong ton tai shipment nao trong goods
        // -1 neu chon 'BACK', >1 neu tim duoc shipment
        List<Goods> bucket = new ArrayList<>();
        if (goods.getShipments().isEmpty()) {
            System.out.println("No shipment exist within the goods");
            System.out.println("Aborting...");
            return null;
        }
        bucket.add(goods);
        do {
            showGoodsList(bucket);
            System.out.print("Input shipment ID or type BACK to go back: ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("back")) {
                System.out.println("Back...");
                return null;
            } else {
                for (Shipment shipment : goods.getShipments()) {
                    if (input.equals(shipment.getShipmentID())) {
                        return shipment;
                    }
                }
                System.out.println("No shipment found!");
            }
        } while (true);
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
                    System.out.print("Input goods name or type EXIT to exit: ");
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
                    System.out.print("Input goods manufacturer or type BACK/EXIT to go back/exit: ");
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
                    int matched = goodsCompare(good);
                    if (matched == 1) {
                        System.out.println("Good already existed!");
                        System.out.println("Aborting...");
                        return;
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
    private void importGoods() {
        Goods goods = searchGoods();
        if (goods == null) {
            return;
        }
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
                        System.out.print("Input production date or type BACK/EXIT to get back/exit: ");
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
            shipment.setShipmentID(String.format("%06d", goods.getShipments().size()));
            goods.getShipments().add(shipment);
        }
    }

    // function 3
    private void changeGoodsAndShipmentsInfo() {
        int choice1;
        do {
            try {
                menuOfChangeInfor();
                choice1 = sc.nextInt();
                int choice2;
                Goods searchGoods = null;
                String inputString;
                boolean completed;
                switch (choice1) {
                    case 1:
                        searchGoods = searchGoods();
                        if (searchGoods == null) {
                            return;
                        }
                        Goods temp = new Goods(searchGoods.getGoodsName(), searchGoods.getProvider(),
                                searchGoods.getListPrice());
                        do {
                            try {
                                menuOfChangGoodsInfor();
                                choice2 = sc.nextInt();
                                sc.nextLine();
                                switch (choice2) {
                                    case 1:
                                        while (true) {
                                            System.out.print("Input new Goods Name or type BACK to get back: ");
                                            inputString = sc.nextLine();
                                            if (inputString.equalsIgnoreCase("back")) {
                                                break;
                                            } else if ("".equals(inputString)) {
                                                System.out.println("Input is required!");
                                            } else {
                                                temp.setGoodsName(inputString);
                                                break;
                                            }
                                        }
                                        break;
                                    case 2:
                                        completed = false;
                                        while (!completed) {
                                            System.out.print("Input new Goods ListPrice or type BACK to get back: ");
                                            inputString = sc.nextLine();
                                            if (inputString.equalsIgnoreCase("back")) {
                                                break;
                                            } else {
                                                try {
                                                    int listPrice = Integer.parseInt(inputString);
                                                    if (listPrice < 0) {
                                                        System.out.println("List price must be a positive number!");
                                                        continue;
                                                    }
                                                    temp.setListPrice(listPrice);
                                                    completed = true;
                                                } catch (NumberFormatException nfe) {
                                                    if ("".equals(inputString)) {
                                                        System.out.println("Input is required!");
                                                    } else {
                                                        System.out.println("Wrong input!");
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        while (true) {
                                            System.out.print("Input new goods manufacturer or type BACK to get back: ");
                                            inputString = sc.nextLine();
                                            if (inputString.equalsIgnoreCase("back")) {
                                                break;
                                            } else if ("".equals(inputString)) {
                                                System.out.println("Input is required!");
                                            } else {
                                                temp.setProvider(inputString);
                                                break;
                                            }
                                        }
                                        break;
                                    case 4:
                                        List<Goods> bucket = new ArrayList<>();
                                        for (Goods checkGoodsList : goodsList) {
                                            if (checkGoodsList != searchGoods) {
                                                if (checkGoodsList.getGoodsName().equalsIgnoreCase(temp.getGoodsName())
                                                        && checkGoodsList.getProvider()
                                                                .equalsIgnoreCase(temp.getProvider())) {
                                                    bucket.add(checkGoodsList);
                                                }
                                            }
                                        }
                                        if (!bucket.isEmpty()) {
                                            System.out.print(
                                                    "Cannot implement your changes cause it conflicts with these goods information!");
                                            showGoodsList(bucket);
                                        } else {
                                            searchGoods.setGoodsName(temp.getGoodsName());
                                            searchGoods.setProvider(temp.getProvider());
                                            searchGoods.setListPrice(temp.getListPrice());
                                            System.out.println("Changes succeeded...");
                                        }
                                        System.out.println("Back...");
                                        break;
                                    default:
                                        System.out.println("Wrong input, Please type from 1->4!");
                                }
                            } catch (InputMismatchException ime) {
                                System.out.println("Wrong input!");
                                choice2 = -1;
                                sc.next();
                            }
                        } while (choice2 != 4);
                        break;
                    case 2:
                        searchGoods = searchGoods();
                        if (searchGoods == null) {
                            return;
                        }
                        Shipment searchShipment = searchShipments(searchGoods);
                        if (searchShipment == null) {
                            return;
                        }
                        Shipment token = new Shipment(searchShipment.getQuantity(),
                                searchShipment.getImportPrice(), searchShipment.getNsx(), searchShipment.getHsd());
                        do {
                            try {
                                menuOfChangShipmentsInfor();
                                choice2 = sc.nextInt();
                                sc.nextLine();
                                switch (choice2) {
                                    case 1:
                                        completed = false;
                                        while (!completed) {
                                            System.out
                                                    .print("Input new Shipment ImportPrice or type BACK to get back: ");
                                            inputString = sc.nextLine();
                                            if (inputString.equalsIgnoreCase("back")) {
                                                break;
                                            } else {
                                                try {
                                                    int importPrice = Integer.parseInt(inputString);
                                                    if (importPrice < 0) {
                                                        System.out.println("Import price must be a positive number!");
                                                        continue;
                                                    }
                                                    token.setImportPrice(importPrice);
                                                    completed = true;
                                                } catch (NumberFormatException nfe) {
                                                    if ("".equals(inputString)) {
                                                        System.out.println("Input is required!");
                                                    } else {
                                                        System.out.println("Wrong input!");
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 2:
                                        while (true) {
                                            System.out.print("Input new production date or type BACK to get back: ");
                                            inputString = sc.nextLine();
                                            if (inputString.equalsIgnoreCase("back")) {
                                                break;
                                            } else {
                                                try {
                                                    Date nsx = df.parse(inputString);
                                                    token.setNsx(nsx);
                                                    break;
                                                } catch (ParseException pe) {
                                                    System.out.println("Wrong input!");
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        while (true) {
                                            System.out.print("Input new expiration date or type BACK to get back: ");
                                            inputString = sc.nextLine();
                                            if (inputString.equalsIgnoreCase("back")) {
                                                break;
                                            } else {
                                                try {
                                                    Date hsd = df.parse(inputString);
                                                    token.setHsd(hsd);
                                                    break;
                                                } catch (ParseException pe) {
                                                    System.out.println("Wrong input!");
                                                }
                                            }
                                        }
                                        break;
                                    case 4:
                                        while (true) {
                                            System.out.print("Input product quantity or type Back to get back: ");
                                            inputString = sc.nextLine();
                                            if (inputString.equalsIgnoreCase("back")) {
                                                break;
                                            } else {
                                                try {
                                                    int quantity = Integer.parseInt(inputString);
                                                    token.setQuantity(quantity);
                                                    break;
                                                } catch (NumberFormatException nfe) {
                                                    if ("".equals(inputString)) {
                                                        System.out.println("Input is required!");
                                                    } else {
                                                        System.out.println("Wrong input!");
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 5:
                                        int shipmentIndex = shipmentCompare(token, searchGoods);
                                        if (shipmentIndex != -1 && shipmentIndex != searchGoods.getShipments().indexOf(searchShipment)) {
                                            completed = false;
                                            Shipment duplicateShipment = searchGoods.getShipments().get(shipmentIndex);
                                            do {
                                                System.out.println(
                                                        "This shipment already exists, do you want to keep your changes?");
                                                System.out
                                                        .print("(Y:add to the existing one / N:abort changes)=>Y/N: ");
                                                String yesNo = sc.nextLine();
                                                if (yesNo.equalsIgnoreCase("y")) {
                                                    int sum = token.getQuantity() + duplicateShipment.getQuantity();
                                                    searchGoods.getShipments().get(shipmentIndex).setQuantity(sum);
                                                    searchGoods.getShipments().remove(searchShipment);
                                                    for (Shipment shipment : searchGoods.getShipments()) {
                                                        shipment.setShipmentID(String.format("%06d", searchGoods.getShipments().indexOf(shipment)));
                                                    }
                                                    System.out.println("Add succceed...");
                                                    break;
                                                } else if (yesNo.equalsIgnoreCase("n")) {
                                                    System.out.println("Aborting...");
                                                    break;
                                                } else {
                                                    System.out.println("Wrong input!");
                                                }
                                            } while (!completed);
                                        } else if (shipmentIndex == -1) {
                                            searchShipment.setHsd(token.getHsd());
                                            searchShipment.setNsx(token.getNsx());
                                            searchShipment.setImportPrice(token.getImportPrice());
                                            searchShipment.setQuantity(token.getQuantity());
                                            System.out.println("Changes succeeded...");
                                        } else {
                                            System.out.println("Back...");
                                        }
                                        break;
                                    default:
                                        System.out.println("Wrong input, Please type from 1->5!");
                                }
                            } catch (InputMismatchException ime) {
                                System.out.println("Wrong input!");
                                choice2 = -1;
                                sc.next();
                            }
                        } while (choice2 != 5);
                        break;
                    case 3:
                        System.out.println("Back...");
                        break;
                    default:
                        System.out.println("Wrong input, Please type from 1->3!");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
                choice1 = -1;
                sc.next();
            }
        } while (choice1 != 3);
    }

    // function 4
    private void deleteGoodsAndShipments() {
        int input;

        do {
            System.out.println("********************************");
            System.out.println("* 1. Delete a goods            *");
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
            if (input != 3 && input != 1 && input != 2) {
                System.out.println("Wrong input!");
            }
        } while (input != 3 && input != 1 && input != 2);

        switch (input) {
            case 1:
                Goods goods = searchGoods();
                if (goods == null) {
                    break;
                }
                for (Goods goods1 : goodsList) {
                    if (goods1.getGoodsID().equals(goods.getGoodsID())) {
                        goodsList.remove(goods1);
                        break;
                    }
                }
                for (Goods goods1 : goodsList) {
                    goods1.setGoodsID(String.format("%06d", goodsList.indexOf(goods1)));
                }
                break;
            case 2:
                Goods searchGoods = searchGoods();
                if (searchGoods == null) {
                    return;
                }
                Shipment searchShipment = searchShipments(searchGoods);
                if (searchShipment == null) {
                    return;
                } else {
                    for (Shipment shipment : searchGoods.getShipments()) {
                        if (shipment == searchShipment) {
                            searchGoods.getShipments().remove(searchShipment);
                            break;
                        }
                    }
                    for (Shipment shipment : searchGoods.getShipments()) {
                        shipment.setShipmentID(String.format("%06d", searchGoods.getShipments().indexOf(shipment)));
                    }
                }
            case 3:
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
                "Goods ID", "Name", "Provider", "List Price", "Total Quantity", "Shipment ID",
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
                        importGoods();
                        break;
                    case 3:
                        changeGoodsAndShipmentsInfo();
                        break;
                    case 4:
                        deleteGoodsAndShipments();
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
