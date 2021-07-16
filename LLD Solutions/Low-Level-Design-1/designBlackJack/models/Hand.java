/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designBlackJack.models;

import java.util.ArrayList;

/**
 * @author paras.chawla
 * @version $Id: Hand.java, v 0.1 2020-12-20 12:39 paras.chawla Exp $$
 */

// All players are having individual Hand having there own cards
public class Hand<T extends Card> {

    protected ArrayList<T> cards = new ArrayList<>();

    // 1. Calculate Score of particular Hand
    public int score() {
        int score = 0;

        for(T card: cards){
            score+=card.value();
        }
        return score;
    }

    // 2. Add Card for a particular Hand
    public void addCard(T card){
        cards.add(card);
    }


    // 3. print cards of a particular Hand
    public void print(){
        for(Card card: cards){
            card.print();
        }
    }

}