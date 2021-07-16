/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designBlackJack.models;

/**
 * @author paras.chawla
 * @version $Id: Suit.java, v 0.1 2020-12-20 12:28 paras.chawla Exp $$
 * <p>
 * Fixed 4 Suit for every card of a Deck
 */
public enum Suit {

    Club(0),
    Diamond(1),
    Heart(2),
    Spade(3);

    private int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitFromValue(int value) {
        switch (value) {
            case 0:
                return Suit.Club;
            case 1:
                return Suit.Diamond;
            case 2:
                return Suit.Heart;
            case 3:
                return Suit.Spade;
            default:
                return null;
        }
    }

}