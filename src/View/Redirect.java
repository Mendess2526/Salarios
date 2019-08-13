package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Redirect {
    public static void redirectTo(Parent parent, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(Salarios.class.getClassLoader().getResource(fxml));

        Stage stage = new Stage();
        stage.initOwner(parent.getScene().getWindow());
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}
