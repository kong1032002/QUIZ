module com.example.demo_quanlytrungtam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo_quanlytrungtam to javafx.fxml;
    exports com.example.demo_quanlytrungtam;
    exports com.example.demo_quanlytrungtam.controller;
    opens com.example.demo_quanlytrungtam.controller to javafx.fxml;
    opens com.example.demo_quanlytrungtam.model to javafx.base;
}