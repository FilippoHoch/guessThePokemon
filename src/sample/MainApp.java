package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene sample = new Scene(root);

        primaryStage.setScene(sample);

        primaryStage.setResizable(false);

        primaryStage.setTitle("Guess the Pokemon");
        primaryStage.show();
    }
}
