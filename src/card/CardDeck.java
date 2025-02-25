package src.card;

import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<Card> cardList;

    {
        cardList = Card.getAllCards();
        shuffle();
    }

    public Card draw() {
        return cardList.remove(0);
    }

    public void shuffle() {
        Collections.shuffle(cardList);
    }
}
