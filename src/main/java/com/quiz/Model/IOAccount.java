package com.quiz.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IOAccount {
    public List<Account> getAccount() throws SQLException, ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();
        Connection connection = MySQLConnectionUnit.getMySQLConnection();
        Statement statement = connection.createStatement();
        String sql = "Select * from Account";
        ResultSet resultSet = statement.executeQuery(sql);
        Account account;
        while (resultSet.next()) {
            account = new Account(resultSet.getInt(1)
                    , resultSet.getString(2)
                    , resultSet.getString(3)
                    , resultSet.getString(4)
                    , resultSet.getString(5)
                    , resultSet.getString(6)
                    , resultSet.getString(7));
            accounts.add(account);
        }
        return accounts;
    }

    public int writeAccount(Account account) {
        int written = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = MySQLConnectionUnit.getMySQLConnection();
            String sql = "insert into Account value (?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(account.getId()));
            statement.setString(2, account.getUserName());
            statement.setString(3, account.getPassWord());
            statement.setString(4, account.getName());
            statement.setString(5, account.getRole());
            statement.setString(6, account.getMajor());
            statement.setString(7, account.getPhone());
            written = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert statement != null;
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return written;
    }

    public int deleteAccount(int id) {
        int deleted = 0;
        Connection connection;
        PreparedStatement statement;
        try {
            connection = MySQLConnectionUnit.getMySQLConnection();
            String sql = "delete from Account where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            deleted = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
