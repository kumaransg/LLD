package SystemDesign.JukeBox;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class JukeBox {
    List<User> users;
    public JukeBox() {
        users = new ArrayList<>();
    }

    public static void main(String[] args){
        JukeBox jb = new JukeBox();
        CDPlayer cp = new CDPlayer();

        User user1 = new User("Ajay","12 Hammond",Gender.Male);
        User user2 = new User("Katherine","20 Hammond",Gender.Female);
        CD cd1 = new CD();
        jb.addSongs(user1,user2,cd1);
        jb.users.add(user1);
        jb.users.add(user2);
        cp.getListCD().add(cd1);
        ///////JAVA 8 Predicate use
        Predicate<User> p = new Predicate<User>(){
            @Override
            public boolean test(User check){
                return check.getName().startsWith("Aj");
            }
        };

        jb.users.stream()
                .filter(p)
                .forEach(System.out::println);
    }

    private void addSongs(User user1, User user2, CD cd1) {
        Artist a1 = new Artist("Artist1","Boston",Gender.Male);
        Song s1 = new Song("Song1",a1, 2020);
        a1.addSong(s1);
        user1.getPlaylist().addSong(s1);

        Artist a2 = new Artist("Artist2","Boston",Gender.Male);
        Song s2 = new Song("Song2",a1, 2020);
        a2.addSong(s2);
        user2.getPlaylist().addSong(s2);
        user2.getPlaylist().addSong(s1);

        cd1.addSong(s1);
        cd1.addSong(s2);
    }
}
