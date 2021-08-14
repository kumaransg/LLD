package SystemDesign.JukeBox;

import java.util.ArrayList;
import java.util.List;

public class CD {
    List<Song> songs;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public CD() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song s){

    }
}
