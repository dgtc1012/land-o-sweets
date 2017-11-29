import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards implements java.io.Serializable {

    private ArrayList<Card> deck = new ArrayList<>();

    public DeckOfCards() {
        populateDeck();
        shuffleDeck();
    }

    /**
     * Returns the whole deck of cards
     *
     * @return Deck of cards
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Populates the deck of cards with all of the cards specified by the user
     */
    public void populateDeck() {
        deck = new ArrayList<>();
        // Add 12 cards of each color
        for (CardColor color : CardColor.values()) {
          if (color != CardColor.ICECREAM && color != CardColor.LICORICE && color != CardColor.CUPCAKE &&
            color != CardColor.PEPPERMINT && color != CardColor.GINGERBREAD){
              for (int i = 0; i < 10; i++) {
                  deck.add(new Card(color, Constants.SINGLE));
              }
              for (int i = 0; i < 2; i++) {
                  deck.add(new Card(color, Constants.DOUBLE));
              }
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

    /**
     * Shuffles all of the card objects into a random order
     */
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    /**
     * Draws a card from the deck
     *
     * @return The deck drawn, or null if the deck is empty
     */
    public Card drawCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        } else {
            return null;
        }
    }

    //Sets the current deck
    public void setDeck(ArrayList<Card> newDeck) {

        deck = newDeck;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(deck.size());
        for (Card c : deck) {

            sb.append("\n");
            sb.append(c.toString());
        }

        return sb.toString();
    }

    public Card drawWorstCard(int index) {
        CardColor cc;
        Card c;
        Card a = new Card(CardColor.RED, Constants.SINGLE);
        int temp = -1;
        if (!deck.isEmpty()) {
            for (int i = index; i <= index + 9; i++){
                if (i == index){
                  c = new Card(null, Constants.SKIP);
                  temp = firstIndex(c);
                  if (temp > -1)
                    break;
                }else{
                    if (i>=88)
                      WorldOfSweets.movePlayer(new Card(CardColor.GREEN, Constants.SINGLE), WorldOfSweets.currentPlayerIndex);
                    cc = Gameboard.getSquareCardColor(i);
                    if (cc == CardColor.CUPCAKE)
                        c = new Card(null, Constants.CUPCAKE);
                    else if (cc == CardColor.PEPPERMINT)
                        c = new Card(null, Constants.PEPPERMINT);
                    else if (cc == CardColor.LICORICE)
                        c = new Card(null, Constants.LICORICE);
                    else if (cc == CardColor.GINGERBREAD)
                        c = new Card(null, Constants.GINGERBREAD);
                    else if (cc == CardColor.ICECREAM)
                        c = new Card(null, Constants.ICECREAM);
                    else{
                        if (i<index+5)
                            c = new Card(cc, Constants.SINGLE);
                        else
                            c = new Card(cc, Constants.DOUBLE);
                    }
                    temp = firstIndex(c);
                    if (temp > -1)
                      break;
                }
            }
            if (temp > -1)
              return deck.remove(temp);
            else
              return null;
        } else {
            return null;
        }
    }
    public boolean sameCard(Card c1, Card c2){
      return (c1.getColor() == c2.getColor() && c1.getValue() == c2.getValue());
    }
    public int firstIndex(Card card){
      int i = 0;
      for(Card c : deck) {
        if (sameCard(c, card))
          return i;
        i++;
      }
      return -1;

    }




}
