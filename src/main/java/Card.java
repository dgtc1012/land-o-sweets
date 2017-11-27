public class Card implements java.io.Serializable {

    private CardColor color;
    private int value;

    public Card(CardColor color, int value) {
        this.color = color;
        this.value = value;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public CardColor getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(color + "-");
        sb.append(value);
        return sb.toString();
    }
}
