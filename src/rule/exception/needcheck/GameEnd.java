package src.rule.exception.needcheck;

// 검사 예외 throws나 예외처리 강제됨
public class GameEnd extends Exception {
    public GameEnd(String winner) {
        super(winner + "님이 게임을 우승하셨습니다.\n게임을 마칩니다.");
    }
}
