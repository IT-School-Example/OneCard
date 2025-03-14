package src.player;

import src.card.Card;
import src.card.CardDeck;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    public static CardDeck cardDeck;

    protected String name; // 플레이어 이름

    protected List<Card> handCard = new ArrayList<>();

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
    public void draw() {
        handCard.add(cardDeck.draw());
    }
    // 카드 내기 (핸드 카드 마이너스)
    public Card drawOut(int index) {
        return handCard.remove(index);
    }

    public void defense() {
    }

    // 카드 N개를 뽑는 메서드
    public void drawN(int n){
        for(int i=0;i<n;i++){
            draw();
        }
    }
}
