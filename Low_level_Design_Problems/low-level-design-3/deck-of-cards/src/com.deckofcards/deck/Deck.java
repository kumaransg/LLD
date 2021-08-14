package deck;

import java.util.ArrayList;
import card.Cards;
import enums.Suite;


public class Deck {
    private ArrayList<Cards> cardsDeck = new ArrayList<>();

    public Deck() {
        for(int faceValue = 1; faceValue <= 13; faceValue++) {
            for(Suite suite: Suite.values()) {
                cardsDeck.add(new Cards(faceValue, suite));
            }
        }
    }

    /**
     * @return the cardsDeck
     */
    public ArrayList<Cards> getCardsDeck() {
        return cardsDeck;
    }
}