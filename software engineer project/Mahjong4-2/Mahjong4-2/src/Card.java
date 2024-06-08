import java.util.Arrays;
import java.util.List;

public class Card implements Comparable<Card> {
    private String type; // 表示牌的类型，例如“万”、“条”、“筒”、“东”、“南”、“西”、“北”、“中”、“发”、“白”、“花”
    private Integer value; // 表示牌的数值，例如1-9，风牌、花牌的编号为null
    private boolean hasValue; // 是否有数值

    public Card(Integer value, String type) {
        this.type = type;
        this.value = value;
        this.hasValue = value != null;
    }

    public String getType() {
        return type;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (!hasValue) {
            // 如果牌没有数值，直接返回类型
            return type;
        } else {
            return value + type;
        }
    }


    @Override
    public boolean equals(Object obj) {
        // 比较两个对象是否相等
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        // 将obj转换为Card类型
        Card card = (Card) obj;
        // 比较type和value是否相等
        return type.equals(card.type) &&
                ((value == null && card.value == null) || (value != null && value.equals(card.value)));
    }

    public int compareTo(Card other) {
        // 定义牌的排序顺序
        String[] typesOrder = {"万", "条", "筒", "东风", "南风", "西风", "北风", "红中", "发财", "白板"};
        List<String> typesList = Arrays.asList(typesOrder);

        int thisTypeIndex = typesList.indexOf(this.type);
        int otherTypeIndex = typesList.indexOf(other.type);

        if (thisTypeIndex != otherTypeIndex) {
            return Integer.compare(thisTypeIndex, otherTypeIndex);
        } else if (this.hasValue && other.hasValue) {
            return Integer.compare(this.value, other.value);
        } else {
            return 0;
        }
    }
}
