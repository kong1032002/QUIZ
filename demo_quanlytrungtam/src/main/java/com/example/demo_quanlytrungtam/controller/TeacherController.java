package com.example.demo_quanlytrungtam.controller;

import com.example.demo_quanlytrungtam.Main;
import com.example.demo_quanlytrungtam.database.TeacherDB;
import com.example.demo_quanlytrungtam.model.Teacher;
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

public class TeacherController implements Initializable {
    @FXML
    Button home;
    @FXML
    Button addGV;
    @FXML
    Button editGV;
    @FXML
    TableView<Teacher> table;
    @FXML
    TableColumn<Teacher, Integer> idCol;
    @FXML
    TableColumn<Teacher, String> firstnameCol;
    @FXML
    TableColumn<Teacher, String> lastnameCol;
    @FXML
    TableColumn<Teacher, String> genderCol;
    @FXML
    TableColumn<Teacher, String> addressCol;
    @FXML
    TableColumn<Teacher, String> emailCol;
    @FXML
    TableColumn<Teacher, String> birthdayCol;
    @FXML
    TableColumn<Teacher, String> roleCol;
    @FXML
    TableColumn<Teacher, Integer> phoneNumberCol;
    @FXML
    TableColumn<Teacher, Integer> idCardCol;
    @FXML
    TableColumn<Teacher, Integer> salaryCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        idCol.
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        birthdayCol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        idCardCol.setCellValueFactory(new PropertyValueFactory<>("idCardNumber"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        table.getItems().addAll(TeacherDB.getData());
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
    public void addGV() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/editGV.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 380, 640);
            Stage stage = new Stage();
            stage.setTitle("Đăng ký");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void editGV() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/editGV.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 380, 640);
            Stage stage = new Stage();
            stage.setTitle("Sửa thông tin giáo viên");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
