package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;


public class sampleController {

    public static boolean work = false;
    public static boolean endGame = true;
    public static ListOfPokemon conversion = new ListOfPokemon();
    public static int nTry = 0;
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
    @FXML
    public Label rarity;
    @FXML
    public Label name;
    public Image[] imagesSprite = new Image[900];
    public Pokemon randomPokemon;
    @FXML
    public ImageView artwork;
    @FXML
    public ImageView outline;
    @FXML
    public ImageView animatedSprite;
    @FXML
    public ImageView footprint;
    @FXML
    public ImageView cover;
    @FXML
    private ImageView logo;
    @SuppressWarnings("FieldMayBeFinal")
    @FXML
    private ListView<String> listView = new ListView<>();

    @FXML
    public void initialize() {
        Image unknownImage = new Image(new File("src/sample/img/unknown.png").toURI().toString());
        logo.setImage(new Image(new File("src/sample/img/logo.png").toURI().toString()));
        cover.setImage(new Image(new File("src/sample/img/coverAnimated.gif").toURI().toString()));
        footprint.setImage(unknownImage);
        animatedSprite.setImage(unknownImage);
        outline.setImage(unknownImage);
        conversion.excelReading();
    }

    @FXML
    private void newGame() throws IOException {
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
        stage.setOnHiding(event -> {
            if (work)
                startGame();
            work = false;
        });
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
        String pokemonChoices = listView.getSelectionModel().selectedItemProperty().getValue();
        if (pokemonChoices.equalsIgnoreCase(randomPokemon.getName())) {
            endGame = true;
            showParameter(10);
        } else {
            nTry++;
            if (nTry >= 9) {
                endGame = true;
            }

            showParameter(nTry);
        }

    }

    @FXML
    private void help() {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/FilippoHoch/guessThePokemon").toURI());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public void showParameter(int i) {
        switch (i) {
            case 10:
                endGame = true;
                cover.setImage(new Image(
                        new File("src/sample/img/GameCover/cover" + randomPokemon.getGeneration() + "generation.jpg")
                                .toURI().toString()));
                animatedSprite.setImage(new Image(
                        "https://play.pokemonshowdown.com/sprites/bwani/" + randomPokemon.getName().toLowerCase() +
                                ".gif"));
                name.setText(randomPokemon.getName());
                if (!rankingController.users.isEmpty())
                    rankingController.users.get(rankingController.users.size() - 1).setScore();
            case 9:
                String url;
                if (randomPokemon.getId() + 1 < 10) {
                    url = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/00" + (randomPokemon.getId()) +
                            ".png";
                } else if (randomPokemon.getId() + 1 < 100) {
                    url = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/0" + (randomPokemon.getId()) +
                            ".png";
                } else {
                    url = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/" + (randomPokemon.getId()) + ".png";
                }
                artwork.setImage(new Image(url));
            case 8:
                ability.setText(randomPokemon.randomAbility);
            case 7:
                footprint.setImage(new Image(
                        new File("src/sample/img/footprints/" + randomPokemon.getId() + ".png").toURI().toString()));
                outline.setImage(ListOfPokemon.pokemonShape.get(randomPokemon.getId() - 1));
            case 6:
                rarity.setText(randomPokemon.getRarity());
            case 5:
                type.setText(randomPokemon.getType1() + ", " + randomPokemon.getType2());
            case 4:
                evolutionStep.setText(String.valueOf(randomPokemon.getEvoPhase()));
            case 3:
                type.setText(type.getText().replace("???", randomPokemon.getType1()));
            case 2:
                height.setText(String.valueOf(randomPokemon.getHeight()));
                weight.setText(String.valueOf(randomPokemon.getWeight()));
        }
    }

    public void startGame() {
        endGame = false;
        listView.getItems().clear();
        for (int i = 0; i < ListOfPokemon.filteredPokemonArrayList.size(); i++) {
            listView.getItems().add(ListOfPokemon.filteredPokemonArrayList.get(i).getName());

            Path imageFileSprite = Paths.get(
                    "src/sample/img/pokemonSpriteDataBase/" +
                            ListOfPokemon.filteredPokemonArrayList.get(i).getName().toLowerCase() + ".png");
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
                        for (int j = 0; j < ListOfPokemon.filteredPokemonArrayList.size(); j++) {
                            if (ListOfPokemon.filteredPokemonArrayList.get(j).getName().equals(name)) {
                                imageView.setImage(imagesSprite[j]);
                            }
                        }
                        setText(name);
                        setGraphic(imageView);
                    }
                }
            });
        }
        nTry = 1;
        randomPokemon = conversion.takeRandomPokemon();
        randomPokemon.randomAbility = conversion.randomAbility(randomPokemon);
        generation.setText(Integer.toString(randomPokemon.getGeneration()));
        Image unknownImage = new Image(new File("src/sample/img/unknown.png").toURI().toString());
        cover.setImage(new Image(new File("src/sample/img/coverAnimated.gif").toURI().toString()));
        footprint.setImage(unknownImage);
        animatedSprite.setImage(unknownImage);
        outline.setImage(unknownImage);
        artwork.setImage(null);
        weight.setText("???");
        height.setText("???");
        type.setText("???");
        ability.setText("???");
        rarity.setText("???");
        evolutionStep.setText("???");
        name.setText("???");


    }
}
