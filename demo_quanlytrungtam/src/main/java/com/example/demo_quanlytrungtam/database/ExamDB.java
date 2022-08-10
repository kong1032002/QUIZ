package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.Exam;
import com.example.demo_quanlytrungtam.model.MultiChoiceQuest;
import com.example.demo_quanlytrungtam.model.Question;
import com.example.demo_quanlytrungtam.model.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExamDB {
    private static final Connection connection = JDBCConnection.getJDBCConnection();

    public static List<Exam> getData() {
        List<Exam> examList = new ArrayList<>();
        List<Subject> subjects = SubjectDB.getData();
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
                for (Subject subject : subjects) {
                    if (subject.getId() == exam.getIdSubject()) {
                        exam.setSubject(subject.getSubject());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return examList;
    }

    public static void pushData(Exam exam) {
        String sql = "insert into dethi(idMonHoc, idSubject) \n" +
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

    public static Exam getExam(int id) {
        Exam exam = new Exam();
        String sql = "select dethi.id as idDeThi, dethi.title ,tracnghiem.* from tracnghiem, cauhoitrongde, dethi where cauhoitrongde.idDeThi = dethi.id and tracnghiem.id = cauhoitrongde.idCauHoi and  cauhoitrongde.idDeThi = " + id + " ;";
        try {
            PreparedStatement statement = JDBCConnection.getJDBCConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (exam.getId() == 0 || exam.getTitle() == "") {
                    exam.setId(resultSet.getInt("idDeThi"));
                    exam.setTitle(resultSet.getString("title"));
                }
                MultiChoiceQuest multiChoiceQuest = new MultiChoiceQuest();
                multiChoiceQuest.setId(resultSet.getInt("id"));
                multiChoiceQuest.setIdSubject(resultSet.getInt("idMonHoc"));
                multiChoiceQuest.setDifficult(resultSet.getString("doKho"));
                multiChoiceQuest.setQuest(resultSet.getString("deBai"));
                multiChoiceQuest.setA(resultSet.getString("A"));
                multiChoiceQuest.setB(resultSet.getString("B"));
                multiChoiceQuest.setC(resultSet.getString("C"));
                multiChoiceQuest.setD(resultSet.getString("D"));
                multiChoiceQuest.setAnswer(resultSet.getString("dapAn"));
                exam.getQuestionList().add(multiChoiceQuest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exam;
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
                    c.setId(rs.getInt("id"));
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
            String sqlScript = "insert into dethi(idMonHoc, title) values (?,?);";
            PreparedStatement statement = JDBCConnection.getJDBCConnection().prepareStatement(sqlScript, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, subject.getId());
            statement.setString(2, title);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            int key = 0;
            if (resultSet.next()) {
                key = resultSet.getInt(1);
            }
            for (Question question : exam.getQuestionList()) {
                sqlScript = "insert into cauHoiTrongDe(idDeThi, idCauHoi) values (?,?)";
                statement = JDBCConnection.getJDBCConnection().prepareStatement(sqlScript);
                statement.setInt(1, key);
                statement.setInt(2, question.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exam;
    }

    public static void removeData(int id) {
        String sql2 = "Delete from cauhoitrongde where idDeThi = " + id;
        String sql1 = "Delete from dethi where id = " + id;
        try {
            PreparedStatement statement = connection.prepareStatement(sql2);
            statement.executeUpdate();
            statement = connection.prepareStatement(sql1);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
