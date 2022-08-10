package com.example.demo_quanlytrungtam.controller;

import com.example.demo_quanlytrungtam.Main;
import com.example.demo_quanlytrungtam.database.JDBCManagement;
import com.example.demo_quanlytrungtam.model.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Register {
    @FXML
    Button signup;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    PasswordField pass;
    @FXML
    TextField name;
    @FXML
    TextField email;
    @FXML
    TextField phone;

    public boolean checkAcc() {
        for (Account acc: JDBCManagement.getAllAccount()) {
            if(acc.getUsername().equals(username.getText())) {
                return false;
            }
        }
        return true;
    }

    public void login() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/viewLogin.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = (Stage) signup.getScene().getWindow();
            stage.setTitle("Đăng nhập");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void register() {
        if(username.getText() == "" || pass.getText() == "" || password.getText() == "" ||
            name.getText() == "" || email.getText() == "" || phone.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin!");
            alert.showAndWait();
        } else {
            if(!pass.getText().equals(password.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Mật khẩu nhập lại không khớp");
                alert.showAndWait();
            } else {
                if(!checkAcc()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText("Lỗi");
                    alert.setContentText("Tên đăng nhập đã tồn tại!");
                    alert.showAndWait();
                } else {
                    Account acc = new Account();
                    acc.setUsername(username.getText());
                    acc.setPassword(password.getText());
                    acc.setFullName(name.getText());
                    acc.setPhoneNumber(Integer.parseInt(phone.getText()));
                    acc.setEmail(email.getText());
                    JDBCManagement.addAccount(acc);
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/viewLogin.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load(), 600, 400);
                        Stage stage = (Stage) signup.getScene().getWindow();
                        stage.setTitle("Đăng nhập");
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
    }
}
