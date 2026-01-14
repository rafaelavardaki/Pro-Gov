package com.progov.ui;

import com.progov.app.App;
import com.progov.model.BudgetData;
import com.progov.service.BudgetDataService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BudgetResultsView {

    private static final BudgetDataService service = new BudgetDataService();

    private static String eurM(double v) {
        return String.format("€%,.0fM", v);
    }

    public static Scene createScene() {
        BudgetData d = service.load();

        VBox content = new VBox(12);
        content.getStyleClass().add("content-wrap");

        Label title = new Label("Υπολογισμοί Προϋπολογισμού");
        title.getStyleClass().add("h1");

        Label rev = new Label("Σύνολο Εσόδων: " + eurM(d.totalRevenue()));
        Label exp = new Label("Σύνολο Εξόδων: " + eurM(d.totalExpenses()));
        Label bal = new Label("Ισοζύγιο: " + eurM(d.balance()));

        Button constraints = new Button("Έλεγχος Περιορισμών");
        constraints.setOnAction(e -> App.setScene(ConstraintsView.createScene()));

        Button back = new Button("Πίσω");
        back.setOnAction(e -> App.setScene(EditorMenuView.createScene()));

        content.getChildren().addAll(title, rev, exp, bal, constraints, back);

        var root = AppShell.wrap("Υπολογισμοί", content, true);
        return new Scene(root, 1000, 650);
    }
}
