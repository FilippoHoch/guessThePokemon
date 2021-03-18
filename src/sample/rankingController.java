package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    public static ArrayList<User> users = new ArrayList<>();
    public static boolean firstTime = true;
    @FXML
    public TableView<User> tableView;
    @FXML
    private ImageView leaderBoard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!sampleController.endGame && !users.isEmpty())
            users.get(users.size() - 1).setScore(0);
        else if (!users.isEmpty())
            users.get(users.size() - 1).setScore();
        try {
            updateUsers();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        File logoFile = new File("src/sample/img/ranking.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        leaderBoard.setImage(logoImage);
        ObservableList<User> userN = FXCollections.observableArrayList(users);
        tableView.setItems(userN);
        TableColumn<User, String> nameColumn = new TableColumn<>("Name");
        TableColumn<User, String> categoryColumn = new TableColumn<>("Category");
        TableColumn<User, Integer> pointsColumn = new TableColumn<>("Points");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("settings"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        nameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        categoryColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.75));
        pointsColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.09));
        tableView.getColumns().addAll(nameColumn, categoryColumn, pointsColumn);
    }

    public void updateUsers() throws IOException {
        Path path = Paths.get("src/sample/databaseUsers.txt");
        Scanner fileReader;
        if (firstTime) {
            fileReader = new Scanner(path);
            while (fileReader.hasNextLine()) {
                String newLine = fileReader.nextLine();
                String[] splitLine = newLine.split(" :: ");
                if (splitLine[2] == null)
                    splitLine[2] = "0";
                users.add(new User(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2])));
            }
            fileReader.close();
            firstTime = false;
        }

        FileWriter fileWriter = new FileWriter(path.toString(), false);
        for (User user : users)
            fileWriter.write(user.username + " :: " + user.settings + " :: " + user.score +
                    "\n");
        fileWriter.close();
        users.clear();
        fileReader = new Scanner(path);
        while (fileReader.hasNextLine()) {
            String newLine = fileReader.nextLine();
            String[] splitLine = newLine.split(" :: ");
            if (splitLine[2] == null)
                splitLine[2] = "0";
            users.add(new User(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2])));
        }
        fileReader.close();
    }
}
