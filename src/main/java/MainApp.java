import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        Button b = new Button("Πάτα με");
        b.setOnAction(e -> System.out.println("JavaFX δουλεύει!"));

        stage.setScene(new Scene(new StackPane(b), 300, 200));
        stage.setTitle("Pro-Gov GUI");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
