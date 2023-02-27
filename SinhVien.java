/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapLon1;

/**
 *
 * @author FPTSHOP
 */
public class SinhVien {
    private String maSinhVien = new String();
    private String lop = new String();
    private String hoVaTen = new String();
    private String ngaySinh = new String();
    private String gioiTinh = new String();
    private double diemTb;

    public SinhVien(){
    }
    
    public SinhVien(String maSinhVien, String lop, String hoVaTen, String ngaySinh, String gioiTinh, double diemTb) {
        this.maSinhVien = maSinhVien;
        this.lop = lop;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diemTb = diemTb;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public String getLop() {
        return lop;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }
    
    public String getFirstName(){
        int i = this.hoVaTen.lastIndexOf(' ');
        return this.hoVaTen.substring(i+1);
    }

    public String getLastName(){
        int i = this.hoVaTen.lastIndexOf(' ');
        return this.hoVaTen.substring(0, i);
    }
    
    public double getDiemTb() {
        return diemTb;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDiemTb(double diemTb) {
        this.diemTb = diemTb;
    }
    
}
