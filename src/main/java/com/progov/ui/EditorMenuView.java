package com.progov.ui;

import com.progov.app.App;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EditorMenuView {

    public static Scene createScene() {

        // Content wrapper
        VBox content = new VBox(12);
        content.getStyleClass().add("content-wrap");

        // Card
        VBox card = new VBox(10);
        card.getStyleClass().add("card");

        Label title = new Label("Μενού Επεξεργαστή");
        title.getStyleClass().add("page-title");

        Button btnInput = new Button("Εισαγωγή / Τροποποίηση");
        Button btnResults = new Button("Υπολογισμοί");
        Button btnConstraints = new Button("Έλεγχος Περιορισμών");
        Button btnBack = new Button("Αρχική");

        // Styles
        btnInput.getStyleClass().add("primary");
        btnResults.getStyleClass().add("secondary");
        btnConstraints.getStyleClass().add("secondary");
        btnBack.getStyleClass().add("secondary");

        // Actions
        btnInput.setOnAction(e -> App.setScene(BudgetInputView.createScene()));
        btnResults.setOnAction(e -> App.setScene(BudgetResultsView.createScene()));
        btnConstraints.setOnAction(e -> App.setScene(ConstraintsView.createScene()));
        btnBack.setOnAction(e -> App.showMainMenu());

        card.getChildren().addAll(
                title,
                btnInput,
                btnResults,
                btnConstraints,
                btnBack
        );

        content.getChildren().add(card);

        var root = AppShell.wrap("Επεξεργαστής", content, true);
        return new Scene(root, 1000, 650);
    }
}
