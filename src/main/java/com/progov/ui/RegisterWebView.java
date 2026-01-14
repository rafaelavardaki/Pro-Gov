package com.progov.ui;

import com.progov.service.AuthService;
import com.progov.app.App;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class RegisterWebView {

    private static final Bridge BRIDGE = new Bridge();
    private static final AuthService auth = new AuthService();


    public static Scene createScene() {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();

        var url = RegisterWebView.class.getResource("/web/register.html");
        if (url == null) throw new IllegalStateException("Missing /web/register.html");
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
        public void backToLanding() { App.showMainMenu(); }

        public String registerCitizen(String pan, String password) {
            return auth.registerCitizen(pan, password);
        }
    }
}
