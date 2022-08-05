package com.example.demo_quanlytrungtam.database;

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
                c.setSubject(rs.getString("mon"));
                c.setChapter(rs.getInt("chuong"));
                c.setQuest(rs.getString("deBai"));
                c.setDifficult(rs.getInt("doKho"));
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
        String sql = "insert into tracnghiem(mon, chuong, deBai, doKho, A, B, C, D, dapAn) \n"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, quest.getSubject());
            p.setInt(2, quest.getChapter());
            p.setString(3, quest.getQuest());
            p.setInt(4, quest.getDifficult());
            p.setString(5, quest.getA());
            p.setString(6, quest.getB());
            p.setString(7, quest.getC());
            p.setString(8, quest.getD());
            p.setString(0, quest.getDapAn());
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
