package com.example.demo_quanlytrungtam.controller.dethi;

import com.example.demo_quanlytrungtam.controller.ForwardScene;
import com.example.demo_quanlytrungtam.database.ExamDB;
import com.example.demo_quanlytrungtam.database.SubjectDB;
import com.example.demo_quanlytrungtam.database.TracNghiemDB;
import com.example.demo_quanlytrungtam.model.Exam;
import com.example.demo_quanlytrungtam.model.Subject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class Lamdethi implements Initializable {
    @FXML
    TextField easy;
    @FXML
    TextField normal;
    @FXML
    TextField hard;
    @FXML
    TextField hardest;
    @FXML
    Button cancel;
    @FXML
    ComboBox<Subject> subject;
    @FXML
    TextField title;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subject.getItems().addAll(SubjectDB.getData());
    }

    public void gohome() {
        ForwardScene.forward("dethi.fxml", "Đề thi", cancel);
    }

    public void ok(MouseEvent mouseEvent) {
        try {
            ExamDB.createExam(title.getText(), subject.getValue(),
                    Integer.parseInt(easy.getText()),
                    Integer.parseInt(normal.getText()),
                    Integer.parseInt(hard.getText()),
                    Integer.parseInt(hardest.getText()));
            gohome();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancel(MouseEvent mouseEvent) {
        gohome();
    }
}
