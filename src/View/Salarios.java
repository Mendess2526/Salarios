package View;

import javafx.application.Application;
import javafx.stage.Stage;

@SuppressWarnings("SameParameterValue")
public class Salarios extends Application {

    private static Stage primaryStage;

    static void redirectTo(SceneLoader.View view) {
        primaryStage.setScene(SceneLoader.get(view));
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Salarios.primaryStage = primaryStage;
        Salarios.primaryStage.setTitle("Salários");
        Salarios.primaryStage.setScene(SceneLoader.get(SceneLoader.View.InputWindow));
        Salarios.primaryStage.show();
    }
}
