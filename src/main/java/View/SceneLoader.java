package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


class SceneLoader {
    private static Map<String, Scene> scenes;

    private static void initIfNeeded() {
        if (scenes == null) {
            scenes = new HashMap<>(View.values().length);
        }
    }

    static Scene get(View view) {
        initIfNeeded();
        String name = view.getName();
        if (!scenes.containsKey(name)) {
            try {
                scenes.put(
                        name,
                        new Scene(FXMLLoader.load(Objects.requireNonNull(Salarios.class.getClassLoader()
                                                                                       .getResource(name)))));
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return scenes.get(name);
    }

    enum View {
        InputWindow("View/InputWindow.fxml"),
        OutputWindow("View/OutputWindow.fxml"),
        ;
        private final String name;

        View(String name) {
            this.name = name;
        }

        private String getName() {
            return this.name;
        }
    }
}
