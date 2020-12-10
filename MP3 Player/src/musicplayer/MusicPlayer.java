package musicplayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicPlayer extends Application {

    private FileChooser chooser = new FileChooser();
    private File saveFile = null;

    private boolean changesMade = false;
    private Stage mainStage;

    private Playlist listOfSongs;
    private ListView<Song> playList;
    private TextField nameTF;
    private TextField artistTF;
    private TextField albumTF;
    private Label songLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        MenuBar menubar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem saveAsMenuItem = new MenuItem("Save As...");
        MenuItem closeMenuItem = new MenuItem("Close");
        fileMenu.getItems().addAll(openMenuItem, new SeparatorMenuItem(),
                saveMenuItem,saveAsMenuItem, new SeparatorMenuItem(), closeMenuItem);
        menubar.getMenus().add(fileMenu);

        openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openMenuItemActionPerformed();
            }
        });

        saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveMenuItemActionPerformed();
            }
        });

        saveAsMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveAsMenuItemActionPerformed();
            }
        });

        closeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeMenuItemActionPerformed();
            }
        });

        listOfSongs = new Playlist();
        listOfSongs.addSong("Mr Brightside", "The Killers", "Hot Fuss");
        listOfSongs.addSong("Wonderwall", "Oasis", "What's the Story?");
        listOfSongs.addSong("R U Mine?", "Arctic Monkeys", "AM");
        listOfSongs.addSong("Chop Suey!", "System of a Down", "Toxicity");
        listOfSongs.addSong("Everlong", "Foo Fighters", "The Colour and the Shape");

        playList = new ListView<>();
        playList.setPrefSize(280, 220);

        playList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playListSelectionMade();
            }
        });

        playList.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                playListSelectionMade();
            }
        });

        playList.setItems(listOfSongs);

        HBox topBox = new HBox(new Label("Music Playlist"));
        topBox.setAlignment(Pos.CENTER);

        VBox centreLeftBox = new VBox(playList);

        nameTF = new TextField();
        artistTF = new TextField();
        albumTF = new TextField();

        VBox centreRightBox = new VBox(new Label("Song"), nameTF,
                new Label("Artist"), artistTF,
                new Label("Album"), albumTF);
        centreRightBox.setAlignment(Pos.CENTER);
        centreRightBox.setSpacing(2);

        HBox musicBox = new HBox(centreLeftBox, centreRightBox);
        musicBox.setSpacing(5);
        musicBox.setPadding(new Insets(20));

        Button addButton = new Button("Add");
        addButton.setPrefSize(90, 20);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addButtonPressed();
            }
        });

        Button removeButton = new Button("Remove");
        removeButton.setPrefSize(90, 20);
        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                removeButtonPressed();
            }
        });

        Button clearButton = new Button("Clear");
        clearButton.setPrefSize(90, 20);
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearButtonPressed();
            }
        });

        Button findButton = new Button("Find");
        findButton.setPrefSize(90, 20);
        findButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                findButtonPressed();
            }
        });


        HBox middleBox = new HBox(addButton, removeButton, clearButton, findButton);
        middleBox.setAlignment(Pos.CENTER);
        middleBox.setSpacing(10);

        Button playButton = new Button("Play");
        playButton.setPrefSize(90,20);
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playButtonPressed();
            }
        });

        Button nextButton = new Button("Next");
        nextButton.setPrefSize(90,20);
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                nextButtonPressed();
            }
        });

        Button stopButton = new Button("Stop");
        stopButton.setPrefSize(90,20);
        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stopButtonPressed();
            }
        });

        Button shuffleButton = new Button("Shuffle");
        shuffleButton.setPrefSize(90,20);
        shuffleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                shuffleButtonPressed();
            }
        });

        HBox bottomBox = new HBox(playButton,nextButton,stopButton,shuffleButton);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setSpacing(10);

        songLabel = new Label();

        HBox playbackBox = new HBox(songLabel);
        playbackBox.setAlignment(Pos.CENTER);

        VBox musicGUI = new VBox(menubar, topBox, musicBox, middleBox, bottomBox, playbackBox);

        Scene scene = new Scene(musicGUI, 500, 450);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override public void handle(WindowEvent t) {
                exitForm();
            }
        });

        mainStage = primaryStage;
    }

    private void playListSelectionMade(){
        Song selectedSong = playList.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            setAllTextFields(selectedSong);
        }
    }

    private void addButtonPressed(){
        String newName = nameTF.getText();
        String newArtist = artistTF.getText();
        String newAlbum = albumTF.getText();
        if (newName.equals("") || newArtist.equals("") || newAlbum.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Enter Full Details", ButtonType.OK);
            alert.showAndWait();
        }
        else {
            listOfSongs.addSong(newName, newArtist, newAlbum);
            Song newSong = listOfSongs.findSongByName(newName);
            playList.getSelectionModel().select(newSong);
            playList.scrollTo(newSong);
            setAllTextFields(newSong);
            changesMade = true;
        }
    }

    private void removeButtonPressed(){
        int selectedIndex = playList.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Select a Song", ButtonType.OK);
            alert.showAndWait();
        } else {
            Song toDelete = playList.getItems().get(selectedIndex);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete " + toDelete + " ?",
                    ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                listOfSongs.removeSong(toDelete.getName());
                clearAllTextFields();
                playList.getSelectionModel().clearSelection();
                changesMade = true;
            }
        }
    }

    private void clearButtonPressed() {
        clearAllTextFields();
        playList.getSelectionModel().clearSelection();
    }

    private void findButtonPressed() {
        Song searchedFor;
        String findName = nameTF.getText();
        if (findName.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Enter a song", ButtonType.OK);
            alert.showAndWait();
        } else {
            searchedFor = listOfSongs.findSongByName(findName);
            if (searchedFor == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Song Not Found", ButtonType.OK);
                alert.showAndWait();
            } else {
                setAllTextFields(searchedFor);
                playList.getSelectionModel().select(searchedFor);
            }
        }
    }

    private void clearAllTextFields() {
        nameTF.setText("");
        artistTF.setText("");
        albumTF.setText("");
    }

    private void setAllTextFields(Song s){
        nameTF.setText(s.getName());
        artistTF.setText(s.getArtist());
        albumTF.setText(s.getAlbum());
    }

    private void playButtonPressed() {
        Song selectedSong = playList.getSelectionModel().getSelectedItem();
        songLabel.setText("Now Playing: " + selectedSong.getName());
    }

    private void nextButtonPressed(){
        String currentSong = songLabel.getText();
        String sub = currentSong.substring(13, currentSong.length()-0);
        for (Song s : listOfSongs){
            if (s.getName().equals(sub)){
                int Index = listOfSongs.indexOf(s) + 1;
                Song nextSong = listOfSongs.get(Index);
                songLabel.setText("Now Playing: " + nextSong.getName());
            }
        }
    }

    private void stopButtonPressed(){
        songLabel.setText("");
    }

    private void shuffleButtonPressed(){
        Random shuffle = new Random();
        int randomIndex = shuffle.nextInt(listOfSongs.size());
        Song randomSong = listOfSongs.get(randomIndex);
        songLabel.setText("Now Playing: " + randomSong);
    }

    private void openMenuItemActionPerformed() {
        saveIfNecessary();
        File selectedFile  = chooser.showOpenDialog(mainStage);
        if (selectedFile != null) {
            if (!selectedFile.exists()){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error: File Not Found");
                alert.showAndWait();
            } else {
                saveFile = selectedFile;
                try {
                    FileInputStream in = new FileInputStream(saveFile);
                    ObjectInputStream oIn = new ObjectInputStream(in);
                    List<Song> list = (List<Song>)oIn.readObject();
                    listOfSongs.setAll(list);
                    oIn.close();
                } catch (Exception e) {
                    System.out.print("Error : " + e);
                }
                playList.setItems(listOfSongs);
                changesMade = false;
                clearAllTextFields();
            }
        }
    }

    private void saveMenuItemActionPerformed() {
        if (saveFile == null)
            saveAsMenuItemActionPerformed();
        else{
            try {
                FileOutputStream out = new FileOutputStream(saveFile);
                ObjectOutputStream oOut = new ObjectOutputStream(out);
                oOut.writeObject(new ArrayList<>(listOfSongs));
                oOut.flush();
                oOut.close();
            } catch (Exception e) {
                System.out.print("Error : " + e);
            }
            changesMade = false;
        }
    }


    private void saveAsMenuItemActionPerformed() {
        saveFile = chooser.showSaveDialog(mainStage);
        if (saveFile != null) {
            try {
                FileOutputStream out = new FileOutputStream(saveFile);
                ObjectOutputStream oOut = new ObjectOutputStream(out);
                oOut.writeObject(new ArrayList<>(listOfSongs));
                oOut.flush();
                oOut.close();
            } catch (Exception e) {
                System.out.print("Error : " + e);
            }
            changesMade=false;
        }
    }

    private void closeMenuItemActionPerformed() {
        saveIfNecessary();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Really Quit?",
                ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            System.exit(0);
        }
    }

    private void saveIfNecessary(){
        boolean inLoop = changesMade;
        while(inLoop){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Save Changes?",
                    ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                saveMenuItemActionPerformed();
                inLoop = changesMade;
            } else
                inLoop = false;
        }
    }

    private void exitForm() {
        saveIfNecessary();
        System.exit(0);
    }

}
