package com.progov.ui;

import com.progov.app.App;
import com.progov.model.BudgetData;
import com.progov.model.BudgetItem;
import com.progov.service.BudgetDataService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BudgetInputView {

    private static final BudgetDataService service = new BudgetDataService();

    private static double parseOrZero(String s) {
        if (s == null) return 0;
        s = s.trim().replace(",", ".");
        if (s.isEmpty()) return 0;
        return Double.parseDouble(s);
    }

    private static String eurM(double v) {
        return String.format("€%,.0fM", v);
    }

    public static Scene createScene() {
        BudgetData data = service.load();

        VBox content = new VBox(14);
        content.getStyleClass().add("content-wrap");

        Label title = new Label("Εισαγωγή / Τροποποίηση (Κατηγορίες)");
        title.getStyleClass().add("h1");

        Label msg = new Label();

        // Inputs revenue
        TextField revName = new TextField();
        revName.setPromptText("Κατηγορία Εσόδου");
        TextField revAmt = new TextField();
        revAmt.setPromptText("Ποσό (σε εκατ. €)");

        Button addRev = new Button("Προσθήκη Εσόδου");
        addRev.setOnAction(e -> {
            try {
                service.addRevenue(data, revName.getText().trim(), parseOrZero(revAmt.getText()));
                App.setScene(BudgetInputView.createScene());
            } catch (Exception ex) {
                msg.setText("Σφάλμα: βάλε σωστό όνομα και αριθμό.");
            }
        });

        // Inputs expense
        TextField expName = new TextField();
        expName.setPromptText("Κατηγορία Εξόδου");
        TextField expAmt = new TextField();
        expAmt.setPromptText("Ποσό (σε εκατ. €)");

        Button addExp = new Button("Προσθήκη Εξόδου");
        addExp.setOnAction(e -> {
            try {
                service.addExpense(data, expName.getText().trim(), parseOrZero(expAmt.getText()));
                App.setScene(BudgetInputView.createScene());
            } catch (Exception ex) {
                msg.setText("Σφάλμα: βάλε σωστό όνομα και αριθμό.");
            }
        });

        // Lists
        VBox revList = new VBox(6);
        revList.getChildren().add(new Label("Έσοδα:"));
        for (BudgetItem i : data.revenues) {
            Button del = new Button("Διαγραφή");
            del.setOnAction(e -> { service.deleteRevenue(data, i.id); App.setScene(BudgetInputView.createScene()); });
            HBox row = new HBox(10, new Label(i.name + " = " + eurM(i.amount)), del);
            revList.getChildren().add(row);
        }

        VBox expList = new VBox(6);
        expList.getChildren().add(new Label("Έξοδα:"));
        for (BudgetItem i : data.expenses) {
            Button del = new Button("Διαγραφή");
            del.setOnAction(e -> { service.deleteExpense(data, i.id); App.setScene(BudgetInputView.createScene()); });
            HBox row = new HBox(10, new Label(i.name + " = " + eurM(i.amount)), del);
            expList.getChildren().add(row);
        }

        Label totals = new Label("Σύνολα: Έσοδα=" + eurM(data.totalRevenue()) +
                " | Έξοδα=" + eurM(data.totalExpenses()) +
                " | Ισοζύγιο=" + eurM(data.balance()));

        Button results = new Button("Υπολογισμοί");
        results.setOnAction(e -> App.setScene(BudgetResultsView.createScene()));

        Button back = new Button("Πίσω");
        back.setOnAction(e -> App.setScene(EditorMenuView.createScene()));

        content.getChildren().addAll(
                title,
                new Label("Προσθήκη εσόδου:"), new HBox(10, revName, revAmt), addRev,
                new Separator(),
                new Label("Προσθήκη εξόδου:"), new HBox(10, expName, expAmt), addExp,
                new Separator(),
                totals,
                new Separator(),
                revList,
                new Separator(),
                expList,
                new Separator(),
                results, back, msg
        );

        content.setPadding(new Insets(10));

        var root = AppShell.wrap("Επεξεργασία", content, true);
        return new Scene(root, 1000, 650);
    }
}
