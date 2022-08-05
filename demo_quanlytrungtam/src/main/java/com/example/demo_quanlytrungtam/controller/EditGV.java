package com.example.demo_quanlytrungtam.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditGV implements Initializable {
    @FXML
    Button cancel;
    @FXML
    TextField maGV;
    @FXML
    TextField hoten;
    @FXML
    TextField diachi;
    @FXML
    TextField gmail;
    @FXML
    TextField sdt;
    @FXML
    TextField cmnd;
    @FXML
    TextField luong;
    @FXML
    TextField chucvu;
    @FXML
    TextField gioitinh;
    @FXML
    TextField ngaysinh;

    public void gohome() {
            Stage stage = (Stage) cancel.getScene().getWindow();
            stage.setTitle("Đăng nhập");
            stage.close();

    }

    public void ok() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
