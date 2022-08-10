package com.example.demo_quanlytrungtam.controller.teacher;

import com.example.demo_quanlytrungtam.controller.ForwardScene;
import com.example.demo_quanlytrungtam.model.Teacher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
        ForwardScene.forward("Teacher.fxml","Giáo viên",cancel);

    }

    public void ok() {
        if(fullName.getText() == "" || address.getText() == "" || phoneNumber.getText() == "" || idCard.getText() == "" || email.getText() == "" ||
                salary.getText() == "" || role.getText() == "" || gender.getValue() == "" ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();
        }
        else {
            Teacher teacher = new Teacher();
            teacher.setAddress(address.getText());
            teacher.setRole(role.getText());
            teacher.setSalary(Double.parseDouble(salary.getText()));
            teacher.setEmail(email.getText());
            teacher.setPhoneNumber(Integer.parseInt(phoneNumber.getText()));
            teacher.setBirthday(String.valueOf(birthday.getValue()));
            teacher.setIdCard(Integer.parseInt(idCard.getText()));
            gohome();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender.getItems().addAll("Nam", "Nữ", "Khác");
    }
}
