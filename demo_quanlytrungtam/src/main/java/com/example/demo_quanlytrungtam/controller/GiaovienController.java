package com.example.demo_quanlytrungtam.controller;

import com.example.demo_quanlytrungtam.Main;
import com.example.demo_quanlytrungtam.model.Giaovien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class GiaovienController {
    @FXML
    Button home;
    @FXML
    Button addGV;
    @FXML
    Button editGV;
    @FXML
    TableView<Giaovien> table;
    @FXML
    TableColumn<Giaovien, String> maGV;
    @FXML
    TableColumn<Giaovien, String> ten;
    @FXML
    TableColumn<Giaovien, String> gioitinh;
    @FXML
    TableColumn<Giaovien, String> diachi;
    @FXML
    TableColumn<Giaovien, String> gmail;
    @FXML
    TableColumn<Giaovien, String> ngaysinh;
    @FXML
    TableColumn<Giaovien, String> chucvu;
    @FXML
    TableColumn<Giaovien, Integer> sdt;
    @FXML
    TableColumn<Giaovien, Integer> cccd;
    @FXML
    TableColumn<Giaovien, Integer> luong;

    private ObservableList<Giaovien> listGV = FXCollections.observableArrayList();

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
