package com.progov.ui;

import com.progov.app.App;
import com.progov.model.Budget;
import com.progov.service.BudgetService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ConstraintsView {

    private static final BudgetService service = new BudgetService();

    public static Scene createScene() {
        Budget b = service.getBudget();

        boolean ok = service.passesConstraints();

        Label title = new Label("Έλεγχος Περιορισμών");
        Label rule1 = new Label("Κανόνας: Έξοδα ≤ Έσοδα");
        Label status = new Label(ok ? "✅ OK" : "❌ Παραβίαση (χρειάζονται αλλαγές)");

        Label now = new Label("Τώρα: Έσοδα=" + b.totalRevenue() + " | Έξοδα=" + b.totalExpenses());

        Button apply = new Button("Εφαρμογή Αλλαγών");
        Button back = new Button("Πίσω");

        apply.setOnAction(e -> {
            service.applyFixesIfNeeded();
            App.setScene(ConstraintsView.createScene()); // refresh
        });

        back.setOnAction(e -> App.setScene(EditorMenuView.createScene()));

        VBox root = new VBox(10, title, rule1, status, now, apply, back);
        root.setPadding(new Insets(20));
        return new Scene(root, 560, 320);
    }
}
