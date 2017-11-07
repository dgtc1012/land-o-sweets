import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MoveTokenTest {

   /* WorldOfSweets w;
	Token token;
	Card card;
    Player player;

    @Before
    public void setup() {
        w = new WorldOfSweets();
        player = new Player(1, "player1");
        w.players = new Player[]{player};
        card = new Card(null, 0);

    }


    @Test
    //US-25
    // Checks if player 1 moves to the first red square after recieving a single red card
    public void checkMoveToFirstRedSquare() throws Exception {
        card = new Card(CardColor.RED, 1);
        w =  new WorldOfSweets();
        w.players = new Player[]{player, player};
        int playerSquare = w.movePlayer(card, 0);
        int x = w.players[0].getToken().getX();
        int y = w.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray =  {w.gameboard.getSquareXLocation(playerSquare), w.gameboard.getSquareXLocation(0)};
        System.out.println(x);
        System.out.println(y);
        System.out.println(w.gameboard.getSquareXLocation(0));
        System.out.println(w.gameboard.getSquareYLocation(0));
        int[] all = {x, y, w.gameboard.getSquareXLocation(0), w.gameboard.getSquareXLocation(0)};
        w.printAll(all);
        assertEquals(0, 0);

    }

    @Test
    //US-25
    // Checks if player 1 moves to the first orange square after recieving a single orange card
    public void checkMoveToFirstOrangeSquare() throws Exception {
        card = new Card(CardColor.ORANGE, 1);
        w.movePlayer(card, 0);
        int x = w.players[0].getToken().getX();
        int y = w.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray =  {w.gameboard.getSquareXLocation(4), w.gameboard.getSquareXLocation(4)};
        assertArrayEquals(expectedArray, resultArray);

    }

    @Test
    //US-26
    // Checks if player 1 moves to the first red square after recieving a single red card
    public void checkMoveToSecondRedSquare() throws Exception {
        card = new Card(CardColor.RED, 2);
        w.movePlayer(card, 0);
        int x = w.players[0].getToken().getX();
        int y = w.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray =  {w.gameboard.getSquareXLocation(5), w.gameboard.getSquareXLocation(5)};
        assertArrayEquals(expectedArray, resultArray);

    }

    @Test
    //US-26
    // Checks if player 1 moves to the first orange square after recieving a single orange card
    public void checkMoveToSecondOrangeSquare() throws Exception {
        card = new Card(CardColor.ORANGE, 2);
        w.movePlayer(card, 0);
        int x = w.players[0].getToken().getX();
        int y = w.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray =  {w.gameboard.getSquareXLocation(9), w.gameboard.getSquareXLocation(9)};
        assertArrayEquals(expectedArray, resultArray);

    }*/


}