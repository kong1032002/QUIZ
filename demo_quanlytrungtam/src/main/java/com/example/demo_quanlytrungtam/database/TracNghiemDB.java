package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.MultiChoiceQuest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TracNghiemDB {
    public static List<MultiChoiceQuest> getData() {
        List<MultiChoiceQuest> list = new ArrayList<>();
        String sql = "SELECT * FROM tracnghiem";
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            assert conn != null;
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                MultiChoiceQuest c = new MultiChoiceQuest();
                c.setQuest(rs.getString("deBai"));
                c.setDifficult(rs.getString("doKho"));
                c.setIdSubject(rs.getInt("idMonHoc"));
                c.setA(rs.getString("A"));
                c.setB(rs.getString("B"));
                c.setC(rs.getString("C"));
                c.setD(rs.getString("D"));
                c.setAnswer(rs.getString("dapAn"));
                list.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void pushData(MultiChoiceQuest quest){
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "insert into tracnghiem(idMonHoc, deBai, doKho, A, B, C, D, dapAn) \n"
                + "values (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, quest.getIdSubject());
            p.setString(2, quest.getQuest());
            p.setString(3, quest.getDifficult());
            p.setString(4, quest.getA());
            p.setString(5, quest.getB());
            p.setString(6, quest.getC());
            p.setString(7, quest.getD());
            p.setString(8, quest.getAnswer());
            p.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<MultiChoiceQuest> getQuestion(int idSubject,String difficult, int limit) {
        List<MultiChoiceQuest> list = new ArrayList<>();
        String sql = "select * from tracnghiem where doKho = '" + difficult + "' and idMonHoc = " + idSubject + " order by rand() limit " + limit + ";";
        System.out.println(sql);
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            assert conn != null;
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                MultiChoiceQuest c = new MultiChoiceQuest();
                c.setQuest(rs.getString("deBai"));
                c.setDifficult(rs.getString("doKho"));
                c.setIdSubject(rs.getInt("idMonHoc"));
                c.setA(rs.getString("A"));
                c.setB(rs.getString("B"));
                c.setC(rs.getString("C"));
                c.setD(rs.getString("D"));
                c.setAnswer(rs.getString("dapAn"));
                list.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void removeData(int id) {
        String sql = "Delete from tracnghiem where id = " + id;
        try {
            PreparedStatement statement = JDBCConnection.getJDBCConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
