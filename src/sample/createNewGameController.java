package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static sample.sampleController.conversion;

public class createNewGameController implements Initializable {

    public static ArrayList<Boolean> generationResult = new ArrayList<>();
    public static ArrayList<Boolean> evolutionStepResult = new ArrayList<>();
    public static ArrayList<Boolean> rarityResult = new ArrayList<>();
    public String activeUserText;
    public User activeUser;
    //Generation
    CheckBox gen1CheckBox = new CheckBox("Generation 1");
    CustomMenuItem gen1Item = new CustomMenuItem(gen1CheckBox);
    CheckBox gen2CheckBox = new CheckBox("Generation 2");
    CustomMenuItem gen2Item = new CustomMenuItem(gen2CheckBox);
    CheckBox gen3CheckBox = new CheckBox("Generation 3");
    CustomMenuItem gen3Item = new CustomMenuItem(gen3CheckBox);
    CheckBox gen4CheckBox = new CheckBox("Generation 4");
    CustomMenuItem gen4Item = new CustomMenuItem(gen4CheckBox);
    CheckBox gen5CheckBox = new CheckBox("Generation 5");
    CustomMenuItem gen5Item = new CustomMenuItem(gen5CheckBox);
    CheckBox gen6CheckBox = new CheckBox("Generation 6");
    CustomMenuItem gen6Item = new CustomMenuItem(gen6CheckBox);
    //Evolution step
    CheckBox baseCheckBox = new CheckBox("Base");
    CustomMenuItem baseItem = new CustomMenuItem(baseCheckBox);
    CheckBox phase1CheckBox = new CheckBox("First evolution");
    CustomMenuItem phase1Item = new CustomMenuItem(phase1CheckBox);
    CheckBox phase2CheckBox = new CheckBox("Second evolution");
    CustomMenuItem phase2Item = new CustomMenuItem(phase2CheckBox);
    //Rarity
    CheckBox starterCheckBox = new CheckBox("Starter");
    CustomMenuItem starterItem = new CustomMenuItem(starterCheckBox);
    CheckBox commonCheckBox = new CheckBox("Common");
    CustomMenuItem commonItem = new CustomMenuItem(commonCheckBox);
    CheckBox fossilCheckBox = new CheckBox("Fossil");
    CustomMenuItem fossilItem = new CustomMenuItem(fossilCheckBox);
    CheckBox legendaryCheckBox = new CheckBox("Legendary");
    CustomMenuItem legendaryItem = new CustomMenuItem(legendaryCheckBox);
    CheckBox semiLegendaryCheckBox = new CheckBox("Semi-legendary");
    CustomMenuItem semiLegendaryItem = new CustomMenuItem(semiLegendaryCheckBox);
    CheckBox mysteriousCheckBox = new CheckBox("Mysterious");
    CustomMenuItem mysteriousItem = new CustomMenuItem(mysteriousCheckBox);
    @FXML
    private Button cancel;

    @FXML
    private ImageView createNewGameImage;

    @FXML
    private TextField nicknameField;

    @FXML
    private MenuButton generation;

    @FXML
    private MenuButton evolutionStep;

    @FXML
    private MenuButton rarity;

    @FXML
    private Label noArguments;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File logoFile = new File("src/sample/img/createNewGame.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        createNewGameImage.setImage(logoImage);
        gen1Item.setHideOnClick(false);
        gen1CheckBox.setSelected(true);

        gen2Item.setHideOnClick(false);
        gen2CheckBox.setSelected(true);

        gen3Item.setHideOnClick(false);
        gen3CheckBox.setSelected(true);

        gen4Item.setHideOnClick(false);
        gen4CheckBox.setSelected(true);

        gen5Item.setHideOnClick(false);
        gen5CheckBox.setSelected(true);

        gen6Item.setHideOnClick(false);
        gen6CheckBox.setSelected(true);
        generation.getItems().setAll(gen1Item, gen2Item, gen3Item, gen4Item, gen5Item, gen6Item);

        baseItem.setHideOnClick(false);
        baseCheckBox.setSelected(true);

        phase1Item.setHideOnClick(false);
        phase1CheckBox.setSelected(true);

        phase2Item.setHideOnClick(false);
        phase2CheckBox.setSelected(true);
        evolutionStep.getItems().setAll(baseItem, phase1Item, phase2Item);

        starterItem.setHideOnClick(false);
        starterCheckBox.setSelected(true);

        commonItem.setHideOnClick(false);
        commonCheckBox.setSelected(true);

        fossilItem.setHideOnClick(false);
        fossilCheckBox.setSelected(true);

        legendaryItem.setHideOnClick(false);
        legendaryCheckBox.setSelected(true);

        semiLegendaryItem.setHideOnClick(false);
        semiLegendaryCheckBox.setSelected(true);

        mysteriousItem.setHideOnClick(false);
        mysteriousCheckBox.setSelected(true);
        rarity.getItems().setAll(starterItem, commonItem, fossilItem, legendaryItem, semiLegendaryItem, mysteriousItem);
    }

