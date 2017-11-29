import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/************************************************
 * all tests in this file pertain to US-28 except the last 2
 ************************************************/
public class BoomerangTest {

    Player player1;
    Player player2;

    @Before
    public void setup() {
        player1 = new Player(1, "p1", false);
        player2 = new Player(2, "p2", false);
        WorldOfSweets.players = new Player[2];
        WorldOfSweets.players[0] = player1;
        WorldOfSweets.players[1] = player2;
        WorldOfSweets.pNames = new String[2];
        WorldOfSweets.pNames[0] = "p1";
        WorldOfSweets.pNames[1] = "p2";
        WorldOfSweets.gameboard = new Gameboard();
        WorldOfSweets.gameModeStrategic = true;
    }

    @Test
    //US-46
    public void testStartBoomerangCount() {
        assertEquals(3, player1.getBoomerangs());
    }

    @Test
    //US-46
    public void testBoomerangDecrementing() {
        assertEquals(3, player1.getBoomerangs());
        player1.decrementBoomerangCount();
        assertEquals(2, player1.getBoomerangs());
        player1.decrementBoomerangCount();
        assertEquals(1, player1.getBoomerangs());
        player1.decrementBoomerangCount();
        assertEquals(0, player1.getBoomerangs());
        player1.decrementBoomerangCount();
        assertEquals(0, player1.getBoomerangs());
    }

    /*
    * All tests below are for US-47
    * */
    @Test
    //Orange to Red single
    public void checkOrangetoRedSingleTransition() throws Exception {
        player1.moveToken(4, CardColor.ORANGE);
        player1.useBoomerang(1, CardColor.RED);
        assertEquals(CardColor.RED, player1.getCurrentSquareColor());
        assertEquals(0, player1.getCurrentSquareValue());
    }

    @Test
    //Orange to Yellow single
    public void checkOrangetoYellowSingleTransition() throws Exception {
        player1.moveToken(4, CardColor.ORANGE);
        player1.useBoomerang(1, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player1.getCurrentSquareColor());
        assertEquals(1, player1.getCurrentSquareValue());
    }

