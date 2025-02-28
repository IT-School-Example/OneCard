package src.card;

import src.player.Player;

@FunctionalInterface
public interface CardEffect {
    void apply(Player player); // 적용
}
