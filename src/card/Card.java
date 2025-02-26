package src.card;

import java.util.ArrayList;
import java.util.List;

// Card 클래스
public class Card {
    private CardShape shape; // 카드 문양
    private int number; // 카드 숫자 (1~13, 조커는 예외)
    private CardEffect effect; // 카드 효과

    private static final List<Card> allCards = new ArrayList<>(); // 54장 카드 리스트

    // 모든 카드 리스트 초기화
    static {
        initializeCardList();
    }

    // 일반 카드 생성자
    public Card(CardShape shape, int number) {
        if (shape == CardShape.JOKER) {
            throw new IllegalArgumentException("조커 카드는 별도의 생성자를 사용하세요.");
        }
        if (number < 1 || number > 13) {
            throw new IllegalArgumentException("숫자는 1~13 범위여야 합니다.");
        }
        this.shape = shape;
        this.number = number;
        this.effect = assignEffect(number); // 카드 숫자에 맞는 효과 부여받음
    }

    // 조커 카드 생성자 (흑백 조커, 컬러 조커)
    public Card(boolean isColorJoker) {
        this.shape = CardShape.JOKER;
        this.number = isColorJoker ? 1 : 0; // 1: 컬러 조커, 0: 흑백 조커
        this.effect = CardEffect.ATTACK_5;
    }

    // 카드 숫자에 따른 효과 부여
    private static CardEffect assignEffect(int number) {
        switch (number) {
            case 1:
                return CardEffect.ATTACK_3; // A 카드
            case 2:
                return CardEffect.ATTACK_2;
            case 3:
                return CardEffect.DEFEND_2_SAME_SHAPE;
            case 11:
                return CardEffect.EXTRA_TURN; // J 카드
            case 12:
                return CardEffect.EXTRA_TURN; // Q 카드
            case 13:
                return CardEffect.EXTRA_TURN; // K 카드
            default:
                return CardEffect.NONE;
        }
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

    // Getter 메서드

    public CardShape getShape() {
        return shape;
    }

    public int getNumber() {
        return number;
    }

    public CardEffect getEffect() {
        return effect;
    }

    // toString() : 카드 정보 출력
    @Override
    public String toString() {
        if (this.shape == CardShape.JOKER) {
            return number == 1 ? "\uD83C\uDCCF 컬러 조커 (ATTACK_5)" : "\uD83C\uDCCF 흑백 조커 (ATTACK_5)";
        } else {
            String numStr = switch (number) {
                case 1 -> "A";
                case 11 -> "J";
                case 12 -> "Q";
                case 13 -> "K";
                default -> String.valueOf(number);
            };
            return shape + " " + numStr + (effect != CardEffect.NONE ? " (" + effect + ")" : "");
        }
    }
}