package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Salarios extends Application {

    private static Stage primaryStage;

    private static HashMap<String, Scene> sceneCache;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Salarios.sceneCache = new HashMap<>();
        Salarios.primaryStage = primaryStage;
        Salarios.primaryStage.setTitle("Salários");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader()
                                                                       .getResource("View/InputWindow.fxml")));
        Salarios.primaryStage.setScene(new Scene(root));
        Salarios.primaryStage.show();
    }

    public static void redirectTo(String fxml) throws IOException {
        if (!sceneCache.containsKey(fxml)) {
            FXMLLoader loader = new FXMLLoader(Salarios.class.getClassLoader().getResource(fxml));
            sceneCache.put(fxml, new Scene(loader.load()));
        }
        primaryStage.setScene(sceneCache.get(fxml));
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
