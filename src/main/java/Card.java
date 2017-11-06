public class Card {

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

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
