package com.progov.ui;

import com.progov.app.App;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class RoleSelectionView {

    public static Scene createScene() {
        Button citizenBtn = new Button("Πολίτης");
        Button editorBtn = new Button("Επεξεργαστής");
        Button exitBtn = new Button("Έξοδος");

        citizenBtn.setOnAction(e -> App.setScene(CitizenView.createScene()));
        editorBtn.setOnAction(e -> App.setScene(EditorMenuView.createScene()));
        exitBtn.setOnAction(e -> System.exit(0));

        VBox root = new VBox(15, citizenBtn, editorBtn, exitBtn);
        root.setPadding(new Insets(20));
        return new Scene(root, 400, 250);
    }
}
