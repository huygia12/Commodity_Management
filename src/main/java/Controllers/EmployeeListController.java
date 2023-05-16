/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Employee;
import Models.EmployeeList;
import Models.Shift;
import View.EmployeeListView;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class EmployeeListController {
    private final EmployeeListView view = new EmployeeListView();
    private final Scanner sc = new Scanner(System.in);
    final EmployeeController employeeCtr = new EmployeeController();
    final HumanController humanCtr = new HumanController();
    
    public EmployeeListController() {
    }

    public EmployeeListView getView() {
        return view;
    }

    public void employeeListManagement(EmployeeList employeeList, Shift currentShift) {
        Employee searchedEmployee;
        String choice;
        do {
            this.view.menuOfEmployeeManagement();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    addNewEmployee(employeeList);
                    break;
                case "2":
                    searchedEmployee = searchEmployee(employeeList);
                    if (searchedEmployee != null) {
                        editEmployeeInfor(searchedEmployee, employeeList);
                    }
                    break;
                case "3":
                    Employee delEmployee = searchEmployee(employeeList);
                    if (delEmployee != null) {
                        if (currentShift != null) {
                            if (containEmployee(currentShift.getEmployeeOfThisShift(), delEmployee.getCCCD()) != null) {
                                System.out.println("This employee is still working in this shift, delete connot be performed!");
                                break;
                            }
                        }
                        deleteEmpployee(delEmployee, employeeList);
                    }
                    break;
                case "4":
                    searchedEmployee = searchEmployee(employeeList);
                    if (searchedEmployee != null) {
                        EmployeeList tmp = new EmployeeList(new ArrayList<>());
                        tmp.getList().add(searchedEmployee);
                        this.view.showList(tmp);
                    }
                    break;
                case "5":
                    this.view.showList(employeeList);
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Wrong input, Please type from 1->6!");
                    break;
            }
        } while (!choice.equals("6"));
    }

    public void addNewEmployee(EmployeeList employeeList) {
        Employee newEmployee = new Employee();
        int n = 1;
        int nextProcess;
        while (n != 8) {
            switch (n) {
                case 1:
                    nextProcess = employeeCtr.getView().typeInFirstName(newEmployee);
                    if (nextProcess == 0 || nextProcess == -1) {
                        return;
                    }
                case 2:
                    nextProcess = employeeCtr.getView().typeInLastName(newEmployee);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 1;
                        break;
                    }
                case 3:
                    nextProcess = employeeCtr.getView().typeInAge(newEmployee);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 2;
                        break;
                    }
                case 4:
                    nextProcess = employeeCtr.getView().typeInPhoneNumber(newEmployee);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 3;
                        break;
                    } else if (humanCtr.phoneNumAlreadyExisted(employeeList.getList(), 
                            newEmployee.getPhoneNumber()) != null) {
                        System.out.println("This phone number already existed.");
                        n = 4;
                        break;
                    }
                case 5:
                    nextProcess = employeeCtr.getView().typeInGender(newEmployee);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 4;
                        break;
                    }
                case 6:
                    nextProcess = employeeCtr.getView().typeInAndress(newEmployee);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 5;
                        break;
                    }
                case 7:
                    nextProcess = employeeCtr.getView().typeInCCCD(newEmployee, employeeList, this);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 6;
                        break;
                    }
                case 8:
                    nextProcess = employeeCtr.getView().typeInSalaryPerDay(newEmployee);
                    if (nextProcess == 0) {
                        return;
                    } else if (nextProcess == -1) {
                        n = 7;
                        break;
                    }
                    n = 8;
            }
        }
        employeeList.getList().add(newEmployee);
    }

    public void editEmployeeInfor(Employee employee, EmployeeList employeeList) {
        Employee cloneEmployee = employeeCtr.cloneEmployee(employee);
        String choice;
        do {
            this.view.menuOfEditEmployeeInfor();
            choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    if (employeeCtr.getView().typeInFirstName(cloneEmployee) == 0) {
                        return;
                    }
                    break;
                case "2":
                    if (employeeCtr.getView().typeInLastName(cloneEmployee) == 0) {
                        return;
                    }
                    break;
                case "3":
                    if (employeeCtr.getView().typeInCCCD(cloneEmployee, employeeList, this) == 0) {
                        return;
                    }
                    break;
                case "4":
                    String tmp = cloneEmployee.getPhoneNumber();
                    int nextProcess = employeeCtr.getView().typeInPhoneNumber(cloneEmployee);
                    if (nextProcess == 0) {
                        return;
                    } else if (humanCtr.phoneNumAlreadyExisted(employeeList.getList(),
                            cloneEmployee.getPhoneNumber()) != null) {
                        System.out.println("This phone number already existed.");
                        cloneEmployee.setPhoneNumber(tmp);
                    }
                    break;
                case "5":
                    if (employeeCtr.getView().typeInAge(cloneEmployee) == 0) {
                        return;
                    }
                    break;
                case "6":
                    if (employeeCtr.getView().typeInGender(cloneEmployee) == 0) {
                        return;
                    }
                    break;
                case "7":
                    if (employeeCtr.getView().typeInSalaryPerDay(cloneEmployee) == 0) {
                        return;
                    }
                    break;
                case "8":
                    if (employeeCtr.getView().typeInAndress(cloneEmployee) == 0) {
                        return;
                    }
                    break;
                case "9":
                    // neu co it nhat 1 thuoc tinh thay doi thi edit succeed
                    if (!cloneEmployee.equals(employee)) {
                        employeeList.getList().set(employeeList.getList().indexOf(employee), 
                                cloneEmployee);
                        System.out.println("Edit succeed...");
                    }
                    System.out.println("Back...");
                    break;
            }
        } while (!choice.equals("9"));
    }

    public void deleteEmpployee(Employee employee, EmployeeList employeeList) {
        employeeList.getList().remove(employee);
        System.out.println("Delete succeed!");
    }

    public Employee searchEmployee(EmployeeList employeeList) {
        Employee searchingEmployee = null;
        if (employeeList.getList().isEmpty()) {
            System.out.println("Cannot search in an empty List!");
        } else {
            String inputStr;
            boolean completed = false;
            do {
                System.out.print("Input phone number to search(Type last name for suggestion or press 'Enter' to see the whole List) or BACK to go back: ");
                inputStr = sc.nextLine();
                try {
                    int phoneNum = Integer.parseInt(inputStr);
                    searchingEmployee = humanCtr.phoneNumAlreadyExisted(employeeList.getList(),
                            inputStr);
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
                    for (Employee e : employeeList.getList()) {
                        String lastName = e.getLastName().toLowerCase();
                        if (lastName.contains(inputStrToLowCase)) {
                            bucket.getList().add(e);
                        }
                    }
                    if (bucket.getList().isEmpty()) {
                        System.out.println("No employee match with your input!");
                    } else {
                        System.out.print("\nSearching : \"" + inputStr + "\"");
                        this.view.showList(employeeList);
                    }
                }
            } while (!completed);
        }
        return searchingEmployee;
    }

    public Employee containEmployee(EmployeeList employeeList, String CCCD) {
        for (Employee e : employeeList.getList()) {
            if (e.getCCCD().equalsIgnoreCase(CCCD)) {
                return e;
            }
        }
        return null;
    }

}
