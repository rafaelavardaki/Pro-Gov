package com.progov.ui;

import com.progov.app.App;
import com.progov.model.BudgetData;
import com.progov.service.BudgetDataService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ConstraintsView {

    private static final BudgetDataService service = new BudgetDataService();

    private static String eurM(double v) {
        return String.format("€%,.0fM", v);
    }

    public static Scene createScene() {
        BudgetData d = service.load();
        boolean ok = service.passesConstraints(d);

        VBox content = new VBox(12);
        content.getStyleClass().add("content-wrap");

        Label title = new Label("Έλεγχος Περιορισμών");
        title.getStyleClass().add("h1");

        Label rule1 = new Label("1) Έξοδα ≤ 105% των Εσόδων");
        Label rule2 = new Label("2) Καμία κατηγορία εξόδων > 30% του συνόλου");
        Label rule3 = new Label("3) Αποθεματικό ≥ 10% των Εσόδων");

        Label status = new Label(ok ? "✅ OK" : "❌ Παραβίαση (χρειάζονται αλλαγές)");
        Label now = new Label("Τώρα: Έσοδα=" + eurM(d.totalRevenue()) + " | Έξοδα=" + eurM(d.totalExpenses()) + " | Ισοζύγιο=" + eurM(d.balance()));

        Button apply = new Button("Εφαρμογή Διορθώσεων");
        apply.setOnAction(e -> {
            BudgetData cur = service.load();
            service.applyFixesIfNeeded(cur);
            App.setScene(ConstraintsView.createScene());
        });

        Button back = new Button("Πίσω");
        back.setOnAction(e -> App.setScene(EditorMenuView.createScene()));

        content.getChildren().addAll(title, rule1, rule2, rule3, status, now, apply, back);

        var root = AppShell.wrap("Περιορισμοί", content, true);
        return new Scene(root, 1000, 650);
    }
}
