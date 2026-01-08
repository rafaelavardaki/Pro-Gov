package com.progov.ui;

import com.progov.app.App;
import com.progov.model.Budget;
import com.progov.service.BudgetService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BudgetResultsView {

    private static final BudgetService service = new BudgetService();

    public static Scene createScene() {
        Budget b = service.getBudget();

        Label title = new Label("Υπολογισμοί Προϋπολογισμού");
        Label rev = new Label("Σύνολο Εσόδων: " + b.totalRevenue());
        Label exp = new Label("Σύνολο Εξόδων: " + b.totalExpenses());
        Label bal = new Label("Ισοζύγιο (Έσοδα - Έξοδα): " + b.balance());

        Button constraints = new Button("Έλεγχος Περιορισμών");
        Button back = new Button("Πίσω");

        constraints.setOnAction(e ->
            App.setScene(ConstraintsView.createScene())
        );

        back.setOnAction(e ->
            App.setScene(EditorMenuView.createScene())
        );

        VBox root = new VBox(10, title, rev, exp, bal, constraints, back);
        root.setPadding(new Insets(20));

        return new Scene(root, 480, 280);
    }
}
