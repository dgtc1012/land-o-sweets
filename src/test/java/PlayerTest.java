import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/************************************************
 * all tests in this file pertain to US-28 except the last 2
 ************************************************/
public class PlayerTest {
    Player player;

    @Before
    public void setup(){
        player = new Player(1, "player1");
        WorldOfSweets.players = new Player[2];
        WorldOfSweets.players[0] = new Player(1, "p1");
        WorldOfSweets.players[1] = new Player(2, "p1");
        WorldOfSweets.gameboard = new Gameboard();
    }

    @Test
    //check that initial position starts at -1
    public void checkStartPosition() throws Exception{
        assertEquals(-1, player.getCurrentSquareValue());
    }

    @Test
    //check that initial color is orange
    public void checkStartColor() throws Exception{
        assertEquals(CardColor.ORANGE, player.getCurrentSquareColor());
    }

    @Test
    //Orange to Red single
    public void checkOrangetoRedSingleTransition() throws Exception{
        player.newCardDrawn(1, CardColor.RED);
        assertEquals(CardColor.RED, player.getCurrentSquareColor());
        assertEquals(0, player.getCurrentSquareValue());
    }

    @Test
    //Orange to Yellow single
    public void checkOrangetoYellowSingleTransition() throws Exception{
        player.moveToken(-1, CardColor.ORANGE);
        player.newCardDrawn(1, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player.getCurrentSquareColor());
        assertEquals(1, player.getCurrentSquareValue());
    }

    @Test
    //Orange to Blue single
    public void checkOrangetoBlueSingleTransition() throws Exception{
        player.moveToken(-1, CardColor.ORANGE);
        player.newCardDrawn(1, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player.getCurrentSquareColor());
        assertEquals(2, player.getCurrentSquareValue());
    }

    @Test
    //Orange to Green single
    public void checkOrangetoGreenSingleTransition() throws Exception{
        player.moveToken(-1, CardColor.ORANGE);
        player.newCardDrawn(1, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player.getCurrentSquareColor());
        assertEquals(3, player.getCurrentSquareValue());
    }

    @Test
    //Orange to Orange single
    public void checkOrangetoOrangeSingleTransition() throws Exception{
        player.moveToken(-1, CardColor.ORANGE);
        player.newCardDrawn(1, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player.getCurrentSquareColor());
        assertEquals(4, player.getCurrentSquareValue());
    }

    //Start on RED
    @Test
    //Red to Red single
    public void checkRedtoRedSingleTransition() throws Exception{
        player.moveToken(0, CardColor.RED);
        player.newCardDrawn(1, CardColor.RED);
        assertEquals(CardColor.RED, player.getCurrentSquareColor());
        assertEquals(5, player.getCurrentSquareValue());
    }

    @Test
    //Red to Yellow single
    public void checkRedtoYellowSingleTransition() throws Exception{
        player.moveToken(0, CardColor.RED);
        player.newCardDrawn(1, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player.getCurrentSquareColor());
        assertEquals(1, player.getCurrentSquareValue());
    }

    @Test
    //Red to Blue single
    public void checkRedtoBlueSingleTransition() throws Exception{
        player.moveToken(0, CardColor.RED);
        player.newCardDrawn(1, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player.getCurrentSquareColor());
        assertEquals(2, player.getCurrentSquareValue());
    }

    @Test
    //Red to Green single
    public void checkRedtoGreenSingleTransition() throws Exception{
        player.moveToken(0, CardColor.RED);
        player.newCardDrawn(1, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player.getCurrentSquareColor());
        assertEquals(3, player.getCurrentSquareValue());
    }

    @Test
    //Red to Orange single
    public void checkRedtoOrangeSingleTransition() throws Exception{
        player.moveToken(0, CardColor.RED);
        player.newCardDrawn(1, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player.getCurrentSquareColor());
        assertEquals(4, player.getCurrentSquareValue());
    }

    //Start on Yellow
    @Test
    //Yellow to Red single
    public void checkYellowtoRedSingleTransition() throws Exception{
        player.moveToken(1, CardColor.YELLOW);
        player.newCardDrawn(1, CardColor.RED);
        assertEquals(CardColor.RED, player.getCurrentSquareColor());
        assertEquals(5, player.getCurrentSquareValue());
    }

