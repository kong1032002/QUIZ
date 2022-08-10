package com.example.demo_quanlytrungtam.controller.dethi;

import com.example.demo_quanlytrungtam.Main;
import com.example.demo_quanlytrungtam.controller.ForwardScene;
import com.example.demo_quanlytrungtam.database.ExamDB;
import com.example.demo_quanlytrungtam.database.SubjectDB;
import com.example.demo_quanlytrungtam.database.TracNghiemDB;
import com.example.demo_quanlytrungtam.model.Exam;
import com.example.demo_quanlytrungtam.model.Subject;
import com.mysql.cj.x.protobuf.MysqlxCursor;
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
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Dictionary;
import java.util.ResourceBundle;

public class DethiController implements Initializable {

    @FXML
    ComboBox<Subject> subjectSelection;
    @FXML
    TableView<Exam> exams;
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
        subject.setCellValueFactory(new PropertyValueFactory<>("idSubject"));
        examTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        exams.getItems().addAll(ExamDB.getData());
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
//        DirectoryChooser directoryChooser = new DirectoryChooser();
//        Stage stage = (Stage) lamdethi.getScene().getWindow();
//        try {
//            File file = new File(directoryChooser.showDialog(stage) + "\\dethi.docx");
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Exam exam = new Exam();
//        exam.getQuestionList().addAll(TracNghiemDB.getQuestion(4, "Đọc Hiểu", 2));
    }

    public void exportExam(MouseEvent mouseEvent) {
    }
}
