package com.progov.app;

import com.progov.ui.RoleSelectionView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Pro-Gov");
        showMainMenu();
        primaryStage.show();
    }

    public static void setScene(Scene scene) {
        primaryStage.setScene(scene);
    }

    public static void showMainMenu() {
        setScene(RoleSelectionView.createScene());
    }

    public static void main(String[] args) {
        launch();
    }
}
