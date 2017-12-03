import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class DadModeTest {

    DeckOfCards deck;
    Player player;

    @Before
    public void setup() {
        deck = new DeckOfCards();
    }


    @Test
    //US-49
    // Checks if player has activated DadMode when entering their name as "Dad"
    public void checkIsDad() throws Exception {
        player = new Player(1, "Dad", false);
        assertTrue(player.isDad());

    }

    @Test
    //US-49
    // Checks if player hasnt activated DadMode when entering any name other than "Dad"
    public void checkIsNotDad() throws Exception {
        player = new Player(1, "foobar", false);
        assertFalse(player.isDad());

    }

    @Test
    //US-50
    // Checks if the first worst card than is delt from the deck is a Skip Card
    public void checkWorstCardSkip() throws Exception {
        Card resultCard = deck.drawWorstCard(-1);
        Card expectedCard = new Card (null, Constants.SKIP);
        assertTrue(deck.sameCard(expectedCard, resultCard));

    }

    @Test
    //US-50
    // Checks if the first worst delt after the Skip Cards is a Single Red Card
    public void checkWorstCardRed() throws Exception {
        Card resultCard;
        for (int i=0; i<5; i++)
          resultCard = deck.drawWorstCard(-1);    //draws out the 5 skip cards
        resultCard = deck.drawWorstCard(-1);
        Card expectedCard = new Card (CardColor.RED, Constants.SINGLE);
        assertTrue(deck.sameCard(expectedCard, resultCard));

    }

}
