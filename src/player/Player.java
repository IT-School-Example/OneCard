package src.player;

import src.card.Card;
import src.card.CardDeck;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    protected String name; // 플레이어 이름

    private List<Card> handCard = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHandCards() {
        return handCard;
    }

    // 카드 가져오기 (핸드 카드 플러스), 카드 공격당하거나, 낼게 없을때.
    public void draw(CardDeck cardDeck) {
        handCard.add(cardDeck.draw());
    }
    // 카드 내기 (핸드 카드 마이너스)
    public Card drawOut(int index) {
        return handCard.remove(index);
    }
}
