/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.AbstractHuman;
import Models.Gender;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 * @param <T>
 */
public class HumanView<T extends AbstractHuman> {

    final Cautions ctions = new Cautions();

    public int typeInFirstName(T human, Scanner sc) {
        while (true) {
            System.out.print("Type in Fisrt Name or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                human.setFirstName(inputStr);
                return 1;
            }
        }
    }

    public int typeInLastName(T human, Scanner sc) {
        while (true) {
            System.out.print("Type in Last Name or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                human.setLastName(inputStr);
                return 1;
            }
        }
    }

    public int typeInAndress(T human, Scanner sc) {
        while (true) {
            System.out.print("Type in Andress or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                human.setAddress(inputStr);
                return 1;
            }
        }
    }

    public int typeInAge(T human, Scanner sc) {
        while (true) {
            System.out.print("Type in Age or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                try {
                    int age = Integer.parseInt(inputStr);
                    if (ctions.checkIfIntNegative(age)
                            || ctions.checkIfIntEqualZero(age)) {
                        continue;
                    }
                    human.setAge(age);
                    return 1;
                } catch (NumberFormatException nfe) {
                    ctions.wrInput();
                }
            }
        }
    }

    public int typeInPhoneNumber(T human, Scanner sc) {
        while (true) {
            System.out.print("Type in Phone Number or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)
                    || !ctions. checkIfANumberSequence(inputStr)) {
            }else {
                human.setPhoneNumber(inputStr);
                return 1;
            }
        }
    }

    public int typeInGender(T human, Scanner sc) {
        while (true) {
            System.out.print("Type in Gender or type EXIT/BACK to exit/back: ");
            String inputStr = sc.nextLine().trim().toLowerCase();
            if ("exit".equalsIgnoreCase(inputStr)) {
                return 0;
            } else if ("back".equalsIgnoreCase(inputStr)) {
                return -1;
            } else if (ctions.checkIfNoInput(inputStr)) {
            } else {
                switch (inputStr) {
                    case "male":
                        human.setGender(Gender.MALE);
                        return 1;
                    case "female":
                        human.setGender(Gender.FEMALE);
                        return 1;
                    case "other":
                        human.setGender(Gender.OTHER);
                        return 1;
                    default:
                        ctions.wrInput();
                }
            }
        }
    }
}
