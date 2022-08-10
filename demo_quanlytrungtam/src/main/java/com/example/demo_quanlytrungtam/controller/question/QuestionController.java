package com.example.demo_quanlytrungtam.controller.question;

import com.example.demo_quanlytrungtam.controller.ForwardScene;
import com.example.demo_quanlytrungtam.database.SubjectDB;
import com.example.demo_quanlytrungtam.database.TracNghiemDB;
import com.example.demo_quanlytrungtam.model.MultiChoiceQuest;
import com.example.demo_quanlytrungtam.model.Question;
import com.example.demo_quanlytrungtam.model.Subject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class QuestionController implements Initializable {
    @FXML
    ComboBox<Subject> subjectSelection;
    @FXML
    TableView<MultiChoiceQuest> quests;
    @FXML
    TableColumn<MultiChoiceQuest, String> subject;
    @FXML
    TableColumn<MultiChoiceQuest, String> question;
    @FXML
    TableColumn<MultiChoiceQuest, String> answer;
    @FXML
    Button addCH;
    @FXML
    Button editCH;
    @FXML
    Button cancel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subjectSelection.getItems().addAll(SubjectDB.getData());
        subject.setCellValueFactory(new PropertyValueFactory<>("idSubject"));
        question.setCellValueFactory(new PropertyValueFactory<>("quest"));
        answer.setCellValueFactory(new PropertyValueFactory<>("answer"));
        quests.getItems().addAll(TracNghiemDB.getData());
    }

    public void addCH() {
        ForwardScene.forward("AddQuestion.fxml", "Câu hỏi", addCH);
    }

    public void editCH() {
        ForwardScene.forward("editQuestion.fxml", "Câu hỏi", editCH);
    }

    public void gohome() {
        ForwardScene.forward("viewMain.fxml", "Main", cancel);
    }

    public void deleteQuestion(MouseEvent mouseEvent) {
        MultiChoiceQuest multiChoiceQuest = quests.getSelectionModel().getSelectedItem();
        TracNghiemDB.removeData(multiChoiceQuest.getId());
        refresh();
    }

    public void refresh() {
        quests.getItems().removeAll(quests.getItems());
        quests.getItems().addAll(TracNghiemDB.getData());
    }
}
