package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.text.TableView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class rankingController implements Initializable {
    @FXML
    private ImageView leaderBoard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File logoFile = new File("src/sample/img/ranking.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        leaderBoard.setImage(logoImage);
    }

    public static void updateUsers() {
        Path path = Paths.get("src/sample/databaseUsers.txt");
        try {

            FileWriter fileWriter = new FileWriter(path.toString());
            for (int i = 0; i < users.size(); i++)
                fileWriter.write(users.get(0).username + "/" + users.get(0).settings + "/" + users.get(0).score);
            fileWriter.close();

            users.clear();
            Scanner fileReader = new Scanner(path.toString());
            while (fileReader.hasNextLine()) {
                String newLine = fileReader.nextLine();
                String[] splitLine = newLine.split("/");
                users.add(new User(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2])));
            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
