import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.*;

@RunWith(MockitoJUnitRunner.class)
public class CardDeckGUITest {

    @Mock
    Graphics graphics;
    @Mock
    Card card;
    @Mock
    DeckOfCards deck;
    CardDeckGUI cardDeckGUI;
    CardDeckGUI spy;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        WorldOfSweets.pNames = new String[2];
        WorldOfSweets.pNames[0] = "Player 1";
        WorldOfSweets.pNames[1] = "Player 2";
        cardDeckGUI = new CardDeckGUI();
        spy = Mockito.spy(cardDeckGUI);
    }

    @Test
    // US-27
    public void testSkipCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(null);
        Mockito.when(card.getValue()).thenReturn(0);
        spy.drawCard(graphics, card, 0, 0);
        Mockito.verify(graphics, Mockito.times(1)).drawString("SKIP!", (CardDeckGUI.CARDWIDTH / 2 - CardDeckGUI.BLOCKSIZE / 2),
                CardDeckGUI.CARDHEIGHT / 2);
    }

    @Test
    // US-27
    public void testGoToMiddleCard() throws Exception {
        Mockito.when(card.getColor()).thenReturn(null);
        Mockito.when(card.getValue()).thenReturn(45);
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

    @Test
    // US-31
    public void testDoDrawNoGameInProgress() throws Exception {
        spy.gameInProgress = false;
        spy.doDraw();
        Assert.assertEquals(null, spy.lastCard);
    }

    @Test

    // US-31
    public void testDoDrawGameInProgress() throws Exception {
        spy.doDraw();
        Mockito.verify(spy).repaint();
    }

    @Test
    // US-31
    public void testDoNewGameGameInProgress() throws Exception {
        spy.gameInProgress = true;
        spy.doNewGame();
        Assert.assertEquals("You still have to finish the game!", spy.message);
    }

    @Test
    // US-31
    public void testNewCard() throws Exception {
        Card card = spy.newCard();
        Assert.assertNotNull(card);
    }

    @Test
    // US-31
    public void testNewCardDeckEmpty() throws Exception {
        for (int i = 0; i < 68; i++) {
            spy.deck.drawCard();
        }
        Card card = spy.newCard();
        Assert.assertNotNull(card);
    }
}