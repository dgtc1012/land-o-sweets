import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SpecialSquaresTest {

    Card card1;
    Card card2;
    Card card3;
    Card icecream;
    Card gingerbead;
    Player player;

    @Before
    public void setup() {
        player = new Player(1, "player1", false);
        WorldOfSweets.pNames = new String[2];
        WorldOfSweets.pNames[0] = "p1";
        WorldOfSweets.pNames[1] = "p2";
        WorldOfSweets.players = new Player[]{player};
        WorldOfSweets.gameboard = new Gameboard();
        card1 = new Card(CardColor.BLUE, 1);
        card2 = new Card(CardColor.BLUE, 2);
        card3 = new Card(CardColor.GREEN, 1);
        icecream = new Card(null, 4);
        gingerbead = new Card(null, 5);
    }


    @Test
    //US-40
    // Checks if player 1 moves to the ice cream square after recieving the ice cream card
    public void checkMoveToIceCreamSquare() throws Exception {
        int playerSquare = WorldOfSweets.movePlayer(icecream, 0);
        assertEquals(45, playerSquare);

    }


    @Test
    //US-40
    // Checks if player 1 moves to the gingerbread square after recieving the gingerbread card
    public void checkMoveToGingerbreadSquare() throws Exception {
        int playerSquare = WorldOfSweets.movePlayer(gingerbead, 0);
        assertEquals(61, playerSquare);

    }

    @Test
    //US-41
    // Checks if player 1 moves past the peppermint square to the next green
    public void checkMovePastPeppermintSquare() throws Exception {
        WorldOfSweets.movePlayer(card1, 0);
        WorldOfSweets.movePlayer(card2, 0);
        int playerSquare = WorldOfSweets.movePlayer(card3, 0);
        assertEquals(14, playerSquare);

    }


    @Test
    //US-41
    // Checks if player 1 moves past the licorice square to the next green
    public void checkMovePastLicoriceSquare() throws Exception {
        WorldOfSweets.movePlayer(card2, 0);
        WorldOfSweets.movePlayer(card2, 0);
        WorldOfSweets.movePlayer(card2, 0);
        int playerSquare = WorldOfSweets.movePlayer(card3, 0);
        assertEquals(30, playerSquare);
    }

    @Test
    //US-39
    // Checks if the 13th square has a peppermint image
    public void checkPeppermintSquare() throws Exception {
        SpecialSquare s = (SpecialSquare) WorldOfSweets.gameboard.getSquare(13);
        Image img = s.getImage();
        assertEquals(new ImageIcon("src/main/resources/images/peppermint.jpg").getImage(), img);
    }

    @Test
    //US-39
    // Checks if the 77th square has a cupcake image
    public void checkCupcakeSquare() throws Exception {
        SpecialSquare s = (SpecialSquare) WorldOfSweets.gameboard.getSquare(77);
        Image img = s.getImage();
        assertEquals(new ImageIcon("src/main/resources/images/cupcake.jpg").getImage(), img);
    }
}