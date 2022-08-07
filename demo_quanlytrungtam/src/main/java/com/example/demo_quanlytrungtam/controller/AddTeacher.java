package com.example.demo_quanlytrungtam.controller;

import com.example.demo_quanlytrungtam.model.Teacher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTeacher implements Initializable {
    @FXML
    Button cancel;
    @FXML
    TextField id;
    @FXML
    TextField fullName;
    @FXML
    TextField address;
    @FXML
    TextField email;
    @FXML
    TextField phoneNumber;
    @FXML
    TextField idCard;
    @FXML
    TextField salary;
    @FXML
    TextField role;
    @FXML
    ComboBox<String> gender;
    @FXML
    DatePicker birthday;

    public void gohome() {
            Stage stage = (Stage) cancel.getScene().getWindow();
            stage.setTitle("Đăng nhập");
            stage.close();

    }

    public void ok() {
        Teacher teacher = new Teacher();
        teacher.setAddress(address.getText());
        teacher.setRole(role.getText());
        teacher.setSalary(Double.parseDouble(salary.getText()));
        teacher.setEmail(email.getText());
        teacher.setPhoneNumber(Integer.parseInt(phoneNumber.getText()));
        teacher.setBirthday(String.valueOf(birthday.getValue()));
        teacher.setIdCard(Integer.parseInt(idCard.getText()));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender.getItems().addAll("Nam", "Nữ", "Khác");
    }
}