    @Test
    //Orange to Blue single
    public void checkOrangetoBlueSingleTransition() throws Exception {
        player1.moveToken(4, CardColor.ORANGE);
        player1.useBoomerang(1, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(2, player1.getCurrentSquareValue());
    }

    @Test
    //Orange to Green single
    public void checkOrangetoGreenSingleTransition() throws Exception {
        player1.moveToken(4, CardColor.ORANGE);
        player1.useBoomerang(1, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player1.getCurrentSquareColor());
        assertEquals(3, player1.getCurrentSquareValue());
    }

    @Test
    //Orange to Orange single
    public void checkOrangetoOrangeSingleTransition() throws Exception {
        player1.moveToken(4, CardColor.ORANGE);
        player1.useBoomerang(1, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player1.getCurrentSquareColor());
        assertEquals(-1, player1.getCurrentSquareValue());
    }

    //Start on RED
    @Test
    //Red to Red single
    public void checkRedtoRedSingleTransition() throws Exception {
        player1.moveToken(5, CardColor.RED);
        player1.useBoomerang(1, CardColor.RED);
        assertEquals(CardColor.RED, player1.getCurrentSquareColor());
        assertEquals(0, player1.getCurrentSquareValue());
    }

    @Test
    //Red to Yellow single
    public void checkRedtoYellowSingleTransition() throws Exception {
        player1.moveToken(5, CardColor.RED);
        player1.useBoomerang(1, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player1.getCurrentSquareColor());
        assertEquals(1, player1.getCurrentSquareValue());
    }

    @Test
    //Red to Blue single
    public void checkRedtoBlueSingleTransition() throws Exception {
        player1.moveToken(5, CardColor.RED);
        player1.useBoomerang(1, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(2, player1.getCurrentSquareValue());
    }

    @Test
    //Red to Green single
    public void checkRedtoGreenSingleTransition() throws Exception {
        player1.moveToken(5, CardColor.RED);
        player1.useBoomerang(1, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player1.getCurrentSquareColor());
        assertEquals(3, player1.getCurrentSquareValue());
    }

    @Test
    //Red to Orange single
    public void checkRedtoOrangeSingleTransition() throws Exception {
        player1.moveToken(5, CardColor.RED);
        player1.useBoomerang(1, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player1.getCurrentSquareColor());
        assertEquals(4, player1.getCurrentSquareValue());
    }

    //Start on Yellow
    @Test
    //Yellow to Red single
    public void checkYellowtoRedSingleTransition() throws Exception {
        player1.moveToken(6, CardColor.YELLOW);
        player1.useBoomerang(1, CardColor.RED);
        assertEquals(CardColor.RED, player1.getCurrentSquareColor());
        assertEquals(5, player1.getCurrentSquareValue());
    }

    @Test
    //Yellow to Yellow single
    public void checkYellowtoYellowSingleTransition() throws Exception {
        player1.moveToken(6, CardColor.YELLOW);
        player1.useBoomerang(1, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player1.getCurrentSquareColor());
        assertEquals(1, player1.getCurrentSquareValue());
    }

    @Test
    //Yellow to Blue single
    public void checkYellowtoBlueSingleTransition() throws Exception {
        player1.moveToken(6, CardColor.YELLOW);
        player1.useBoomerang(1, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(2, player1.getCurrentSquareValue());
    }

    @Test
    //Yellow to Green single
    public void checkYellowtoGreenSingleTransition() throws Exception {
        player1.moveToken(6, CardColor.YELLOW);
        player1.useBoomerang(1, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player1.getCurrentSquareColor());
        assertEquals(3, player1.getCurrentSquareValue());
    }

    @Test
    //Yellow to Orange single
    public void checkYellowtoOrangeSingleTransition() throws Exception {
        player1.moveToken(6, CardColor.YELLOW);
        player1.useBoomerang(1, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player1.getCurrentSquareColor());
        assertEquals(4, player1.getCurrentSquareValue());
    }

    //Start on Blue
    @Test
    //Blue to Red single
    public void checkBluetoRedSingleTransition() throws Exception {
        player1.moveToken(7, CardColor.BLUE);
        player1.useBoomerang(1, CardColor.RED);
        assertEquals(CardColor.RED, player1.getCurrentSquareColor());
        assertEquals(5, player1.getCurrentSquareValue());
    }

    @Test
    //Blue to Yellow single
    public void checkBluetoYellowSingleTransition() throws Exception {
        player1.moveToken(7, CardColor.BLUE);
        player1.useBoomerang(1, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player1.getCurrentSquareColor());
        assertEquals(6, player1.getCurrentSquareValue());
    }

    @Test
    //Blue to Blue single
    public void checkBluetoBlueSingleTransition() throws Exception {
        player1.moveToken(7, CardColor.BLUE);
        player1.useBoomerang(1, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(2, player1.getCurrentSquareValue());
    }

    @Test
    //Blue to Green single
    public void checkBluetoGreenSingleTransition() throws Exception {
        player1.moveToken(7, CardColor.BLUE);
        player1.useBoomerang(1, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player1.getCurrentSquareColor());
        assertEquals(3, player1.getCurrentSquareValue());
    }

    @Test
    //Blue to Orange single
    public void checkBluetoOrangeSingleTransition() throws Exception {
        player1.moveToken(7, CardColor.BLUE);
        player1.useBoomerang(1, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player1.getCurrentSquareColor());
        assertEquals(4, player1.getCurrentSquareValue());
    }

    //Start on Green
    @Test
    //Green to Red single
    public void checkGreentoRedSingleTransition() throws Exception {
        player1.moveToken(8, CardColor.GREEN);
        player1.useBoomerang(1, CardColor.RED);
        assertEquals(CardColor.RED, player1.getCurrentSquareColor());
        assertEquals(5, player1.getCurrentSquareValue());
    }

    @Test
    //Green to Yellow single
    public void checkGreentoYellowSingleTransition() throws Exception {
        player1.moveToken(8, CardColor.GREEN);
        player1.useBoomerang(1, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player1.getCurrentSquareColor());
        assertEquals(6, player1.getCurrentSquareValue());
    }

    @Test
    //Green to Blue single
    public void checkGreentoBlueSingleTransition() throws Exception {
        player1.moveToken(8, CardColor.GREEN);
        player1.useBoomerang(1, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(7, player1.getCurrentSquareValue());
    }

    @Test
    //Green to Green single
    public void checkGreentoGreenSingleTransition() throws Exception {
        player1.moveToken(8, CardColor.GREEN);
        player1.useBoomerang(1, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player1.getCurrentSquareColor());
        assertEquals(3, player1.getCurrentSquareValue());
    }

    @Test
    //Green to Orange single
    public void checkGreentoOrangeSingleTransition() throws Exception {
        player1.moveToken(8, CardColor.GREEN);
        player1.useBoomerang(1, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player1.getCurrentSquareColor());
        assertEquals(4, player1.getCurrentSquareValue());
    }

//*******************************************************************************************
    //double cards

    //start on Orange
    @Test
    //Orange to Red Double
    public void checkOrangetoRedDoubleTransition() throws Exception {
        player1.moveToken(4 + 5 + 5, CardColor.ORANGE);
        player1.useBoomerang(2, CardColor.RED);
        assertEquals(CardColor.RED, player1.getCurrentSquareColor());
        assertEquals(5, player1.getCurrentSquareValue());
    }

    @Test
    //Orange to Yellow Double
    public void checkOrangetoYellowDoubleTransition() throws Exception {
        player1.moveToken(4 + 5 + 5, CardColor.ORANGE);
        player1.useBoomerang(2, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player1.getCurrentSquareColor());
        assertEquals(6, player1.getCurrentSquareValue());
    }

    @Test
    //Orange to Blue Double
    public void checkOrangetoBlueDoubleTransition() throws Exception {
        player1.moveToken(4 + 5 + 5, CardColor.ORANGE);
        player1.useBoomerang(2, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(7, player1.getCurrentSquareValue());
    }

    @Test
    //Orange to Green Double
    public void checkOrangetoGreenDoubleTransition() throws Exception {
        player1.moveToken(4 + 5 + 5, CardColor.ORANGE);
        player1.useBoomerang(2, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player1.getCurrentSquareColor());
        assertEquals(8, player1.getCurrentSquareValue());
    }

    @Test
    //Orange to Orange Double
    public void checkOrangetoOrangeDoubleTransition() throws Exception {
        player1.moveToken(4 + 5 + 5, CardColor.ORANGE);
        player1.useBoomerang(2, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player1.getCurrentSquareColor());
        assertEquals(4, player1.getCurrentSquareValue());
    }

    //Start on RED
    @Test
    //Red to Red Double
    public void checkRedtoRedDoubleTransition() throws Exception {
        player1.moveToken(0 + 5 + 5, CardColor.RED);
        player1.useBoomerang(2, CardColor.RED);
        assertEquals(CardColor.RED, player1.getCurrentSquareColor());
        assertEquals(0, player1.getCurrentSquareValue());
    }

    @Test
    //Red to Yellow Double
    public void checkRedtoYellowDoubleTransition() throws Exception {
        player1.moveToken(0 + 5 + 5, CardColor.RED);
        player1.useBoomerang(2, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player1.getCurrentSquareColor());
        assertEquals(1, player1.getCurrentSquareValue());
    }

    @Test
    //Red to Blue Double
    public void checkRedtoBlueDoubleTransition() throws Exception {
        player1.moveToken(0 + 5 + 5, CardColor.RED);
        player1.useBoomerang(2, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(2, player1.getCurrentSquareValue());
    }

    @Test
    //Red to Green Double
    public void checkRedtoGreenDoubleTransition() throws Exception {
        player1.moveToken(0 + 5 + 5, CardColor.RED);
        player1.useBoomerang(2, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player1.getCurrentSquareColor());
        assertEquals(3, player1.getCurrentSquareValue());
    }

    @Test
    //Red to Orange Double
    public void checkRedtoOrangeDoubleTransition() throws Exception {
        player1.moveToken(0 + 5 + 5, CardColor.RED);
        player1.useBoomerang(2, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player1.getCurrentSquareColor());
        assertEquals(4, player1.getCurrentSquareValue());
    }

    //Start on Yellow
    @Test
    //Yellow to Red Double
    public void checkYellowtoRedDoubleTransition() throws Exception {
        player1.moveToken(1 + 5 + 5, CardColor.YELLOW);
        player1.useBoomerang(2, CardColor.RED);
        assertEquals(CardColor.RED, player1.getCurrentSquareColor());
        assertEquals(5, player1.getCurrentSquareValue());
    }

    @Test
    //Yellow to Yellow Double
    public void checkYellowtoYellowDoubleTransition() throws Exception {
        player1.moveToken(1 + 5 + 5, CardColor.YELLOW);
        player1.useBoomerang(2, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player1.getCurrentSquareColor());
        assertEquals(1, player1.getCurrentSquareValue());
    }

    @Test
    //Yellow to Blue Double
    public void checkYellowtoBlueDoubleTransition() throws Exception {
        player1.moveToken(1 + 5 + 5, CardColor.YELLOW);
        player1.useBoomerang(2, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(2, player1.getCurrentSquareValue());
    }

    @Test
    //Yellow to Green Double
    public void checkYellowtoGreenDoubleTransition() throws Exception {
        player1.moveToken(1 + 5 + 5, CardColor.YELLOW);
        player1.useBoomerang(2, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player1.getCurrentSquareColor());
        assertEquals(3, player1.getCurrentSquareValue());
    }

    @Test
    //Yellow to Orange Double
    public void checkYellowtoOrangeDoubleTransition() throws Exception {
        player1.moveToken(1 + 5 + 5, CardColor.YELLOW);
        player1.useBoomerang(2, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player1.getCurrentSquareColor());
        assertEquals(4, player1.getCurrentSquareValue());
    }

    //Start on Blue
    @Test
    //Blue to Red Double
    public void checkBluetoRedDoubleTransition() throws Exception {
        player1.moveToken(2 + 5 + 5, CardColor.BLUE);
        player1.useBoomerang(2, CardColor.RED);
        assertEquals(CardColor.RED, player1.getCurrentSquareColor());
        assertEquals(5, player1.getCurrentSquareValue());
    }

    @Test
    //Blue to Yellow Double
    public void checkBluetoYellowDoubleTransition() throws Exception {
        player1.moveToken(2 + 5 + 5, CardColor.BLUE);
        player1.useBoomerang(2, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player1.getCurrentSquareColor());
        assertEquals(6, player1.getCurrentSquareValue());
    }

    @Test
    //Blue to Blue Double
    public void checkBluetoBlueDoubleTransition() throws Exception {
        player1.moveToken(2 + 5 + 5, CardColor.BLUE);
        player1.useBoomerang(2, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(2, player1.getCurrentSquareValue());
    }

    @Test
    //Blue to Green Double
    public void checkBluetoGreenDoubleTransition() throws Exception {
        player1.moveToken(2 + 5 + 5, CardColor.BLUE);
        player1.useBoomerang(2, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player1.getCurrentSquareColor());
        assertEquals(3, player1.getCurrentSquareValue());
    }

    @Test
    //Blue to Orange Double
    public void checkBluetoOrangeDoubleTransition() throws Exception {
        player1.moveToken(2 + 5 + 5, CardColor.BLUE);
        player1.useBoomerang(2, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player1.getCurrentSquareColor());
        assertEquals(4, player1.getCurrentSquareValue());
    }

    //Start on Green
    @Test
    //Green to Red Double
    public void checkGreentoRedDoubleTransition() throws Exception {
        player1.moveToken(3 + 5 + 5, CardColor.GREEN);
        player1.useBoomerang(2, CardColor.RED);
        assertEquals(CardColor.RED, player1.getCurrentSquareColor());
        assertEquals(5, player1.getCurrentSquareValue());
    }

    @Test
    //Green to Yellow Double
    public void checkGreentoYellowDoubleTransition() throws Exception {
        player1.moveToken(3 + 5 + 5, CardColor.GREEN);
        player1.useBoomerang(2, CardColor.YELLOW);
        assertEquals(CardColor.YELLOW, player1.getCurrentSquareColor());
        assertEquals(6, player1.getCurrentSquareValue());
    }

    @Test
    //Green to Blue Double
    public void checkGreentoBlueDoubleTransition() throws Exception {
        player1.moveToken(3 + 5 + 5, CardColor.GREEN);
        player1.useBoomerang(2, CardColor.BLUE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(7, player1.getCurrentSquareValue());
    }

    @Test
    //Green to Green Double
    public void checkGreentoGreenDoubleTransition() throws Exception {
        player1.moveToken(3 + 5 + 5, CardColor.GREEN);
        player1.useBoomerang(2, CardColor.GREEN);
        assertEquals(CardColor.GREEN, player1.getCurrentSquareColor());
        assertEquals(3, player1.getCurrentSquareValue());
    }

    @Test
    //Green to Orange Double
    public void checkGreentoOrangeDoubleTransition() throws Exception {
        player1.moveToken(3 + 5 + 5, CardColor.GREEN);
        player1.useBoomerang(2, CardColor.ORANGE);
        assertEquals(CardColor.ORANGE, player1.getCurrentSquareColor());
        assertEquals(4, player1.getCurrentSquareValue());
    }

    /*
    * All tests below are for US-48
    * */

    @Test
    public void checkCupcakeTransition() throws Exception {
        player1.useBoomerang(Constants.CUPCAKE, CardColor.ORANGE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(77, player1.getCurrentSquareValue());
    }

    @Test
    public void checkLicoriceTransition() throws Exception {
        player1.useBoomerang(Constants.LICORICE, CardColor.ORANGE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(29, player1.getCurrentSquareValue());
    }

    @Test
    public void checkIcecreamTransition() throws Exception {
        player1.useBoomerang(Constants.ICECREAM, CardColor.ORANGE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(45, player1.getCurrentSquareValue());
    }

    @Test
    public void checkPeppermintTransition() throws Exception {
        player1.useBoomerang(Constants.PEPPERMINT, CardColor.ORANGE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(13, player1.getCurrentSquareValue());
    }

    @Test
    public void checkGingerbreadTransition() throws Exception {
        player1.useBoomerang(Constants.GINGERBREAD, CardColor.ORANGE);
        assertEquals(CardColor.BLUE, player1.getCurrentSquareColor());
        assertEquals(61, player1.getCurrentSquareValue());
    }
}
