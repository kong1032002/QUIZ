package com.example.demo_quanlytrungtam;

import com.example.demo_quanlytrungtam.database.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/viewLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Đăng nhập");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        System.out.println(StudentDB.getData());
        System.out.println(TeacherDB.getData());
        System.out.println(AccountDB.getData());
        System.out.println(TracNghiemDB.getData());
        System.out.println(TuLuanDB.getData());
    }
}
