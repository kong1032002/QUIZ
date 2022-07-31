package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.Account;
import com.example.demo_quanlytrungtam.model.TracNghiem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TracNghiemDB {
    public static List<TracNghiem> getAllQuest() {
        List<TracNghiem> list = new ArrayList<>();
        String sql = "SELECT * FROM tracnghiem";
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            assert conn != null;
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                TracNghiem c = new TracNghiem();
                c.setMon(rs.getString("mon"));
                c.setChuong(rs.getInt("chuong"));
                c.setDeBai(rs.getString("deBai"));
                c.setDoKho(rs.getInt("doKho"));
                c.setA(rs.getString("A"));
                c.setB(rs.getString("B"));
                c.setC(rs.getString("C"));
                c.setD(rs.getString("D"));
                c.setDapAn(rs.getString("dapAn"));
                list.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void addTracNghiem(TracNghiem quest){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO tracnghiem (chuong, deBai, doKho, A, B, C, D ,dapAn) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, quest.getChuong());
            p.setString(2, quest.getDeBai());
            p.setInt(3, quest.getDoKho());
            p.setString(4, quest.getA());
            p.setString(5, quest.getB());
            p.setString(6, quest.getC());
            p.setString(7, quest.getD());
            p.setString(8, quest.getDapAn());
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
