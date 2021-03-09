package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class rankingController implements Initializable {
    @FXML
    private ImageView leaderBoard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File logoFile = new File("src/sample/img/ranking.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        leaderBoard.setImage(logoImage);
    }
}
