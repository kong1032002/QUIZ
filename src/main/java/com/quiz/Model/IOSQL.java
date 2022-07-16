package com.quiz.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IOSQL {
    public int numberSQL(String nameTable, int userID) {
        int n = 0;
        try {
            Connection connection = MySQLConnectionUnit.getMySQLConnection(1);
            Statement statement = connection.createStatement();
            String sql = "select id from " + nameTable + " where userID = " + userID;
            ResultSet resultSet = statement.executeQuery(sql.trim());
            while (resultSet.next()) {
                n++;
                if (n != resultSet.getInt(1)) {
                    statement.close();
                    connection.close();
                    return n;
                }
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n + 1;
    }

    public String readName(int id) {
        int check = 0;
        try {
            Connection connection = MySQLConnectionUnit.getMySQLConnection();
            Statement statement = connection.createStatement();
            String sql = "Select id, name from Account";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (resultSet.getInt(1) == id) {
                    resultSet.close();
                    statement.close();
                    connection.close();
                    return resultSet.getString(2);
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