    @FXML
    private void confirm() {
        generationResult.clear();
        generationResult.add(gen1CheckBox.isSelected());
        generationResult.add(gen2CheckBox.isSelected());
        generationResult.add(gen3CheckBox.isSelected());
        generationResult.add(gen4CheckBox.isSelected());
        generationResult.add(gen5CheckBox.isSelected());
        generationResult.add(gen6CheckBox.isSelected());
        evolutionStepResult.clear();
        evolutionStepResult.add(baseCheckBox.isSelected());
        evolutionStepResult.add(phase1CheckBox.isSelected());
        evolutionStepResult.add(phase2CheckBox.isSelected());
        rarityResult.clear();
        rarityResult.add(starterCheckBox.isSelected());
        rarityResult.add(commonCheckBox.isSelected());
        rarityResult.add(fossilCheckBox.isSelected());
        rarityResult.add(legendaryCheckBox.isSelected());
        rarityResult.add(semiLegendaryCheckBox.isSelected());
        rarityResult.add(mysteriousCheckBox.isSelected());
        Stage stage = (Stage) cancel.getScene().getWindow();
        activeUserText = nicknameField.getText();
        noArguments.setText("");
        if (activeUserText.isEmpty()) {
            nicknameField.setPromptText("Missing Nickname");
        } else if (checkGeneration() || checkEvolutionStep() || checkRarity()) {
            noArguments.setText("");
            boolean temp = checkGeneration();
            temp = checkEvolutionStep();
            temp = checkRarity();
        } else {
            ListOfPokemon.filteredPokemonArrayList = conversion.filteredPokemons();
            activeUser = new User(activeUserText);
            //activeUser.setScore();
            activeUser.setSettings();
            rankingController.users.add(activeUser);
            sampleController.work = true;
            stage.close();
        }
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public boolean checkGeneration() {

        if (!gen1CheckBox.isSelected() && !gen2CheckBox.isSelected() && !gen3CheckBox.isSelected() &&
                !gen4CheckBox.isSelected() && !gen5CheckBox.isSelected() && !gen6CheckBox.isSelected()) {
            noArguments.setText("No arguments selected for Generation");
            return true;
        }
        return false;
    }

    public boolean checkEvolutionStep() {
        if (!baseCheckBox.isSelected() && !phase1CheckBox.isSelected() && !phase2CheckBox.isSelected()) {
            if (noArguments.getText().equals("No arguments selected for Generation"))
                noArguments.setText(noArguments.getText().concat(", Evolution step"));
            else
                noArguments.setText("No arguments selected for Evolution step");
            return true;
        }
        return false;
    }

    public boolean checkRarity() {
        if (!starterCheckBox.isSelected() && !commonCheckBox.isSelected() && !fossilCheckBox.isSelected() &&
                !legendaryCheckBox.isSelected() && !semiLegendaryCheckBox.isSelected() &&
                !mysteriousCheckBox.isSelected()) {
            if (noArguments.getText().equals("No arguments selected for Generation, Evolution step") ||
                    noArguments.getText().equals("No arguments selected for Evolution step")) {
                noArguments.setText(noArguments.getText().concat(", Rarity"));
            } else if (noArguments.getText().equals("No arguments selected for Generation"))
                noArguments.setText(noArguments.getText().concat(", Rarity"));
            else
                noArguments.setText("No arguments selected for Rarity");
            return true;
        }
        return false;
    }
}
