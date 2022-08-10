package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.Student;
import com.example.demo_quanlytrungtam.model.StudentClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentClassDB {
    public static List<StudentClass> getData() {
        List<StudentClass> studentClasses = new ArrayList<>();
        String sql = "select * from lopHanhChinh;";
        try {
            PreparedStatement statement = JDBCConnection.getJDBCConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                StudentClass studentClass = new StudentClass();
                studentClass.setClassName(resultSet.getString("tenLop"));
                studentClass.setIdTeacher(resultSet.getInt("idGVCN"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentClasses;
    }
}
