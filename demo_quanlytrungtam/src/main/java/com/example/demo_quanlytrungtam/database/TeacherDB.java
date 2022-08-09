package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherDB implements EditData {
    private static final Connection connection = JDBCConnection.getJDBCConnection();

    public static List<Teacher> getData() {
        List<Teacher> giaoviens = new ArrayList<>();
        String sql = "Select * from Giaovien";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Teacher giaovien = new Teacher();
                giaovien.setAddress(resultSet.getString("diaChi"));
                giaovien.setBirthday(resultSet.getString("ngaySinh"));
                giaovien.setEmail(resultSet.getString("email"));
                giaovien.setFirstname(resultSet.getString("Ten"));
                giaovien.setLastname(resultSet.getString("Ho"));
                giaovien.setRole(resultSet.getString("chucVu"));
                giaovien.setSalary(resultSet.getDouble("luong"));
                giaovien.setId(resultSet.getInt("id"));
                giaovien.setGender(resultSet.getString("gioiTinh"));
                giaovien.setPhoneNumber(resultSet.getInt("sdt"));
                giaovien.setIdCard(resultSet.getInt("cccd"));
                giaovien.setId(resultSet.getInt("id"));
                giaoviens.add(giaovien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return giaoviens;
    }

    public static void pushData(Teacher teacher) {
        String sql = "insert into giaovien(ho, ten, ngaySinh, gioiTinh, sdt, email, CMND, diaChi, chucVu, luong)" +
                "values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, teacher.getFirstname());
            statement.setString(2, teacher.getLastname());
            statement.setString(3, String.valueOf(teacher.getBirthday()));
            statement.setString(4, teacher.getGender());
            statement.setInt(5, teacher.getPhoneNumber());
            statement.setString(6, teacher.getEmail());
            statement.setInt(7, teacher.getIdCard());
            statement.setString(8, teacher.getAddress());
            statement.setString(9, teacher.getRole());
            statement.setDouble(10, teacher.getSalary());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeData(int id) {
        String sql = "delete from giaovien where id = " + id;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
