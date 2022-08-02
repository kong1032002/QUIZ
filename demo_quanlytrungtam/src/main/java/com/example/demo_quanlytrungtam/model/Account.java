package com.example.demo_quanlytrungtam.model;

public class Account {
    private String tendangnhap;
    private String matkhau;
    private int sdt;
    private String gmail;
    private String ten;

    public Account() {
    }

    public Account(String tendangnhap, String matkhau, int sdt, String gmail, String ten) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.sdt = sdt;
        this.gmail = gmail;
        this.ten = ten;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "Account{" +
                "tendangnhap='" + tendangnhap + '\'' +
                ", matkhau='" + matkhau + '\'' +
                ", sdt=" + sdt +
                ", gmail='" + gmail + '\'' +
                ", ten='" + ten + '\'' +
                '}';
    }
}
