/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sourcecode;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    String inputDatePattern = "d/M/y";
    UsefulFunctions uf = new UsefulFunctions();

    public Repository() {
    }

    public Repository(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    private void menuOfRepoManagement() {
        System.out.println("\n***********************************");
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
        System.out.println("\n****************************************");
        System.out.println("* 1. Change goods Informations         *");
        System.out.println("* 2. Change shipment Information       *");
        System.out.println("* 3. Back                              *");
        System.out.println("****************************************");
        System.out.print("Option => ");
    }

    private void menuOfChangeGoodsInfor() {
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
                        for (Goods goods : goodsList) {
                            if (goods.getGoodsName().equalsIgnoreCase(good.getGoodsName()) && goods.getProvider().equalsIgnoreCase(good.getProvider())) {
                                System.out.println("Same product detected!");
                                System.out.println("Aborting...");
                                return;
                            }
                        }
                    }
                    int matched = uf.goodsCompare(good, goodsList);
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
                                long listPrice = Long.parseLong(input);
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
        Goods goods = uf.searchGoods(goodsList);
        if (goods == null) {
            return;
        }
        int n = 1;
        String input;
        Shipment shipment = new Shipment();
        LocalDate nsx = null;
        LocalDate hsd = null;
        while (n != 4) {
            switch (n) {
                case 1:
                    boolean completed = false;
                    while (!completed) {
                        System.out.print("Input product quantity or type EXIT to exit: ");
                        sc.nextLine();
                        input = sc.nextLine();
                        if (input.equalsIgnoreCase("exit")) {
                            return;
                        } else {
                            try {
                                int quantity = Integer.parseInt(input);
                                if (quantity <= 0) {
                                    System.out.println("Shipment quantity must be a positive number!");
                                    continue;
                                }
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
                                long importPrice = Long.parseLong(input);
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
                                nsx = LocalDate.parse(input, DateTimeFormatter.ofPattern(inputDatePattern));
                                shipment.setNsx(nsx);
                                completed = true;
                            } catch (DateTimeException dte) {
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
                                hsd = LocalDate.parse(input, DateTimeFormatter.ofPattern(inputDatePattern));
                                shipment.setHsd(hsd);
                                if (hsd.isBefore(nsx)) {
                                    System.out.println("Invalid Date, must be equal or greater than production date!");
                                } else {
                                    completed = true;
                                }
                            } catch (DateTimeException dte) {
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
        int shipmentIndex = uf.shipmentCompare(shipment, goods);
        if (shipmentIndex != -1 && goods.getShipments().isEmpty() == false) {
            while (true) {
                System.out.println(
                        "This shipment already exists, do you want to keep your changes?");
                System.out
                        .print("(Y:add to the existing one / N:abort)=>Y/N: ");
                String yesNo = sc.nextLine();
                if (yesNo.equalsIgnoreCase("y")) {
                    int sumQuantity = goods.getShipments().get(shipmentIndex).getQuantity() + shipment.getQuantity();
                    goods.getShipments().get(shipmentIndex).setQuantity(sumQuantity);
                    System.out.println("Add succceed...");
                    break;
                } else if (yesNo.equalsIgnoreCase("n")) {
                    System.out.println("Aborting...");
                    break;
                } else {
                    System.out.println("Wrong input!");
                }
            }
        } else {
            shipment.setShipmentID(String.format("%06d", goods.getShipments().size()));
            goods.getShipments().add(shipment);
        }

    }
    
    private void changeGoodsInfor() {
        Goods searchGoods = uf.searchGoods(goodsList);
        int choice;
        String inputString;
        if (searchGoods == null) {
            return;
        }
        Goods temp = new Goods(searchGoods.getGoodsName(), searchGoods.getProvider(),
                searchGoods.getListPrice());
        do {
            try {
                menuOfChangeGoodsInfor();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
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
                        Boolean completed = false;
                        while (!completed) {
                            System.out.print("Input new Goods ListPrice or type BACK to get back: ");
                            inputString = sc.nextLine();
                            if (inputString.equalsIgnoreCase("back")) {
                                break;
                            } else {
                                try {
                                    int listPrice = Integer.parseInt(inputString);
                                    if (listPrice <= 0) {
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
                            uf.showGoodsList(bucket);
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
                choice = -1;
                sc.next();
            }
        } while (choice != 4);
    }

    private void changeShipmentInfor() {
        Goods searchGoods = uf.searchGoods(goodsList);
        int choice;
        String inputString;
        if (searchGoods == null) {
            return;
        }
        Shipment searchShipment = uf.searchShipments(searchGoods);
        if (searchShipment == null) {
            return;
        }
        Shipment temp = new Shipment(searchShipment.getQuantity(),
                searchShipment.getImportPrice(), searchShipment.getNsx(), searchShipment.getHsd());
        do {
            try {
                menuOfChangShipmentsInfor();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        boolean completed = false;
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
                                    temp.setImportPrice(importPrice);
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
                                    LocalDate nsx = LocalDate.parse(inputString,
                                            DateTimeFormatter.ofPattern(inputDatePattern));
                                    if(nsx.isAfter(temp.getHsd())){
                                        System.out.println("Invalid Date,must be equal or less than expiration date!");
                                        continue;
                                    }
                                    temp.setNsx(nsx);
                                    break;
                                } catch (DateTimeException dte) {
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
                                    LocalDate hsd = LocalDate.parse(inputString,
                                            DateTimeFormatter.ofPattern(inputDatePattern));
                                    if (hsd.isBefore(temp.getNsx())) {
                                        System.out.println(
                                                "Invalid Date, must be equal or greater than production date!");
                                        continue;
                                    }
                                    temp.setHsd(hsd);
                                    break;
                                } catch (DateTimeException dte) {
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
                                    if (quantity < 0) {
                                        System.out.println(
                                                "Shipment quantity must be a positive number!");
                                        continue;
                                    } else if (quantity == 0) {
                                        System.out.println(
                                                "Your changes make quantity equal 0, keep your changes?");
                                        System.out.println(
                                                "(Y: automatically delete shipment / N: retype the quantity)=>Y/N: ");
                                        String yesNo = sc.nextLine();
                                        if (yesNo.equalsIgnoreCase("y")) {
                                            searchGoods.getShipments().remove(searchShipment);
                                            System.out.println("Delete succeed...");
                                            for (Shipment shipment : searchGoods.getShipments()) {
                                                shipment.setShipmentID(String.format("%06d",
                                                        searchGoods.getShipments().indexOf(shipment)));
                                            }
                                        } else if (yesNo.equalsIgnoreCase("n")) {
                                            continue;
                                        } else {
                                            System.out.println("Wrong input!");
                                            continue;
                                        }
                                    }
                                    temp.setQuantity(quantity);
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
                        int shipmentIndex = uf.shipmentCompare(temp, searchGoods);
                        if (shipmentIndex != -1 && shipmentIndex != searchGoods.getShipments()
                                .indexOf(searchShipment)) {
                            Shipment duplicateShipment = searchGoods.getShipments().get(shipmentIndex);
                            while (true) {
                                System.out.println(
                                        "This shipment already exists, keep your changes?");
                                System.out
                                        .print("(Y:add to the existing one / N:abort)=>Y/N: ");
                                String yesNo = sc.nextLine();
                                if (yesNo.equalsIgnoreCase("y")) {
                                    int sum = temp.getQuantity() + duplicateShipment.getQuantity();
                                    searchGoods.getShipments().get(shipmentIndex).setQuantity(sum);
                                    searchGoods.getShipments().remove(searchShipment);
                                    for (Shipment shipment : searchGoods.getShipments()) {
                                        shipment.setShipmentID(String.format("%06d",
                                                searchGoods.getShipments().indexOf(shipment)));
                                    }
                                    System.out.println("Add succceed...");
                                    break;
                                } else if (yesNo.equalsIgnoreCase("n")) {
                                    System.out.println("Aborting...");
                                    break;
                                } else {
                                    System.out.println("Wrong input!");
                                }
                            }
                        } else if (shipmentIndex == -1) {
                            searchShipment.setHsd(temp.getHsd());
                            searchShipment.setNsx(temp.getNsx());
                            searchShipment.setImportPrice(temp.getImportPrice());
                            searchShipment.setQuantity(temp.getQuantity());
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
                choice = -1;
                sc.next();
            }
        } while (choice != 5);
    }


    // function 3
    private void changeGoodsAndShipmentsInfor() {
        int choice1;
        do {
            try {
                menuOfChangeInfor();
                choice1 = sc.nextInt();
                switch (choice1) {
                    case 1:
                        changeGoodsInfor();
                        break;
                    case 2:
                        changeShipmentInfor();
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
                Goods goods = uf.searchGoods(goodsList);
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
                Goods searchGoods = uf.searchGoods(goodsList);
                if (searchGoods == null) {
                    return;
                }
                Shipment searchShipment = uf.searchShipments(searchGoods);
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
                        changeGoodsAndShipmentsInfor();
                        break;
                    case 4:
                        deleteGoodsAndShipments();
                        break;
                    case 5:
                        uf.showGoodsList(goodsList);
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
