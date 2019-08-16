package com.mendess.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
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

    public static void popUp(String message) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        VBox dialogBox = new VBox(20);
        dialogBox.getChildren().add(new Text(message));
        Scene dialogScene = new Scene(dialogBox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
