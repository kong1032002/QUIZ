package com.example.demo_quanlytrungtam.controller.export;

import com.example.demo_quanlytrungtam.database.ExamDB;
import com.example.demo_quanlytrungtam.model.Exam;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ExportDethi implements Initializable {
    @FXML
    Button chon;
    @FXML
    Button save;
    @FXML
    TextField tenfile;
    @FXML
    TextField thumuc;
    @FXML
    ComboBox<String> dinhdang;
    @FXML
    Button cancel;
    public static int id = 1;

    public void chon() {
        Stage stage = (Stage) chon.getScene().getWindow();
        DirectoryChooser fc = new DirectoryChooser();
        fc.setTitle("Lưu file");
        File file = fc.showDialog(stage);
        thumuc.setText(file.getAbsolutePath());
    }

    public void save() {
        if(tenfile.getText() == "" || thumuc.getText() == "" || dinhdang.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin!");
            alert.showAndWait();
        } else {
            String path = thumuc.getText() + "\\" + tenfile.getText() + dinhdang.getValue();
            ApachePOIWrite a = new ApachePOIWrite();
            a.writeDethi(path, id);
            Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông báo");
            alert.setContentText("Đã lưu file");
            alert.showAndWait();
        }
    }

    public void cancel() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> dd = FXCollections.observableArrayList(".docx");
        dinhdang.setItems(dd);
    }
}
