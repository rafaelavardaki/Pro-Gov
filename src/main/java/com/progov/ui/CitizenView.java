package com.progov.ui;

import com.progov.app.App;
import com.progov.model.Budget;
import com.progov.service.BudgetService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CitizenView {

    private static final BudgetService service = new BudgetService();

    public static Scene createScene() {
        Budget b = service.getBudget();

        Label title = new Label("Κρατικός Προϋπολογισμός (Πολίτης)");

        Label rev1 = new Label("Έσοδα: Φόρος Εισοδήματος = " + b.getIncomeTax());
        Label rev2 = new Label("Έσοδα: ΦΠΑ = " + b.getVat());
        Label rev3 = new Label("Έσοδα: Άλλα = " + b.getOtherRevenue());

        Label exp1 = new Label("Έξοδα: Μισθοί = " + b.getSalaries());
        Label exp2 = new Label("Έξοδα: Συντάξεις = " + b.getPensions());
        Label exp3 = new Label("Έξοδα: Άλλα = " + b.getOtherExpenses());

        Label totals = new Label("Σύνολα: Έσοδα=" + b.totalRevenue() + " | Έξοδα=" + b.totalExpenses() + " | Ισοζύγιο=" + b.balance());

        Button back = new Button("Πίσω");
        back.setOnAction(e -> App.showMainMenu());

        VBox root = new VBox(8, title, rev1, rev2, rev3, new Label("—"), exp1, exp2, exp3, new Label("—"), totals, back);
        root.setPadding(new Insets(20));
        return new Scene(root, 620, 420);
    }
}
