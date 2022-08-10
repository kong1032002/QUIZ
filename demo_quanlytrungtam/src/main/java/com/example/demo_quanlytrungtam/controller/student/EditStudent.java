package com.example.demo_quanlytrungtam.controller.student;

import com.example.demo_quanlytrungtam.controller.ForwardScene;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class EditStudent {
    @FXML
    ComboBox<String> gender;
    @FXML
    TextField cccd;
    @FXML
    DatePicker birthday;
    @FXML
    TextField parentPhoneNumber;
    @FXML
    TextField mother;
    @FXML
    TextField father;
    @FXML
    TextField email;
    @FXML
    TextField firstname;
    @FXML
    TextField lastname;
    @FXML
    TextField phoneNumber;
    @FXML
    Button cancel;

    public void gohome() {
        ForwardScene.forward("Student.fxml","Học viên",cancel);
    }

    public void ok() {
        if(cccd.getText() == "" || parentPhoneNumber.getText() == "" || phoneNumber.getText() == "" || father.getText() == "" || mother.getText() == "" || email.getText() == "" ||
                firstname.getText() == "" || lastname.getText() == "" || gender.getValue() == "" ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();

        }
        else {

        }
    }
}
