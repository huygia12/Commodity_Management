/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapLon1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author FPTSHOP
 */
public class DanhSachSinhVien {
    public static void cc(){
         
    }
    public static void main(String[] args) throws FileNotFoundException {
        List<SinhVien> list = new ArrayList<SinhVien>();
        Function f = new Function(list);
        //System.setIn(new FileInputStream("E:\\JAVA\\Input\\ok.txt"));
        Scanner sc = new Scanner(System.in);
        int c;
        do {
            do {
                f.menu();
                c = sc.nextInt();
                System.out.println("");
            } while (c > 8 || c < 1);
            switch (c) {
                case 1: {
                    f.addStudent(sc);
                    break;
                }
                case 2: {
                    f.changeStudentInfor(sc);
                    break;
                }
                case 3: {
                    f.searchStudent(sc);
                    break;
                }
                case 4: {
                    f.deleteStudent(sc);
                    break;
                }
                case 5: {
                    f.filterStudent(sc);
                    break;
                }
                case 6: {
                    f.showAllInfor();
                    break;
                }
                case 7: {
                    f.sortByPoint();
                    break;
                }
                default: {
                    System.out.println("Exit...");
                    break;
                }
            }
        } while (c != 8);
    }

}
