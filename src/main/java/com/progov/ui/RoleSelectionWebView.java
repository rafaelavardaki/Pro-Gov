package com.progov.ui;

import com.progov.app.App;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class RoleSelectionWebView {

    private static final Bridge BRIDGE = new Bridge();

    public static Scene createScene() {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        // Φόρτωσε το HTML από resources ώστε να δουλεύουν και σχετικές εικόνες (logo.png)
        var url = RoleSelectionWebView.class.getResource("/web/landing.html");
        if (url == null) throw new IllegalStateException("Missing /web/landing.html");
        engine.load(url.toExternalForm());

        engine.getLoadWorker().stateProperty().addListener((obs, old, state) -> {
            if (state == Worker.State.SUCCEEDED) {
                JSObject window = (JSObject) engine.executeScript("window");
                window.setMember("bridge", BRIDGE);
            }
        });

        return new Scene(webView, 1000, 650);
    }

    public static class Bridge {
        public void goCitizen() { App.setScene(CitizenView.createScene()); }
        public void goEditor()  { App.setScene(EditorWebView.createScene()); }
        public void exit()      { System.exit(0); }
        public void goRegister() { App.setScene(RegisterWebView.createScene()); }
    }
}
