import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckOfCardsTest {

    DeckOfCards deck;

    @Before
    public void setup() {
        deck = new DeckOfCards();
    }

    @Test
    //US-14
    // Check deck contains 70 cards after populated
    public void checkDeckSize() throws Exception {
        deck.populateDeck();
        assertEquals(70, deck.getDeck().size());
    }

    @Test
    //US-14
    // Check deck contains 10 single RED cards
    public void check10RedSingle() throws Exception {
        deck.populateDeck();
        int redSingleCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor() != null && deck.getDeck().get(i).getColor().equals(CardColor.RED) && deck.getDeck().get(i).getValue() == Constants.SINGLE) {
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
            if (deck.getDeck().get(i).getColor() != null && deck.getDeck().get(i).getColor().equals(CardColor.YELLOW) && deck.getDeck().get(i).getValue() == Constants.SINGLE) {
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
            if (deck.getDeck().get(i).getColor() != null && deck.getDeck().get(i).getColor().equals(CardColor.BLUE) && deck.getDeck().get(i).getValue() == Constants.SINGLE) {
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
            if (deck.getDeck().get(i).getColor() != null && deck.getDeck().get(i).getColor().equals(CardColor.GREEN) && deck.getDeck().get(i).getValue() == Constants.SINGLE) {
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
            if (deck.getDeck().get(i).getColor() != null && deck.getDeck().get(i).getColor().equals(CardColor.ORANGE) && deck.getDeck().get(i).getValue() == Constants.SINGLE) {
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
            if (deck.getDeck().get(i).getColor() != null && deck.getDeck().get(i).getColor().equals(CardColor.RED) && deck.getDeck().get(i).getValue() == Constants.DOUBLE) {
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
            if (deck.getDeck().get(i).getColor() != null && deck.getDeck().get(i).getColor().equals(CardColor.YELLOW) && deck.getDeck().get(i).getValue() == Constants.DOUBLE) {
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
            if (deck.getDeck().get(i).getColor() != null && deck.getDeck().get(i).getColor().equals(CardColor.BLUE) && deck.getDeck().get(i).getValue() == Constants.DOUBLE) {
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
            if (deck.getDeck().get(i).getColor() != null && deck.getDeck().get(i).getColor().equals(CardColor.GREEN) && deck.getDeck().get(i).getValue() == Constants.DOUBLE) {
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
            if (deck.getDeck().get(i).getColor() != null && deck.getDeck().get(i).getColor().equals(CardColor.ORANGE) && deck.getDeck().get(i).getValue() == Constants.DOUBLE) {
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
        assertEquals(70, deck.getDeck().size());
    }

    @Test
    //US-19
    // Check to see if card was removed
    public void testDrawCard() throws Exception {
        deck.drawCard();
        assertEquals(69, deck.getDeck().size());
    }

    @Test
    //US-19
    // Check to see if 2 cards were removed
    public void testDrawCard2() throws Exception {
        deck.drawCard();
        deck.drawCard();
        assertEquals(68, deck.getDeck().size());
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
        assertEquals(50, deck.getDeck().size());
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

    @Test
    //US-27
    // Check to see if there are 5 skip cards
    public void check5SkipCards() {
        deck.populateDeck();
        int skipCount = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor() == null && deck.getDeck().get(i).getValue() == Constants.SKIP) {
                skipCount++;
            }
        }
        assertEquals(5, skipCount);
    }

    @Test
    //US-36
    // Check to see if there is 1 LICORICE card
    public void check1LicoriceCard() {
        deck.populateDeck();
        int count = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor() == null && deck.getDeck().get(i).getValue() == Constants.LICORICE) {
                count++;
            }
        }
        assertEquals(1, count);
    }

    @Test
    //US-36
    // Check to see if there is 1 ICECREAM card
    public void check1IcecreamCard() {
        deck.populateDeck();
        int count = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor() == null && deck.getDeck().get(i).getValue() == Constants.ICECREAM) {
                count++;
            }
        }
        assertEquals(1, count);
    }

    @Test
    //US-36
    // Check to see if there is 1 GINGERBREAD card
    public void check1GingerbreadCard() {
        deck.populateDeck();
        int count = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor() == null && deck.getDeck().get(i).getValue() == Constants.GINGERBREAD) {
                count++;
            }
        }
        assertEquals(1, count);
    }

    @Test
    //US-36
    // Check to see if there is 1 CUPCAKE card
    public void check1CupcakeeCard() {
        deck.populateDeck();
        int count = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor() == null && deck.getDeck().get(i).getValue() == Constants.CUPCAKE) {
                count++;
            }
        }
        assertEquals(1, count);
    }

    @Test
    //US-36
    // Check to see if there is 1 PEPPERMINT card
    public void check1PeppermintCard() {
        deck.populateDeck();
        int count = 0;
        for (int i = 0; i < deck.getDeck().size(); i++) {
            if (deck.getDeck().get(i).getColor() == null && deck.getDeck().get(i).getValue() == Constants.PEPPERMINT) {
                count++;
            }
        }
        assertEquals(1, count);
    }

}