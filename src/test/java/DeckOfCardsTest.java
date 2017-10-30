import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DeckOfCardsTest {

    DeckOfCards deck;

    @Before
    public void setup() {
        deck = new DeckOfCards();
    }

    @Test
    //US-14
    // Check deck contains 60 cards after populated
    public void checkDeckSize() throws Exception {
        deck.populateDeck();
        assertEquals(60, deck.getDeck().size());
    }

    @Test
    //US-14
    // Check deck contains 10 single RED cards
    public void check10RedSingle() throws Exception {
        deck.populateDeck();
        int redSingleCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor().equals(CardColor.RED) && deck.getDeck().get(i).getValue() == 1) {
                redSingleCount++;
            }
        }
        assertEquals(10, redSingleCount);
    }

    @Test
    //US-14
    // Check deck contains 10 single YELLOW cards
    public void check10YellowSingle() throws Exception {
        deck.populateDeck();
        int yellowSingleCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor().equals(CardColor.YELLOW) && deck.getDeck().get(i).getValue() == 1) {
                yellowSingleCount++;
            }
        }
        assertEquals(10, yellowSingleCount);
    }

    @Test
    //US-14
    // Check deck contains 10 single BLUE cards
    public void check10BlueSingle() throws Exception {
        deck.populateDeck();
        int blueSingleCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor().equals(CardColor.BLUE) && deck.getDeck().get(i).getValue() == 1) {
                blueSingleCount++;
            }
        }
        assertEquals(10, blueSingleCount);
    }

    @Test
    //US-14
    // Check deck contains 10 single GREEN cards
    public void check10GreenSingle() throws Exception {
        deck.populateDeck();
        int greenSingleCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor().equals(CardColor.GREEN) && deck.getDeck().get(i).getValue() == 1) {
                greenSingleCount++;
            }
        }
        assertEquals(10, greenSingleCount);
    }

    @Test
    //US-14
    // Check deck contains 10 single ORANGE cards
    public void check10OrangeSingle() throws Exception {
        deck.populateDeck();
        int orangeSingleCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor().equals(CardColor.ORANGE) && deck.getDeck().get(i).getValue() == 1) {
                orangeSingleCount++;
            }
        }
        assertEquals(10, orangeSingleCount);
    }

    @Test
    //US-14
    // Check deck contains 2 double RED cards
    public void check10RedDouble() throws Exception {
        deck.populateDeck();
        int redDoubleCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor().equals(CardColor.RED) && deck.getDeck().get(i).getValue() == 2) {
                redDoubleCount++;
            }
        }
        assertEquals(2, redDoubleCount);
    }

    @Test
    //US-14
    // Check deck contains 2 double YELLOW cards
    public void check10YellowDouble() throws Exception {
        deck.populateDeck();
        int yellowDoubleCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor().equals(CardColor.YELLOW) && deck.getDeck().get(i).getValue() == 2) {
                yellowDoubleCount++;
            }
        }
        assertEquals(2, yellowDoubleCount);
    }

    @Test
    //US-14
    // Check deck contains 2 double BLUE cards
    public void check10BlueDouble() throws Exception {
        deck.populateDeck();
        int blueDoubleCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor().equals(CardColor.BLUE) && deck.getDeck().get(i).getValue() == 2) {
                blueDoubleCount++;
            }
        }
        assertEquals(2, blueDoubleCount);
    }

    @Test
    //US-14
    // Check deck contains 2 double GREEN cards
    public void check10GreenDouble() throws Exception {
        deck.populateDeck();
        int greenDoubleCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor().equals(CardColor.GREEN) && deck.getDeck().get(i).getValue() == 2) {
                greenDoubleCount++;
            }
        }
        assertEquals(2, greenDoubleCount);
    }

    @Test
    //US-14
    // Check deck contains 2 double ORANGE cards
    public void check10OrangeDouble() throws Exception {
        deck.populateDeck();
        int orangeDoubleCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor().equals(CardColor.ORANGE) && deck.getDeck().get(i).getValue() == 2) {
                orangeDoubleCount++;
            }
        }
        assertEquals(2, orangeDoubleCount);
    }

    @Test
    //US-19
    // Check to see if deck size is same after shuffle
    public void testDeckSizeAfterShuffle() throws Exception {
        deck.shuffleDeck();
        ArrayList<Card> deckOfCards = deck.getDeck();
        assertEquals(60, deck.getDeck().size());
    }

    @Test
    //US-19
    // Check to see if card was removed
    public void testDrawCard() throws Exception {
        deck.drawCard();
        assertEquals(59, deck.getDeck().size());
    }

    @Test
    //US-19
    // Check to see if 2 cards were removed
    public void testDrawCard2() throws Exception {
        deck.drawCard();
        deck.drawCard();
        assertEquals(58, deck.getDeck().size());
    }

    @Test
    //US-19
    // Check to see if 20 cards were removed
    public void testDrawCard20() throws Exception {
        int i = 0;
        while (i < 20) {
            deck.drawCard();
            i++;
        }
        assertEquals(40, deck.getDeck().size());
    }

    @Test
    //US-19
    // Check to see if null is returned for empty deck
    public void testDrawCardEmptyDeck() {
        int i = 0;
        while (i < 80) {
            deck.drawCard();
            i++;
        }
        assertEquals(null, deck.drawCard());
    }

}