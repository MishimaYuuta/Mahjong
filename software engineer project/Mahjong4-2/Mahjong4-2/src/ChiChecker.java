import java.util.List;

public class ChiChecker {

    // 判断是否可以吃牌
    public static boolean canChi(List<Card> hand, Card discardedCard) {
        // 获取打出的牌的数值和类型

        String discardedType = discardedCard.getType();

        // 检查手牌中是否有相邻的两张牌与打出的牌组成顺子
        if (discardedType.equals("万") || discardedType.equals("条") || discardedType.equals("筒")) {
            // 如果是万、条、筒，检查是否有相邻的两张牌
            int discardedValue = discardedCard.getValue();
            return hand.contains(new Card(discardedValue - 1, discardedType)) &&
                    hand.contains(new Card(discardedValue - 2, discardedType)) ||
                    hand.contains(new Card(discardedValue - 1, discardedType)) &&
                            hand.contains(new Card(discardedValue + 1, discardedType)) ||
                    hand.contains(new Card(discardedValue + 1, discardedType)) &&
                            hand.contains(new Card(discardedValue + 2, discardedType));
        } else {
            // 其他类型的牌不能吃
            return false;
        }
    }

    // 执行吃牌操作
    public static void chi(List<Card> hand, Card discardedCard) {
        if (!canChi(hand, discardedCard)) {
            System.out.println("不能吃牌！");
            return;
        }

        // 找到符合条件的两张牌
        int discardedValue = discardedCard.getValue();
        String discardedType = discardedCard.getType();

        Card first = null;
        Card second = null;

        if (discardedType.equals("万") || discardedType.equals("条") || discardedType.equals("筒")) {
            if (hand.contains(new Card(discardedValue - 1, discardedType)) && hand.contains(new Card(discardedValue - 2, discardedType))) {
                first = new Card(discardedValue - 1, discardedType);
                second = new Card(discardedValue - 2, discardedType);
            } else if (hand.contains(new Card(discardedValue - 1, discardedType)) && hand.contains(new Card(discardedValue + 1, discardedType))) {
                first = new Card(discardedValue - 1, discardedType);
                second = new Card(discardedValue + 1, discardedType);
            } else if (hand.contains(new Card(discardedValue + 1, discardedType)) && hand.contains(new Card(discardedValue + 2, discardedType))) {
                first = new Card(discardedValue + 1, discardedType);
                second = new Card(discardedValue + 2, discardedType);
            }
        }

        // 如果找到了符合条件的两张牌，则进行吃牌操作
        if (first != null && second != null) {
            // 从手牌中移除两张牌，并加入到碰牌区
            hand.remove(first);
            hand.remove(second);
            // 输出吃牌的信息
            System.out.println("吃牌成功！");
        } else {
            System.out.println("未找到符合条件的牌！");
        }
    }

}
