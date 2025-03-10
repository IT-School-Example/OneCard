package src.player;

import src.card.Card;
import src.card.CardDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Computer extends Player {
    private int computer; // 컴퓨터 플레이어 수

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
    public Card drawOut() {
        // 내 카드 중에 낼 수 있는 카드가 있는지?
        // 방법1. 그게 아니라면 예외를 던지거나
        // 방법2. 카드뽑기 draw()를 호출하고 return (밑에 코드는 실행 x)

        // index는 랜덤으로 뽑는다.
        int index =((int) Math.random() * handCard.size()) + 1;

        // 해당 index의 카드를 가져온다,
        Card card = handCard.get(index);

        // 해당 카드가 같은 문양이거나 같은 숫자이지를 밑에서 판단한다
        while (!Rule.isValiableCard(card)) {
            index = ((int) Math.random() * handCard.size())+1;
            card = handCard.get(index);
        }
        return handCard.remove(index);
    }
    @Override
    public Card drawOut(int index) {
        // 카드 위치 : 랜던
        return drawOut();
    }

    // 컴퓨터 N 플레이어
    public int[] ComputerPlayers() {
        Scanner sc = new Scanner(System.in);
        this.computer = sc.nextInt();
        int data [] = new int [computer];
        return data;
    }
}
