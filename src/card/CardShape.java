package src.card;

// 카드 문양 enum
public enum CardShape {
    CLUBS("♣"), DIAMONDS("♦"), HEARTS("♥"), SPADES("♠"), JOKER("JOKER");

    private final String symbol;

    CardShape(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}