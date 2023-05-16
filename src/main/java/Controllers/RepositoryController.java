/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Ultility.IDGenerator;
import Ultility.QuanComparator;
import Ultility.NameComparator;
import Ultility.ManufacComparator;
import Ultility.Cautions;
import View.RepositoryView;
import Models.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class RepositoryController {

    private final RepositoryView view = new RepositoryView();
    final LocalDate CURRENT_DATE = LocalDate.now();
    final Scanner sc = new Scanner(System.in);
    final Cautions ctions = new Cautions();
    final GoodsController goodsCtr = new GoodsController();
    final ShipmentController shipmentCtr = new ShipmentController();
    final GoodsListController goodsListCtr = new GoodsListController();

    public RepositoryController() {
    }

    public RepositoryView getRepositoryView() {
        return this.view;
    }

    public void repositoryManagement(Shift shift, IDGenerator idGenerator, GoodsList<Goods> repoGoodsList) {
        int choice;
        do {
            try {
                this.view.menuOfRepoManagement();
                choice = sc.nextInt();
                sc.nextLine();
                //uf.clearScreen();
                switch (choice) {
                    case 1:
                        addGoodsToList(idGenerator, repoGoodsList);
                        break;
                    case 2:
                        ImportedGoods newImportGoods = importGoods(idGenerator, repoGoodsList);
                        // sau moi lan nhap hang thi add newImportGoods vao ImportGoodsHistory cua shift hien tai
                        if (newImportGoods != null) {
                            shift.getImportGoodsHis()
                                    .getGoodsList()
                                    .add(newImportGoods);
                        }
                        break;
                    case 3:
                        editGoodsAndShipmentInfor(repoGoodsList);
                        break;
                    case 4:
                        delGoodsAShipment(repoGoodsList);
                        break;
                    case 5:
                        printCurGoodsList(repoGoodsList);
                        break;
                    case 6:
                        makeListByRequirement(repoGoodsList);
                        break;
                    case 7:
                        System.out.println("Back...");
                        break;
                    default:
                        System.out.println("Wrong input, Please type from 1->7!");
                        break;
                }
            } catch (InputMismatchException ime) {
                ctions.wrInput();
                choice = -1;
                sc.next();
            }
        } while (choice != 7);
    }

    // Function1
    private void addGoodsToList(IDGenerator idGenerator, GoodsList<Goods> repoGoodsList) {
        Goods newGoods = new Goods();
        int n = 1;
        int nextProcess;
        while (n != 3) {
            switch (n) {
                case 1:
                    nextProcess = goodsCtr.getView().typeInName(newGoods);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        return;
                    }
                case 2:
                    nextProcess = goodsCtr.getView().typeInManufac(newGoods, repoGoodsList);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        break;
                    } else if (goodsListCtr.indexOfDupGoods(repoGoodsList, newGoods) != -1) {
                        System.out.println("Same goods detected!");
                        System.out.println("Aborting...");
                        return;
                    }
                case 3:
                    nextProcess = goodsCtr.getView().typeInListPrice(newGoods);
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
        newGoods.setID(idGenerator.generateID(Goods.class.getName(), 6));
        repoGoodsList.getGoodsList().add(newGoods);
    }

    // Function2
    private ImportedGoods importGoods(IDGenerator idGenerator, GoodsList<Goods> repoGoodsList) {
        Goods searchGoods = goodsListCtr.searchGoods(repoGoodsList);
        if (searchGoods == null) {
            return null;
        }
        int n = 1;
        int nextProcess;
        Shipment newShipment = new Shipment();
        ImportedGoods newImportedGoods = new ImportedGoods(searchGoods);
        // copy lay cac thuoc tinh ngoai tru cac list Shipment trong searchGoods
        newImportedGoods.getShipments().clear();
        while (n != 4) {
            switch (n) {
                case 1:
                    nextProcess = shipmentCtr.getView().typeInQuan(newShipment);
                    if (nextProcess == 0 || nextProcess == -1) {
                        return null;
                    }
                case 2:
                    nextProcess = shipmentCtr.getView().typeInImportPrice(newShipment);
                    if (nextProcess == 0) {
                        return null;
                    } else if (nextProcess == -1) {
                        break;
                    }
                case 3:
                    nextProcess = shipmentCtr.getView().typeInProDate(newShipment);
                    if (nextProcess == 0) {
                        return null;
                    } else if (nextProcess == -1) {
                        n = 2;
                        break;
                    }
                case 4:
                    nextProcess = shipmentCtr.getView().typeInEpirDate(newShipment);
                    switch (nextProcess) {
                        case 0:
                            return null;
                        case -1:
                            n = 3;
                            break;
                        default:
                            n = 4;
                    }
            }
        }
        // kiem tra neu shipment nay da ton tai 
        int shipmentIndex = goodsCtr.indexOfDupShip(searchGoods, newShipment);
        if (shipmentIndex != -1) {
            // neu shipment da ton tai
            Shipment dupShipment = searchGoods.getShipments().get(shipmentIndex);
            if (shipmentCtr.getView().gainQuanDecision()) {
                shipmentCtr.gainQuantity(dupShipment, newShipment.getQuantity());
                newShipment.setID(dupShipment.getID());
            }
        } else {
            // neu Shipment nay la moi
            newShipment.setID(idGenerator.generateID(Shipment.class.getName(), 8));
            searchGoods.getShipments().add(newShipment);
        }
        newImportedGoods.getShipments().add(newShipment);
        return newImportedGoods;
    }

    // Function 3
    private void editGoodsAndShipmentInfor(GoodsList<Goods> repoGoodsList) {
        String choice;
        Goods searchGoods = null;
        do {
            this.view.menuOfFunctionEditInfor();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    searchGoods = goodsListCtr.searchGoods(repoGoodsList);
                    if (searchGoods == null) {
                        return;
                    }
                    editGoods(searchGoods, repoGoodsList);
                    break;
                case "2":
                    searchGoods = goodsListCtr.searchGoods(repoGoodsList);
                    if (searchGoods == null) {
                        return;
                    }
                    Shipment searchShipment = goodsCtr.searchShipment(searchGoods);
                    if (searchShipment == null) {
                        break;
                    }
                    editShip(searchShipment, searchGoods, repoGoodsList);
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

    // Function 3.1
    private void editGoods(Goods searchGoods, GoodsList<Goods> goodsList) {
        Goods draftGoods = goodsCtr.cloneGoods(searchGoods);
        int choice;
        do {
            try {
                this.view.menuOfFunctionEditGoodsInfor();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        if (goodsCtr.getView().typeInName(draftGoods) == 0) {
                            return;
                        }
                        break;
                    case 2:
                        if (goodsCtr.getView().typeInListPrice(draftGoods) == 0) {
                            return;
                        }
                        break;
                    case 3:
                        if (goodsCtr.getView().typeInManufac(draftGoods, goodsList) == 0) {
                            return;
                        }
                        break;
                    case 4:
                        finishEditGoods(searchGoods, draftGoods, goodsList);
                        break;
                    default:
                        System.out.println("Wrong input, Please type from 1->4!");
                }
            } catch (InputMismatchException ime) {
                ctions.wrInput();
                sc.next();
                choice = -1;
            }
        } while (choice != 4);
    }

    private void finishEditGoods(Goods searchGoods, Goods draftGoods, GoodsList<Goods> goodsList) {
        GoodsList bucket = new GoodsList(new ArrayList<>(goodsList.getGoodsList()
                .stream()
                .filter(x -> goodsCtr.twoGoodsIsDup(x, draftGoods))
                .toList()));
        if (bucket.getGoodsList().contains(searchGoods)) {
            bucket.getGoodsList().remove(searchGoods);
        }
        if (!bucket.getGoodsList().isEmpty()) {
            System.out.print(
                    "Cannot implement your changes cause it make duplicate value with these existed Goods value!");
            goodsListCtr.getView().showGoodsList(bucket);
            System.out.println("Aborting...");
        } else if (!goodsCtr.twoGoodsIsDup(searchGoods, draftGoods)
                || searchGoods.getListPrice() != draftGoods.getListPrice()) {
            searchGoods.setManufacture(draftGoods.getManufacture());
            searchGoods.setGoodsName(draftGoods.getGoodsName());
            searchGoods.setListPrice(draftGoods.getListPrice());
            System.out.println("Changes succeeded...");
        } else {
            System.out.println("Back...");
        }
    }
    
    // Function 3.2
    private void editShip(Shipment shipment, Goods goods, GoodsList<Goods> repoGoodsList) {
        int choice;
        Shipment draftShipment = shipmentCtr.cloneShipment(shipment);
        do {
            try {
                this.view.menuOfFunctionEditShipmentsInfor();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        if (shipmentCtr.getView().typeInImportPrice(draftShipment) == 0) {
                            return;
                        }
                        break;
                    case 2:
                        if (shipmentCtr.getView().typeInProDate(draftShipment) == 0) {
                            return;
                        }
                        break;
                    case 3:
                        if (shipmentCtr.getView().typeInEpirDate(draftShipment) == 0) {
                            return;
                        }
                        break;
                    case 4:
                        if (shipmentCtr.getView().typeInQuan(draftShipment) == 0) {
                            return;
                        }
                        break;
                    case 5:
                        if (quanBecomeZero(goods, shipment, draftShipment, repoGoodsList)) {
                            return;
                        }
                        finishEditShip(goods, shipment, draftShipment);
                        break;
                    default:
                        System.out.println("Wrong input, Please type from 1->5!");
                }
            } catch (InputMismatchException ime) {
                ctions.wrInput();
                sc.next();
                choice = -1;
            }
        } while (choice != 5);
    }
    
    private void finishEditShip(Goods searchGoods, Shipment searchShipment,Shipment draftShipment) {
        int shipmentIndex = goodsCtr.indexOfDupShip(searchGoods, draftShipment);
        if (shipmentIndex != -1 && shipmentIndex != searchGoods.getShipments()
                .indexOf(searchShipment)) {
            //Neu thay doi tao ra 1 shipment da ton tai, user chon xem co them so luong vao cai da ton tai roi hay khong
            Shipment duplicateShipment = searchGoods.getShipments().get(shipmentIndex);
            if (shipmentCtr.getView().gainQuanDecision()) {
                // Neu user chon them vao cai da ton tai thi tang so luong 
                shipmentCtr.gainQuantity(duplicateShipment, draftShipment.getQuantity());
                // xoa shipment hien dang chinh sua
                searchGoods.getShipments().remove(searchShipment);
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

    private boolean quanBecomeZero(Goods searchGoods, Shipment searchShipment, 
            Shipment draftShipment, GoodsList<Goods> repoGoodsList) {
        while (draftShipment.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
            System.out.println(
                    "Your changes make quantity equal 0 and  this shipment will be deleted, keep your changes?");
            System.out.print(
                    "(Y: automatically delete shipment / N: undo changes)=> ");
            String yesNo = sc.nextLine();
            if (yesNo.equalsIgnoreCase("y")) {
                delShipInRepo(searchShipment, searchGoods, repoGoodsList);
                return true;
            } else if (yesNo.equalsIgnoreCase("n")) {
                return true;
            } else {
                ctions.wrInput();
            }
        }
        return false;
    }
    
    // Function 4
    private void delGoodsAShipment(GoodsList<Goods> repoGoodsList) {
        Goods searchGoods = null;
        while (true) {
            int input = this.view.typeDelOption();
            switch (input) {
                case 1:
                    searchGoods = goodsListCtr.searchGoods(repoGoodsList);
                    if (searchGoods != null) {
                        delGoodsInRepo(searchGoods, repoGoodsList);
                    }
                    break;
                case 2:
                    searchGoods = goodsListCtr.searchGoods(repoGoodsList);
                    if (searchGoods != null) {
                        Shipment searchShipment = goodsCtr.searchShipment(searchGoods);
                        if (searchShipment != null) {
                            delShipInRepo(searchShipment, searchGoods, repoGoodsList);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Back...");
                    return;
            }
        }
    }

    // Function 4.1
    private void delGoodsInRepo(Goods goods, GoodsList<Goods> repoGoodsList) {
        repoGoodsList.getGoodsList().remove(goods);
        System.out.println("Delete succeed...");
    }

    // Function 4.2
    private void delShipInRepo(Shipment shipment, Goods goods, GoodsList<Goods> repoGoodsList) {
        // tra ve true neu xoa thanh cong, false neu shipment 
        goods.getShipments().remove(shipment);
        if (goods.getShipments().isEmpty()) {
            delGoodsInRepo(goods, repoGoodsList);
        }
        System.out.println("Delete succeed...");
    }

    // Function 5
    private void printCurGoodsList(GoodsList<Goods> repoGoodsList) {

        //goodsList se sap xeo theo thu tu uu tien: name -> manufacture
        repoGoodsList
                .getGoodsList()
                .sort(new NameComparator().thenComparing(new ManufacComparator()));
        goodsListCtr.getView().showGoodsList(repoGoodsList);
    }

    // Function 6
    private void makeListByRequirement(GoodsList<Goods> repoGoodsList) {
        if (repoGoodsList.getGoodsList().isEmpty()) {
            System.out.println("Notthing found in repository to make a filter!");
            return;
        }
        String choice;
        do {
            this.view.menuOfRequestedList();
            choice = sc.nextLine().trim();
            //uf.clearScreen();
            switch (choice) {
                case "1":
                    printSameManufacGoodsList(repoGoodsList);
                    sc.nextLine();
                    break;
                case "2":
                    printTopLeastQuan(repoGoodsList);
                    break;
                case "3":
                    printTopLargestQuan(repoGoodsList);
                    break;
                case "4":
                    printTopNewestGoods(repoGoodsList);
                    break;
                case "5":
                    printAllExpired(repoGoodsList);
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->6!");
            }
        } while (!choice.equals("6"));
    }

    // Function 6.1
    private void printSameManufacGoodsList(GoodsList<Goods> repoGoodsList) {
        GoodsList filterList = new GoodsList(new ArrayList<>());
        List<String> listOfManufac = new ArrayList<>(this.view.printManufacList(repoGoodsList));
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
                    filterList.setGoodsList(new ArrayList<>(repoGoodsList
                            .getGoodsList()
                            .stream()
                            .filter(x -> x.getManufacture().equalsIgnoreCase(tmpStr))
                            .toList()));
                    goodsListCtr.getView().showGoodsList(filterList);
                    break;
                }
            } catch (InputMismatchException ime) {
                ctions.wrInput();
                choice = -1;
                sc.next();
            }
        } while (choice != length + 1);
    }

    // Function 6.2
    private void printTopLeastQuan(GoodsList<Goods> repoGoodsList) {
        repoGoodsList.getGoodsList()
                .sort(new QuanComparator()
                        .thenComparing(new NameComparator())
                        .thenComparing(new ManufacComparator()));
        GoodsList filterList = new GoodsList(repoGoodsList.getGoodsList()
                .stream()
                .limit(10).toList());
        goodsListCtr.getView().showGoodsList(filterList);
    }

    // Function 6.3
    private void printTopLargestQuan(GoodsList<Goods> repoGoodsList) {
        repoGoodsList.getGoodsList()
                .sort(new QuanComparator().reversed()
                        .thenComparing(new NameComparator())
                        .thenComparing(new ManufacComparator()));
        GoodsList filterList = new GoodsList(repoGoodsList.getGoodsList()
                .stream()
                .limit(10)
                .toList());
        goodsListCtr.getView().showGoodsList(filterList);
    }

    private void sortShipmentByProducDate(Goods goods) {
        Collections.sort(goods.getShipments(),
                (Shipment shipment1, Shipment shipment2)
                -> (-1) * shipment1.getNsx().compareTo(shipment2.getNsx()));
    }

    private List<Goods> listGoodsNewestProducDate(GoodsList<Goods> repoGoodsList) {
        // Tao 1 danh sach cac goods chi co 1 shipment moi nhat cua goods do
        // Loai tru cac goods khong chua shipment nao ca
        List<Goods> filterList = new ArrayList<>();
        for (Goods goods : repoGoodsList.getGoodsList()) {
            if (!goods.getShipments().isEmpty()) {
                sortShipmentByProducDate(goods);
                Goods tmpGoods = goodsCtr.cloneGoods(goods);
                tmpGoods.getShipments().clear();
                tmpGoods.getShipments().add(goods.getShipments().get(0));
                filterList.add(tmpGoods);
            }
        }
        return filterList;
    }
    
    // Function 6.4
    private void printTopNewestGoods(GoodsList<Goods> repoGoodsList) {
        GoodsList filterList = new GoodsList(listGoodsNewestProducDate(repoGoodsList));
        // Because Goods now only contains 1 shipment, we sort bucket by productionDate
        Collections.sort(filterList.getGoodsList(), new Comparator<Goods>() {
            @Override
            public int compare(Goods goods1, Goods goods2) {
                return (-1) * goods1.getShipments().get(0).getNsx()
                        .compareTo(goods2.getShipments().get(0).getNsx());
            }
        }.thenComparing(new NameComparator()));
        //If bucket contains less than 10 goods, list them all
        // otherwise, we only take 10 goods with latest Production Date to print out
        int size = filterList.getGoodsList().size();
        if (size <= 10) {
            goodsListCtr.getView().showGoodsList(filterList);
        } else {
            GoodsList tmp = new GoodsList(filterList.getGoodsList().subList(0, 10));
            goodsListCtr.getView().showGoodsList(tmp);
        }
    }

    // Function 6.5
    private void printAllExpired(GoodsList<Goods> repoGoodsList) {
        GoodsList filterList = new GoodsList(new ArrayList<>());
        for (Goods goods : repoGoodsList.getGoodsList()) {
            List<Shipment> tmpShipmentList = goods.getShipments()
                    .stream()
                    .filter(shipment -> shipment.getHsd().isBefore(CURRENT_DATE))
                    .toList();
            if (!tmpShipmentList.isEmpty()) {
                Goods tmpGoods = goodsCtr.cloneGoods(goods);
                tmpGoods.setShipments(tmpShipmentList);
                filterList.getGoodsList().add(tmpGoods);
            }
        }
        if (filterList.getGoodsList().isEmpty()) {
            System.out.println("No expired Goods found!");
        } else {
            goodsListCtr.getView().showGoodsList(filterList);
        }
    }
}
