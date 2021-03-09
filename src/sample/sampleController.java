package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class sampleController implements Initializable {

    @FXML
    private Label generation;
    @FXML
    private Label weight;
    @FXML
    private Label height;
    @FXML
    private Label type;
    @FXML
    private Label evolutionStep;
    @FXML
    private Label ability;
    @FXML
    private ImageView outline;
    @FXML
    private ImageView animatedSprite;
    @FXML
    private ImageView footprint;
    @FXML
    private ImageView artwork;
    @FXML
    private ImageView cover;
    @FXML
    private ImageView logo;
    @SuppressWarnings("FieldMayBeFinal")
    @FXML
    private ListView<String> listView = new ListView<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File logoFile = new File("src/sample/img/logo.png");
        File coverAnimatedFile = new File("src/sample/img/coverAnimated.gif");
        File unknownFile = new File("src/sample/img/unknown.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        Image coverAnimatedImage = new Image(coverAnimatedFile.toURI().toString());
        Image unknownImage = new Image(unknownFile.toURI().toString());
        logo.setImage(logoImage);
        cover.setImage(coverAnimatedImage);
        footprint.setImage(unknownImage);
        animatedSprite.setImage(unknownImage);
        outline.setImage(unknownImage);
    }

    @FXML
    private void newGame(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/createNewGame.fxml"));
        Parent root = loader.load();
        createNewGameController sceneController = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("New Game");
        Stage currentStage = (Stage) logo.getScene().getWindow();
        stage.initOwner(currentStage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();

    }

    @FXML
    private void leaderBoards(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/ranking.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Leader Board");
        Stage currentStage = (Stage) logo.getScene().getWindow();
        stage.initOwner(currentStage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    @FXML
    private void selectElementOfList() {

    }
}
