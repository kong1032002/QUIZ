package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.Student;
import javafx.collections.FXCollections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDB implements EditData {

    private static final Connection connection = JDBCConnection.getJDBCConnection();

    public static List<Student> getData() {
        List<Student> students = new ArrayList<>();
        String sql = "select * from hocsinh";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setBirthday(resultSet.getString("ngaysinh"));
                student.setFather(resultSet.getString("tenBo"));
                student.setFirstname(resultSet.getString("ho"));
                student.setLastname(resultSet.getString("ten"));
                student.setId(resultSet.getInt("id"));
                student.setMother(resultSet.getString("tenMe"));
                student.setGender(resultSet.getString("gioiTinh"));
                student.setPhoneNumber(resultSet.getInt("sdt"));
                student.setParentPhoneNumber(resultSet.getInt("sdtPhuHuynh"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void pushData(Student student) {
        String sql = "insert into hocsinh(ho, ten, ngaySinh, gioiTinh, sdt, email, cccd, sdtPhuHuynh) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getFirstname());
            statement.setString(2, student.getLastname());
            statement.setString(3, String.valueOf(student.getBirthday()));
            statement.setString(4, student.getGender());
            statement.setInt(5, student.getPhoneNumber());
            statement.setString(6, student.getEmail());
            statement.setInt(7, student.getIdCard());
            statement.setInt(8, student.getParentPhoneNumber());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeData(int id) {
        String sql = "Delete from hocsinh where id = " + id;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
