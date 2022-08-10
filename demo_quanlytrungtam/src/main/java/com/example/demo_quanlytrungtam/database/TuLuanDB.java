package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.TuLuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TuLuanDB {
    public static List<TuLuan> getData() {
        List<TuLuan> list = new ArrayList<>();
        String sql = "SELECT * FROM tuluan";
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            assert conn != null;
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                TuLuan c = new TuLuan();
                c.setQuest(rs.getString("deBai"));
                c.setDifficult(rs.getString("doKho"));
                c.setGoiY(rs.getString("goiY"));
                list.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void pushData(TuLuan quest){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "insert into tuluan(mon, deBai, doKho, goiY)\n" +
                "values (?, ?, ?, ?);";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, quest.getIdSubject());
            p.setString(3, quest.getQuest());
            p.setString(4, quest.getDifficult());
            p.setString(5, quest.getGoiY());
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
