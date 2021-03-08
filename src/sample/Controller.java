package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.ResourceBundle;


public class Controller implements Initializable {
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
    @Override
    public void initialize(URL location, ResourceBundle resources){
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


    @SuppressWarnings("FieldMayBeFinal")
    @FXML
    private ListView<String> listView = new ListView<>();

    @FXML
    private void newGame() {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane root = fxmlLoader.load(getClass().getResource("C:\\Users\\DELL\\IdeaProjects\\guessThePokemon\\src\\sample\\createNewGame.fxml").openStream());
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }

    @FXML
    private void leaderBoards(){

    }

    @FXML
    private void selectElementOfList() {

    }


}
