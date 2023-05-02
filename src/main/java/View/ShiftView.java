/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author FPTSHOP
 */
public class ShiftView {
    public ShiftView(){
    }
    
    public void shiftNotOpenCaution(){
        System.out.println("Shift not open yet!");
    }
    
    public void menuOfEditShift(){
        System.out.println("""
                           *************************************
                           * 1. Open shift                     *
                           * 2. Set Shipping fee               *
                           * 3. Change employees of this shift *
                           * 4. Change this shift open balance *
                           * 5. End shift                      *
                           *************************************
                           Options => 
                           """);
    }
    
    
}
