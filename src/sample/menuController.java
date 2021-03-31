package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static sample.sampleController.work;

public class menuController {
    @FXML
    private ImageView cover;
    @FXML
    private ImageView logo;

    @FXML
    public void initialize() {
        logo.setImage(new Image(new File("src/sample/img/logo.png").toURI().toString()));
        cover.setImage(new Image(new File("src/sample/img/coverAnimated.gif").toURI().toString()));
    }

    @FXML
    public void help() throws Exception{
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/FilippoHoch/guessThePokemon").toURI());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void leaderboard() throws  Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/ranking.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Leader Board");
        Stage currentStage = (Stage) logo.getScene().getWindow();
        stage.initOwner(currentStage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void newGame() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/createNewGame.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("New Game");
        Stage currentStage = (Stage) logo.getScene().getWindow();
        stage.initOwner(currentStage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.show();
    }
}
