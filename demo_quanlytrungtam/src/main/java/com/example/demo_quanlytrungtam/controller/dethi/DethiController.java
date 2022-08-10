package com.example.demo_quanlytrungtam.controller.dethi;

import com.example.demo_quanlytrungtam.Main;
import com.example.demo_quanlytrungtam.controller.ForwardScene;
import com.example.demo_quanlytrungtam.controller.export.ExportDethi;
import com.example.demo_quanlytrungtam.database.ExamDB;
import com.example.demo_quanlytrungtam.database.SubjectDB;
import com.example.demo_quanlytrungtam.model.Exam;
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

public class DethiController implements Initializable {

    @FXML
    ComboBox<Subject> subjectSelection;
    @FXML
    TableView<Exam> table;
    @FXML
    TableColumn<Exam, String> subject;
    @FXML
    TableColumn<Exam, String> examTitle;
    @FXML
    Button cancel;
    @FXML
    Button lamdethi;
    @FXML
    Button addDT;
    @FXML
    Button deleteDT;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subjectSelection.getItems().addAll(SubjectDB.getData());
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        examTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        table.getItems().addAll(ExamDB.getData());
    }

    public void chonmonhoc() {

    }


    public void deleteDT() {

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
    }

    public void lamdethi() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/lamdethi.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
            Stage stage = (Stage) lamdethi.getScene().getWindow();
            stage.setTitle("Đăng nhập");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportDT() {
        Exam exam = table.getSelectionModel().getSelectedItem();
        ExportDethi.id = exam.getId();
        System.out.println(exam.getId());
        ForwardScene.newStage("exportDethi.fxml", "xuất file", addDT);
    }

    public void deleteExam(MouseEvent mouseEvent) {
        Exam exam = table.getSelectionModel().getSelectedItem();
        System.out.println(exam.getId());
        ExamDB.removeData(exam.getId());
        refresh();
    }

    public void refresh() {
        table.getItems().removeAll(table.getItems());
        table.getItems().addAll(ExamDB.getData());
    }
}
