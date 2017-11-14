import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.*;
import java.awt.*;
import static org.junit.Assert.*;

public class SpecialSquaresTest {

    WorldOfSweets w;
	Token token;
	Card card1;
    Card card2;
    Card card3;
    Card icecream;
    Card gingerbead;
    Player player;

    @Before
    public void setup() {
        w = new WorldOfSweets();
        player = new Player(1, "player1");
        w.gameboard = new Gameboard();
        w.players = new Player[]{player};
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
        int playerSquare = w.movePlayer(icecream, 0);
        assertEquals(45, playerSquare);

    }

    
    @Test
    //US-40
    // Checks if player 1 moves to the gingerbread square after recieving the gingerbread card
    public void checkMoveToGingerbreadSquare() throws Exception {
        int playerSquare = w.movePlayer(gingerbead, 0);
        assertEquals(61, playerSquare);

    }

    @Test
    //US-41
    // Checks if player 1 moves past the peppermint square to the next green
    public void checkMovePastPeppermintSquare() throws Exception {
        w.movePlayer(card1, 0);
        w.movePlayer(card2, 0);
        int playerSquare = w.movePlayer(card3, 0);
        assertEquals(14, playerSquare);

    }

    
    @Test
    //US-41
    // Checks if player 1 moves past the licorice square to the next green
    public void checkMovePastLicoriceSquare() throws Exception {
        w.movePlayer(card2, 0);
        w.movePlayer(card2, 0);
        w.movePlayer(card2, 0);
        int playerSquare = w.movePlayer(card3, 0);
        assertEquals(30, playerSquare);
    }

    @Test
    //US-39
    // Checks if the 13th square has a peppermint image
    public void checkPeppermintSquare() throws Exception {
        SpecialSquare s = (SpecialSquare) w.gameboard.getSquare(13);
        Image img = s.getImage();
        assertEquals(new ImageIcon("src/main/resources/images/peppermint.jpg").getImage(), img);
    }

    @Test
    //US-39
    // Checks if the 77th square has a cupcake image
    public void checkCupcakeSquare() throws Exception {
        SpecialSquare s = (SpecialSquare) w.gameboard.getSquare(77);
        Image img = s.getImage();
        assertEquals(new ImageIcon("src/main/resources/images/cupcake.jpg").getImage(), img);
    }
}