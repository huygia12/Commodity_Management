/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Builder.EmployeeBuilder;
import View.Cautions;
import View.GoodsView;
import View.RepositoryView;
import View.ShipmentView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author s1rja
 */
public class Repository extends GoodsList {

    Cautions ctions = new Cautions();

    public Repository(List<Goods> repoGoodsList) {
        super(repoGoodsList);
    }

    public void addGoodsToList(GoodsView goodsView) {
        Goods newGoods = new Goods();
        int n = 1;
        int nextProcess;
        while (n != 3) {
            switch (n) {
                case 1:
                    nextProcess = goodsView
                            .typeInName(newGoods);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        return;
                    }
                case 2:
                    nextProcess = goodsView
                            .typeInManufac(newGoods, this);
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
                            .typeInListPrice(newGoods);
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
        newGoods.setID(String.format("%06d", this.getGoodsList().size()));
        this.getGoodsList().add(newGoods);
    }

    public void importGoods(ShipmentView shipView) {
        Goods searchGoods = this.searchGoods();
        if (searchGoods == null) {
            return;
        }
        int n = 1;
        int nextProcess;
        Shipment newShipment = new Shipment();
        while (n != 4) {
            switch (n) {
                case 1:
                    nextProcess = shipView.typeInQuan(newShipment);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        return;
                    }
                case 2:
                    nextProcess = shipView.typeInImportPrice(newShipment);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        break;
                    }
                case 3:
                    nextProcess = shipView.typeInProDate(newShipment);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 2;
                        break;
                    }
                case 4:
                    nextProcess = shipView.typeInEpirDate(newShipment);
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
        // kiem tra neu shipment nay da ton tai 
        int shipmentIndex = searchGoods.indexOfDupShip(newShipment);
        if (shipmentIndex != -1) {
            Shipment dupShipment = searchGoods.getShipments().get(shipmentIndex);
            shipView.gainQuanDecision(newShipment.getQuantity(), dupShipment);
        } else {
            newShipment.setID(String.format("%06d", searchGoods.getShipments().size()));
            searchGoods.getShipments().add(newShipment);
        }
    }

    public void delGoodsInRepo(Goods goods, GoodsList goodsList) {
        goodsList.getGoodsList().remove(goods);
        for (Goods tmpGoods : goodsList.getGoodsList()) {
            tmpGoods.setID(String.format("%06d", goodsList.getGoodsList().indexOf(tmpGoods)));
        }
        System.out.println("Delete succeed...");
    }

    private void finishEditGoods(Goods searchGoods, Goods draftGoods, GoodsList goodsList) {
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

    public void editGoods(Goods searchGoods, GoodsList goodsList, GoodsView goodsView, RepositoryView repoView) {
        Goods draftGoods = searchGoods.cloneGoods();

        int choice;
        do {
            try {
                repoView.menuOfFunctionEditGoodsInfor();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        if (goodsView.typeInName(draftGoods) == 0) {
                            return;
                        }
                        break;
                    case 2:
                        if (goodsView.typeInListPrice(draftGoods) == 0) {
                            return;
                        }
                        break;
                    case 3:
                        if (goodsView.typeInManufac(draftGoods, goodsList) == 0) {
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
        for (Shipment tmpShipment : goods.getShipments()) {
            tmpShipment.setID(String.format("%06d", goods.getShipments().indexOf(tmpShipment)));
        }
        if (goods.getShipments().isEmpty()) {
            delGoodsInRepo(goods, this);
        }
        System.out.println("Delete succeed...");
    }

    private void finishEditShip(Goods searchGoods, Shipment searchShipment, Shipment draftShipment, ShipmentView shipView) {
        int shipmentIndex = searchGoods.indexOfDupShip(draftShipment);
        if (shipmentIndex != -1 && shipmentIndex != searchGoods.getShipments()
                .indexOf(searchShipment)) {
            //If changes make duplicate shipments exist, make decision to add to existing one or not
            Shipment duplicateShipment = searchGoods.getShipments().get(shipmentIndex);
            if (shipView.gainQuanDecision(draftShipment.getQuantity(), duplicateShipment)) {
                // If user decided to add to the existing one, then remove the edited shipment 
                // and reset the id of shipment'sList in searchGoods
                searchGoods.getShipments().remove(searchShipment);
                for (Shipment shipment : searchGoods.getShipments()) {
                    shipment.setID(String.format("%06d",
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

    public void editShip(Shipment shipment, Goods goods, ShipmentView shipView, RepositoryView repositoryView) {
        int choice;
        Shipment draftShipment = shipment.cloneShipment();
        do {
            try {
                repositoryView.menuOfFunctionEditShipmentsInfor();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        if (shipView.typeInImportPrice(draftShipment) == 0) {
                            return;
                        }
                        break;
                    case 2:
                        if (shipView.typeInProDate(draftShipment) == 0) {
                            return;
                        }
                        break;
                    case 3:
                        if (shipView.typeInEpirDate(draftShipment) == 0) {
                            return;
                        }
                        break;
                    case 4:
                        if (shipView.typeInQuan(draftShipment) == 0) {
                            return;
                        }
                        break;
                    case 5:
                        if (quanBecomeZero(goods, shipment, draftShipment)) {
                            return;
                        }
                        finishEditShip(goods, shipment, draftShipment, shipView);
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
