package SystemDesign.JukeBox;

import java.util.ArrayList;
import java.util.List;

public class CDPlayer {
    List<CD> listCD;


    public List<CD> getListCD() {
        return listCD;
    }

    public void setListCD(List<CD> listCD) {
        this.listCD = listCD;
    }

    public CDPlayer() {
        this.listCD = new ArrayList<>();
    }

    public void addSong(CD s){

    }
}
