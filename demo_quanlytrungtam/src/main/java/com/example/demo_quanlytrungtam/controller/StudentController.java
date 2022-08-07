package com.example.demo_quanlytrungtam.controller;

import com.example.demo_quanlytrungtam.Main;
import com.example.demo_quanlytrungtam.database.StudentDB;
import com.example.demo_quanlytrungtam.model.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
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
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        birthdayCol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        motherCol.setCellValueFactory(new PropertyValueFactory<>("mother"));
        fatherCol.setCellValueFactory(new PropertyValueFactory<>("father"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        parentPhoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("parentPhoneNumber"));
        table.getItems().addAll(StudentDB.getData());
    }

    public void refresh() {

    }

    public void gohome() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/viewMain.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
            Stage stage = (Stage) home.getScene().getWindow();
            stage.setTitle("Đăng nhập");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addHV() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/AddStudent.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 640, 640);
            Stage stage = new Stage();
            stage.setTitle("Đăng ký");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void editHV() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/AddStudent.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 640, 640);
            Stage stage = new Stage();
            stage.setTitle("Đăng ký");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
