package com.example.demo_quanlytrungtam.model;

public class StudentClass {
    private String className;
    private int idTeacher;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Override
    public String toString() {
        return className;
    }
}
