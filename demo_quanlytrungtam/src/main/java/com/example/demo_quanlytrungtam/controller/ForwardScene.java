package com.example.demo_quanlytrungtam.controller;

import com.example.demo_quanlytrungtam.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ForwardScene {
    public static void forward(String file, String title, Button bt){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/" + file));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) bt.getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void newStage(String file, String title, Button bt) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/" + file));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
