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
    public void testGreenSingleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.GREEN);
        Mockito.when(card.getValue()).thenReturn(1);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.GREEN);
    }

    @Test
    // US-27
    public void testOrangeSingleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.ORANGE);
        Mockito.when(card.getValue()).thenReturn(1);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.ORANGE);
    }

    @Test
    // US-27
    public void testRedSingleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.RED);
        Mockito.when(card.getValue()).thenReturn(1);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.RED);
    }

    @Test
    // US-27
    public void testYellowSingleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.YELLOW);
        Mockito.when(card.getValue()).thenReturn(1);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.YELLOW);
    }

    @Test
    // US-27
    public void testBlueSingleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.BLUE);
        Mockito.when(card.getValue()).thenReturn(1);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(2)).setColor(Color.BLUE);
    }

    @Test
    // US-27
    public void testGreenDoubleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.GREEN);
        Mockito.when(card.getValue()).thenReturn(2);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.GREEN);
    }

    @Test
    // US-27
    public void testOrangeDoubleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.ORANGE);
        Mockito.when(card.getValue()).thenReturn(2);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.ORANGE);
    }

    @Test
    // US-27
    public void testRedDoubleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.RED);
        Mockito.when(card.getValue()).thenReturn(2);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.RED);
    }

    @Test
    // US-27
    public void testYellowDoubleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.YELLOW);
        Mockito.when(card.getValue()).thenReturn(2);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.YELLOW);
    }

    @Test
    // US-27
    public void testBlueDoubleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(CardColor.BLUE);
        Mockito.when(card.getValue()).thenReturn(2);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(2)).setColor(Color.BLUE);
    }

    @Test
    // US-27
    public void testDrawCardNull() throws Exception {
        cardDeckGUI.drawCard(graphics, null, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).setColor(Color.WHITE);
    }

    @Test
    // US-36
    public void testLicoriceCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(null);
        Mockito.when(card.getValue()).thenReturn(Constants.LICORICE);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).drawImage(Mockito.any(), Mockito.anyInt(), Mockito.anyInt(), Mockito.any());
    }

    @Test
    // US-36
    public void testIcecreamCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(null);
        Mockito.when(card.getValue()).thenReturn(Constants.ICECREAM);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).drawImage(Mockito.any(), Mockito.anyInt(), Mockito.anyInt(), Mockito.any());
    }

    @Test
    // US-36
    public void testGingerbreadCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(null);
        Mockito.when(card.getValue()).thenReturn(Constants.GINGERBREAD);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).drawImage(Mockito.any(), Mockito.anyInt(), Mockito.anyInt(), Mockito.any());
    }

    @Test
    // US-36
    public void testCupcakeCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(null);
        Mockito.when(card.getValue()).thenReturn(Constants.CUPCAKE);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).drawImage(Mockito.any(), Mockito.anyInt(), Mockito.anyInt(), Mockito.any());
    }

    @Test
    // US-36
    public void testPeppermintCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(null);
        Mockito.when(card.getValue()).thenReturn(Constants.PEPPERMINT);
        cardDeckGUI.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).drawImage(Mockito.any(), Mockito.anyInt(), Mockito.anyInt(), Mockito.any());
    }
}