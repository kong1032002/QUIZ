package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDB {
    public static List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM TAIKHOAN";
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                Account c = new Account();
                c.setTendangnhap(rs.getString("tendangnhap"));
                c.setMatkhau(rs.getString("matkhau"));
                c.setTen(rs.getString("ten"));
                c.setGmail(rs.getString("gmail"));
                c.setSdt(rs.getInt("sdt"));
                list.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void addAccount(Account acc){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO taikhoan (tendangnhap, matkhau, ten, gmail, sdt) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, acc.getTendangnhap());
            p.setString(2, acc.getMatkhau());
            p.setInt(5,acc.getSdt());
            p.setString(4, acc.getGmail());
            p.setString(3, acc.getTen());
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
