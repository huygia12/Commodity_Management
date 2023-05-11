/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import View.EmployeeListView;
import View.EmployeeView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class EmployeeList extends AbstractHumanList<Employee> {
    @SerializedName("salaryMaxSize")
    @Expose
    private int salaryMaxSize;
    @SerializedName("CCCDmaxSize")
    @Expose
    private int CCCDmaxSize;
    @SerializedName("firstNameMaxSize")
    @Expose
    private int firstNameMaxSize;
    @SerializedName("lastNameMaxSize")
    @Expose
    private int lastNameMaxSize;
    @SerializedName("phoneNumberMaxSize")
    @Expose
    private int phoneNumberMaxSize;
    @SerializedName("addressMaxSize")
    @Expose
    private int addressMaxSize;
    

    public EmployeeList() {
    }

    public EmployeeList(List<Employee> employeeList) {
        this.list = employeeList;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> humanList) {
        this.list = humanList;
    }

    public void addNewEmployee(EmployeeView employeeView, Scanner sc) {
        Employee newEmployee = new Employee();
        int n = 1;
        int nextProcess;
        while (n != 8) {
            switch (n) {
                case 1:
                    nextProcess = employeeView.typeInFirstName(newEmployee, sc);
                    if (nextProcess == 0 || nextProcess == -1) {
                        return;
                    }
                case 2:
                    nextProcess = employeeView.typeInLastName(newEmployee, sc);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 1;
                        break;
                    }
                case 3:
                    nextProcess = employeeView.typeInAge(newEmployee, sc);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 2;
                        break;
                    }
                case 4:
                    nextProcess = employeeView.typeInPhoneNumber(newEmployee, sc);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 3;
                        break;
                    } else if (this.phoneNumAlreadyExisted(newEmployee.getPhoneNumber()) != null) {
                        System.out.println("This phone number already existed.");
                        n = 4;
                        break;
                    }
                case 5:
                    nextProcess = employeeView.typeInGender(newEmployee, sc);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 4;
                        break;
                    }
                case 6:
                    nextProcess = employeeView.typeInAndress(newEmployee, sc);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 5;
                        break;
                    }
                case 7:
                    nextProcess = employeeView.typeInCCCD(newEmployee, this, sc);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 6;
                        break;
                    }
                case 8:
                    nextProcess = employeeView.typeInSalaryPerDay(newEmployee, sc);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 7;
                        break;
                    }
                    n = 8;
            }
        }
        this.getList().add(newEmployee);
    }

    public void editEmployeeInfor(Employee employee, EmployeeListView employeeListView, 
            EmployeeView employeeView, Scanner sc) {
        Employee cloneEmployee = employee.cloneEmployee();
        String choice;
        do {
            employeeListView.menuOfEditEmployeeInfor();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    if (employeeView.typeInFirstName(cloneEmployee, sc) == 0) {
                        return;
                    }
                    break;
                case "2":
                    if (employeeView.typeInLastName(cloneEmployee, sc) == 0) {
                        return;
                    }
                    break;
                case "3":
                    if (employeeView.typeInCCCD(cloneEmployee, this, sc) == 0) {
                        return;
                    }
                    break;
                case "4":
                    String tmp = cloneEmployee.getPhoneNumber();
                    int nextProcess = employeeView.typeInPhoneNumber(cloneEmployee, sc);
                    if (nextProcess == 0) {
                        return;
                    } else if (this.phoneNumAlreadyExisted(cloneEmployee.getPhoneNumber()) != null) {
                        System.out.println("This phone number already existed.");
                        cloneEmployee.setPhoneNumber(tmp);
                    }
                    break;
                case "5":
                    if (employeeView.typeInAge(cloneEmployee, sc) == 0) {
                        return;
                    }
                    break;
                case "6":
                    if (employeeView.typeInGender(cloneEmployee, sc) == 0) {
                        return;
                    }
                    break;
                case "7":
                    if (employeeView.typeInSalaryPerDay(cloneEmployee, sc) == 0) {
                        return;
                    }
                    break;
                case "8":
                    if (employeeView.typeInAndress(cloneEmployee, sc) == 0) {
                        return;
                    }
                    break;
                case "9":
                    if (!cloneEmployee.equals(employee)) {
                        this.getList().set(this.getList().indexOf(employee), cloneEmployee);
                        System.out.println("Edit succeed...");
                    }
                    System.out.println("Back...");
                    break;
            }
        } while (!choice.equals("9"));
    }

    public void deleteEmpployee(Employee employee) {
        this.getList().remove(employee);
        System.out.println("Delete succeed!");
    }

    public Employee searchEmployee(Scanner sc) {
        Employee searchingEmployee = null;
        if (this.getList().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
        } else {
            String inputStr;
            boolean completed = false;
            do {
                System.out.print("Input phone number to search(Type last name for suggestion or press 'Enter' to see the whole List) or BACK to go back: ");
                inputStr = sc.nextLine();
                try {
                    int phoneNum = Integer.parseInt(inputStr);
                    searchingEmployee = phoneNumAlreadyExisted(inputStr);
                    if (searchingEmployee == null) {
                        System.out.println("Employee with this input phone number doesnt existed.");
                        continue;
                    }
                    completed = true;
                } catch (NumberFormatException nfe) {
                    if (inputStr.equalsIgnoreCase("back")
                            || inputStr.equalsIgnoreCase("exit")) {
                        return null;
                    }
                    EmployeeList bucket = new EmployeeList(new ArrayList<>());
                    String inputStrToLowCase = inputStr.toLowerCase();
                    for (Employee e : this.getList()) {
                        String lastName = e.getLastName().toLowerCase();
                        if (lastName.contains(inputStrToLowCase)) {
                            bucket.getList().add(e);
                        }
                    }
                    if (bucket.getList().isEmpty()) {
                        System.out.println("No employee match with your input!");
                    } else {
                        System.out.print("\nSearching : \"" + inputStr + "\"");
                        bucket.showList();
                    }
                }
            } while (!completed);
        }
        return searchingEmployee;
    }

    @Override
    public void showList() {
        if (this.getList().isEmpty()) {
            System.out.println("Nothing found in this List!");
            return;
        }
        computeSizeOfEachCol();
        int totalColSize = salaryMaxSize + CCCDmaxSize + firstNameMaxSize
                + lastNameMaxSize + phoneNumberMaxSize + addressMaxSize + 3 + 6;
        final int extraLengthOfBorder = 23;
        int borderLength = totalColSize + extraLengthOfBorder;
        System.out.println("");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        System.out.printf("| %-" + String.format(CCCDmaxSize + "s")
                + " | %-" + String.format(firstNameMaxSize + "s")
                + " | %-" + String.format(lastNameMaxSize + "s")
                + " | %-" + String.format(phoneNumberMaxSize + "s")
                + " | %-" + String.format(3 + "s")
                + " | %-" + String.format(6 + "s")
                + " | %-" + String.format(addressMaxSize + "s")
                + " | %-" + String.format(salaryMaxSize + "s") + " |\n",
                "CCCD",
                "First Name",
                "Last Name",
                "Phone Number",
                "Age",
                "Gender",
                "Address",
                "Salary Per Day");
        System.out.println("|" + "-".repeat(borderLength) + "|");
        for (Employee e : this.getList()) {
            System.out.printf("| %-" + String.format(CCCDmaxSize + "s")
                    + " | %-" + String.format(firstNameMaxSize + "s")
                    + " | %-" + String.format(lastNameMaxSize + "s")
                    + " | %-" + String.format(phoneNumberMaxSize + "s")
                    + " | %-" + String.format(3 + "s")
                    + " | %-" + String.format(6 + "s")
                    + " | %-" + String.format(addressMaxSize + "s")
                    + " | %-" + String.format(salaryMaxSize + "s") + " |\n",
                    e.getCCCD(),
                    e.getFirstName(),
                    e.getLastName(),
                    e.getPhoneNumber(),
                    e.getAge(),
                    e.getGender(),
                    e.getAddress(),
                    e.getSalaryPerDay());
            System.out.println("|" + "-".repeat(borderLength) + "|");
        }
    }

    @Override
    protected void computeSizeOfEachCol() {
        salaryMaxSize = "Salary per day".length();
        CCCDmaxSize = "CCCD".length();
        firstNameMaxSize = "First Name".length();
        lastNameMaxSize = "Last Name".length();
        phoneNumberMaxSize = "Phone Number".length();
        addressMaxSize = "Address".length();
        for (Employee e : this.getList()) {
            if ((e.getSalaryPerDay() + "").length() > salaryMaxSize) {
                salaryMaxSize = (e.getSalaryPerDay() + "").length();
            }
            if (e.getCCCD().length() > CCCDmaxSize) {
                CCCDmaxSize = e.getCCCD().length();
            }
            if (e.getFirstName().length() > firstNameMaxSize) {
                firstNameMaxSize = e.getFirstName().length();
            }
            if (e.getLastName().length() > lastNameMaxSize) {
                lastNameMaxSize = e.getLastName().length();
            }
            if (e.getPhoneNumber().length() > phoneNumberMaxSize) {
                phoneNumberMaxSize = e.getPhoneNumber().length();
            }
            if (e.getAddress().length() > addressMaxSize) {
                addressMaxSize = e.getAddress().length();
            }
        }
    }

    public Employee containEmployee(String CCCD) {
        for (Employee e : this.getList()) {
            if (e.getCCCD().equalsIgnoreCase(CCCD)) {
                return e;
            }
        }
        return null;
    }
    
}
