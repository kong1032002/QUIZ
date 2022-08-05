package com.example.demo_quanlytrungtam.model;

public class Account {
    private String username;
    private String password;
    private int phoneNumber;
    private String email;
    private String fullName;

    public Account() {
    }

    public Account(String username, String password, int phoneNumber, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "tendangnhap='" + username + '\'' +
                ", matkhau='" + password + '\'' +
                ", sdt=" + phoneNumber +
                ", gmail='" + email + '\'' +
                ", ten='" + fullName + '\'' +
                '}';
    }
}
