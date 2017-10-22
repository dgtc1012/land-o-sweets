import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class DeckOfCards {

    private ArrayList<Card> deck = new ArrayList<>();
    private static final int SINGLE = 1;
    private static final int DOUBLE = 2;

    public DeckOfCards() {
        populateDeck();
        shuffleDeck();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void populateDeck() {
        deck = new ArrayList<>();
        for (Color color:Color.values()) {
            for (int i = 0; i < 10; i++) {
                deck.add(new Card(color, SINGLE));
            }
            for (int i = 0; i < 2; i++) {
                deck.add(new Card(color, DOUBLE));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        } else {
            throw new NoSuchElementException();
        }
    }
}
