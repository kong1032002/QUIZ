package com.example.demo_quanlytrungtam.controller;

import com.example.demo_quanlytrungtam.Main;
import com.example.demo_quanlytrungtam.database.JDBCManagement;
import com.example.demo_quanlytrungtam.model.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SignIn {
    @FXML
    Button signin;
    @FXML
    Text signup;
    @FXML
    TextField username;
    @FXML
    PasswordField password;


    public void signUp() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/viewSignUp.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = (Stage) signup.getScene().getWindow();
            stage.setTitle("Đăng ký");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkAcc() {
        for (Account acc: JDBCManagement.getAllAccount()) {
            if(acc.getUsername().equals(username.getText())  && acc.getPassword().equals(password.getText())) {
                return true;
            }
        }
        return false;
    }
/*
    public void viewMain() {
        if(username.getText() == "" || password.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin!");
            alert.showAndWait();
        } else {
            if(checkAcc()) {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/viewMain.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 1000, 700);
                    Stage stage = (Stage) signin.getScene().getWindow();
                    stage.setTitle("Trang chủ");
                    stage.setScene(scene);
                    stage.setX(250);
                    stage.setY(50);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Sai tài khoản hoặc mật khẩu!");
                alert.showAndWait();
            }
        }

    }
*/
    public void viewMain() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/viewMain.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
            Stage stage = (Stage) signin.getScene().getWindow();
            stage.setTitle("Trang chủ");
            stage.setScene(scene);
            stage.setX(250);
            stage.setY(50);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
