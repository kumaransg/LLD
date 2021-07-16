package SystemDesign.JukeBox;

import java.util.ArrayList;
import java.util.List;

public class Artist extends Person{
    List<Song> songs;
    List<String> awards;

    public Artist(String name, String address, Gender gender) {
        super(name, address, gender);
        this.songs = new ArrayList<>();
        this.awards = new ArrayList<>();
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public void addSong(Song s){

    }
    public void addAwards(String s){

    }
}
