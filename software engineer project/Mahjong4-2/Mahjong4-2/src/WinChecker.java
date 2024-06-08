import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinChecker {

    // 判断是否胡牌
    public static boolean isWinningHand(List<Card> hand) {
        // 手牌数量不能胡牌
        if (hand.size() %3 != 2) {
            return false;
        }

        // 尝试将其中一张牌作为将牌（一对），然后将剩余的牌进行组合
        for (int i = 0; i < hand.size() ; i++) {
            List<Card> copyHand = new ArrayList<>(hand);
            Card pair = copyHand.remove(i); // 将牌作为将牌（一对）
            if (isWinningHand(copyHand, pair)) {
                return true;
            }
        }
        return false;
    }

    // 判断剩余的牌是否满足胡牌条件
    private static boolean isWinningHand(List<Card> hand, Card pair) {
        // 递归结束条件：手牌为空
        if (hand.isEmpty()) {
            return true;
        }

        // 尝试组合成顺子
        for (int i = 0; i < hand.size() - 2; i++) {
            Card first = hand.get(i);
            Card second = hand.get(i + 1);
            Card third = hand.get(i + 2);

            if (isSequence(first, second, third)) {
                List<Card> newHand = new ArrayList<>(hand);
                newHand.remove(first);
                newHand.remove(second);
                newHand.remove(third);
                if (isWinningHand(newHand, pair)) {
                    return true;
                }
            }
        }

        // 尝试组合成刻子
        for (int i = 0; i < hand.size(); i++) {
            Card current = hand.get(i);
            List<Card> newHand = new ArrayList<>(hand);
            if (current.equals(pair)) {
                newHand.remove(i);
                newHand.remove(pair);
                if (isWinningHand(newHand, null)) {
                    return true;
                }
            } else if (countOccurrences(current, hand) >= 3) {
                newHand.remove(current);
                newHand.remove(current);
                newHand.remove(current);
                if (isWinningHand(newHand, pair)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 判断是否是顺子
    private static boolean isSequence(Card first, Card second, Card third) {
        return first.getType().equals(second.getType())
                && second.getType().equals(third.getType())
                && first.getValue() + 1 == second.getValue()
                && second.getValue() + 1 == third.getValue();
    }

    // 计算指定牌在手牌中出现的次数
    private static int countOccurrences(Card card, List<Card> hand) {
        int count = 0;
        for (Card c : hand) {
            if (c.equals(card)) {
                count++;
            }
        }
        return count;
    }
}
