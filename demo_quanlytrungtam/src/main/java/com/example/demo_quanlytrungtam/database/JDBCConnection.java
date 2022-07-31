package com.example.demo_quanlytrungtam.database;

import java.sql.*;

class JDBCConnection {
    //Tạo kết nối với MySQL
    public static Connection getJDBCConnection() {
        final String url = "jdbc:mysql://localhost:3306/quanlytrungtam";
        final String user = "root";
        final String password = "gogeta12";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}