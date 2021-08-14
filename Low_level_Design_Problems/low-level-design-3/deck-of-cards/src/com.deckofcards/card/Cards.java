package card;

import enums.Suite;

/**
 * Card class to represent particular card
 */
public class Cards {
    int value;
    Suite suite;

    public Cards(int faceValue, Suite assignSuite){
        value = faceValue;
        suite = assignSuite;
    }

    public int getValue() {
        return value;
    }

    public Suite getSuite() {
        return suite;
    }
}