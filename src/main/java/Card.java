public class Card {

    private Color color;
    private int value;

    public Card(Color color, int value) {
        this.color = color;
        this.value = value;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
