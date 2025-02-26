package src.player;

import src.card.Card;
import src.card.CardDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Computer extends Player {
    private int computer; // 컴퓨터 플레이어 수

    public List<Card> handCard = new ArrayList<>();

    public Computer(String name) {
        super(name);
    }

    public Computer getComputer() {
        return this;
    }

    public List<Card> getHandCards() { return handCard; }

    // 카드 가져오기 (핸드 카드 플러스), 카드 공격당하거나, 낼게 없을때.
    public void draw(CardDeck cardDeck) {
        handCard.add(cardDeck.draw());
    }

    // 카드 내기 (핸드 카드 마이너스)
    public Card drawOut(int index) {
        return handCard.remove(((int) Math.random() * handCard.size())+1); // 보류
    }

    // 컴퓨터 N 플레이어
    public int[] ComputerPlayers() {
        Scanner sc = new Scanner(System.in);
        this.computer = sc.nextInt();
        int data [] = new int [computer];
        return data;
    }
}
