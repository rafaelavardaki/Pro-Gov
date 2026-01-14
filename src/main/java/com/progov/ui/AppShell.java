package com.progov.ui;

import com.progov.app.App;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class AppShell {

    public static BorderPane wrap(String titleText, Node content, boolean showBackToHome) {
        // ===== Header (Navbar) =====
        HBox nav = new HBox(10);
        nav.setPadding(new Insets(12, 18, 12, 18));
        nav.setAlignment(Pos.CENTER_LEFT);
        nav.getStyleClass().add("navfx");

        ImageView logo = new ImageView(new Image(AppShell.class.getResourceAsStream("/images/logo.png")));
        logo.setFitWidth(34);
        logo.setFitHeight(34);
        logo.setPreserveRatio(true);
        logo.getStyleClass().add("navfx-logo");

        Label brand = new Label("Pro-GOV");
        brand.getStyleClass().add("navfx-brand");

        Label pageTitle = new Label(titleText);
        pageTitle.getStyleClass().add("navfx-title");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button homeBtn = new Button("Αρχική");
        homeBtn.getStyleClass().add("navfx-btn");
        homeBtn.setOnAction(e -> App.showMainMenu());

        nav.getChildren().addAll(logo, brand, pageTitle, spacer);
        if (showBackToHome) nav.getChildren().add(homeBtn);

        // ===== Center (scrollable) =====
        ScrollPane sp = new ScrollPane(content);
        sp.setFitToWidth(true);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.getStyleClass().add("page-scroll");

        // ===== Footer =====
        HBox footer = new HBox();
        footer.setPadding(new Insets(10, 18, 10, 18));
        footer.setAlignment(Pos.CENTER);
        footer.getStyleClass().add("footerfx");

        Label foot = new Label("© 2026 Pro-GOV");
        foot.getStyleClass().add("footerfx-text");
        footer.getChildren().add(foot);

        // ===== Root =====
        BorderPane root = new BorderPane(sp);
        root.setTop(nav);
        root.setBottom(footer);
        root.getStyleClass().add("appfx-root");

        return root;
    }
}
