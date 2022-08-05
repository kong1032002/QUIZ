package com.example.demo_quanlytrungtam.database;

import com.example.demo_quanlytrungtam.model.Giaovien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GiaoVienDB {
    public static List<Giaovien> getAllGiaoVien() {
        List<Giaovien> giaoviens = new ArrayList<>();
        String sql = "Select * from Giaovien";
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Giaovien giaovien = new Giaovien();
                giaovien.setAddress(resultSet.getString("diaChi"));
                giaovien.setBirthday(resultSet.getString("ngaySinh"));
                giaovien.setEmail(resultSet.getString("email"));
                giaovien.setFirstname(resultSet.getString("Ten"));
                giaovien.setLastname(resultSet.getString("Ho"));
                giaovien.setRole(resultSet.getString("chucVu"));
                giaovien.setSalary(resultSet.getDouble("luong"));
                giaovien.setId(resultSet.getInt("id"));
                giaovien.setGender(resultSet.getString("gioiTinh"));
                giaovien.setPhoneNumber(resultSet.getInt("soDienThoai"));
                giaovien.setIdCardNumber(resultSet.getInt("soCMND"));
                giaovien.setId(resultSet.getInt("id"));
                giaoviens.add(giaovien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return giaoviens;
    }
}
