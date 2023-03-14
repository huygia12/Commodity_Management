/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaProject;

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
    
    // sub methods
    public Goods searchGoods() {
        // Huy
        Goods goods = new Goods();
        int length = goodsList.size();
        for (int i = 0; i < length; i++) {
        }
        return goods;
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
        // Tung
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
                                good.setListPrice(listPrice);
                                completed = true;
                            } catch (NumberFormatException nfe) {
                                System.out.println("Wrong input!");
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
        // Huy
        sc.nextLine();
        int n = 1;
        String input;
        Shipment shipment = new Shipment();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
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
                                ;
                                completed = true;
                            } catch (NumberFormatException nfe) {
                                System.out.println("Wrong input!");
                            }
                        }
                    }
                case 2:
                    System.out.print("Input product import price or type BACK/EXIT to go back/exit:");
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("exit")) {
                        return;
                    } else if (input.equalsIgnoreCase("back")) {
                        continue;
                    } else {
                        shipment.setImportPrice(n);
                    }
                case 3:
                    n = 2;
                    completed = false;
                    boolean chooseBack = false;
                    while (!completed) {
                        System.out.print("Input production date or type BACK/EXIT to go back/exit:");
                        input = sc.nextLine();
                        if (input.equalsIgnoreCase("exit")) {
                            return;
                        } else if (input.equalsIgnoreCase("back")) {
                            chooseBack = true;
                            break;
                        } else {
                            try {
                                Date nsx = df.parse(input);
                                shipment.setNsx(nsx);
                                completed = true;
                            } catch (ParseException pe) {
                                System.out.println("Wrong input!");
                            }
                        }
                    }
                    if (chooseBack) {
                        break;
                    }
                case 4:
                    completed = false;
                    chooseBack = false;
                    while (!completed) {
                        System.out.print("Input product expiration Date or type BACK/EXIT to go back/exit: ");
                        input = sc.nextLine();
                        if (input.equalsIgnoreCase("exit")) {
                            return;
                        } else if (input.equalsIgnoreCase("back")) {
                            chooseBack = true;
                            break;
                        } else {
                            try {
                                Date hsd = df.parse(input);
                                shipment.setHsd(hsd);
                                completed = true;
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
        // Undeveloped
    }

    // function 5
    public void showGoodsList(List<Goods> goodsList) {
        // Tuyen
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
                        importGoods(searchGoods());
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
            }
        } while (choice != 7);
    }
}
