package com.example.demo_quanlytrungtam.model;

public class TuLuan extends Question {
    private String goiY;

    public String getGoiY() {
        return goiY;
    }

    public void setGoiY(String goiY) {
        this.goiY = goiY;
    }

    @Override
    public String toString() {
        return "TuLuan{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", chapter=" + chapter +
                ", quest='" + quest + '\'' +
                ", difficult=" + difficult +
                ", userID=" + userID +
                ", goiY='" + goiY + '\'' +
                '}';
    }
}
