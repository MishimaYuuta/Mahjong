import java.util.List;

public class PengChecker {

    // 判断是否可以碰牌
    public static boolean canPeng(List<Card> hand, Card discardedCard) {
        // 计算手牌中与打出的牌相同的数量
        int count = 0;
        for (Card card : hand) {
            if (card.equals(discardedCard)) {
                count++;
            }
        }
        // 如果手牌中相同的牌数量大于等于2，即可以碰牌
        if (count == 2){
            return true;}
        return false;
    }

    // 执行碰牌操作
    public static void peng(List<Card> hand, Card discardedCard) {
        // 从手牌中移除两张与打出的牌相同的牌，并加入到碰牌区
        hand.remove(discardedCard);
        hand.remove(discardedCard);
        // 输出碰牌的信息
        System.out.println("碰牌成功！");
    }
}
