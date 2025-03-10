package src.card;

import java.util.ArrayList;
import java.util.List;
import src.card.CardDeck;

// Card 클래스
public class Card {
    private CardShape shape; // 카드 문양
    private int number; // 카드 숫자 (1~13, 조커는 예외)
    private CardEffect effect; // 카드 효과

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
        this.effect = player -> player.drawN(5); // 상대 5장 뽑게 하기
        if(number==1){ // 컬러 조커이면
            this.effect =player -> player.drawN(5); // 상대 5장 뽑게 하기
        }else if(number==0){ // 흑백 조커이면
            this.effect =player -> player.drawN(4); // 상대 4장 뽑게 하기
        }
    }

    public static List<Card> getAllCards() {
        return getAllCards();
    }

    // 카드 숫자에 따른 효과 부여
    private CardEffect assignEffect(int number){
        switch (number) {
            case 1:
                return (player)->{
                  player.drawN(3);
                }; // A 카드
            case 2:
                return (player)->{
                    player.drawN(2);
                }; // 2 카드
            case 3:
                return (player)->{
                    throw new RuntimeException("방어 이벤트 발생");
                }; // 3 카드
            case 11: // J 카드
            case 12: // Q 카드
            case 13: // K 카드
                return (player)->{
                    player.draw(); // 한 장 더 뽑기
                };
            default:
                return (player)->{}; // 아무 효과 없음
        }
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
            return shape + " " + numStr + (effect != null ? " (" + effect + ")" : "");
        }
    }
}