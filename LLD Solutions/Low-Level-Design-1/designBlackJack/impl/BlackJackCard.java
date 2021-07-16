/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designBlackJack.impl;

import designBlackJack.models.Card;
import designBlackJack.models.Suit;

/**
 * @author paras.chawla
 * @version $Id: BlackJackCard.java, v 0.1 2020-12-20 12:44 paras.chawla Exp $$
 */
public class BlackJackCard extends Card {

    public BlackJackCard(int faceValue, Suit suit) {
        super(faceValue, suit);
    }

    // BlackJackCard is having its own implementation of value() handling
    public int value() {
        if (isAce()) {
            return 1;
        } else if (isFaceCard()) {
            return 10;
        } else {
            return faceValue;
        }
    }

    // Min value of Ace should be 1
    public int minValue(){
        if(isAce()){
            return 1;
        }else{
            return value();
        }
    }

    // Max value of Ace should be 11
    public int maxValue(){
        if(isAce()){
            return 11;
        }else{
            return value();
        }
    }

    public boolean isAce() {
        return faceValue == 1;
    }

    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }
}