package View;

import javafx.application.Application;
import javafx.stage.Stage;

public class Salarios extends Application {

    private static Stage primaryStage;

    static void redirectTo(SceneLoader.View view) {
        primaryStage.setScene(SceneLoader.get(view));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void redirectToReloaded(SceneLoader.View view) {
        primaryStage.setScene(SceneLoader.getReloaded(view));
    }

    @Override
    public void start(Stage primaryStage) {
        Salarios.primaryStage = primaryStage;
        Salarios.primaryStage.setTitle("Salários");
        Salarios.primaryStage.setScene(SceneLoader.get(SceneLoader.View.InputWindow));
        Salarios.primaryStage.show();
    }
}
