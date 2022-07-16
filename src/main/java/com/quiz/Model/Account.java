package com.quiz.Model;

public class Account {
    private int id;
    private String userName;
    private String passWord;
    private String role;
    private String phone;
    private String major;
    private String name;

    public Account() {
    }

    public Account(int id, String userName, String passWord, String name, String role, String major, String phone) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        this.phone = phone;
        this.major = major;
        this.name = name;
    }

    public Account(String userName, String passWord, String name, String role, String major, String phone) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        this.phone = phone;
        this.major = major;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
