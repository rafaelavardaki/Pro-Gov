package com.progov.ui;

import com.progov.service.AuthService;
import com.progov.app.App;
import com.progov.service.BudgetStore;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class EditorWebView {

    private static final BudgetStore store = new BudgetStore();
    private static final Bridge BRIDGE = new Bridge();
    private static final AuthService auth = new AuthService();

    public static Scene createScene() {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        var url = EditorWebView.class.getResource("/web/editor.html");
        if (url == null) throw new IllegalStateException("Missing /web/editor.html");
        engine.load(url.toExternalForm());

        engine.getLoadWorker().stateProperty().addListener((obs, old, state) -> {
            System.out.println("EDITOR WEB LOAD = " + state);
            if (state == Worker.State.SUCCEEDED) {
                JSObject window = (JSObject) engine.executeScript("window");
                window.setMember("bridge", BRIDGE);
                System.out.println("EDITOR BRIDGE BINDED");
            }
        });


        return new Scene(webView, 1200, 750);
    }

    public static class Bridge {
        public void logout() { App.showMainMenu(); }

        // 1) δώσε στο JS το τρέχον budget (JSON string)
        public String loadBudgetJson() { return store.loadJson(); }

        // 2) πάρε από JS το νέο budget (JSON string) και αποθήκευσέ το
        public void saveBudgetJson(String json) { store.saveJson(json); }

        // constraints: ίδιοι κανόνες με HTML (ενδεικτικά)
        public boolean passesConstraints(String json) {
            var data = new com.google.gson.Gson().fromJson(json, com.progov.model.BudgetData.class);
            if (data == null) return false;

            double rev = data.totalRevenue();
            double exp = data.totalExpenses();

            // Rule1: expenses <= 105% revenues
            if (rev > 0 && exp > rev * 1.05) return false;

            // Rule3: reserve >= 10% revenues  => balance >= 10% of revenues
            double bal = rev - exp;
            if (rev > 0 && bal < rev * 0.10) return false;

            // Rule2: no single expense > 30% of total expenses
            if (exp > 0) {
                for (var item : data.expenses) {
                    if (item.amount > exp * 0.30) return false;
                }
            }
            return true;
        }
        public boolean login(String role, String usernameOrPan, String password) {
            if ("editor".equals(role)) {
                return auth.loginEditor(usernameOrPan, password);
            }
            if ("citizen".equals(role)) {
                return auth.loginCitizen(usernameOrPan, password);
            }
            return false;
        }

    }
}
