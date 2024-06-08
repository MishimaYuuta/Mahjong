import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    // 构造函数
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    // 获取名字
    public String getName() {
        return name;
    }

    // 获取手牌
    public List<Card> getHand() {
        return hand;
    }

    public void dealcard(Card card) {
        hand.add(card);
    }


    // 摸牌
    public void draw(Card card) {
        hand.add(card);
        //System.out.println(name + " drew " + card);
    }

    // 整牌
    public void sortHand() {
        Collections.sort(hand);
    }

    // 出牌
    public void play(Card card) {
        hand.remove(card);
        //System.out.println(name + " played " + card);
    }

    // 检查玩家是否可以胡牌
    public boolean canWin() {
        return WinChecker.isWinningHand(hand);
    }

}