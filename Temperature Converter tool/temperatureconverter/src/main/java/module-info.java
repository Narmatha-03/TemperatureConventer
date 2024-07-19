module com.temperature {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.temperature to javafx.fxml;
    exports com.temperature;
}
