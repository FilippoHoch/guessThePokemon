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

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class sampleController {


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

    public ListOfPokemon conversion = new ListOfPokemon();
    public Image[] imagesSprite = new Image[900];
    public boolean firstTime = true;
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

    public static int nTry = 0;
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
        if (firstTime) {
            firstTime = false;
            for (int i = 0; i < ListOfPokemon.pokemonArrayList.size(); i++) {
                listView.getItems().add(ListOfPokemon.pokemonArrayList.get(i).getName());

                Path imageFileSprite = Paths.get(
                        "src/sample/img/pokemonSpriteDataBase/" +
                                ListOfPokemon.pokemonArrayList.get(i).getName().toLowerCase() + ".png");
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
                            for (int j = 0; j < ListOfPokemon.pokemonArrayList.size(); j++) {
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
        stage.setOnHiding(event -> {
            startGame();
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
            showParameter(9);
        } else {
            nTry++;
            showParameter(nTry);
        }

    }

    public void showParameter(int i) {
        if (i >= 10) {
        } else if (i > 0) {
            weight.setText(String.valueOf(randomPokemon.getWeight()));
            height.setText(String.valueOf(randomPokemon.getHeight()));
            if (i > 1) {
                type.setText(randomPokemon.getType1());
                if (i > 2) {
                    evolutionStep.setText(String.valueOf(randomPokemon.getEvoPhase()));
                    if (i > 3) {
                        type.setText(type.getText().concat(", " + randomPokemon.getType2()));
                        if (i > 4) {
                            rarity.setText(randomPokemon.getRarity());
                            if (i > 5) {
                                footprint.setImage(new Image(
                                        new File("src/sample/img/footprints/" + randomPokemon.getId() + ".png").toURI()
                                                .toString()));
                                outline.setImage(ListOfPokemon.pokemonShape.get(randomPokemon.getId() - 1));
                                if (i > 6) {
                                    ability.setText(randomPokemon.randomAbility);
                                    if (i > 7) {
                                        String url;
                                        if (randomPokemon.getId() + 1 < 10) {
                                            url = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/00" +
                                                    (randomPokemon.getId()) + ".png";
                                        } else if (randomPokemon.getId() + 1 < 100) {
                                            url = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/0" +
                                                    (randomPokemon.getId()) + ".png";
                                        } else {
                                            url = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/" +
                                                    (randomPokemon.getId()) + ".png";
                                        }
                                        artwork.setImage(new Image(url));
                                        if (i > 8) {
                                            cover.setImage(new Image(new File(
                                                    "src/sample/img/GameCover/cover" + randomPokemon.getGeneration() +
                                                            "generation.jpg").toURI().toString()));
                                            animatedSprite.setImage(new Image(
                                                    "https://play.pokemonshowdown.com/sprites/bwani/" +
                                                            randomPokemon.getName().toLowerCase() + ".gif"));
                                            name.setText(randomPokemon.getName());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void startGame() {
        nTry=0;
        ListOfPokemon.filteredPokemonArrayList = conversion.filteredPokemons();
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
