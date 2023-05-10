/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.Cautions;
import View.GoodsView;
import View.RepositoryView;
import View.ShipmentView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author s1rja
 */
public class Repository extends GoodsList<Goods>{
    @SerializedName("ctions")
    @Expose
    final Cautions ctions = new Cautions();

    public Repository(List<Goods> repoGoodsList) {
        super(repoGoodsList);
    }

    public void addGoodsToList(GoodsView goodsView, IDGenerator idGenerator, Scanner sc) {
        Goods newGoods = new Goods();
        int n = 1;
        int nextProcess;
        while (n != 3) {
            switch (n) {
                case 1:
                    nextProcess = goodsView
                            .typeInName(newGoods, sc);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        return;
                    }
                case 2:
                    nextProcess = goodsView
                            .typeInManufac(newGoods, this, sc);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        break;
                    } else if (this.indexOfDupGoods(newGoods) != -1) {
                        System.out.println("Same goods detected!");
                        System.out.println("Aborting...");
                        return;
                    }
                case 3:
                    nextProcess = goodsView
                            .typeInListPrice(newGoods, sc);
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
        this.getGoodsList().add(newGoods);
    }

    public ImportedGoods importGoods(ShipmentView shipView, IDGenerator idGenerator, Scanner sc) {
        Goods searchGoods = this.searchGoods(sc);
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
                    nextProcess = shipView.typeInQuan(newShipment, sc);
                    if (nextProcess == 0 || nextProcess == -1) {
                        return null;
                    } 
                case 2:
                    nextProcess = shipView.typeInImportPrice(newShipment, sc);
                    if (nextProcess == 0) {
                        return null;
                    } else if (nextProcess == -1) {
                        break;
                    }
                case 3:
                    nextProcess = shipView.typeInProDate(newShipment, sc);
                    if (nextProcess == 0) {
                        return null;
                    } else if (nextProcess == -1) {
                        n = 2;
                        break;
                    }
                case 4:
                    nextProcess = shipView.typeInEpirDate(newShipment, sc);
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
        int shipmentIndex = searchGoods.indexOfDupShip(newShipment);
        if (shipmentIndex != -1) {
            // neu shipment da ton tai
            Shipment dupShipment = searchGoods.getShipments().get(shipmentIndex);
            if(shipView.gainQuanDecision(sc)){
                dupShipment.gainQuantity(newShipment.getQuantity());
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

    public void delGoodsInRepo(Goods goods, GoodsList<Goods> goodsList) {
        goodsList.getGoodsList().remove(goods);
        System.out.println("Delete succeed...");
    }

    private void finishEditGoods(Goods searchGoods, Goods draftGoods, GoodsList<Goods> goodsList) {
        GoodsList bucket = new GoodsList(new ArrayList<>(goodsList.getGoodsList()
                .stream()
                .filter(x -> x.twoGoodsIsDup(draftGoods))
                .toList()));
        if (bucket.getGoodsList().contains(searchGoods)) {
            bucket.getGoodsList().remove(searchGoods);
        }
        if (!bucket.getGoodsList().isEmpty()) {
            System.out.print(
                    "Cannot implement your changes cause it make duplicate value with these existed Goods value!");
            bucket.showGoodsList();
            System.out.println("Aborting...");
        } else if (!searchGoods.twoGoodsIsDup(draftGoods)
                || searchGoods.getListPrice() != draftGoods.getListPrice()) {
            searchGoods.setManufacture(draftGoods.getManufacture());
            searchGoods.setGoodsName(draftGoods.getGoodsName());
            searchGoods.setListPrice(draftGoods.getListPrice());
            System.out.println("Changes succeeded...");
        } else {
            System.out.println("Back...");
        }
    }

    public void editGoods(Goods searchGoods, GoodsList<Goods> goodsList, 
            GoodsView goodsView, RepositoryView repoView, Scanner sc) {
        Goods draftGoods = searchGoods.cloneGoods();

        int choice;
        do {
            try {
                repoView.menuOfFunctionEditGoodsInfor();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        if (goodsView.typeInName(draftGoods, sc) == 0) {
                            return;
                        }
                        break;
                    case 2:
                        if (goodsView.typeInListPrice(draftGoods, sc) == 0) {
                            return;
                        }
                        break;
                    case 3:
                        if (goodsView.typeInManufac(draftGoods, goodsList, sc) == 0) {
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

    
    public void delShipInRepo(Shipment shipment, Goods goods) {
        // tra ve true neu xoa thanh cong, false neu shipment 
        goods.getShipments().remove(shipment);
        if (goods.getShipments().isEmpty()) {
            delGoodsInRepo(goods, this);
        }
        System.out.println("Delete succeed...");
    }

    private void finishEditShip(Goods searchGoods, Shipment searchShipment, 
            Shipment draftShipment, ShipmentView shipView, Scanner sc) {
        int shipmentIndex = searchGoods.indexOfDupShip(draftShipment);
        if (shipmentIndex != -1 && shipmentIndex != searchGoods.getShipments()
                .indexOf(searchShipment)) {
            //Neu thay doi tao ra 1 shipment da ton tai, user chon xem co them so luong vao cai da ton tai roi hay khong
            Shipment duplicateShipment = searchGoods.getShipments().get(shipmentIndex);
            if (shipView.gainQuanDecision(sc)) {
                // Neu user chon them vao cai da ton tai thi tang so luong 
                duplicateShipment.gainQuantity(draftShipment.getQuantity());
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

    private boolean quanBecomeZero(Goods searchGoods, Shipment searchShipment, Shipment draftShipment, Scanner sc) {
        while (draftShipment.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
            System.out.println(
                    "Your changes make quantity equal 0 and  this shipment will be deleted, keep your changes?");
            System.out.print(
                    "(Y: automatically delete shipment / N: undo changes)=> ");
            String yesNo = sc.nextLine();
            if (yesNo.equalsIgnoreCase("y")) {
                delShipInRepo(searchShipment, searchGoods);
                return true;
            } else if (yesNo.equalsIgnoreCase("n")) {
                return true;
            } else {
                ctions.wrInput();
            }
        }
        return false;
    }

    public void editShip(Shipment shipment, Goods goods, ShipmentView shipView,
            RepositoryView repositoryView, Scanner sc) {
        int choice;
        Shipment draftShipment = shipment.cloneShipment();
        do {
            try {
                repositoryView.menuOfFunctionEditShipmentsInfor();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        if (shipView.typeInImportPrice(draftShipment, sc) == 0) {
                            return;
                        }
                        break;
                    case 2:
                        if (shipView.typeInProDate(draftShipment, sc) == 0) {
                            return;
                        }
                        break;
                    case 3:
                        if (shipView.typeInEpirDate(draftShipment, sc) == 0) {
                            return;
                        }
                        break;
                    case 4:
                        if (shipView.typeInQuan(draftShipment, sc) == 0) {
                            return;
                        }
                        break;
                    case 5:
                        if (quanBecomeZero(goods, shipment, draftShipment, sc)) {
                            return;
                        }
                        finishEditShip(goods, shipment, draftShipment, shipView, sc);
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
    
}
