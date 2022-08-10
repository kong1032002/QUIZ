package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDB {
    public static List<Subject> getData() {
        List<Subject> subjectList = new ArrayList<>();
        String sql = "select * from monHoc;";
        try {
            PreparedStatement statement = JDBCConnection.getJDBCConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setId(resultSet.getInt("id"));
                subject.setSubject(resultSet.getString("tenMonHoc"));
                subjectList.add(subject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subjectList;
    }
}
