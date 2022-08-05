package com.example.demo_quanlytrungtam;

import com.example.demo_quanlytrungtam.database.*;
import com.example.demo_quanlytrungtam.model.Account;
import com.example.demo_quanlytrungtam.model.Cauhoi;
import com.example.demo_quanlytrungtam.model.TracNghiem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;

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
//        launch();
//        Account account = new Account();
//        account.setTendangnhap("123123");
//        account.setMatkhau("123");
//        account.setSdt(1233);
//        account.setTen("123132");
//        account.setGmail("123123");
//        AccountDB.addAccount(account);
        System.out.println(StudentDB.getData());
        System.out.println(TeacherDB.getData());
        System.out.println(AccountDB.getData());
        System.out.println(TracNghiemDB.getData());
        System.out.println(TuLuanDB.getData());
    }
}
