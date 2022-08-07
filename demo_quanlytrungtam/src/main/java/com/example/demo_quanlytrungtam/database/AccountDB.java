package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDB  implements EditData {
    public static List<Account> getData() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM TAIKHOAN";
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                Account c = new Account();
                c.setUsername(rs.getString("tendangnhap"));
                c.setPassword(rs.getString("matkhau"));
                c.setFullName(rs.getString("ten"));
                c.setEmail(rs.getString("email"));
                c.setPhoneNumber(rs.getInt("sdt"));
                list.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void pushData(Account acc){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "insert into taikhoan(tendangnhap, matkhau, sdt, gmail, ten) \n" +
                "values (?, ?, ?, ?, ?);";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, acc.getUsername());
            p.setString(2, acc.getPassword());
            p.setInt(5,acc.getPhoneNumber());
            p.setString(4, acc.getEmail());
            p.setString(3, acc.getFullName());
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
