package com.example.demo_quanlytrungtam.controller.question;

import com.example.demo_quanlytrungtam.controller.ForwardScene;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditQuestion {
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
    @FXML
    Button cancel;
    @FXML
    Button ok;

    public void cancel() {
        ForwardScene.forward("Quest.fxml","Câu hỏi",cancel);
    }
    public void ok() {
        if(answer.getText() == "" || fourthOption.getText() == "" || thirdOption.getText() == "" || secondOption.getText() == "" || firstOption.getText() == "" ||
                subject.getText() == "" || question.getText() == ""  ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Lỗi");
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();

        }
        else {

        }
    }
}