    @Test
    //Yellow to Yellow single
    public void checkYellowtoYellowSingleTransition() throws Exception{
        player.moveToken(1, CardColor.YELLOW);
        player.newCardDrawn(1, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player.getCurrentSquareColor());
        assertEquals(6, player.getCurrentSquareValue());
    }

    @Test
    //Yellow to Blue single
    public void checkYellowtoBlueSingleTransition() throws Exception{
        player.moveToken(1, CardColor.YELLOW);
        player.newCardDrawn(1, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player.getCurrentSquareColor());
        assertEquals(2, player.getCurrentSquareValue());
    }

    @Test
    //Yellow to Green single
    public void checkYellowtoGreenSingleTransition() throws Exception{
        player.moveToken(1, CardColor.YELLOW);
        player.newCardDrawn(1, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player.getCurrentSquareColor());
        assertEquals(3, player.getCurrentSquareValue());
    }

    @Test
    //Yellow to Orange single
    public void checkYellowtoOrangeSingleTransition() throws Exception{
        player.moveToken(1, CardColor.YELLOW);
        player.newCardDrawn(1, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player.getCurrentSquareColor());
        assertEquals(4, player.getCurrentSquareValue());
    }

    //Start on Blue
    @Test
    //Blue to Red single
    public void checkBluetoRedSingleTransition() throws Exception{
        player.moveToken(2, CardColor.BLUE);
        player.newCardDrawn(1, CardColor.RED);
        assertEquals(CardColor.RED, player.getCurrentSquareColor());
        assertEquals(5, player.getCurrentSquareValue());
    }

    @Test
    //Blue to Yellow single
    public void checkBluetoYellowSingleTransition() throws Exception{
        player.moveToken(2, CardColor.BLUE);
        player.newCardDrawn(1, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player.getCurrentSquareColor());
        assertEquals(6, player.getCurrentSquareValue());
    }

    @Test
    //Blue to Blue single
    public void checkBluetoBlueSingleTransition() throws Exception{
        player.moveToken(2, CardColor.BLUE);
        player.newCardDrawn(1, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player.getCurrentSquareColor());
        assertEquals(7, player.getCurrentSquareValue());
    }

    @Test
    //Blue to Green single
    public void checkBluetoGreenSingleTransition() throws Exception{
        player.moveToken(2, CardColor.BLUE);
        player.newCardDrawn(1, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player.getCurrentSquareColor());
        assertEquals(3, player.getCurrentSquareValue());
    }

    @Test
    //Blue to Orange single
    public void checkBluetoOrangeSingleTransition() throws Exception{
        player.moveToken(2, CardColor.BLUE);
        player.newCardDrawn(1, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player.getCurrentSquareColor());
        assertEquals(4, player.getCurrentSquareValue());
    }

    //Start on Green
    @Test
    //Green to Red single
    public void checkGreentoRedSingleTransition() throws Exception{
        player.moveToken(3, CardColor.GREEN);
        player.newCardDrawn(1, CardColor.RED);
        assertEquals(CardColor.RED, player.getCurrentSquareColor());
        assertEquals(5, player.getCurrentSquareValue());
    }

    @Test
    //Green to Yellow single
    public void checkGreentoYellowSingleTransition() throws Exception{
        player.moveToken(3, CardColor.GREEN);
        player.newCardDrawn(1, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player.getCurrentSquareColor());
        assertEquals(6, player.getCurrentSquareValue());
    }

    @Test
    //Green to Blue single
    public void checkGreentoBlueSingleTransition() throws Exception{
        player.moveToken(3, CardColor.GREEN);
        player.newCardDrawn(1, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player.getCurrentSquareColor());
        assertEquals(7, player.getCurrentSquareValue());
    }

    @Test
    //Green to Green single
    public void checkGreentoGreenSingleTransition() throws Exception{
        player.moveToken(3, CardColor.GREEN);
        player.newCardDrawn(1, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player.getCurrentSquareColor());
        assertEquals(8, player.getCurrentSquareValue());
    }

    @Test
    //Green to Orange single
    public void checkGreentoOrangeSingleTransition() throws Exception{
        player.moveToken(3, CardColor.GREEN);
        player.newCardDrawn(1, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player.getCurrentSquareColor());
        assertEquals(4, player.getCurrentSquareValue());
    }

//*******************************************************************************************
    //double cards

