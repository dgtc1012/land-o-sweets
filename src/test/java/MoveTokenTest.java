import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MoveTokenTest {

    WorldOfSweets w;
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
        w.gameboard = new Gameboard();
        w.players = new Player[]{player, player};
        int playerSquare = w.movePlayer(card, 0);
        int x = w.players[0].getToken().getX();
        int y = w.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray =  {w.gameboard.getSquareXLocation(playerSquare), w.gameboard.getSquareYLocation(playerSquare)};
        assertArrayEquals(expectedArray, resultArray);

    }

    @Test
    //US-25
    // Checks if player 1 moves to the first orange square after recieving a single orange card
    public void checkMoveToFirstOrangeSquare() throws Exception {
        card = new Card(CardColor.ORANGE, 1);
        w =  new WorldOfSweets();
        w.gameboard = new Gameboard();
        w.players = new Player[]{player, player};
        int playerSquare = w.movePlayer(card, 0);
        int x = w.players[0].getToken().getX();
        int y = w.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray =  {w.gameboard.getSquareXLocation(playerSquare), w.gameboard.getSquareYLocation(playerSquare)};
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    //US-26
    // Checks if player 1 moves to the second red square after recieving a double red card
    public void checkMoveToSecondRedSquare() throws Exception {
        card = new Card(CardColor.RED, 2);
        w =  new WorldOfSweets();
        w.gameboard = new Gameboard();
        w.players = new Player[]{player, player};
        int playerSquare = w.movePlayer(card, 0);
        int x = w.players[0].getToken().getX();
        int y = w.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray =  {w.gameboard.getSquareXLocation(playerSquare), w.gameboard.getSquareYLocation(playerSquare)};
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    //US-26
    // Checks if player 1 moves to the second orange square after recieving a double orange card
    public void checkMoveToSecondOrangeSquare() throws Exception {
        card = new Card(CardColor.ORANGE, 2);
        w =  new WorldOfSweets();
        w.gameboard = new Gameboard();
        w.players = new Player[]{player, player};
        int playerSquare = w.movePlayer(card, 0);
        int x = w.players[0].getToken().getX();
        int y = w.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray =  {w.gameboard.getSquareXLocation(playerSquare), w.gameboard.getSquareYLocation(playerSquare)};
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    //US-17
    //Checks if the player's token moves to the grandma's house panel after landing on it
    public void checkLandOnGrandmasHouse() throws Exception {
      w = new WorldOfSweets();
      w.gameboard = new Gameboard();
      w.players = new Player[]{player, player};
      int value = w.gameboard.getNumberOfSquares();
      if (value >= w.gameboard.getNumberOfSquares()){
        w.players[0].getToken().setCoords(w.gameboard.grandmasHouse.getX(), w.gameboard.grandmasHouse.getY());
      }
      int x = w.players[0].getToken().getX();
      int y = w.players[0].getToken().getY();
      int[] resultArray = {x,y};
      int[] expectedArray =  {w.gameboard.grandmasHouse.getX(), w.gameboard.grandmasHouse.getY()};
      assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    //US-17
    //Checks if the player's token moves to the grandma's house panel after going past it
    public void checkLandPastGrandmasHouse() throws Exception {
      w = new WorldOfSweets();
      w.gameboard = new Gameboard();
      w.players = new Player[]{player, player};
      int value = w.gameboard.getNumberOfSquares()+5;
      if (value >= w.gameboard.getNumberOfSquares()){
        w.players[0].getToken().setCoords(w.gameboard.grandmasHouse.getX(), w.gameboard.grandmasHouse.getY());
      }
      int x = w.players[0].getToken().getX();
      int y = w.players[0].getToken().getY();
      int[] resultArray = {x,y};
      int[] expectedArray =  {w.gameboard.grandmasHouse.getX(), w.gameboard.grandmasHouse.getY()};
      assertArrayEquals(expectedArray, resultArray);
    }

}
