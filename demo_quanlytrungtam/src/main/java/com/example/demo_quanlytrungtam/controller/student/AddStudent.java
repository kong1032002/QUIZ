package com.example.demo_quanlytrungtam.controller.student;

import com.example.demo_quanlytrungtam.controller.ForwardScene;
import com.example.demo_quanlytrungtam.database.StudentDB;
import com.example.demo_quanlytrungtam.model.Student;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class AddStudent implements Initializable {

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
            Student student = new Student();
            student.setFirstname(firstname.getText());
            student.setLastname(lastname.getText());
            student.setBirthday(String.valueOf(birthday.getValue()));
            student.setEmail(email.getText());
            student.setPhoneNumber(Integer.parseInt(phoneNumber.getText()));
            student.setFather(father.getText());
            student.setMother(mother.getText());
            student.setParentPhoneNumber(Integer.parseInt(parentPhoneNumber.getText()));
            student.setGender(gender.getValue());
            StudentDB.pushData(student);
            gohome();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender.getItems().addAll(FXCollections.observableArrayList("Nam","Nữ","Khác"));
    }
}
