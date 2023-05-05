/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.ShiftView;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPTSHOP
 */
public class Shift {

    private final String HOME = System.getProperty("user.dir");
    private final String SEPARATOR = File.separator;
    private final String FILE_PRINT = HOME + SEPARATOR + "output" + SEPARATOR + "shiftOverView.txt";

    final Scanner sc = new Scanner(System.in);
    private Stack<Order> orderHisPerShift = new Stack<>();
    private Stack<ImportedGoods> importGoodsHis = new Stack<>();
    private String openDateTime = null;
    private String endDateTime = null;
    private String ID;
    private BigDecimal openingBalance = null;
    private BigDecimal shippingFee = null;
    private EmployeeList employeeOfThisShift;
    private Employee cashier;
    private BigDecimal grossRevenue = BigDecimal.ZERO;
    private BigDecimal netRevenue = BigDecimal.ZERO;
    
    public Shift() {
    }

    public Shift(String ID) {
        this.ID = ID;
    }

    public Stack<Order> getOrderHisPerShift() {
        return orderHisPerShift;
    }

    public Stack<ImportedGoods> getImportGoodsHis() {
        return importGoodsHis;
    }

    public void setOrderHisPerShift(Stack<Order> orderHisPerShift) {
        this.orderHisPerShift = orderHisPerShift;
    }

    public void setImportGoodsHis(Stack<ImportedGoods> importGoodsHis) {
        this.importGoodsHis = importGoodsHis;
    }

    public String getOpenTime() {
        return openDateTime;
    }

    public void setOpenTime() {
        this.openDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getEndTime() {
        return endDateTime;
    }

    public void setEndTime() {
        this.endDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(BigDecimal openingBalance) {
        this.openingBalance = openingBalance;
    }

    public BigDecimal getTransportFee() {
        return shippingFee;
    }

    public void setTransportFee(BigDecimal transportFee) {
        this.shippingFee = transportFee;
    }

    public EmployeeList getEmployeeOfThisShift() {
        return employeeOfThisShift;
    }

    public void setEmployeeOfThisShift(EmployeeList employeeList) {
        this.employeeOfThisShift = employeeList;
    }

    public Employee getCashier() {
        return cashier;
    }

    public void setCashier(Employee cashier) {
        this.cashier = cashier;
    }

    public BigDecimal getGrossRevenue() {
        return grossRevenue;
    }

    public BigDecimal getNetRevenue() {
        return netRevenue;
    }

    public boolean orderOnSameDay(Order newOrder) {
        LocalDateTime date1 = LocalDateTime.parse(this.orderHisPerShift.peek().getInVoiceDateTime(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime date2 = LocalDateTime.parse(newOrder.getInVoiceDateTime(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return date1.getDayOfMonth() == date2.getDayOfMonth()
                && date1.getMonth() == date2.getMonth()
                && date1.getYear() == date2.getYear();
    }

    public boolean importGoodsOnSameDay(ImportedGoods newImportGoods) {
        LocalDateTime date1 = LocalDateTime.parse(this.importGoodsHis.peek().getImportDateTime(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime date2 = LocalDateTime.parse(newImportGoods.getImportDateTime(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return date1.getDayOfMonth() == date2.getDayOfMonth()
                && date1.getMonth() == date2.getMonth()
                && date1.getYear() == date2.getYear();
    }

    public void openShift(ShiftView shiftView, EmployeeList employeeList) {
        if (this.endDateTime == null) {
            shiftView.shiftNotEndCaution();
            return;
        }
        this.setOpenTime();
        int n = 1;
        int nextProcess;
        while (n != 3) {
            switch (n) {
                case 1:
                    nextProcess = shiftView.typeInOpeningBalance(this);
                    if (nextProcess == 0 || nextProcess == -1) {
                        return;
                    }
                    break;
                case 2:
                    nextProcess = shiftView.typeInEmployeesOfThisShift(this, employeeList);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        break;
                    }
                    break;
                case 3:
                    nextProcess = shiftView.typeInCashier(this);
                    break;
            }
        }
        this.openDateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"));

    }

    public void modifyEmployeeOfThisShift(ShiftView shiftView, EmployeeList employeeList) {
        String choice;
        Employee e;
        do {
            shiftView.menuOfModifyEmployeeListOfThisShift();
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    e = employeeList.searchEmployee();
                    if (e != null) {
                        this.employeeOfThisShift.getList().add(e);
                    }
                    break;
                case "2":
                    e = this.employeeOfThisShift.searchEmployee();
                    if (e != null) {
                        this.employeeOfThisShift.getList().remove(e);
                    }
                    break;
                case "3":
                    this.employeeOfThisShift.getList().clear();
                    shiftView.typeInEmployeesOfThisShift(this, employeeList);
                    break;
                case "4":
                    System.out.println("Back...");
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->4!");
            }
        } while (!choice.equalsIgnoreCase("4"));
    }

    private void computeGrossRevenue(){
        BigDecimal result = BigDecimal.ZERO;
        for (Order order : this.orderHisPerShift) {
            result = result.add(order.getDiscountMoney());
        }
    }
    
    private void computeNetRevenue(){
        
    }
    
    public void endShift(ShiftView shiftView, Store myStore) {
        if (this.openDateTime == null) {
            shiftView.shiftNotOpenCaution();
            return;
        }
        if (this.shippingFee != null) {
            shiftView.typeInShippingFee(this);
        }
        this.setEndTime();
        printFileOfThisShiftOverView(myStore);
    }

    public void printFileOfThisShiftOverView(Store myStore) {
        Path outputPath = Path.of(FILE_PRINT);
        try ( PrintWriter pw = new PrintWriter(Files.newBufferedWriter(outputPath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING))) {
            pw.printf("%5s", "END-SHIFT-REPORT");
            pw.println(String.format("%20s" + " | " + "%-20s", "STORE NAME", myStore.getName()));
            pw.println("-".repeat(40));
            pw.println(String.format("%20s" + " | " + "%-20s", "Open time", this.openDateTime));
            pw.println(String.format("%20s" + " | " + "%-20s", "Close time", this.endDateTime));
            pw.println(String.format("%20s" + " | " + "%-20s", "Cashier", this.cashier.getFirstName()+" "+this.cashier.getLastName()));
            pw.println(String.format("%20s" + " | " + "%-20s", "Openning balance", this.openingBalance));
            pw.println(String.format("%20s" + " | " + "%-20s", "Openning balance", this.openingBalance));
            pw.println(String.format("%20s" + " | " + "%-20s", "Openning balance", this.openingBalance));
            pw.println(String.format("%20s" + " | " + "%-20s", "Openning balance", this.openingBalance));
            pw.println(String.format("%20s" + " | " + "%-20s", "Openning balance", this.openingBalance));
            pw.println(String.format("%20s" + " | " + "%-20s", "Openning balance", this.openingBalance));
            pw.println(String.format("%20s" + " | " + "%-20s", "Openning balance", this.openingBalance));
            pw.println(String.format("%20s" + " | " + "%-20s", "Openning balance", this.openingBalance));
            pw.println(String.format("%20s" + " | " + "%-20s", "Openning balance", this.openingBalance));
            pw.println(String.format("%20s" + " | " + "%-20s", "Openning balance", this.openingBalance));

        } catch (IOException ex) {
            Logger.getLogger(Shift.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
