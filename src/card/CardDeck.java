package src.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 카드 리스트 부분은 Card 클래스에서 CardDeck 클래스로 이관

public class CardDeck {
    private static final List<Card> allCards = new ArrayList<>(); // 54장 카드 리스트
    // 모든 카드 리스트 초기화
    static {
        initializeCardList();
    }

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

    // 54장의 카드 리스트 초기화 메서드
    private static void initializeCardList() {
        CardShape[] shapes = {CardShape.CLOVER, CardShape.DIAMONDS, CardShape.HEARTS, CardShape.SPADES};

        for (CardShape shape : shapes) {
            for (int num = 1; num <= 13; num++) {
                allCards.add(new Card(shape, num));
            }
        }
        // 조커 2장 추가
        allCards.add(new Card(true)); // 컬러 조커
        allCards.add(new Card(false)); // 흑백 조커
    }

    // 전체 카드 리스트 반환
    public static List<Card> getAllCards() {
        return new ArrayList<>(allCards);
    }
}
