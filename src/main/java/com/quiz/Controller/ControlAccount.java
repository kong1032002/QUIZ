package com.quiz.Controller;

import com.quiz.Model.Account;

import java.util.ArrayList;
import java.util.List;

public class ControlAccount {
    public int login(String userName, String password) {
        int id = -1;
        try {
            List<Account> accounts = new ArrayList<>();
            for (Account account : accounts) {
                if (userName.equals(account.getUserName()) && password.equals(account.getPassWord())) {
                    id = account.getId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean register(String userName, String password, String name, String role, String major, String phone) {
        boolean check = false;
        Account account = new Account(userName, password, name, role, major, phone);
        return check;
    }

    public boolean removeAccount(int id) {
        boolean check = false;

        return check;
    }
}
