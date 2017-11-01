import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;

public class CardDeckGUITest {

    Graphics graphics;
    Card card;
    DeckOfCards deck;
    CardDeckGUI cardDeckGUI;

    @Before
    public void setup() {
        graphics = Mockito.mock(Graphics.class);
        card = Mockito.mock(Card.class);
        deck = Mockito.mock(DeckOfCards.class);
        WorldOfSweets.pNames = new String[2];
        cardDeckGUI = new CardDeckGUI();
    }

    @Test
    // US-27
    public void testSkipCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(null);
        Mockito.when(card.getValue()).thenReturn(0);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).drawString("SKIP!", (CardDeckGUI.CARDWIDTH / 2 - CardDeckGUI.BLOCKSIZE / 2),
                CardDeckGUI.CARDHEIGHT / 2);
    }

    @Test
    // US-27
    public void testGoToMiddleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(null);
        Mockito.when(card.getValue()).thenReturn(20);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).drawString("Go To", (CardDeckGUI.CARDWIDTH / 2 - CardDeckGUI.BLOCKSIZE / 2),
                CardDeckGUI.CARDHEIGHT / 3 - CardDeckGUI.BLOCKSIZE / 3);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.MAGENTA);
    }

    @Test
    public void testGreenSingleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.GREEN);
        Mockito.when(card.getValue()).thenReturn(1);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.GREEN);
    }

    @Test
    public void testOrangeSingleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.ORANGE);
        Mockito.when(card.getValue()).thenReturn(1);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.ORANGE);
    }

    @Test
    public void testRedSingleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.RED);
        Mockito.when(card.getValue()).thenReturn(1);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.RED);
    }

    @Test
    public void testYellowSingleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.YELLOW);
        Mockito.when(card.getValue()).thenReturn(1);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.YELLOW);
    }

    @Test
    public void testBlueSingleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.BLUE);
        Mockito.when(card.getValue()).thenReturn(1);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(2)).setColor(Color.BLUE);
    }

    @Test
    public void testGreenDoubleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.GREEN);
        Mockito.when(card.getValue()).thenReturn(2);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.GREEN);
    }

    @Test
    public void testOrangeDoubleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.ORANGE);
        Mockito.when(card.getValue()).thenReturn(2);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.ORANGE);
    }

    @Test
    public void testRedDoubleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.RED);
        Mockito.when(card.getValue()).thenReturn(2);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.RED);
    }

    @Test
    public void testYellowDoubleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.YELLOW);
        Mockito.when(card.getValue()).thenReturn(2);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.YELLOW);
    }

    @Test
    public void testBlueDoubleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.BLUE);
        Mockito.when(card.getValue()).thenReturn(2);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(2)).setColor(Color.BLUE);
    }

    @Test
    public void testDrawCardNull() throws Exception {
        cardDeckGUI.drawCard(graphics, null, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.WHITE);
    }
}