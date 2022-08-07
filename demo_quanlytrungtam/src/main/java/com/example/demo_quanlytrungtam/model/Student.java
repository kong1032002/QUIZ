package com.example.demo_quanlytrungtam.model;

public class Student extends Person{
    private String father;
    private String mother;
    private int parentPhoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public int getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(int parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", id=" + id +
                ", father='" + father + '\'' +
                ", mother='" + mother + '\'' +
                ", parentPhoneNumber=" + parentPhoneNumber +
                "}";
    }
}
