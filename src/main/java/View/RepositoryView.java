/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controllers.RepositoryController;
import Models.Goods;
import java.util.InputMismatchException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author FPTSHOP
 */
public class RepositoryView {
    
    public void menuOfRepoManagement() {
        System.out.println("\n***********************************");
        System.out.println("* 1. Add New Goods                *");
        System.out.println("* 2. Import Goods                 *");
        System.out.println("* 3. Change Goods||Shipment Infor *");
        System.out.println("* 4. Delete Goods||Shipment Infor *");
        System.out.println("* 5. Show Repository              *");
        System.out.println("* 6. List Filter                  *");
        System.out.println("* 7. Back                         *");
        System.out.println("***********************************");
        System.out.print("Option => ");
    }

    public void menuOfFunctionEditGoodsInfor() {
        System.out.println("\n***************************************");
        System.out.println("* 1. Change product Name              *");
        System.out.println("* 2. Change goods List price          *");
        System.out.println("* 3. Change goods Manufacture         *");
        System.out.println("* 4. Back                             *");
        System.out.println("***************************************");
        System.out.print("Option => ");
    }

    public void menuOfFunctionEditShipmentsInfor() {
        System.out.println("\n***************************************");
        System.out.println("* 1. Change shipment Import Price     *");
        System.out.println("* 2. Change shipment Production Date  *");
        System.out.println("* 3. Change shipment Expiration Date  *");
        System.out.println("* 4. Change shipment Quantity         *");
        System.out.println("* 5. Back                             *");
        System.out.println("***************************************");
        System.out.print("Option => ");
    }

    public void menuOfFunctionEditInfor() {
        System.out.println("\n****************************************");
        System.out.println("* 1. Change goods Informations         *");
        System.out.println("* 2. Change shipment Information       *");
        System.out.println("* 3. Back                              *");
        System.out.println("****************************************");
        System.out.print("Option => ");
    }

    
    public void menuOfFunctionDel() {
        System.out.println("\n********************************");
        System.out.println("* 1. Delete a goods            *");
        System.out.println("* 2. Delete a shipment         *");
        System.out.println("* 3. Back                      *");
        System.out.println("********************************");
        System.out.print("Option => ");
    }

    public int typeDelOption(Scanner sc) {
        // Option duoc tra ve: 1-Xoa 1 goods | 2-Xoa 1 shipment | 3-back
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

    
    public void menuOfRequestedList() {
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
    
    public Set<String> printManufacList(RepositoryController repoCtr) {
        // in ra danh sach cac manufacture hien tai(khong in trung lap)
        Set<String> listOfManufac = new HashSet<>();
        for (Goods goods : repoCtr.getRepository().getGoodsList()) {
            listOfManufac.add(goods.getManufacture());
        }
        if (listOfManufac.isEmpty()) {
            System.out.println("Notthing found in your repository!");
            return null;
        }
        String title = "ManufacturerList";
        int maxSize = title.length() + 20;
        for (String tmpStr : listOfManufac) {
            int length = tmpStr.length();
            if (length > (maxSize - 5)) {
                maxSize = length + 5;
                if (maxSize % 2 != 0) {
                    maxSize += 1;
                }
            }
        }
        System.out.println("");
        System.out.println("|" + "-".repeat((maxSize - title.length()) / 2) + title + "-".repeat((maxSize - title.length()) / 2) + "|");
        int index = 1;
        for (String manufac : listOfManufac) {
            System.out.println("| " + index + ". " + manufac + String.format("%" + (maxSize - manufac.length() - 3) + "s", " |"));
            index++;
        }
        System.out.println("| " + (listOfManufac.size() + 1) + ". Back" + String.format("%" + (maxSize - 7) + "s", " |"));
        System.out.println("|" + "-".repeat(maxSize) + "|");
        return listOfManufac;
    }
}
