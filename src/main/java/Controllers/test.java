/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Store;





/**
 *
 * @author FPTSHOP
 */
public class test {
    public static void main(String[] args) {
        testSetting();
    }
    
    public static void testSetting(){
        SettingsController s = new SettingsController(new Store());
        s.SettingsManagement();
    }
}
