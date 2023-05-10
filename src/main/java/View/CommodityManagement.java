/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.LocalDateDeserializer;
import Models.LocalDateSerializer;


/**
 *
 * @author FPTSHOP
 */
public class CommodityManagement {

    private static final String HOME = System.getProperty("user.dir");
    private static final String SEPARATOR = File.separator;
    private static final String FILE_PRINT = HOME + SEPARATOR + "data" + SEPARATOR + "projectData.json";
    private static final Path dataPath = Path.of(FILE_PRINT);
    
    static Scanner sc = new Scanner(System.in);
    static Cautions ctions = new Cautions();
    static DataStorage myData = new DataStorage();
    static GsonBuilder gsonBuilder = new GsonBuilder();
    
    private static void menuOfMainFunction() {
        System.out.println("\n********************************");
        System.out.println("* 1. Repository Management     *");
        System.out.println("* 2. Make New Order            *");
        System.out.println("* 3. Current Shift             *");
        System.out.println("* 4. Commodity History         *");
        System.out.println("* 5. Employee Management       *");
        System.out.println("* 6. Customer card Management  *");
        System.out.println("* 7. Settings                  *");
        System.out.println("* 8. Exit                      *");
        System.out.println("********************************");
        System.out.print("Option => ");
    }

    public static void main(String[] args) {
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        Gson gson =  gsonBuilder.setPrettyPrinting().create();
        loadData(gson);
        int choice;
        //insertInformation();
        do {
            try {
                menuOfMainFunction();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        if (myData.getShiftCtr().getShift() == null) {
                            myData.getShiftCtr().getView().shiftNotOpenCaution();
                            break;
                        }
                        myData.getRepoCtr().repositoryManagement(myData.getShiftCtr().getShift(), 
                                myData.getIdGenerator()
                                , sc);
                        break;
                    case 2:
                        if (myData.getShiftCtr().getShift() == null) {
                            myData.getShiftCtr().getView().shiftNotOpenCaution();
                            break;
                        }
                        myData.getOrderCtr().makeNewOrder(myData.getRepoCtr().getRepository(),
                                myData.getCustomerCardListCtr().getCustomerCardList(),
                                myData.getSettingsCtr().getMyStore(),
                                myData.getShiftCtr().getShift(),
                                myData.getIdGenerator(), 
                                sc);
                        break;
                    case 3:
                        myData.getShiftCtr().ShiftManagement(myData.getEmployeeListCtr().getEmployeeList(),
                                myData.getSettingsCtr().getMyStore(),
                                myData.getIdGenerator(),
                                myData.getHisCtr().getHistory(),
                                sc);
                        break;
                    case 4:
                        myData.getHisCtr().historyManagement(sc);
                        break;
                    case 5:
                        myData.getEmployeeListCtr().employeeListManagement(myData.getShiftCtr().getShift(), sc);
                        break;
                    case 6:
                        myData.getCustomerCardListCtr().customerCardListManagement(myData.getIdGenerator(), sc);
                        break;
                    case 7:
                        myData.getSettingsCtr().SettingsManagement(myData.getShiftCtr().getShift(), sc);
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Wrong input, Please type from 1->6!");
                        break;
                }
            } catch (InputMismatchException ime) {
                ctions.wrInput();
                choice = -1;
                sc.next();
            }
        } while (choice != 8);
        saveData(gson);
    }

    private static void insertInformation() {
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Custard Cake", "TuyenIndustry", new BigDecimal("3000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Cup Cake", "TuyenIndustry", new BigDecimal("8000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Donut", "TuyenIndustry", new BigDecimal("12000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Flan", "Kem cacao", new BigDecimal("5000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Strawberry ice-cream", "Kem cacao", new BigDecimal("9000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Paddle pop", "Kem cacao", new BigDecimal("5000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Lemon Soda", "Kem cacao", new BigDecimal("8000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Ruler", "HuyStationery", new BigDecimal("3000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Pencil", "HuyStationery", new BigDecimal("2000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Rubber", "HuyStationery", new BigDecimal("2000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Note", "HuyStationery", new BigDecimal("7000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Sugar", "CookWithTung", new BigDecimal("22000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Cooking oil", "CookWithTung", new BigDecimal("48000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Spring-roll", "CookWithTung", new BigDecimal("50000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Salt", "CookWithTung", new BigDecimal("5000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().add(new Goods("Instant Noodle", "CookWithTung", new BigDecimal("14000"), myData.getIdGenerator().generateID(Goods.class.getName(), 6)));
        myData.getRepoCtr().getRepository().getGoodsList().get(0).getShipments().add(new Shipment(new BigDecimal("20"), new BigDecimal("20000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(0).getShipments().add(new Shipment(new BigDecimal("40"), new BigDecimal("19000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(0).getShipments().add(new Shipment(new BigDecimal("30000"), new BigDecimal("18000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(1).getShipments().add(new Shipment(new BigDecimal("50"), new BigDecimal("3000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(1).getShipments().add(new Shipment(new BigDecimal("20"), new BigDecimal("4000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(1).getShipments().add(new Shipment(new BigDecimal("10"), new BigDecimal("5000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(2).getShipments().add(new Shipment(new BigDecimal("35"), new BigDecimal("5000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 5, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(2).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("6000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 5, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(2).getShipments().add(new Shipment(new BigDecimal("29"), new BigDecimal("7000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(3).getShipments().add(new Shipment(new BigDecimal("50"), new BigDecimal("2500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(3).getShipments().add(new Shipment(new BigDecimal("51"), new BigDecimal("2400"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(3).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("2100"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(4).getShipments().add(new Shipment(new BigDecimal("56"), new BigDecimal("4500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(4).getShipments().add(new Shipment(new BigDecimal("44"), new BigDecimal("4700"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(4).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("3800"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(5).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("2500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(5).getShipments().add(new Shipment(new BigDecimal("46"), new BigDecimal("2700"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(5).getShipments().add(new Shipment(new BigDecimal("68"), new BigDecimal("2200"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(6).getShipments().add(new Shipment(new BigDecimal("42"), new BigDecimal("4000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(6).getShipments().add(new Shipment(new BigDecimal("65"), new BigDecimal("4300"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(6).getShipments().add(new Shipment(new BigDecimal("26"), new BigDecimal("5000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(7).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("1000"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(7).getShipments().add(new Shipment(new BigDecimal("77"), new BigDecimal("1200"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(7).getShipments().add(new Shipment(new BigDecimal("88"), new BigDecimal("1000"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(8).getShipments().add(new Shipment(new BigDecimal("13"), new BigDecimal("800"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(8).getShipments().add(new Shipment(new BigDecimal("16"), new BigDecimal("750"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(8).getShipments().add(new Shipment(new BigDecimal("44"), new BigDecimal("700"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(9).getShipments().add(new Shipment(new BigDecimal("15"), new BigDecimal("700"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(9).getShipments().add(new Shipment(new BigDecimal("17"), new BigDecimal("750"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(9).getShipments().add(new Shipment(new BigDecimal("44"), new BigDecimal("750"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(10).getShipments().add(new Shipment(new BigDecimal("42"), new BigDecimal("3000"), LocalDate.of(2023, 3, 13), LocalDate.of(2025, 3, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(10).getShipments().add(new Shipment(new BigDecimal("19"), new BigDecimal("3000"), LocalDate.of(2023, 3, 15), LocalDate.of(2025, 3, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(10).getShipments().add(new Shipment(new BigDecimal("18"), new BigDecimal("4000"), LocalDate.of(2023, 3, 17), LocalDate.of(2025, 3, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(11).getShipments().add(new Shipment(new BigDecimal("15"), new BigDecimal("11000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 8, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(11).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("11000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 8, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(11).getShipments().add(new Shipment(new BigDecimal("23"), new BigDecimal("12000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 8, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(12).getShipments().add(new Shipment(new BigDecimal("32"), new BigDecimal("24000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 8, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(12).getShipments().add(new Shipment(new BigDecimal("31"), new BigDecimal("24000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 8, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(12).getShipments().add(new Shipment(new BigDecimal("33"), new BigDecimal("25000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 8, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(13).getShipments().add(new Shipment(new BigDecimal("35"), new BigDecimal("25000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 4, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(13).getShipments().add(new Shipment(new BigDecimal("37"), new BigDecimal("25000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(13).getShipments().add(new Shipment(new BigDecimal("28"), new BigDecimal("25000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 4, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(14).getShipments().add(new Shipment(new BigDecimal("43"), new BigDecimal("2000"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 12, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(14).getShipments().add(new Shipment(new BigDecimal("22"), new BigDecimal("2000"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 12, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(14).getShipments().add(new Shipment(new BigDecimal("25"), new BigDecimal("2000"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 12, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(15).getShipments().add(new Shipment(new BigDecimal("23"), new BigDecimal("6500"), LocalDate.of(2023, 3, 13), LocalDate.of(2023, 10, 14), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(15).getShipments().add(new Shipment(new BigDecimal("27"), new BigDecimal("6500"), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 10, 16), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getRepoCtr().getRepository().getGoodsList().get(15).getShipments().add(new Shipment(new BigDecimal("11"), new BigDecimal("6500"), LocalDate.of(2023, 3, 17), LocalDate.of(2023, 10, 18), myData.getIdGenerator().generateID(Shipment.class.getName(), 8)));
        myData.getEmployeeListCtr().getEmployeeList().getList().add(new Employee(new BigDecimal("22000"), "2223666611", "Nguyen Gia", "Huy", "0705737293", "so10-Ngo2-YenPhuc-PhucLa-HaDong", 19, Gender.MALE));
        myData.getEmployeeListCtr().getEmployeeList().getList().add(new Employee(new BigDecimal("23000"), "3553646623", "Vu Hung", "Tung", "0905737293", "AeonMall HaDong", 16, Gender.MALE));
        myData.getEmployeeListCtr().getEmployeeList().getList().add(new Employee(new BigDecimal("22000"), "7337593977", "Dao Van", "Tuyen", "0805737293", "220-TrieuKhuc-TanTrieu-ThanhTri", 20, Gender.MALE));
        myData.getEmployeeListCtr().getEmployeeList().getList().add(new Employee(new BigDecimal("25000"), "3957577777", "Nguyen Thao", "Chi", "0505737293", "141-ChienThang-TanTrieu", 20, Gender.FEMALE));
        myData.getEmployeeListCtr().getEmployeeList().getList().add(new Employee(new BigDecimal("20000"), "2727495500", "Tran Luu", "Dung", "0903737293", "Vinhome Riverside", 19, Gender.OTHER));
        myData.getCustomerCardListCtr().getCustomerCardList().getList().add(new CustomerCard(myData.getIdGenerator().generateID(CustomerCard.class.getName(), 6), new Customer("Nguyen Duc", "Anh", "0444033022", "34 Nguyen Du", 20, Gender.MALE)));
        myData.getCustomerCardListCtr().getCustomerCardList().getList().add(new CustomerCard(myData.getIdGenerator().generateID(CustomerCard.class.getName(), 6), new Customer("Le Van", "Quyet", "0333333222", "26 Do Duc Duc", 20, Gender.OTHER)));
        myData.getCustomerCardListCtr().getCustomerCardList().getList().add(new CustomerCard(myData.getIdGenerator().generateID(CustomerCard.class.getName(), 6), new Customer("Do Quynh", "Anh", "0733833888", "16 Cau Giay", 22, Gender.FEMALE)));
        myData.getCustomerCardListCtr().getCustomerCardList().getList().add(new CustomerCard(myData.getIdGenerator().generateID(CustomerCard.class.getName(), 6), new Customer("Le Duc", "Cuong", "053555133", "41 Minh Khai", 17, Gender.MALE)));
        myData.getSettingsCtr().setMyStore(new Store("Chang hi", "bonEmMuonAnHotpotWangWang@gmail.com", "112-Nguyen Van Loc", 10, "0705737292"));
    }

    public void clearScreen() {
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.
        } catch (AWTException ex) {
            Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void typeAnyKeyToContinue() {
        System.out.println("\nType any key to continue...");
        sc.nextLine();
    }

    private static void saveData(Gson gson) {
//        myData.getstorage().put("myData.getRepoCtr().getRepository().getGoodsList()", myData.getRepoCtr().getRepository().getGoodsList());
//        myData.getstorage().put("myData.getIdGenerator()", myData.getIdGenerator());
//        myData.getstorage().put("shiftCtr", shiftCtr);
//        myData.getstorage().put("myData.getEmployeeListCtr()", myData.getEmployeeListCtr());
//        myData.getstorage().put("myData.getCustomerCardListCtr()", myData.getCustomerCardListCtr());
//        myData.getstorage().put("settingsCtr", settingsCtr);
//        myData.getstorage().put("repoCtr", repoCtr);
//        myData.getstorage().put("hisCtr", hisCtr);
        
        try ( PrintWriter pw = new PrintWriter(Files.newBufferedWriter(dataPath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            gson.toJson(myData, pw);
        } catch (IOException ex) {
            Logger.getLogger(CommodityManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void loadData(Gson gson) {
        try ( BufferedReader br = new BufferedReader(Files.newBufferedReader(dataPath))) {
            myData = gson.fromJson(br, DataStorage.class);
        } catch (IOException ex) {
            Logger.getLogger(CommodityManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
//        myData.getRepoCtr().getRepository().getGoodsList() = (List<Goods>)myData.getstorage().get("myData.getRepoCtr().getRepository().getGoodsList()");
//        myData.getIdGenerator() = (IDGenerator)myData.getstorage().get("myData.getIdGenerator()");
//        shiftCtr = (ShiftController)myData.getstorage().get("shiftCtr");
//        myData.getEmployeeListCtr() = (EmployeeListController)myData.getstorage().get("myData.getEmployeeListCtr()");
//        myData.getCustomerCardListCtr() = (CustomerCardListController)myData.getstorage().get("myData.getCustomerCardListCtr()");
//        settingsCtr = (SettingsController)myData.getstorage().get("settingsCtr");
//        repoCtr = (RepositoryController)myData.getstorage().get("repoCtr");
//        hisCtr = (HistoryController)myData.getstorage().get("hisCtr");
    }
}
