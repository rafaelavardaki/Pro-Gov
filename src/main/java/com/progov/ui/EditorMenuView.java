package com.progov.ui;

import com.progov.app.App;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class EditorMenuView {

    public static Scene createScene() {
        Button btnInput = new Button("Εισαγωγή / Τροποποίηση");
        Button btnResults = new Button("Υπολογισμοί");
        Button btnConstraints = new Button("Έλεγχος Περιορισμών");
        Button btnBack = new Button("Πίσω");

        btnInput.setOnAction(e -> App.setScene(BudgetInputView.createScene()));
        btnResults.setOnAction(e -> App.setScene(BudgetResultsView.createScene()));
        btnConstraints.setOnAction(e -> App.setScene(ConstraintsView.createScene()));
        btnBack.setOnAction(e -> App.showMainMenu());

        VBox root = new VBox(10, btnInput, btnResults, btnConstraints, btnBack);
        root.setPadding(new Insets(20));
        return new Scene(root, 420, 280);
    }
}
