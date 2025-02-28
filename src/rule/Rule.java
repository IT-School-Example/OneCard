package src.rule;

import src.card.Card;
import src.player.Player;

public class Rule {

    public static int MAX_OF_PLAYER = 4;

    public static int DEFAULT_HAND_SIZE = 7;

    public static boolean isValidCard(Card tableCard, Card drawOut) {
        // 테이블에 놓인 카드와 현재 내는 카드가 적합한지 확인
        // 같은 문양, 같은 숫자 확인
    }

    // 카드 소진
    public static boolean checkGameEnd(Player player) {
        return player.getHandCards().isEmpty();
    }

    // 카드 초과
    public static boolean checkGameEnd_2(Player player) {
        return player.getHandCards().size() > 16;
    }
}
