package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;


public class sampleController implements Initializable {


    @FXML
    public Label weight;
    @FXML
    public Label height;
    @FXML
    public Label type;
    @FXML
    public Label evolutionStep;
    @FXML
    public Label ability;
    @FXML
    public Label generation;

    public ListOfPokemon conversion = new ListOfPokemon();
    public Image[] imagesSprite = new Image[900];
    public boolean firstTime = true;
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
        conversion.excelReading();
        weight.setText("???");
        height.setText("???");
        type.setText("???");
        evolutionStep.setText("???");
        ability.setText("???");

    }

    @FXML
    private void newGame() throws IOException {
        if (firstTime) {
            firstTime = false;
            for (int i = 0; i < conversion.pokemonArrayList.size(); i++) {
                listView.getItems().add(conversion.pokemonArrayList.get(i).getName());

                Path imageFileSprite = Paths.get(
                        "src/sample/img/pokemonSpriteDataBase/" +
                                conversion.pokemonArrayList.get(i).getName().toLowerCase() + ".png");
                try {
                    imagesSprite[i] = new Image(imageFileSprite.toUri().toURL().toExternalForm());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                listView.setCellFactory(param -> new ListCell<>() {
                    private final ImageView imageView = new ImageView();

                    @Override
                    public void updateItem(String name, boolean empty) {
                        super.updateItem(name, empty);
                        if (empty) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            for (int j = 0; j < conversion.pokemonArrayList.size(); j++) {
                                if (conversion.nameToInt(name) == j) {
                                    imageView.setImage(imagesSprite[j]);
                                }
                            }
                            setText(name);
                            setGraphic(imageView);
                        }
                    }
                });
            }
        }
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

    @FXML
    private void leaderBoards() throws IOException {
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
    private void selectElementOfList() {

    }

    public void startGame(){
        Pokemon randomPokemon = conversion.takeRandomPokemon();
        generation.setText(String.valueOf(randomPokemon.getGeneration()));
    }

}
