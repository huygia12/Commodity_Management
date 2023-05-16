/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.AbstractHuman;
import View.HumanView;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class HumanController {
    private final HumanView view = new HumanView();

    public HumanController() {
    }

    public HumanView getView() {
        return view;
    }
    
    public <T extends AbstractHuman> T phoneNumAlreadyExisted(List<T> list, String checkingPhoneNum) {
        // neu nhu ton tai human co cung sdt voi human truyen vao thi tra ve true
        // nguoc lai tra ve false
        for (T temp : list) {
            if (temp.getPhoneNumber().equalsIgnoreCase(checkingPhoneNum)) {
                return temp;
            }
        }
        return null;
    }
}
