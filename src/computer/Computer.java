package src.computer;

import java.util.Scanner;

public class Computer {
    private int computer; // 컴퓨터 플레이어 수

    public Computer(int computer) {
        this.computer = computer;
    }

    public int getComputer() {
        return computer;
    }

    public void setComputer(int computer) {
        this.computer = computer;
    }
    //
}
class Player {


    private String name; // 플레이어 이름

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
    // 컴퓨터 핸드 카드 ( 타입 확정시 수정)
   /*  private List<Card> handCard = new ArrayList<>();

    public List<Card> getHandCards() {
        return handCard;
    }
    // 카드 가져오기 (핸드 카드 플러스), 카드 공격당하거나, 낼게 없을때.
    public void draw(CardDeck cardDeck) {
        Card card = cardDeck.getCard();
        handCard.add(card);
    }
    // 카드 내기 (핸드 카드 마이너스)
    public void drawOut(CardDeck cardDeck) {
        Card card = cardDeck.getCard();
        handCard.minus(card);
    }
*/
/*Scanner sc = new Scanner(System.in);
        computer = sc.nextInt();
        int data [] = new int[computer];*/
