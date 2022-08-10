module com.example.demo_quanlytrungtam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires org.apache.poi.ooxml;


    opens com.example.demo_quanlytrungtam to javafx.fxml;
    exports com.example.demo_quanlytrungtam;
    exports com.example.demo_quanlytrungtam.controller;
    opens com.example.demo_quanlytrungtam.controller to javafx.fxml;
    opens com.example.demo_quanlytrungtam.model to javafx.base;
    exports com.example.demo_quanlytrungtam.controller.student;
    opens com.example.demo_quanlytrungtam.controller.student to javafx.fxml;
    exports com.example.demo_quanlytrungtam.controller.teacher;
    opens com.example.demo_quanlytrungtam.controller.teacher to javafx.fxml;
    exports com.example.demo_quanlytrungtam.controller.question;
    opens com.example.demo_quanlytrungtam.controller.question to javafx.fxml;
    exports com.example.demo_quanlytrungtam.controller.dethi;
    opens com.example.demo_quanlytrungtam.controller.dethi to javafx.fxml;
    exports com.example.demo_quanlytrungtam.controller.export;
    opens com.example.demo_quanlytrungtam.controller.export to javafx.fxml;
}