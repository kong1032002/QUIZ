package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.Exam;
import com.example.demo_quanlytrungtam.model.MultiChoiceQuest;
import com.example.demo_quanlytrungtam.model.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExamDB {
    private static final Connection connection = JDBCConnection.getJDBCConnection();

    public static List<Exam> getData() {
        List<Exam> examList = new ArrayList<>();
        String sql = "select * from dethi;";
        try {
            PreparedStatement statement = JDBCConnection.getJDBCConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Exam exam = new Exam();
                exam.setId(resultSet.getInt("id"));
                exam.setIdSubject(resultSet.getInt("idMonHoc"));
                exam.setTitle(resultSet.getString("title"));
                examList.add(exam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return examList;
    }

    public static void pushData(Exam exam) {
        String sql = "insert into dethi(id, idSubject) \n" +
                "values(?, ?);";
        try {
            PreparedStatement statement = JDBCConnection.getJDBCConnection().prepareStatement(sql);
            statement.setInt(1, exam.getIdSubject());
            statement.setInt(2, exam.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Exam createExam(String title, Subject subject,int easy, int normal, int hard, int hardest) {
        Exam exam = new Exam();
        try {
            String[] sql = new String[5];
            System.out.println(subject.getId() + " " + subject.getSubject());
            sql[0] = "select * from tracnghiem where idMonHoc = " + subject.getId() + " and doKho = 'NB' order by rand() limit " + easy + ";";
            sql[1] = "select * from tracnghiem where idMonHoc = " + subject.getId() + " and doKho = 'TH' order by rand() limit " + normal + ";";
            sql[2] = "select * from tracnghiem where idMonHoc = " + subject.getId() + " and doKho = 'VD' order by rand() limit " + hard + ";";
            sql[3] = "select * from tracnghiem where idMonHoc = " + subject.getId() + " and doKho = 'VDC' order by rand() limit " + hardest + ";";

            for (int i = 0; i < 3; i++) {
                PreparedStatement statement = JDBCConnection.getJDBCConnection().prepareStatement(sql[i]);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    MultiChoiceQuest c = new MultiChoiceQuest();
                    c.setQuest(rs.getString("deBai"));
                    c.setDifficult(rs.getString("doKho"));
                    c.setIdSubject(rs.getInt("idMonHoc"));
                    c.setA(rs.getString("A"));
                    c.setB(rs.getString("B"));
                    c.setC(rs.getString("C"));
                    c.setD(rs.getString("D"));
                    c.setAnswer(rs.getString("dapAn"));
                    exam.getQuestionList().add(c);
                }
            }
            exam.setTitle(title + "  - Môn: " + subject.getSubject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exam;
    }
}
