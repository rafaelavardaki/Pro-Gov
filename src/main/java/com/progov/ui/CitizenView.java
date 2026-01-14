package com.progov.ui;

import com.progov.app.App;
import com.progov.model.BudgetData;
import com.progov.model.BudgetItem;
import com.progov.service.BudgetDataService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class CitizenView {

    private static final BudgetDataService service = new BudgetDataService();

    private static String eurM(double v) {
        return String.format("€%,.0fM", v);
    }

    private static VBox section(String title, java.util.List<BudgetItem> items) {
        VBox box = new VBox(6);
        Label t = new Label(title);
        t.getStyleClass().add("h2");
        box.getChildren().add(t);

        for (BudgetItem i : items) {
            box.getChildren().add(new Label("• " + i.name + " = " + eurM(i.amount)));
        }
        return box;
    }

    public static Scene createScene() {
        BudgetData data = service.load();

        VBox content = new VBox(12);
        content.getStyleClass().add("content-wrap");

        Label title = new Label("Κρατικός Προϋπολογισμός (Πολίτης)");
        title.getStyleClass().add("h1");

        Label totals = new Label(
                "Σύνολα: Έσοδα=" + eurM(data.totalRevenue()) +
                        " | Έξοδα=" + eurM(data.totalExpenses()) +
                        " | Ισοζύγιο=" + eurM(data.balance())
        );

        Button back = new Button("Πίσω");
        back.setOnAction(e -> App.showMainMenu());

        content.getChildren().addAll(
                title,
                totals,
                new Separator(),
                section("Έσοδα", data.revenues),
                new Separator(),
                section("Έξοδα", data.expenses),
                new Separator(),
                back
        );

        var root = AppShell.wrap("Πολίτης", content, true);
        return new Scene(root, 1000, 650);
    }
}
