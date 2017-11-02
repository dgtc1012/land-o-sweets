import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {

    private ArrayList<Card> deck = new ArrayList<>();
    private static final int GO_TO_MIDDLE = 45;
    private static final int SKIP = 0;
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
        // Add 12 cards of each color
        for (CardColor color : CardColor.values()) {
            for (int i = 0; i < 10; i++) {
                deck.add(new Card(color, SINGLE));
            }
            for (int i = 0; i < 2; i++) {
                deck.add(new Card(color, DOUBLE));
            }
        }
        // Add 5 skip cards
        for (int i = 0; i < 5; i++) {
            deck.add(new Card(null, SKIP));
        }
        // Add 3 Go-To-Middle cards
        for (int i = 0; i < 3; i++) {
            deck.add(new Card(null, GO_TO_MIDDLE));
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        } else {
            return null;
        }
    }
}
