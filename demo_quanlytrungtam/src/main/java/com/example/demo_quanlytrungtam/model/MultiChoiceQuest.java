package com.example.demo_quanlytrungtam.model;

public class MultiChoiceQuest extends Question {

    private String A;
    private String B;
    private String C;
    private String D;
    private String answer;

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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return  " Đề Bài:" + quest + "? \n" +
                ",  A - " + A + "\n" +
                ",  B - " + B + "\n" +
                ",  C - " + C + "\n" +
                ",  D - " + D + "\n" +
//                ", dapAn='" + answer + '\'' +
                "\n";
    }
}
