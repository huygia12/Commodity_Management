/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.time.LocalDate;
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
        System.out.println("* 4. Delete Goods||Shipment Infor *");
        System.out.println("* 5. Show Repository              *");
        System.out.println("* 6. Make a filter                *");
        System.out.println("* 7. Back                         *");
        System.out.println("***********************************");
        System.out.print("Option => ");
    }

    private void menuOfFunctionDel() {
        System.out.println("\n********************************");
        System.out.println("* 1. Delete a goods            *");
        System.out.println("* 2. Delete a shipment         *");
        System.out.println("* 3. Back                      *");
        System.out.println("********************************");
        System.out.print("Option => ");
    }

    private void menuOfFunctionEditInfor() {
        System.out.println("\n****************************************");
        System.out.println("* 1. Change goods Informations         *");
        System.out.println("* 2. Change shipment Information       *");
        System.out.println("* 3. Back                              *");
        System.out.println("****************************************");
        System.out.print("Option => ");
    }

    private void menuOfFunctionEditGoodsInfor() {
        System.out.println("\n***************************************");
        System.out.println("* 1. Change product Name              *");
        System.out.println("* 2. Change goods List price          *");
        System.out.println("* 3. Change goods Manufacture         *");
        System.out.println("* 4. Back                             *");
        System.out.println("***************************************");
        System.out.print("Option => ");
    }

    private void menuOfFunctionEditShipmentsInfor() {
        System.out.println("\n***************************************");
        System.out.println("* 1. Change shipment Import Price     *");
        System.out.println("* 2. Change shipment Production Date  *");
        System.out.println("* 3. Change shipment Expiration Date  *");
        System.out.println("* 4. Change shipment Quantity         *");
        System.out.println("* 5. Back                             *");
        System.out.println("***************************************");
        System.out.print("Option => ");
    }

    private void menuOfRequestedList() {
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

    // Function 1
    private void addNewGoods() {
        Goods newGoods = new Goods();
        int n = 1;
        int nextProcess;
        while (n != 3) {
            switch (n) {
                case 1:
                    nextProcess = uf.typeInName(newGoods);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        return;
                    }
                case 2:
                    nextProcess = uf.typeInManufac(newGoods, myGoodsList);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        break;
                    }
                case 3:
                    nextProcess = uf.typeInListPrice(newGoods);
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
                    nextProcess = uf.typeInQuan(newShipment);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        return;
                    } else if (uf.checkIfNumIsZero(newShipment.getQuantity())) {
                        break;
                    }
                case 2:
                    nextProcess = uf.typeInImportPrice(newShipment);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        break;
                    }
                case 3:
                    nextProcess = uf.typeInProDate(newShipment);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 2;
                        break;
                    }
                case 4:
                    nextProcess = uf.typeInEpirDate(newShipment);
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
    private void finishEditGoods(Goods searchGoods, Goods draftGoods) {
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
            searchGoods.setProvider(draftGoods.getProvider());
            searchGoods.setGoodsName(draftGoods.getGoodsName());
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
            menuOfFunctionEditGoodsInfor();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    if (uf.typeInName(draftGoods) == 0) {
                        return;
                    }
                    break;
                case "2":
                    if (uf.typeInListPrice(draftGoods) == 0) {
                        return;
                    }
                    break;
                case "3":
                    if (uf.typeInManufac(draftGoods, myGoodsList) == 0) {
                        return;
                    }
                    break;
                case "4":
                    finishEditGoods(searchGoods, draftGoods);
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->4!");
            }
        } while (!choice.equals("4"));
    }

    // Function 3.2
    private void finishEditShipment(Goods searchGoods, Shipment searchShipment, Shipment draftShipment) {
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

    private boolean quanBecomeZero(Goods searchGoods, Shipment searchShipment, Shipment draftShipment) {
        while (draftShipment.getQuantity() == 0) {
            System.out.println(
                    "Your changes make quantity equal 0 and  this shipment will be deleted, keep your changes?");
            System.out.print(
                    "(Y: automatically delete shipment / N: undo changes)=> ");
            String yesNo = sc.nextLine();
            if (yesNo.equalsIgnoreCase("y")) {
                delShipment(searchShipment, searchGoods);
                if (searchGoods.getShipments().isEmpty()) {
                    delGoods(searchGoods);
                }
                return true;
            } else if (yesNo.equalsIgnoreCase("n")) {
                return true;
            } else {
                System.out.println("Wrong input!");
            }
        }
        return false;
    }

    private void editShipmentInfor(Shipment searchShipment, Goods searchGoods) {
        String choice;
        Shipment draftShipment = searchShipment.cloneShipment();
        do {
            menuOfFunctionEditShipmentsInfor();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    if (uf.typeInImportPrice(draftShipment) == 0) {
                        return;
                    }
                    break;
                case "2":
                    if (uf.typeInProDate(draftShipment) == 0) {
                        return;
                    }
                    break;
                case "3":
                    if (uf.typeInEpirDate(draftShipment) == 0) {
                        return;
                    }
                    break;
                case "4":
                    if (uf.typeInQuan(draftShipment) == 0) {
                        return;
                    }
                    break;
                case "5":
                    if (quanBecomeZero(searchGoods, searchShipment, draftShipment)) {
                        return;
                    }
                    finishEditShipment(searchGoods, searchShipment, draftShipment);
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
            menuOfFunctionEditInfor();
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
    private int delOption() {
        // return option: 1-delete goods | 2-delete shipment | 3-back
        int input;
        do {
            menuOfFunctionDel();
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

    private void delGoods(Goods goods) {
        if (goods != null) {
            myGoodsList.remove(goods);
            for (Goods tmpGoods : myGoodsList) {
                tmpGoods.setGoodsID(String.format("%06d", myGoodsList.indexOf(tmpGoods)));
            }
            System.out.println("Delete succeed...");
        }
    }

    private void delShipment(Shipment shipment, Goods goods) {
        if (shipment != null) {
            goods.getShipments().remove(shipment);
            for (Shipment tmpShipment : goods.getShipments()) {
                tmpShipment.setShipmentID(String.format("%06d", goods.getShipments().indexOf(tmpShipment)));
            }
            System.out.println("Delete succeed...");
        }
    }

    private void delGoodsAShipment() {
        int input = delOption();
        Goods searchGoods = null;
        while (true) {
            switch (input) {
                case 1:
                    searchGoods = uf.searchGoods(myGoodsList);
                    if (searchGoods != null) {
                        delGoods(searchGoods);
                    }
                    break;
                case 2:
                    searchGoods = uf.searchGoods(myGoodsList);
                    if (searchGoods != null) {
                        Shipment searchShipment = uf.searchShipments(searchGoods);
                        if (searchShipment != null) {
                            delShipment(searchShipment, searchGoods);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Back...");
                    return;
            }
        }
    }

    // Function 5
    private void curGoodsListPrint() {
        //myGoodsList is sorted by name, then is by manufacture
        myGoodsList.sort(new nameComparator().thenComparing(new manufacturerComparator()));
        uf.showGoodsList(myGoodsList);
    }

    // Function 6.1
    private int manufacColSize(int maxSize, List<String> listOfManufac) {
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
        maxSize = manufacColSize(maxSize, listOfManufac);
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

    private void listSameManufacGoods() {
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
    private void listTopLeastQuan() {
        myGoodsList.sort(new quantityCoparator()
                .thenComparing(new nameComparator())
                .thenComparing(new manufacturerComparator()));
        List<Goods> filterList = myGoodsList.stream().limit(10).toList();
        uf.showGoodsList(filterList);
    }

    // Function 6.3
    private void listTopLargestQuan() {
        myGoodsList.sort(new quantityCoparator().reversed()
                .thenComparing(new nameComparator())
                .thenComparing(new manufacturerComparator()));
        List<Goods> filterList = myGoodsList.stream().limit(10).toList();
        uf.showGoodsList(filterList);
    }

    // Function 6.4
    private void sortShipmentByProducDate(Goods goods) {
        Collections.sort(goods.getShipments(),
                (Shipment shipment1, Shipment shipment2)
                -> (-1) * shipment1.getNsx().compareTo(shipment2.getNsx()));
    }

    private List<Goods> listGoodsNewestProducDate() {
        // Make a list of goods with their 1 latest production date
        //(only one shipment with latest production date exists in goods.getShipments())
        // Eliminate all goods with no shipment
        List<Goods> filterList = new ArrayList<>();
        for (Goods goods : myGoodsList) {
            if (!goods.getShipments().isEmpty()) {
                sortShipmentByProducDate(goods);
                Goods tmpGoods = goods.cloneGoods();
                tmpGoods.getShipments().clear();
                tmpGoods.getShipments().add(goods.getShipments().get(0));
                filterList.add(tmpGoods);
            }
        }
        return filterList;
    }

    private void listTopNewestGoods() {
        List<Goods> filterList = listGoodsNewestProducDate();
        // Because Goods now only contains 1 shipment, we sort bucket by productionDate
        Collections.sort(filterList, new Comparator<Goods>() {
            @Override
            public int compare(Goods goods1, Goods goods2) {
                return (-1) * goods1.getShipments().get(0).getNsx()
                        .compareTo(goods2.getShipments().get(0).getNsx());
            }
        }.thenComparing(new nameComparator()));
        //If bucket contains less than 10 goods, list them all
        // otherwise, we only take 10 goods with latest Production Date to print out
        int size = filterList.size();
        if (size <= 10) {
            uf.showGoodsList(filterList);
        } else {
            uf.showGoodsList(filterList.subList(0, 9));
        }
    }

    // Function 6.5
    private void listAllExpired() {
        List<Goods> filterList = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (Goods goods : myGoodsList) {
            List<Shipment> tmpShipmentList = goods.getShipments()
                    .stream()
                    .filter(shipment -> shipment.getHsd().isBefore(currentDate))
                    .toList();
            if (!tmpShipmentList.isEmpty()) {
                Goods tmpGoods = goods.cloneGoods();
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
            menuOfRequestedList();
            choice = sc.nextLine().trim();
            //uf.clearScreen();
            switch (choice) {
                case "1":
                    listSameManufacGoods();
                    //uf.typeAnyKeyToContinue();
                    //uf.clearScreen();
                    break;
                case "2":
                    listTopLeastQuan();
                    break;
                case "3":
                    listTopLargestQuan();
                    break;
                case "4":
                    listTopNewestGoods();
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
        int choice;
        do {
            try {
                menuOfRepoManagement();
                choice = sc.nextInt();
                sc.nextLine();
                //uf.clearScreen();
                switch (choice) {
                    case 1:
                        addNewGoods();
                        //uf.clearScreen();
                        //sc.nextLine();
                        break;
                    case 2:
                        importGoods();
                        //uf.clearScreen();
                        break;
                    case 3:
                        editGoodsAndShipmentInfor();
                        //uf.clearScreen();
                        break;
                    case 4:
                        delGoodsAShipment();
                        //uf.clearScreen();
                        break;
                    case 5:
                        curGoodsListPrint();
                        //uf.typeAnyKeyToContinue();
                        //uf.clearScreen();
                        break;
                    case 6:
                        makeListByRequirement();
                        //uf.clearScreen();
                        break;
                    case 7:
                        System.out.println("Back...");
                        break;
                    default:
                        System.out.println("Wrong input, Please type from 1->7!");
                        break;
                }
            } catch (InputMismatchException ime) {
                uf.wrInput();
                choice = -1;
                sc.next();
            }
        } while (choice != 7);
    }
}
