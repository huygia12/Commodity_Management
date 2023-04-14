/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sourcecode;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author s1rja
 */
public class Repository {

    List<Goods> myGoodsList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    final String INPUT_DATE_PATTERN = "d/M/y";
    UsefulFunctions uf = new UsefulFunctions();

    public Repository() {
    }

    public Repository(List<Goods> goodsList) {
        this.myGoodsList = goodsList;
    }

    // All kinds of menu
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

    private void menuOfFunctionDelete() {
        System.out.println("\n********************************");
        System.out.println("* 1. Delete a goods            *");
        System.out.println("* 2. Delete a shipment         *");
        System.out.println("* 3. Back                      *");
        System.out.println("********************************");
        System.out.print("Option => ");
    }

    private void menuOfFunctionChangeInfor() {
        System.out.println("\n****************************************");
        System.out.println("* 1. Change goods Informations         *");
        System.out.println("* 2. Change shipment Information       *");
        System.out.println("* 3. Back                              *");
        System.out.println("****************************************");
        System.out.print("Option => ");
    }

    private void menuOfFunctionChangeGoodsInfor() {
        System.out.println("\n***************************************");
        System.out.println("* 1. Change product Name              *");
        System.out.println("* 2. Change goods List price          *");
        System.out.println("* 3. Change goods Manufacture         *");
        System.out.println("* 4. Back                             *");
        System.out.println("***************************************");
        System.out.print("Option => ");
    }

    private void menuOfFunctionChangShipmentsInfor() {
        System.out.println("\n***************************************");
        System.out.println("* 1. Change shipment Import Price     *");
        System.out.println("* 2. Change shipment Production Date  *");
        System.out.println("* 3. Change shipment Expiration Date  *");
        System.out.println("* 4. Change shipment Quantity         *");
        System.out.println("* 5. Back                             *");
        System.out.println("***************************************");
        System.out.print("Option => ");
    }

    private void menuOfFunctionFilter() {
        System.out.println("\n*****************************************************");
        System.out.println("* 1. All Goods from the same manufacturer           *");
        System.out.println("* 2. Top 10 least quantity goodss in stock          *");
        System.out.println("* 3. Top 10 largest quantity goodss in stock        *");
        System.out.println("* 4. Top 10 goods with most recent production date  *");
        System.out.println("* 5. List all expired shipment|goods                *");
        System.out.println("* 6. Back                                           *");
        System.out.println("*****************************************************");
        System.out.print("Option => ");
    }

    // Input
    private int typeName(Goods goods) {
        while (true) {
            System.out.print("Input goods name or type Exit/Back to exit/back: ");
            String inputStr = sc.nextLine();
            if (uf.exitCase(inputStr)) {
                return 0;
            } else if (uf.goBack(inputStr)) {
                return -1;
            } else if (uf.checkIfNoInput(inputStr)) {
            } else {
                goods.setGoodsName(inputStr);
                return 1;
            }
        }
    }

    private int typeManufacturer(Goods goods) {
        while (true) {
            System.out.print("Input goods manufacturer or type BACK/EXIT to go back/exit: ");
            String inputStr = sc.nextLine();
            if (uf.exitCase(inputStr)) {
                return 0;
            } else if (uf.goBack(inputStr)) {
                return -1;
            } else if (uf.checkIfNoInput(inputStr)) {
            } else if (uf.checkIfDuplicateGoodsExisted(myGoodsList, goods) != -1) {
            } else {
                goods.setProvider(inputStr);
                return 1;
            }
        }
    }

    private int typeListPrice(Goods goods) {
        while (true) {
            System.out.print("Input listed price or type BACK/EXIT to go back/exit: ");
            String inputStr = sc.nextLine();
            if (uf.exitCase(inputStr)) {
                return 0;
            } else if (uf.goBack(inputStr)) {
                return -1;
            } else if (uf.checkIfNoInput(inputStr)) {
            } else {
                try {
                    int listPrice = Integer.parseInt(inputStr);
                    if (!uf.checkIfNumPositive(listPrice)) {
                        continue;
                    }
                    goods.setListPrice(listPrice);
                    return 1;
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong input!");
                }
            }
        }
    }

