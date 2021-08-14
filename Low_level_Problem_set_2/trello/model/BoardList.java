package trello.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author priyamvora
 * @created 20/04/2021
 */
public class BoardList extends Entity {
    private List<Card> cardList;

    public BoardList(String name) {
        super(name);
        this.cardList = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cardList.add(card);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void removeCard(String cardId) {
        this.cardList = cardList.stream().filter(card -> !card.getEntityId().equals(cardId)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return super.toString() +" BoardList{" +
                "cardList=" + cardList +
                '}';
    }
}
