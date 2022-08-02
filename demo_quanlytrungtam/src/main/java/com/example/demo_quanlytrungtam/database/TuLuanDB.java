package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.TracNghiem;
import com.example.demo_quanlytrungtam.model.TuLuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TuLuanDB {
    public static List<TuLuan> getAllQuest() {
        List<TuLuan> list = new ArrayList<>();
        String sql = "SELECT * FROM tuluan";
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            assert conn != null;
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                TuLuan c = new TuLuan();
                c.setMon(rs.getString("mon"));
                c.setChuong(rs.getInt("chuong"));
                c.setDeBai(rs.getString("deBai"));
                c.setDoKho(rs.getInt("doKho"));
                c.setGoiY(rs.getString("goiY"));
                list.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void addTracNghiem(TuLuan quest){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO tuluan (chuong, deBai, doKho, goiY) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, quest.getChuong());
            p.setString(2, quest.getDeBai());
            p.setInt(3, quest.getDoKho());
            p.setString(4, quest.getGoiY());
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
