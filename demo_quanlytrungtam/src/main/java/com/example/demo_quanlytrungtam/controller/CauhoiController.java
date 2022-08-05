package com.example.demo_quanlytrungtam.controller;

import com.example.demo_quanlytrungtam.Main;
import com.example.demo_quanlytrungtam.database.TracNghiemDB;
import com.example.demo_quanlytrungtam.model.Cauhoi;
import com.example.demo_quanlytrungtam.model.TracNghiem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class CauhoiController  {
    @FXML
    public ListView<TracNghiem> quests;
    @FXML
    Button addCH;
    @FXML
    Button editCH;
    @FXML
    Button cancel;

    public void refresh() {
        quests.getItems().addAll(TracNghiemDB.getAllQuest());
    }

    public void addCH() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/editCH.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setTitle("Đăng ký");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        refresh();
    }

    public void editCH() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/editCH.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setTitle("Đăng ký");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        refresh();
    }

    public void gohome() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/viewMain.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
            Stage stage = (Stage) cancel.getScene().getWindow();
            stage.setTitle("Đăng nhập");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        refresh();
    }

}
