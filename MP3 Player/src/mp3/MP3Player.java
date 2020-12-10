package mp3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class MP3Player extends Application {

    private HBox topBox;
    private HBox middleBox;
    private HBox songBox;
    private HBox bottomBox;

    private ListView<String> songList;
    private ObservableList<String> listOfSongs;

    private Label songLabel;

    private Button playButton;
    private Button stopButton;
    private Button shuffleButton;
    private Button nextButton;

    private Button addButton;
    private Button removeButton;
    private TextField inputTF;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        songList = new ListView<>();
        songList.setPrefSize(200,100);
        listOfSongs = FXCollections.observableArrayList("Mr Brightside","Wonderwall","R U Mine?",
                "Chop Suey!","Everlong");
        songList.setItems(listOfSongs);
        songLabel = new Label();

        playButton = new Button("Play");
        nextButton = new Button("Next");
        stopButton = new Button("Stop");
        shuffleButton = new Button("Shuffle");

        addButton = new Button("Add");
        inputTF = new TextField();
        removeButton = new Button("Remove");

        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String selectedSong = songList.getSelectionModel().getSelectedItem();
                songLabel.setText("Now Playing: " + selectedSong);
            }
        });

        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String currentSong = songLabel.getText();
                String sub = currentSong.substring(13, currentSong.length()-0);
                for (String s : listOfSongs){
                    if (s.contains(sub)){
                        int Index = listOfSongs.indexOf(s) + 1;
                        String nextSong = listOfSongs.get(Index);
                        songLabel.setText("Now Playing: " + nextSong);
                    }
                }
            }
        });

        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                songLabel.setText("");
            }
        });

        shuffleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Random shuffle = new Random();
                int randomIndex = shuffle.nextInt(listOfSongs.size());
                String randomSong = listOfSongs.get(randomIndex);
                songLabel.setText("Now Playing: " + randomSong);
            }
        });

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String newSong = inputTF.getText();
                if (newSong.equals("")){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please Enter A Song", ButtonType.OK);
                    alert.showAndWait();
                } else {
                    listOfSongs.add(newSong);
                    inputTF.setText("");
                }
            }
        });

        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int selectionNumber = songList.getSelectionModel().getSelectedIndex();
                if (selectionNumber == -1) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Select a song to remove", ButtonType.OK);
                    alert.showAndWait();
                } else {
                    listOfSongs.remove(selectionNumber);
                    inputTF.setText("");
                }
            }
        });

        topBox = new HBox(songList);
        topBox.setAlignment(Pos.CENTER);

        middleBox = new HBox(playButton,nextButton,stopButton,shuffleButton);
        middleBox.setAlignment(Pos.CENTER);

        songBox = new HBox(songLabel);
        songBox.setAlignment(Pos.CENTER);

        bottomBox = new HBox(addButton,inputTF,removeButton);
        bottomBox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(topBox,middleBox,songBox,bottomBox);

        Scene mp3Scene = new Scene(vbox, 300, 300);

        primaryStage.setScene(mp3Scene);
        primaryStage.setTitle("JavaFX Menu Demo");
        primaryStage.show();
    }
}
