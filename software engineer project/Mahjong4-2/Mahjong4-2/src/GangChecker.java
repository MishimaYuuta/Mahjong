import java.util.List;

public class GangChecker {

    // 检查是否可以暗杠
    public static boolean canAnGang(List<Card> hand) {
        for (int i = 0; i < hand.size() - 3; i++) {
            if (hand.get(i).equals(hand.get(i + 3))) {
                return true;
            }
        }
        return false;
    }

    // 执行开杠操作
    public static void kaiAnGang(List<Card> hand, Card gangCard) {
        for (int i = 0; i < 4; i++) {
            hand.remove(gangCard);
        }
    }


    // 判断是否可以明杠
    public static boolean canMingGang(List<Card> hand, Card lastDiscard) {
        int count = 0;
        for (Card card : hand) {
            if (card.equals(lastDiscard)) {
                count++;
            }
        }
        return count >= 3;
    }
    // 执行开杠操作
    public static void kaiMingGang(List<Card> hand, Card lastDiscard) {
        for (int i = 0; i < 3; i++) {
            hand.remove(lastDiscard);
        }
    }
}
