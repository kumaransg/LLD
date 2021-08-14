import deck.Deck;

public class DeckOfCardMainApplication {

    public static void main(String [] args ) {
        System.out.println("Hello world!");
        Deck deck = new Deck();
        System.out.printf("First Card Suite %s and %d value.\n", deck.getCardsDeck().get(0).getSuite().toString(), deck.getCardsDeck().get(0).getValue());
    }
};