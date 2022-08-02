package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HocVienDB {
    public static List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        String sql = "select * from hocvien";
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Student student = new Student();
//                student.setBirthday();
//                student.setFather();
//                student.setFirstname();
//                student.setId();
//                student.setLastname();
//                student.setMother();
//                student.setSex();
//                student.setPhoneNumber();
//                student.setParentPhoneNumber();
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
