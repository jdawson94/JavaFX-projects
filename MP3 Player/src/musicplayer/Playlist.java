package musicplayer;

import javafx.collections.FXCollections;
import com.sun.javafx.collections.ObservableListWrapper;

import java.io.Serializable;

public class Playlist extends ObservableListWrapper<Song> implements Serializable {

    public Playlist(){
        super(FXCollections.observableArrayList());
    }

    public void addSong(String name, String artist, String album){
        super.add(new Song(name,artist,album));
    }

    public Song findSongByName(String name){
        Song temp;
        int indexLocation = -1;
        for (int i = 0; i < super.size(); i++) {
            temp = super.get(i);
            if (temp.getName().equals(name)){
                indexLocation = i;
                break;
            }
        }
        if (indexLocation == -1) {
            return null;
        } else {
            return super.get(indexLocation);
        }
    }

    public void removeSong(String song){
        Song deleteSong = this.findSongByName(song);
        super.remove(deleteSong);
    }

}
