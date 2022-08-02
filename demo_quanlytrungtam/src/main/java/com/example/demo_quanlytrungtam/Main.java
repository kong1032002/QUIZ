package com.example.demo_quanlytrungtam;

import com.example.demo_quanlytrungtam.database.AccountDB;
import com.example.demo_quanlytrungtam.database.JDBCConnection;
import com.example.demo_quanlytrungtam.database.TracNghiemDB;
import com.example.demo_quanlytrungtam.model.Account;
import com.example.demo_quanlytrungtam.model.Cauhoi;
import com.example.demo_quanlytrungtam.model.TracNghiem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demo_quanlytrungtam/views/viewSignIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Đăng nhập");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
