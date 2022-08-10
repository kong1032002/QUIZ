package com.example.demo_quanlytrungtam.controller.question;

import com.example.demo_quanlytrungtam.controller.ForwardScene;
import com.example.demo_quanlytrungtam.database.SubjectDB;
import com.example.demo_quanlytrungtam.database.TracNghiemDB;
import com.example.demo_quanlytrungtam.model.MultiChoiceQuest;
import com.example.demo_quanlytrungtam.model.Subject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddQuestion implements Initializable {
    @FXML
    ComboBox<String> difficultSelection;
    @FXML
    TextField answer;
    @FXML
    TextField fourthOption;
    @FXML
    TextField thirdOption;
    @FXML
    TextField secondOption;
    @FXML
    TextField firstOption;
    @FXML
    ComboBox<Subject> subject;
    @FXML
    TextField question;
    @FXML
    Button cancel;
    @FXML
    Button ok;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subject.getItems().addAll(SubjectDB.getData());
        difficultSelection.getItems().addAll("Nhận Biết", "Thông Hiểu", "Vận Dụng", "Vận dụng cao");
    }

    public void ok() {
        if (answer.getText() == "" || fourthOption.getText() == "" || thirdOption.getText() == "" || secondOption.getText() == "" || firstOption.getText() == "" ||
                subject.getValue() == null || question.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();

        } else {
            MultiChoiceQuest quest = new MultiChoiceQuest();
            quest.setIdSubject(subject.getValue().getId());
            quest.setDifficult(difficultSelection.getValue());
            quest.setQuest(question.getText());
            quest.setA(firstOption.getText());
            quest.setB(secondOption.getText());
            quest.setC(thirdOption.getText());
            quest.setD(fourthOption.getText());
            quest.setAnswer(answer.getText());
            TracNghiemDB.pushData(quest);
            cancel();
        }
    }

    public void cancel() {
        ForwardScene.forward("Quest.fxml", "Câu hỏi", cancel);
    }
}
    