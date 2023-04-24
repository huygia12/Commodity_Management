/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import View.ShipmentView;
import View.GoodsView;
import View.Cautions;
import View.RepositoryView;
import Models.Goods;
import Models.GoodsList;
import Models.Repository;
import Models.Shipment;
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
    private Repository repository;

    public RepositoryController(Repository repository) {
        this.repository = repository;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public RepositoryView getRepositoryView(){
        return this.view;
    }
    
    // Function 3
    private void editGoodsAndShipmentInfor(GoodsView goodsView, ShipmentView shipView) {
        String choice;
        Goods searchGoods = null;
        do {
            this.view.menuOfFunctionEditInfor();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    searchGoods = this.getRepository().searchGoods();
                    if (searchGoods == null) {
                        return;
                    }
                    this.repository.editGoods(searchGoods, this.getRepository(), goodsView, view);
                    break;
                case "2":
                    searchGoods = this.repository.searchGoods();
                    if (searchGoods == null) {
                        return;
                    }
                    Shipment searchShipment = searchGoods.searchShipment();
                    if (searchShipment == null) {
                        break;
                    }
                    this.repository.editShip(searchShipment, searchGoods, shipView, view);
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
    private void delGoodsAShipment() {
        int input = this.view.typeDelOption();
        Goods searchGoods = null;
        while (true) {
            switch (input) {
                case 1:
                    searchGoods = this.repository.searchGoods();
                    if (searchGoods != null) {
                        this.repository.delGoodsInRepo(searchGoods, this.getRepository());
                    }
                    break;
                case 2:
                    searchGoods = this.repository.searchGoods();
                    if (searchGoods != null) {
                        Shipment searchShipment = searchGoods.searchShipment();
                        if (searchShipment != null) {
                            this.repository.delShipInRepo(searchShipment, searchGoods);
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
    private void printCurGoodsList() {
        
        //goodsList se sap xeo theo thu tu uu tien: name -> manufacture
        this.getRepository()
                .getGoodsList()
                .sort(new nameComparator().thenComparing(new manufacComparator()));
        this.repository.showGoodsList();
    }

    // Function 6
    private void makeListByRequirement() {
        if (this.repository.getGoodsList().isEmpty()) {
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
                    printSameManufacGoodsList();
                    //uf.typeAnyKeyToContinue();
                    //uf.clearScreen();
                    break;
                case "2":
                    printTopLeastQuan();
                    break;
                case "3":
                    printTopLargestQuan();
                    break;
                case "4":
                    printTopNewestGoods();
                    break;
                case "5":
                    printAllExpired();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->6!");
            }
        } while (!choice.equals("6"));
    }

    // Function 6.1
    private void printSameManufacGoodsList() {
        GoodsList filterList = new GoodsList(new ArrayList<>());
        List<String> listOfManufac = new ArrayList<>(this.view.printManufacList(this));
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
                    filterList.setGoodsList(new ArrayList<>(this.repository
                            .getGoodsList()
                            .stream()
                            .filter(x -> x.getProvider().equalsIgnoreCase(tmpStr))
                            .toList()));
                    filterList.showGoodsList();
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
    private void printTopLeastQuan() {
        this.repository.getGoodsList()
                .sort(new quanComparator()
                        .thenComparing(new nameComparator())
                        .thenComparing(new manufacComparator()));
        GoodsList filterList = new GoodsList(this.repository.getGoodsList()
                .stream()
                .limit(10).toList());
        filterList.showGoodsList();
    }

    // Function 6.3
    private void printTopLargestQuan() {
        this.repository.getGoodsList()
                .sort(new quanComparator().reversed()
                        .thenComparing(new nameComparator())
                        .thenComparing(new manufacComparator()));
        GoodsList filterList = new GoodsList(this.repository.getGoodsList()
                .stream()
                .limit(10)
                .toList());
        filterList.showGoodsList();
    }

    // Function 6.4
    private void sortShipmentByProducDate(Goods goods) {
        Collections.sort(goods.getShipments(),
                (Shipment shipment1, Shipment shipment2)
                -> (-1) * shipment1.getNsx().compareTo(shipment2.getNsx()));
    }

    private List<Goods> listGoodsNewestProducDate() {
        // Tao 1 danh sach cac goods chi co 1 shipment moi nhat cua goods do
        // Loai tru cac goods khong chua shipment nao ca
        List<Goods> filterList = new ArrayList<>();
        for (Goods goods : this.repository.getGoodsList()) {
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

    private void printTopNewestGoods() {
        GoodsList filterList = new GoodsList(listGoodsNewestProducDate());
        // Because Goods now only contains 1 shipment, we sort bucket by productionDate
        Collections.sort(filterList.getGoodsList(), new Comparator<Goods>() {
            @Override
            public int compare(Goods goods1, Goods goods2) {
                return (-1) * goods1.getShipments().get(0).getNsx()
                        .compareTo(goods2.getShipments().get(0).getNsx());
            }
        }.thenComparing(new nameComparator()));
        //If bucket contains less than 10 goods, list them all
        // otherwise, we only take 10 goods with latest Production Date to print out
        int size = filterList.getGoodsList().size();
        if (size <= 10) {
            filterList.showGoodsList();
        } else {
            GoodsList tmp = new GoodsList(filterList.getGoodsList().subList(0, 10));
            tmp.showGoodsList();
        }
    }

    // Function 6.5
    private void printAllExpired() {
        GoodsList filterList = new GoodsList(new ArrayList<>());
        for (Goods goods : this.repository.getGoodsList()) {
            List<Shipment> tmpShipmentList = goods.getShipments()
                    .stream()
                    .filter(shipment -> shipment.getHsd().isBefore(CURRENT_DATE))
                    .toList();
            if (!tmpShipmentList.isEmpty()) {
                Goods tmpGoods = goods.cloneGoods();
                tmpGoods.setShipment(tmpShipmentList);
                filterList.getGoodsList().add(tmpGoods);
            }
        }
        if (filterList.getGoodsList().isEmpty()) {
            System.out.println("No expired Goods found!");
        } else {
            filterList.showGoodsList();
        }
    }

    public void repositoryManagement() {
        ShipmentView shipView = new ShipmentView();
        GoodsView goodsView = new GoodsView();
        int choice;
        do {
            try {
                this.view.menuOfRepoManagement();
                choice = sc.nextInt();
                sc.nextLine();
                //uf.clearScreen();
                switch (choice) {
                    case 1:
                        this.repository.addGoodsToList();
                        //uf.clearScreen();
                        //sc.nextLine();
                        break;
                    case 2:
                        this.repository.importGoods(shipView);
                        //uf.clearScreen();
                        break;
                    case 3:
                        editGoodsAndShipmentInfor(goodsView, shipView);
                        //uf.clearScreen();
                        break;
                    case 4:
                        delGoodsAShipment();
                        //uf.clearScreen();
                        break;
                    case 5:
                        printCurGoodsList();
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
                ctions.wrInput();
                choice = -1;
                sc.next();
            }
        } while (choice != 7);
    }
}
