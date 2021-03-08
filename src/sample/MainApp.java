package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root2 = FXMLLoader.load(getClass().getResource("sample/createNewGame.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getResource("sample/ranking.fxml"));

        Scene sample = new Scene(root);
        Scene createNewGame = new Scene(root2);
        Scene ranking = new Scene(root3);
        primaryStage.setScene(sample);
        Stage newGameStage = new Stage();
        newGameStage.setScene(createNewGame);
        Stage rankingStage = new Stage();
        rankingStage.setScene(ranking);
        primaryStage.setResizable(false);
        newGameStage.setResizable(false);
        rankingStage.setResizable(false);
        primaryStage.setTitle("Guess the Pokemon");
        newGameStage.setTitle("New Game");
        rankingStage.setTitle("Ranking");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
