package src.rule.exception.violation;


public class PlayerHasTooManyCard extends RuntimeException {
    public PlayerHasTooManyCard(String playerName) {
        super(playerName + "님이 카드가 많아 파산합니다.");
    }
}
