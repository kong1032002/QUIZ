package com.example.demo_quanlytrungtam.controller;

import com.example.demo_quanlytrungtam.database.JDBCManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class EditHV {
    @FXML
    Button cancel;
    @FXML
    TableView table;


    public void gohome() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.setTitle("Đăng nhập");
        stage.close();
    }

    public void ok() {

    }

}
