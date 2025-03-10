package src.rule.exception.event;

public class DefenceEvent extends RuntimeException{
    public DefenceEvent(String playerName) {
        super(playerName + "님, 방어 카드를 사용하시겠습니까?");
    }
}
