module salarios {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mendess.View to javafx.fxml;
    exports com.mendess.View;
}