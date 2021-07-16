/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designBlackJack.models;

/**
 * @author paras.chawla
 * @version $Id: Card.java, v 0.1 2020-12-20 12:31 paras.chawla Exp $$
 */

// Abstract because value() of card isn't known before knowing what type of game players are playing
// Card consist of faceValue and Suit
public abstract class Card {

    // Suit and faceValue

    protected int  faceValue;
    protected Suit suit;

    // All cards are available initially and gets to unavailable when game is going on
    private boolean available=true;

    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    protected abstract int value();

    public boolean isAvailable() {
        return available;
    }

    public void markUnavailable() {
        available = false;
    }

    public void markAvailable() {
        available = true;
    }

    public void print(){

        String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        System.out.print(faceValues[faceValue - 1]);

        switch (suit){
            case Club:
                System.out.println("c");
                break;
            case Heart:
                System.out.print("h");
                break;
            case Diamond:
                System.out.print("d");
                break;
            case Spade:
                System.out.print("s");
                break;
        }
        System.out.println(" ");
    }

}