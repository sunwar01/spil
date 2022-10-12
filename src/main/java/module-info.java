module com.example.spil {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spil to javafx.fxml;
    exports com.example.spil;
}