    private int typeQuantity(Shipment shipment) {
        while (true) {
            System.out.print("Input goods quantity or type Exit/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if (uf.goBack(inputStr)) {
                return 0;
            } else if (uf.goBack(inputStr)) {
                return -1;
            } else if (uf.checkIfNoInput(inputStr)) {
            } else {
                try {
                    int quantity = Integer.parseInt(inputStr);
                    if (!uf.checkIfNumPositive(quantity)) {
                        continue;
                    }
                    shipment.setQuantity(quantity);
                    return 1;
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong input!");
                }
            }
        }
    }

    private int typeImportPrice(Shipment shipment) {
        while (true) {
            System.out.print("Input goods import price or type BACK/EXIT to go back/exit: ");
            String inputStr = sc.nextLine();
            if (uf.exitCase(inputStr)) {
                return 0;
            } else if (uf.goBack(inputStr)) {
                return -1;
            } else if (uf.checkIfNoInput(inputStr)) {
            } else {
                try {
                    int importPrice = Integer.parseInt(inputStr);
                    if (uf.checkIfNumPositive(importPrice)) {
                        shipment.setImportPrice(importPrice);
                        return 1;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Wrong input!");
                }
            }
        }
    }

    private int typeProductionDate(Shipment shipment) {
        while (true) {
            System.out.print("Input production date or type BACK/EXIT to get back/exit: ");
            String inputStr = sc.nextLine();
            if (uf.exitCase(inputStr)) {
                return 0;
            } else if (uf.goBack(inputStr)) {
                return -1;
            } else {
                try {
                    LocalDate nsx = LocalDate.parse(inputStr, DateTimeFormatter
                            .ofPattern(INPUT_DATE_PATTERN));
                    if (nsx.isAfter(uf.CURRENT_DATE)) {
                        System.out.println("Invalid Date, production date cannot be after current date!");
                    } else {
                        if (shipment.getHsd() != null) {
                            if (nsx.isAfter(shipment.getHsd())) {
                                System.out.println("Invalid Date, production date cannot be after expiration date!");
                                continue;
                            }
                        }
                        shipment.setNsx(nsx);
                        return 1;
                    }
                } catch (DateTimeException dte) {
                    System.out.println("Wrong input!");
                }
            }
        }
    }

    private int typeExpirationDate(Shipment shipment) {
        while (true) {
            System.out.print("Input expiration Date or type BACK/EXIT to go back/exit: ");
            String inputStr = sc.nextLine();
            if (uf.exitCase(inputStr)) {
                return 0;
            } else if (uf.goBack(inputStr)) {
                return -1;
            } else {
                try {
                    LocalDate hsd = LocalDate.parse(inputStr, DateTimeFormatter
                            .ofPattern(INPUT_DATE_PATTERN));
                    if (hsd.isBefore(shipment.getNsx())) {
                        System.out.println("Invalid Date, expiration date cannot be before production date!");
                    } else {
                        shipment.setHsd(hsd);
                        return 1;
                    }
                } catch (DateTimeException dte) {
                    System.out.println("Wrong input!");
                }
            }
        }
    }

    // Function 1
    private void addNewGoods() {
        Goods newGoods = new Goods();
        int n = 1;
        int nextProcess;
        while (n != 3) {
            switch (n) {
                case 1:
                    nextProcess = typeName(newGoods);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        return;
                    }
                case 2:
                    nextProcess = typeManufacturer(newGoods);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        break;
                    }
                case 3:
                    nextProcess = typeListPrice(newGoods);
                    switch (nextProcess) {
                        case 0:
                            return;
                        case -1:
                            n = 2;
                            break;
                        default:
                            n = 3;
                    }
            }
        }
        myGoodsList.add(newGoods);
        newGoods.setGoodsID(String.format("%06d", myGoodsList.indexOf(newGoods)));
    }

    // Function 2
    private void importGoods() {
        Goods searchGoods = uf.searchGoods(myGoodsList);
        if (searchGoods == null) {
            return;
        }
        int n = 1;
        int nextProcess;
        Shipment newShipment = new Shipment();
        while (n != 4) {
            switch (n) {
                case 1:
                    nextProcess = typeQuantity(newShipment);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        return;
                    }
                case 2:
                    nextProcess = typeImportPrice(newShipment);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        break;
                    }
                case 3:
                    nextProcess = typeProductionDate(newShipment);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 2;
                        break;
                    }
                case 4:
                    nextProcess = typeExpirationDate(newShipment);
                    switch (nextProcess) {
                        case 0:
                            return;
                        case -1:
                            n = 3;
                            break;
                        default:
                            n = 4;
                    }
            }
        }
        // check if shipment already exists
        int shipmentIndex = searchGoods.checkIfDuplicateShipmentExisted(newShipment);
        if (shipmentIndex != -1) {
            Shipment duplicateShipment = searchGoods.getShipments().get(shipmentIndex);
            duplicateShipment.gainQuantityDecision(newShipment.getQuantity());
        } else {
            newShipment.setShipmentID(String.format("%06d", searchGoods.getShipments().size()));
            searchGoods.getShipments().add(newShipment);
        }
    }

    // Function 3.1
    private void finishEditingGoods(Goods searchGoods, Goods draftGoods) {
        List<Goods> bucket = new ArrayList<>(myGoodsList
                .stream()
                .filter(x -> x.checkIfTwoGoodsIsDuplicate(draftGoods))
                .toList());
        if (bucket.contains(searchGoods)) {
            bucket.remove(searchGoods);
        }
        if (!bucket.isEmpty()) {
            System.out.print(
                    "Cannot implement your changes cause it make duplicate value with these Goods attributes value!");
            uf.showGoodsList(bucket);
            System.out.println("Aborting...");
        } else if (!searchGoods.checkIfTwoGoodsIsDuplicate(draftGoods)
                || searchGoods.getListPrice() != draftGoods.getListPrice()) {
            searchGoods.setGoodsName(draftGoods.getGoodsName());
            searchGoods.setProvider(draftGoods.getProvider());
            searchGoods.setListPrice(draftGoods.getListPrice());
            System.out.println("Changes succeeded...");
        } else {
            System.out.println("Back...");
        }
    }

    private void editGoodsInfor(Goods searchGoods) {
        Goods draftGoods = searchGoods.cloneGoods();
        String choice;
        do {
            menuOfFunctionChangeGoodsInfor();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    if (typeName(draftGoods) == 0) {
                        return;
                    }
                    break;
                case "2":
                    if (typeListPrice(draftGoods) == 0) {
                        return;
                    }
                    break;
                case "3":
                    if (typeManufacturer(draftGoods) == 0) {
                        return;
                    }
                    break;
                case "4":
                    finishEditingGoods(searchGoods, draftGoods);
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->4!");
            }
        } while (!choice.equals("4"));
    }

    // Function 3.2
    private void finishEditingShipment(Goods searchGoods, Shipment searchShipment, Shipment draftShipment) {
        int shipmentIndex = searchGoods.checkIfDuplicateShipmentExisted(draftShipment);
        if (shipmentIndex != -1 && shipmentIndex != searchGoods.getShipments()
                .indexOf(searchShipment)) {
            //If changes make duplicate shipments exist, make decision to add to existing one or not
            Shipment duplicateShipment = searchGoods.getShipments().get(shipmentIndex);
            if (duplicateShipment.gainQuantityDecision(draftShipment.getQuantity())) {
                // If user decided to add to the existing one, then remove the edited shipment 
                // and reset the id of shipment'sList in searchGoods
                searchGoods.getShipments().remove(searchShipment);
                for (Shipment shipment : searchGoods.getShipments()) {
                    shipment.setShipmentID(String.format("%06d",
                            searchGoods.getShipments().indexOf(shipment)));
                }
            }
        } else if (shipmentIndex == -1) {
            searchShipment.setHsd(draftShipment.getHsd());
            searchShipment.setNsx(draftShipment.getNsx());
            searchShipment.setImportPrice(draftShipment.getImportPrice());
            searchShipment.setQuantity(draftShipment.getQuantity());
            System.out.println("Changes succeeded...");
        } else {
            System.out.println("Back...");
        }
    }

    private void checkIfQuantityBecomeZero(Goods searchGoods, Shipment searchShipment, Shipment draftShipment, int tmp) {
        while (draftShipment.getQuantity() == 0) {
            System.out.println(
                    "Your changes make quantity equal 0 and it will be deleted, keep your changes?");
            System.out.println(
                    "(Y: automatically delete shipment / N: undo changes)=>Y/N: ");
            String yesNo = sc.nextLine();
            if (yesNo.equalsIgnoreCase("y")) {
                deleteShipment(searchShipment, searchGoods);
            } else if (yesNo.equalsIgnoreCase("n")) {
                draftShipment.setQuantity(tmp);
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    private void editShipmentInfor(Shipment searchShipment, Goods searchGoods) {
        String choice;
        Shipment draftShipment = searchShipment.cloneShipment();
        do {
            menuOfFunctionChangShipmentsInfor();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    if (typeImportPrice(draftShipment) == 0) {
                        return;
                    }
                    break;
                case "2":
                    if (typeProductionDate(draftShipment) == 0) {
                        return;
                    }
                    break;
                case "3":
                    if (typeExpirationDate(draftShipment) == 0) {
                        return;
                    }
                    break;
                case "4":
                    int tmp = draftShipment.getQuantity();
                    if (typeQuantity(draftShipment) == 0) {
                        return;
                    }
                    checkIfQuantityBecomeZero(searchGoods, searchShipment, draftShipment, tmp);
                    break;
                case "5":
                    finishEditingShipment(searchGoods, searchShipment, draftShipment);
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->5!");
            }
        } while (!choice.equals("5"));
    }

    // Function 3
    private void editGoodsAndShipmentInfor() {
        String choice;
        Goods searchGoods = null;
        do {
            menuOfFunctionChangeInfor();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    searchGoods = uf.searchGoods(myGoodsList);
                    if (searchGoods == null) {
                        return;
                    }
                    editGoodsInfor(searchGoods);
                    break;
                case "2":
                    searchGoods = uf.searchGoods(myGoodsList);
                    if (searchGoods == null) {
                        return;
                    }
                    Shipment searchShipment = uf.searchShipments(searchGoods);
                    if (searchShipment == null) {
                        break;
                    }
                    editShipmentInfor(searchShipment, searchGoods);
                    break;
                case "3":
                    System.out.println("Back...");
                    return;
                default:
                    System.out.println("Wrong input, Please type from 1->3!");
                    break;
            }
        } while (!choice.equals("3"));
    }

    // Function 4
    private int decideOptionToDelete() {
        // return option: 1-delete goods | 2-delete shipment | 3-back
        int input;
        do {
            menuOfFunctionDelete();
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
        return input;
    }

    private void deleteGoods(Goods goods) {
        if (goods != null) {
            myGoodsList.remove(goods);
            for (Goods tmpGoods : myGoodsList) {
                tmpGoods.setGoodsID(String.format("%06d", myGoodsList.indexOf(tmpGoods)));
            }
            System.out.println("Delete succeed...");
        }
    }

    private void deleteShipment(Shipment shipment, Goods goods) {
        if (shipment != null) {
            goods.getShipments().remove(shipment);
            for (Shipment tmpShipment : goods.getShipments()) {
                tmpShipment.setShipmentID(String.format("%06d", goods.getShipments().indexOf(tmpShipment)));
            }
            System.out.println("Delete succeed...");
        }
    }

    private void deleteGoodsAndShipment() {
        int input = decideOptionToDelete();
        Goods searchGoods = null;
        switch (input) {
            case 1:
                searchGoods = uf.searchGoods(myGoodsList);
                deleteGoods(searchGoods);
                break;
            case 2:
                searchGoods = uf.searchGoods(myGoodsList);
                if (searchGoods == null) {
                    return;
                }
                Shipment searchShipment = uf.searchShipments(searchGoods);
                deleteShipment(searchShipment, searchGoods);
                break;
            case 3:
                System.out.println("Back...");
                break;
        }
    }

    // Function 6.1
    private int sizeOfManufacColumn(int maxSize, List<String> listOfManufac) {
        for (String tmpStr : listOfManufac) {
            int length = tmpStr.length();
            if (length > (maxSize - 5)) {
                maxSize = length + 5;
                if (maxSize % 2 != 0) {
                    maxSize += 1;
                }
            }
        }
        return maxSize;
    }

    private boolean checkIfManufacExisted(List<String> listOfManufac, String manufac) {
        for (String tmpStr : listOfManufac) {
            if (tmpStr.equalsIgnoreCase(manufac)) {
                return true;
            }
        }
        return false;
    }

    private List<String> listExistingManufac(List<Goods> goodsList) {
        List<String> listOfManufac = new ArrayList<>();
        for (Goods goods : goodsList) {
            String tmp = goods.getProvider();
            if (!checkIfManufacExisted(listOfManufac, tmp)) {
                listOfManufac.add(tmp);
            }
        }
        return listOfManufac;
    }

    private void printManufacList() {
        List<String> listOfManufac = listExistingManufac(myGoodsList);
        if (listOfManufac == null) {
            System.out.println("No product found in your repository!");
            return;
        }
        String title = "ManufacturerList";
        int maxSize = title.length() + 20;
        maxSize = sizeOfManufacColumn(maxSize, listOfManufac);
        System.out.println("");
        System.out.println("|" + "-".repeat((maxSize - title.length()) / 2) + title + "-".repeat((maxSize - title.length()) / 2) + "|");
        int index = 1;
        for (String manufac : listOfManufac) {
            System.out.println("| " + index + ". " + manufac + String.format("%" + (maxSize - manufac.length() - 3) + "s", " |"));
            index++;
        }
        System.out.println("| " + (listOfManufac.size() + 1) + ". Back" + String.format("%" + (maxSize - 7) + "s", " |"));
        System.out.println("|" + "-".repeat(maxSize) + "|");
    }

    private void listGoodsWithSameManufacturer() {
        List<Goods> filterList = new ArrayList<>();
        printManufacList();
        List<String> listOfManufac = listExistingManufac(myGoodsList);
        if (listOfManufac == null) {
            return;
        }
        int choice;
        String manufacNeedToList = null;
        int length = listOfManufac.size();
        do {
            try {
                System.out.print("Choose One Manufacturer => ");
                choice = sc.nextInt();
                if (choice > (length + 1) || choice < 1) {
                    System.out.println("Please type from 1->" + (length + 1) + "!");
                } else if (choice != (length + 1)) {
                    manufacNeedToList = listOfManufac.get(choice - 1);
                    final String tmpStr = manufacNeedToList;
                    filterList = new ArrayList<>(myGoodsList.stream().filter(x -> x.getProvider().equalsIgnoreCase(tmpStr)).toList());
                    uf.showGoodsList(filterList);
                    break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
                choice = -1;
                sc.next();
            }
        } while (choice != length + 1);
    }

    // Function 6.2
    private void listTopLeastQuantity() {
        List<Goods> filterList = new ArrayList<>();

        myGoodsList.sort(new quantityCoparator()
                .thenComparing(new nameComparator())
                .thenComparing(new manufacturerComparator()));
        filterList = myGoodsList.stream().limit(10).toList();
        uf.showGoodsList(filterList);
    }

    // Function 6.3
    private void listTopLargestQuantity() {
        List<Goods> filterList = new ArrayList<>();

        myGoodsList.sort(new quantityCoparator().reversed()
                .thenComparing(new nameComparator())
                .thenComparing(new manufacturerComparator()));
        filterList = myGoodsList.stream().limit(10).toList();
        uf.showGoodsList(myGoodsList);
    }

    // Function 6.4
    private boolean checkIfProducDateExisted(List<LocalDate> listOfProducDate, LocalDate producDate) {
        for (LocalDate tmp : listOfProducDate) {
            if (tmp.isEqual(producDate)) {
                return true;
            }
        }
        return false;
    }

    private List<LocalDate> listAllProductionDate(List<Goods> goodsList) {
        List<LocalDate> listOfProducDate = new ArrayList<>();
        for (Goods tmpGoods : goodsList) {
            for (Shipment tmpShipment : tmpGoods.getShipments()) {
                if (!checkIfProducDateExisted(listOfProducDate, tmpShipment.getNsx())) {
                    listOfProducDate.add(tmpShipment.getNsx());
                }
            }
        }
        Collections.sort(listOfProducDate, (LocalDate date1, LocalDate date2) -> (-1) * date1.compareTo(date2));
        return listOfProducDate;
    }

    private void listTopRecentlyProducDate() {
        List<LocalDate> listOfProducDate = listAllProductionDate(myGoodsList);
        List<Goods> bucket = new ArrayList<>();
    }

    // Function 6.5
    private void listAllExpired() {
        List<Goods> filterList = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (Goods goods : myGoodsList) {
            List<Shipment> tmpShipmentList = goods.getShipments()
                    .stream()
                    .filter(shipment -> shipment.getHsd().isAfter(currentDate))
                    .toList();
            if (tmpShipmentList != null) {
                Goods tmpGoods = new Goods();
                tmpGoods.setGoodsID(goods.getGoodsID());
                tmpGoods.setGoodsName(goods.getGoodsName());
                tmpGoods.setProvider(goods.getProvider());
                tmpGoods.setListPrice(goods.getListPrice());
                tmpGoods.setShipment(tmpShipmentList);
                filterList.add(tmpGoods);
            }
        }
        uf.showGoodsList(filterList);
    }

    // Function 6
    private void makeListByRequirement() {
        if (uf.checkIfListEmpty(myGoodsList)) {
            return;
        }
        String choice;
        do {
            menuOfFunctionFilter();
            choice = sc.nextLine().trim();
            //uf.clearScreen();
            switch (choice) {
                case "1":
                    listGoodsWithSameManufacturer();
                    //uf.typeAnyKeyToContinue();
                    //uf.clearScreen();
                    break;
                case "2":
                    listTopLeastQuantity();
                    break;
                case "3":
                    listTopLargestQuantity();
                    break;
                case "4":
                    listTopRecentlyProducDate();
                    break;
                case "5":
                    listAllExpired();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->6!");
            }
        } while (!choice.equals("6"));
    }

    // Main
    public void repositoryManagement() {
        String choice;
        do {
            menuOfRepoManagement();
            choice = sc.nextLine().trim();
            //uf.clearScreen();
            switch (choice) {
                case "1":
                    addNewGoods();
                    //uf.clearScreen();
                    //sc.nextLine();
                    break;
                case "2":
                    importGoods();
                    //uf.clearScreen();
                    break;
                case "3":
                    editGoodsAndShipmentInfor();
                    //uf.clearScreen();
                    break;
                case "4":
                    deleteGoodsAndShipment();
                    //uf.clearScreen();
                    break;
                case "5":
                    myGoodsList.sort(new nameComparator().thenComparing(new manufacturerComparator()));
                    uf.showGoodsList(myGoodsList);
                    //uf.typeAnyKeyToContinue();
                    //uf.clearScreen();
                    break;
                case "6":
                    makeListByRequirement();
                    //uf.clearScreen();
                    break;
                case "7":
                    System.out.println("Back...");
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->7!");
                    break;
            }
        } while (!choice.equals("7"));
    }
}