    //start on Orange
    @Test
    //Orange to Red Double
    public void checkOrangetoRedDoubleTransition() throws Exception{
        player.moveToken(-1, CardColor.ORANGE);
        player.newCardDrawn(2, CardColor.RED);
        assertEquals(CardColor.RED, player.getCurrentSquareColor());
        assertEquals(0+5, player.getCurrentSquareValue());
    }

    @Test
    //Orange to Yellow Double
    public void checkOrangetoYellowDoubleTransition() throws Exception{
        player.moveToken(-1, CardColor.ORANGE);
        player.newCardDrawn(2, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player.getCurrentSquareColor());
        assertEquals(1+5, player.getCurrentSquareValue());
    }

    @Test
    //Orange to Blue Double
    public void checkOrangetoBlueDoubleTransition() throws Exception{
        player.moveToken(-1, CardColor.ORANGE);
        player.newCardDrawn(2, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player.getCurrentSquareColor());
        assertEquals(2+5, player.getCurrentSquareValue());
    }

    @Test
    //Orange to Green Double
    public void checkOrangetoGreenDoubleTransition() throws Exception{
        player.moveToken(-1, CardColor.ORANGE);
        player.newCardDrawn(2, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player.getCurrentSquareColor());
        assertEquals(3+5, player.getCurrentSquareValue());
    }

    @Test
    //Orange to Orange Double
    public void checkOrangetoOrangeDoubleTransition() throws Exception{
        player.moveToken(-1, CardColor.ORANGE);
        player.newCardDrawn(2, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player.getCurrentSquareColor());
        assertEquals(4+5, player.getCurrentSquareValue());
    }

    //Start on RED
    @Test
    //Red to Red Double
    public void checkRedtoRedDoubleTransition() throws Exception{
        player.moveToken(0, CardColor.RED);
        player.newCardDrawn(2, CardColor.RED);
        assertEquals(CardColor.RED, player.getCurrentSquareColor());
        assertEquals(5+5, player.getCurrentSquareValue());
    }

    @Test
    //Red to Yellow Double
    public void checkRedtoYellowDoubleTransition() throws Exception{
        player.moveToken(0, CardColor.RED);
        player.newCardDrawn(2, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player.getCurrentSquareColor());
        assertEquals(1+5, player.getCurrentSquareValue());
    }

    @Test
    //Red to Blue Double
    public void checkRedtoBlueDoubleTransition() throws Exception{
        player.moveToken(0, CardColor.RED);
        player.newCardDrawn(2, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player.getCurrentSquareColor());
        assertEquals(2+5, player.getCurrentSquareValue());
    }

    @Test
    //Red to Green Double
    public void checkRedtoGreenDoubleTransition() throws Exception{
        player.moveToken(0, CardColor.RED);
        player.newCardDrawn(2, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player.getCurrentSquareColor());
        assertEquals(3+5, player.getCurrentSquareValue());
    }

    @Test
    //Red to Orange Double
    public void checkRedtoOrangeDoubleTransition() throws Exception{
        player.moveToken(0, CardColor.RED);
        player.newCardDrawn(2, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player.getCurrentSquareColor());
        assertEquals(4+5, player.getCurrentSquareValue());
    }

    //Start on Yellow
    @Test
    //Yellow to Red Double
    public void checkYellowtoRedDoubleTransition() throws Exception{
        player.moveToken(1, CardColor.YELLOW);
        player.newCardDrawn(2, CardColor.RED);
        assertEquals(CardColor.RED, player.getCurrentSquareColor());
        assertEquals(5+5, player.getCurrentSquareValue());
    }

    @Test
    //Yellow to Yellow Double
    public void checkYellowtoYellowDoubleTransition() throws Exception{
        player.moveToken(1, CardColor.YELLOW);
        player.newCardDrawn(2, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player.getCurrentSquareColor());
        assertEquals(6+5, player.getCurrentSquareValue());
    }

    @Test
    //Yellow to Blue Double
    public void checkYellowtoBlueDoubleTransition() throws Exception{
        player.moveToken(1, CardColor.YELLOW);
        player.newCardDrawn(2, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player.getCurrentSquareColor());
        assertEquals(2+5, player.getCurrentSquareValue());
    }

    @Test
    //Yellow to Green Double
    public void checkYellowtoGreenDoubleTransition() throws Exception{
        player.moveToken(1, CardColor.YELLOW);
        player.newCardDrawn(2, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player.getCurrentSquareColor());
        assertEquals(3+5, player.getCurrentSquareValue());
    }

