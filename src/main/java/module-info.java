module com.quiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens com.quiz to javafx.fxml;
    exports com.quiz;
}