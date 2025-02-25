package src.card;

// 카드 효과 enum
public enum CardEffect {
    NONE, // 효과 없음
    ATTACK_2, // 상대가 2장 뽑게 함
    ATTACK_3, // 상대가 3장 뽑게 함
    ATTACK_5, // 상대가 5장 뽑게 함
    DEFEND_2_SAME_SHAPE, // 같은 문양의 2를 방어
    EXTRA_TURN // 한 번 더 내거나 뽑기
}
