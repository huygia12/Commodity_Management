/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author FPTSHOP
 */
public class CustomerCardListView {
    public void menuOfcustomerCardListManagement() {
        System.out.print("""
                           \n***************************************
                           * 1. New customer card generate       *
                           * 2. Change card Information          *
                           * 3. Delete a card                    *
                           * 4. Search a card                    *
                           * 5. Show all card & details          *
                           * 6. Back                             *
                           ***************************************
                           Options =>  """);
    }
    
    public void menuOfEditCustomerCardInfor() {
        System.out.print("""
                           \n*************************************
                           * 1. Change Customer first Name     *
                           * 2. Change Customer last Name      *
                           * 3. Change Customer phone number   *
                           * 4. Change Customer age            *
                           * 5. Change Customer gender         *
                           * 6. Change Customer address        *
                           * 7. Back                           *
                           *************************************
                           Options => """);
    }
}
