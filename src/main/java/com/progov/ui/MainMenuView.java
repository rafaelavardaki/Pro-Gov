package com.progov.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import com.progov.app.App;

public class MainMenuView {

    public static Scene createScene() {

        Button btnExit = new Button("Έξοδος");
        btnExit.setOnAction(e -> System.exit(0));

        VBox root = new VBox(10, btnExit);
        root.setPadding(new Insets(20));

        return new Scene(root, 400, 250);
    }
}