    @Test
    //Yellow to Orange Double
    public void checkYellowtoOrangeDoubleTransition() throws Exception{
        player.moveToken(1, CardColor.YELLOW);
        player.newCardDrawn(2, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player.getCurrentSquareColor());
        assertEquals(4+5, player.getCurrentSquareValue());
    }

    //Start on Blue
    @Test
    //Blue to Red Double
    public void checkBluetoRedDoubleTransition() throws Exception{
        player.moveToken(2, CardColor.BLUE);
        player.newCardDrawn(2, CardColor.RED);
        assertEquals(CardColor.RED, player.getCurrentSquareColor());
        assertEquals(5+5, player.getCurrentSquareValue());
    }

    @Test
    //Blue to Yellow Double
    public void checkBluetoYellowDoubleTransition() throws Exception{
        player.moveToken(2, CardColor.BLUE);
        player.newCardDrawn(2, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player.getCurrentSquareColor());
        assertEquals(6+5, player.getCurrentSquareValue());
    }

    @Test
    //Blue to Blue Double
    public void checkBluetoBlueDoubleTransition() throws Exception{
        player.moveToken(2, CardColor.BLUE);
        player.newCardDrawn(2, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player.getCurrentSquareColor());
        assertEquals(7+5, player.getCurrentSquareValue());
    }

    @Test
    //Blue to Green Double
    public void checkBluetoGreenDoubleTransition() throws Exception{
        player.moveToken(2, CardColor.BLUE);
        player.newCardDrawn(2, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player.getCurrentSquareColor());
        assertEquals(3+5, player.getCurrentSquareValue());
    }

    @Test
    //Blue to Orange Double
    public void checkBluetoOrangeDoubleTransition() throws Exception{
        player.moveToken(2, CardColor.BLUE);
        player.newCardDrawn(2, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player.getCurrentSquareColor());
        assertEquals(4+5, player.getCurrentSquareValue());
    }

    //Start on Green
    @Test
    //Green to Red Double
    public void checkGreentoRedDoubleTransition() throws Exception{
        player.moveToken(3, CardColor.GREEN);
        player.newCardDrawn(2, CardColor.RED);
        assertEquals(CardColor.RED, player.getCurrentSquareColor());
        assertEquals(5+5, player.getCurrentSquareValue());
    }

    @Test
    //Green to Yellow Double
    public void checkGreentoYellowDoubleTransition() throws Exception{
        player.moveToken(3, CardColor.GREEN);
        player.newCardDrawn(2, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player.getCurrentSquareColor());
        assertEquals(6+5, player.getCurrentSquareValue());
    }

    @Test
    //Green to Blue Double
    public void checkGreentoBlueDoubleTransition() throws Exception{
        player.moveToken(3, CardColor.GREEN);
        player.newCardDrawn(2, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player.getCurrentSquareColor());
        assertEquals(7+5, player.getCurrentSquareValue());
    }

    @Test
    //Green to Green Double
    public void checkGreentoGreenDoubleTransition() throws Exception{
        player.moveToken(3, CardColor.GREEN);
        player.newCardDrawn(2, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player.getCurrentSquareColor());
        assertEquals(8+5, player.getCurrentSquareValue());
    }

    @Test
    //Green to Orange Double
    public void checkGreentoOrangeDoubleTransition() throws Exception{
        player.moveToken(3, CardColor.GREEN);
        player.newCardDrawn(2, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player.getCurrentSquareColor());
        assertEquals(4+5, player.getCurrentSquareValue());
    }

//Special cards

    @Test
    //US-30
    //skip card
    public void checkSkipCardResponse() throws Exception{
        player.moveToken(5, CardColor.RED);
        player.newCardDrawn(0, null);
        assertEquals(5, player.getCurrentSquareValue());
    }

    @Test
    //US-29
    //middle card proceed forward
    public void checkMiddleCardResponse_Forward() throws Exception{
        player.moveToken(5, CardColor.RED);
        player.newCardDrawn(45, null);
        assertEquals((WorldOfSweets.getBoardLength()-1)/2, player.getCurrentSquareValue());
    }

    @Test
    //US-29
    //middle card recede back
    public void checkMiddleCardResponse_Back() throws Exception{
        player.moveToken(5*15, CardColor.RED);
        player.newCardDrawn(45, null);
        assertEquals((WorldOfSweets.getBoardLength()-1)/2, player.getCurrentSquareValue());
    }
}
