package com.example.demo_quanlytrungtam.controller.student;

import com.example.demo_quanlytrungtam.Main;
import com.example.demo_quanlytrungtam.controller.ForwardScene;
import com.example.demo_quanlytrungtam.database.StudentClassDB;
import com.example.demo_quanlytrungtam.database.StudentDB;
import com.example.demo_quanlytrungtam.database.SubjectDB;
import com.example.demo_quanlytrungtam.model.Student;
import com.example.demo_quanlytrungtam.model.StudentClass;
import com.example.demo_quanlytrungtam.model.Subject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    ComboBox<Subject> subjectSelection;
    @FXML
    ComboBox<StudentClass> classSelection;
    @FXML
    TableColumn<Student, Integer> idCol;
    @FXML
    TableColumn<Student, String> firstnameCol;
    @FXML
    TableColumn<Student, String> lastnameCol;
    @FXML
    TableColumn<Student, String> genderCol;
    @FXML
    TableColumn<Student, String> birthdayCol;
    @FXML
    TableColumn<Student, String> motherCol;
    @FXML
    TableColumn<Student, String> parentPhoneNumberCol;
    @FXML
    TableColumn<Student, String> fatherCol;
    @FXML
    TableColumn<Student, String> phoneNumberCol;
    @FXML
    TableView<Student> table;
    @FXML
    Button home;
    @FXML
    Button addHV;
    @FXML
    Button editHV;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subjectSelection.getItems().addAll(SubjectDB.getData());
        classSelection.getItems().addAll(StudentClassDB.getData());
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        birthdayCol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        motherCol.setCellValueFactory(new PropertyValueFactory<>("mother"));
        fatherCol.setCellValueFactory(new PropertyValueFactory<>("father"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        parentPhoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("parentPhoneNumber"));
        refresh();
    }

    public void refresh() {
        table.getItems().removeAll(table.getItems());
        table.getItems().addAll(StudentDB.getData());
    }

    public void gohome() {
        ForwardScene.forward("viewMain.fxml", "Main", home);
    }

    public void addHV() {
        ForwardScene.forward("AddStudent.fxml", "Học viên", addHV);
    }

    public void editHV() {
        ForwardScene.forward("editStudent.fxml", "Học viên", editHV);
    }

    public void deleteStudent(MouseEvent mouseEvent) {
        Student student = table.getSelectionModel().getSelectedItem();
        StudentDB.removeData(student.getId());
        refresh();
    }
}
