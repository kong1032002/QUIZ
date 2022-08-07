package com.example.demo_quanlytrungtam.model;

public class MultiChoiceQuest extends Question {

    private String A;
    private String B;
    private String C;
    private String D;
    private String dapAn;

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    @Override
    public String toString() {
        return "TracNghiem{" +
                "id=" + id +
                ", mon='" + subject + '\'' +
                ", chuong=" + chapter +
                ", deBai='" + quest + '\'' +
                ", doKho=" + difficult +
                ", userID=" + userID +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", dapAn='" + dapAn + '\'' +
                '}';
    }
}
