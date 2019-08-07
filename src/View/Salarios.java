package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Salarios extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("View/InputWindow.fxml")));
            primaryStage.setTitle("Salários");
            primaryStage.setScene(new Scene(root));

            primaryStage.show();
        }


        public static void main(String[] args){
            launch(args);
        }
}
