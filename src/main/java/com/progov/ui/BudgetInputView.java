package com.progov.ui;

import com.progov.app.App;
import com.progov.model.Budget;
import com.progov.service.BudgetService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BudgetInputView {

    private static final BudgetService service = new BudgetService();

    private static double parseOrZero(String s) {
        if (s == null) return 0;
        s = s.trim().replace(",", "."); // βοηθάει αν γράψεις 10,5
        if (s.isEmpty()) return 0;
        return Double.parseDouble(s);
    }

    public static Scene createScene() {
        Budget b = service.getBudget();

        Label title = new Label("Εισαγωγή Εσόδων / Εξόδων");
        Label msg = new Label();

        TextField tfIncomeTax = new TextField(String.valueOf(b.getIncomeTax()));
        TextField tfVat = new TextField(String.valueOf(b.getVat()));
        TextField tfOtherRev = new TextField(String.valueOf(b.getOtherRevenue()));

        TextField tfSalaries = new TextField(String.valueOf(b.getSalaries()));
        TextField tfPensions = new TextField(String.valueOf(b.getPensions()));
        TextField tfOtherExp = new TextField(String.valueOf(b.getOtherExpenses()));

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        int r = 0;
        grid.add(new Label("Έσοδα - Φόρος Εισοδήματος"), 0, r); grid.add(tfIncomeTax, 1, r++);
        grid.add(new Label("Έσοδα - ΦΠΑ"), 0, r); grid.add(tfVat, 1, r++);
        grid.add(new Label("Έσοδα - Άλλα"), 0, r); grid.add(tfOtherRev, 1, r++);

        grid.add(new Separator(), 0, r++, 2, 1);

        grid.add(new Label("Έξοδα - Μισθοί"), 0, r); grid.add(tfSalaries, 1, r++);
        grid.add(new Label("Έξοδα - Συντάξεις"), 0, r); grid.add(tfPensions, 1, r++);
        grid.add(new Label("Έξοδα - Άλλα"), 0, r); grid.add(tfOtherExp, 1, r++);

        Button save = new Button("Αποθήκευση");
        Button calc = new Button("Υπολογισμοί");
        Button back = new Button("Πίσω");

        save.setOnAction(e -> {
            try {
                b.setIncomeTax(parseOrZero(tfIncomeTax.getText()));
                b.setVat(parseOrZero(tfVat.getText()));
                b.setOtherRevenue(parseOrZero(tfOtherRev.getText()));

                b.setSalaries(parseOrZero(tfSalaries.getText()));
                b.setPensions(parseOrZero(tfPensions.getText()));
                b.setOtherExpenses(parseOrZero(tfOtherExp.getText()));

                msg.setText("Αποθηκεύτηκε.");
            } catch (Exception ex) {
                msg.setText("Σφάλμα: βάλε μόνο αριθμούς.");
            }
        });

        calc.setOnAction(e -> App.setScene(BudgetResultsView.createScene()));
        back.setOnAction(e -> App.setScene(EditorMenuView.createScene()));

        VBox root = new VBox(12, title, grid, new VBox(8, save, calc, back), msg);
        root.setPadding(new Insets(20));
        return new Scene(root, 620, 420);
    }
}
