package com.quiz.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUnit {
    private static final String hostName = "localhost";
    private static final String userName = "root";
    private static final String password = "123";


    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
        String databaseName = "Account";
        return getMySQLConnection(hostName, databaseName, userName, password);
    }

    public static Connection getMySQLConnection(int n) throws SQLException, ClassNotFoundException {
        String databaseName = null;
        if (n == 1) {
            databaseName = "Mon";
        } else {
            databaseName = "Toan";
        }
        return getMySQLConnection(hostName, databaseName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String databaseName, String userName, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + databaseName + "?useUnicode=true&characterEncoding=UTF-8";
        return DriverManager.getConnection(connectionURL, userName, password);
    }
}
