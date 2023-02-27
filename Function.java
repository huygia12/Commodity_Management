/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapLon1;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FPTSHOP
 */
public class Function {

    public List<SinhVien> list;

    public Function(List<SinhVien> list) {
        this.list = list;
    }

    private boolean checkMaSv(String maSv) {
        for (SinhVien sv : this.list) {
            if (maSv.equals(sv.getMaSinhVien())) {
                return true;
            }
        }
        return false;
    }

    private String enterBirthDate(Scanner sc) {
        String ngaySinh;
        int[] time;
        do {
            System.out.print("Nhap ngay sinh: ");
            ngaySinh = sc.nextLine();
            String[] nums = ngaySinh.split("/");
            time = new int[nums.length];
            try {
                for (int i = 0; i < time.length; i++) {
                    time[i] = Integer.parseInt(nums[i]);
                }
                if (time.length != 3 || nums[0].length() != 2 || nums[1].length() != 2 || nums[2].length() != 4) {
                    System.out.println("Ban nhap ngay sinh khong hop le!(Format sample: dd/MM/yyyy)");
                    continue;
                }
                if (checkValidDate(time)) {
                    break;
                } else {
                    System.out.println("Ban nhap ngay sinh khong hop le!(Format sample: dd/MM/yyyy)");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ban nhap ngay sinh khong hop le!(Format sample: dd/MM/yyyy)");
            }
        } while (true);
        return ngaySinh;
    }

    private String enterValidGender(Scanner sc) {
        int c;
        do {
            System.out.println("");
            System.out.println("****************");
            System.out.println("* 1. Male      *");
            System.out.println("* 2. Female    *");
            System.out.println("* 3. Other     *");
            System.out.println("****************");
            System.out.print("Your choice: ");
            c = sc.nextInt();
        } while (c > 3 || c < 1);
        switch (c) {
            case 1:
                return "Male";
            case 2:
                return "Female";
            default:
                return "Other";
        }
    }

    private boolean checkValidDate(int[] time) {
        boolean checkNamNhuan = false;
        // check year
        if (time[2] > 2023) {
            return false;
        }
        if (time[2] % 4 == 0) {
            checkNamNhuan = true;
            if (time[2] % 100 == 0) {
                checkNamNhuan = false;
                if (time[2] % 400 == 0) {
                    checkNamNhuan = true;
                }
            }
        }
        // check month
        if (time[1] > 12 || time[1] < 1) {
            return false;
        }
        // check day
        switch (time[1]) {
            case 2: {
                if (time[0] > 29 || time[0] < 1) {
                    return false;
                } else if (time[0] == 29 && checkNamNhuan == false) {
                    return false;
                }
                break;
            }
            case 4, 6, 9, 11: {
                if (time[0] > 30 || time[0] < 1) {
                    return false;
                }
                break;
            }
            default: {
                if (time[0] > 31 || time[0] < 1) {
                    return false;
                }
                break;
            }
        }
        return true;
    }

    private boolean checkName(String name1, String name2) {
        if (name1.length() != name2.length()) {
            return false;
        } else {
            for (int i = 0; i < name1.length(); i++) {
                if (name1.charAt(i) >= 65 && name1.charAt(i) <= 90) {
                    if (name1.charAt(i) != name2.charAt(i)) {
                        if (name1.charAt(i) != (name2.charAt(i) - 32)) {
                            return false;
                        }
                    }
                } else if (name1.charAt(i) >= 97 && name1.charAt(i) <= 122) {
                    if (name1.charAt(i) != name2.charAt(i)) {
                        if (name1.charAt(i) != (name2.charAt(i) + 32)) {
                            return false;
                        }
                    }
                } else {
                    System.out.println("Invalid Name(alphabet only).");
                    break;
                }
            }
        }
        return true;
    }

    public void menu() {
        System.out.println("****************************************");
        System.out.println("* 1. Add student                       *");
        System.out.println("* 2. Change student's information      *");
        System.out.println("* 3. Search student                    *");
        System.out.println("* 4. Delete student                    *");
        System.out.println("* 5. Filter student                    *");
        System.out.println("* 6. Show all information              *");
        System.out.println("* 7. Sort the list by point            *");
        System.out.println("* 8. Exit                              *");
        System.out.println("****************************************");
        System.out.print("Option: ");
    }

    // ALL FUNCTIONS
    public void addStudent(Scanner sc) {
        sc.nextLine();
        String maSv;
        do {
            System.out.print("Nhap ma sinh vien: ");
            maSv = sc.nextLine();
            try {
                int check = Integer.parseInt(maSv);
            } catch (NumberFormatException ex) {
                System.out.println("ID khong hop le!");
            }
        } while (maSv.length() != 6 || checkMaSv(maSv) == true);
        String lop = new String();
        do {
            System.out.print("Nhap lop: ");
            lop = sc.nextLine();
        } while (lop == "");
        String hoVaTen = new String();
        do {
            System.out.print("Nhap ho va ten: ");
            hoVaTen = sc.nextLine();
        } while (hoVaTen == "");
        String ngaySinh = enterBirthDate(sc);
        System.out.print("Nhap gioi tinh: ");
        String gioiTinh = enterValidGender(sc);
        double diemTb;
        do {
            System.out.print("Nhap diem Tb: ");
            diemTb = sc.nextDouble();
        } while (diemTb < 0 || diemTb > 10);
        SinhVien sv = new SinhVien(maSv, lop, hoVaTen, ngaySinh, gioiTinh, diemTb);
        list.add(sv);
    }

    public void showAllInfor() {
        System.out.println(String.format("%55s", "STUDENT LIST"));
        System.out.println(String.format("%5s%10s%10s%15s%15s%15s%10s%10s", "Order", "ID", "Class",
                "First name", "Last name", "Birthdate", "Gender", "Score"));
        double sum = 0;
        int length = this.list.size();
        int i;
        for (i = 0; i < length; i++) {
            SinhVien sv = (SinhVien) this.list.get(i);
            System.out.println(String.format("%5d%10s%10s%15s%15s%15s%10s%10.2f", i + 1, sv.getMaSinhVien(),
                    sv.getLop(), sv.getFirstName(), sv.getLastName(), sv.getNgaySinh(), sv.getGioiTinh(),
                    sv.getDiemTb()));
            sum += sv.getDiemTb();
        }
        System.out.println(String.format("%80s%10.2f", "Average score", sum / (i + 1)));
    }

    public void deleteStudent(Scanner sc) {
        if (this.list.isEmpty() == true) {
            System.out.println("This list contains no elements!");
            return;
        }
        String maSv = new String();
        sc.nextLine();
        System.out.println("Nhap ma sinh vien muon xoa:");
        do {
            System.out.print("ID: ");
            maSv = sc.nextLine();
        } while (checkMaSv(maSv) == false);
        for (int i = 0; i < this.list.size(); i++) {
            if (maSv.equals(this.list.get(i).getMaSinhVien())) {
                this.list.remove(i);
                break;
            }
        }
    }

    public void changeStudentInfor(Scanner sc) {
        if (this.list.isEmpty() == true) {
            System.out.println("This list contains no elements!");
            return;
        }
        sc.nextLine();
        String maSv;
        System.out.println("Nhap ma sinh vien muon thay doi:");
        do {
            System.out.print("ID: ");
            maSv = sc.nextLine();
            try {
                int check = Integer.parseInt(maSv);
            } catch (NumberFormatException ex) {
                System.out.println("ID khong hop le!");
            }
        } while (maSv.length() != 6 || checkMaSv(maSv) == false);
        int c;
        do {
            System.out.println("****************");
            System.out.println("* 1. ID        *");
            System.out.println("* 2. Class     *");
            System.out.println("* 3. Name      *");
            System.out.println("* 4. Birthdate *");
            System.out.println("* 5. Gender    *");
            System.out.println("* 6. Score     *");
            System.out.println("****************");
            System.out.print("Your choice: ");
            c = sc.nextInt();
        } while (c > 6 || c < 1);
        int i;
        for (i = 0; i < this.list.size(); i++) {
            if (maSv.equals(this.list.get(i).getMaSinhVien())) {
                break;
            }
        }
        sc.nextLine();
        switch (c) {
            case 1: {
                String msv;
                do {
                    System.out.print("New ID: ");
                    msv = sc.nextLine();
                    try {
                        int check1 = Integer.parseInt(msv);
                    } catch (NumberFormatException ex) {
                        System.out.println("ID khong hop le!");
                    }
                } while (msv.length() != 6 || checkMaSv(msv) == true);
                this.list.get(i).setMaSinhVien(msv);
                break;
            }
            case 2: {
                System.out.print("New Class: ");
                this.list.get(i).setLop(sc.nextLine());
                break;
            }
            case 3: {
                System.out.print("New Name: ");
                this.list.get(i).setHoVaTen(sc.nextLine());
                break;
            }
            case 4: {
                this.list.get(i).setNgaySinh(enterBirthDate(sc));
                break;
            }
            case 5: {
                this.list.get(i).setGioiTinh(enterValidGender(sc));
                break;
            }
            case 6: {
                Double diem;
                do {
                    System.out.print("New Points: ");
                    diem = sc.nextDouble();
                } while (diem < 1 || diem > 10);
                this.list.get(i).setDiemTb(diem);
            }
        }
    }

    public void searchStudent(Scanner sc) {
        if (this.list.isEmpty() == true) {
            System.out.println("This list contains no elements!");
            return;
        }
        sc.nextLine();
        String maSv;
        System.out.println("Nhap ma sinh vien muon tim kiem:");
        do {
            System.out.print("ID: ");
            maSv = sc.nextLine();
            try {
                int check = Integer.parseInt(maSv);
            } catch (NumberFormatException ex) {
                System.out.println("ID khong hop le!");
            }
        } while (maSv.length() != 6 || checkMaSv(maSv) == false);
        int i;
        for (i = 0; i < this.list.size(); i++) {
            if (maSv.equals(this.list.get(i).getMaSinhVien())) {
                break;
            }
        }
        System.out.println(String.format("%55s", "STUDENT INFORMATION SEARCHING RESULTS"));
        System.out.println(String.format("%7s%10s%15s%15s%15s%10s%10s", "ID", "Class",
                "First name", "Last name", "Birthdate", "Gender", "Score"));
        System.out.println(String.format("%7s%10s%15s%15s%15s%10s%10.2f", this.list.get(i).getMaSinhVien(),
                this.list.get(i).getLop(), this.list.get(i).getFirstName(),
                this.list.get(i).getLastName(), this.list.get(i).getNgaySinh(),
                this.list.get(i).getGioiTinh(), this.list.get(i).getDiemTb()));
    }

    public void filterStudent(Scanner sc) {
        if (this.list.isEmpty() == true) {
            System.out.println("This list contains no elements!");
            return;
        }
        int c;
        do {
            System.out.println("********************************************************");
            System.out.println("* 1. Students whose points are greater or equal 8.00   *");
            System.out.println("* 2. Students whose name is entered from the console   *");
            System.out.println("********************************************************");
            System.out.print("Your choice: ");
            c = sc.nextInt();
        } while (c > 2 || c < 1);
        switch (c) {
            case 1: {
                System.out.println(String.format("%55s", "STUDENTS'S POINT >= 8.0"));
                System.out.println(String.format("%5s%10s%10s%15s%15s%15s%10s%10s", "Order", "ID", "Class",
                        "First name", "Last name", "Birthdate", "Gender", "Score"));
                double sum = 0;
                int i = 0;
                for (SinhVien sv : list) {
                    if (sv.getDiemTb() >= 8.0) {
                        System.out.println(String.format("%5d%10s%10s%15s%15s%15s%10s%10.2f", i + 1, sv.getMaSinhVien(),
                                sv.getLop(), sv.getFirstName(), sv.getLastName(), sv.getNgaySinh(), sv.getGioiTinh(),
                                sv.getDiemTb()));
                        sum += sv.getDiemTb();
                    }
                }
                System.out.println(String.format("%80s%10.2f", "Average score", sum / (i + 1)));
                break;
            }
            case 2: {
                sc.nextLine();
                System.out.print("Enter First Name: ");
                String firstName = sc.nextLine();
                System.out.println(String.format("%50s%6s", "STUDENTS HAVE NAME: ", firstName));
                System.out.println(String.format("%5s%10s%10s%15s%15s%15s%10s%10s", "Order", "ID", "Class",
                        "First name", "Last name", "Birthdate", "Gender", "Score"));
                double sum = 0;
                int i = 0;
                for (SinhVien sv : list) {
                    if (this.checkName(firstName, sv.getFirstName())) {
                        System.out.println(String.format("%5d%10s%10s%15s%15s%15s%10s%10.2f", i + 1, sv.getMaSinhVien(),
                                sv.getLop(), sv.getFirstName(), sv.getLastName(), sv.getNgaySinh(), sv.getGioiTinh(),
                                sv.getDiemTb()));
                        sum += sv.getDiemTb();
                    }
                }
                System.out.println(String.format("%80s%10.2f", "Average score", sum / (i + 1)));
                break;
            }
        }
    }

    public void sortByPoint() {
        if (this.list.isEmpty() == true) {
            System.out.println("This list contains no elements!");
            return;
        }
        int pos;
        int i = list.size() - 1;
        while (i > 0) {
            pos = -1;
            double diem = this.list.get(i).getDiemTb();
            for (int j = i - 1; j >= 0; j--) {
                if (diem < this.list.get(j).getDiemTb()) {
                    pos = j;
                }
            }
            if (pos != -1) {
                SinhVien temp1 = this.list.get(i);
                SinhVien temp2 = this.list.get(pos);
                this.list.set(pos, temp1);
                this.list.set(i, temp2);
            } else {
                i--;
            }
        }
    }
}
