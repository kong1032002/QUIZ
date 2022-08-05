package com.example.demo_quanlytrungtam.database;

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
                c.setSubject(rs.getString("mon"));
                c.setChapter(rs.getInt("chuong"));
                c.setQuest(rs.getString("deBai"));
                c.setDifficult(rs.getInt("doKho"));
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
        String sql = "insert into tuluan(mon, chuong , deBai, doKho, goiY)\n" +
                "values (?, ?, ?, ?, ?);";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, quest.getSubject());
            p.setInt(2, quest.getChapter());
            p.setString(3, quest.getQuest());
            p.setInt(4, quest.getDifficult());
            p.setString(5, quest.getGoiY());
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
