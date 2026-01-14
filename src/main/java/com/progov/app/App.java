package com.progov.app;

import com.progov.ui.RoleSelectionWebView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class App extends Application {

    private static Stage primaryStage;
    private static String THEME; // cached theme URL

    private static void applyTheme(Scene scene) {
        if (THEME == null) {
            URL css = App.class.getResource("/styles/theme.css");
            THEME = (css == null) ? null : css.toExternalForm();
            System.out.println("THEME = " + THEME);
        }
        if (THEME != null && !scene.getStylesheets().contains(THEME)) {
            scene.getStylesheets().add(THEME);
        }
        // ΚΡΙΣΙΜΟ: class στο root για να "πιάνει" το CSS
        if (!scene.getRoot().getStyleClass().contains("app-root")) {
            scene.getRoot().getStyleClass().add("app-root");
        }
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;

        Scene scene = RoleSelectionWebView.createScene();
        applyTheme(scene);

        stage.setScene(scene);
        stage.setTitle("Pro-GOV");
        stage.show();
    }

    public static void setScene(Scene scene) {
        applyTheme(scene);
        primaryStage.setScene(scene);
    }

    public static void showMainMenu() {
        setScene(RoleSelectionWebView.createScene());
    }

    public static void main(String[] args) {
        launch();
    }
}
