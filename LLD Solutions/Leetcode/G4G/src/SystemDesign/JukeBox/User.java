package SystemDesign.JukeBox;

public class User extends Person {
    private PlayList playlist;

    public User(String name, String address, Gender gender) {
        super(name, address, gender);
        this.playlist = new PlayList();
    }

    public PlayList getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlayList playlist) {
        this.playlist = playlist;
    }

    @Override
    public String toString() {
        return super.getName().toString();
    }
}
