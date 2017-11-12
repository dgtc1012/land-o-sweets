import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {

    private ArrayList<Card> deck = new ArrayList<>();

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
                deck.add(new Card(color, Constants.SINGLE));
            }
            for (int i = 0; i < 2; i++) {
                deck.add(new Card(color, Constants.DOUBLE));
            }
        }
        // Add 5 skip cards
        for (int i = 0; i < 5; i++) {
            deck.add(new Card(null, Constants.SKIP));
        }
        // Add 5 "Go to Square X cards"
        deck.add(new Card(null, Constants.LICORICE));
        deck.add(new Card(null, Constants.ICECREAM));
        deck.add(new Card(null, Constants.GINGERBREAD));
        deck.add(new Card(null, Constants.CUPCAKE));
        deck.add(new Card(null, Constants.PEPPERMINT));
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
