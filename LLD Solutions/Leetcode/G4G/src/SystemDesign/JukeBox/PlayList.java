package SystemDesign.JukeBox;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlayList {
    Queue<Song> listSongs;
    User user;

    public PlayList() {
        this.listSongs = new LinkedList<>();
        //this.user = user;
    }

    public void addSong(Song s){
        listSongs.offer(s);
    }

    public Queue<Song> getListSongs() {
        return listSongs;
    }

    public void setListSongs(Queue<Song> listSongs) {
        this.listSongs = listSongs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Song getNextSong(){
        return null;
    }
}
