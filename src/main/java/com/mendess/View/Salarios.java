package com.mendess.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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

    static void popUp(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }
}
