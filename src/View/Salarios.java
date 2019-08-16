package View;

import javafx.application.Application;
import javafx.stage.Stage;

public class Salarios extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        Salarios.primaryStage = primaryStage;
        Salarios.primaryStage.setTitle("Salários");
        Salarios.primaryStage.setScene(SceneLoader.get(SceneLoader.View.InputWindow));
        Salarios.primaryStage.show();
    }

    static void redirectTo(SceneLoader.View view) {
        primaryStage.setScene(SceneLoader.get(view));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
