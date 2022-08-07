package com.example.demo_quanlytrungtam.controller;

import com.example.demo_quanlytrungtam.database.TracNghiemDB;
import com.example.demo_quanlytrungtam.model.MultiChoiceQuest;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddQuestion {
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
    TextField subject;
    @FXML
    TextField question;

    public void ok(MouseEvent mouseEvent) {
        MultiChoiceQuest quest = new MultiChoiceQuest();
        quest.setSubject(subject.getText());
        quest.setQuest(question.getText());
        quest.setA(firstOption.getText());
        quest.setB(secondOption.getText());
        quest.setC(thirdOption.getText());
        quest.setD(fourthOption.getText());
        quest.setDapAn(answer.getText());
        System.out.println(quest);
        TracNghiemDB.pushData(quest);
    }

    public void cancel(MouseEvent mouseEvent) {
    }
}
    