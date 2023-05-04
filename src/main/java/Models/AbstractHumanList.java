/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;

/**
 *
 * @author FPTSHOP
 * @param <T>
 */
public abstract class AbstractHumanList<T extends AbstractHuman> {
    protected List<T> list;

    protected abstract void showList();
    
    protected abstract void computeSizeOfEachCol();
    
    public T phoneNumAlreadyExisted(String checkingPhoneNum) {
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
