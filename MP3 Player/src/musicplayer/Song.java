package musicplayer;

import java.io.Serializable;

public class Song implements Serializable {

    private String name;
    private String artist;
    private String album;

    public Song(){
    }

    public Song(String name, String artist, String album){
        this.name = name;
        this.artist = artist;
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return artist + ": " + name;
    }
}
