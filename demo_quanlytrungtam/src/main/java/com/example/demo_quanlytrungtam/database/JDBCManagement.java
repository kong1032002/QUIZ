package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.*;

import java.util.List;

public class JDBCManagement {

    public static List<Account> getAllAccount() {
       return AccountDB.getData();
    }

    public static void addAccount(Account acc){
        AccountDB.pushData(acc);
    }

}
