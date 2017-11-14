import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MoveTokenTest {

    WorldOfSweets WorldOfSweets;
    Token token;
    Card card;
    Player player;

    @Before
    public void setup() {
        WorldOfSweets = new WorldOfSweets();
        player = new Player(1, "player1");
        WorldOfSweets.players = new Player[]{player};
        card = new Card(null, 0);
        WorldOfSweets.pNames = new String[2];
        WorldOfSweets.pNames[0] = "p1";
        WorldOfSweets.pNames[1] = "p2";
    }


    @Test
    //US-25
    // Checks if player 1 moves to the first red square after recieving a single red card
    public void checkMoveToFirstRedSquare() throws Exception {
        card = new Card(CardColor.RED, 1);
        WorldOfSweets.gameboard = new Gameboard();
        WorldOfSweets.players = new Player[]{player, player};

        int playerSquare = WorldOfSweets.movePlayer(card, 0);
        int x = WorldOfSweets.players[0].getToken().getX();
        int y = WorldOfSweets.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray = {WorldOfSweets.gameboard.getSquareXLocation(playerSquare), WorldOfSweets.gameboard.getSquareYLocation(playerSquare)};
        assertArrayEquals(expectedArray, resultArray);

    }

    @Test
    //US-25
    // Checks if player 1 moves to the first orange square after recieving a single orange card
    public void checkMoveToFirstOrangeSquare() throws Exception {
        card = new Card(CardColor.ORANGE, 1);
        WorldOfSweets = new WorldOfSweets();
        WorldOfSweets.gameboard = new Gameboard();
        WorldOfSweets.players = new Player[]{player, player};
        int playerSquare = WorldOfSweets.movePlayer(card, 0);
        int x = WorldOfSweets.players[0].getToken().getX();
        int y = WorldOfSweets.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray = {WorldOfSweets.gameboard.getSquareXLocation(playerSquare), WorldOfSweets.gameboard.getSquareYLocation(playerSquare)};
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    //US-26
    // Checks if player 1 moves to the second red square after recieving a double red card
    public void checkMoveToSecondRedSquare() throws Exception {
        card = new Card(CardColor.RED, 2);
        WorldOfSweets = new WorldOfSweets();
        WorldOfSweets.gameboard = new Gameboard();
        WorldOfSweets.players = new Player[]{player, player};
        int playerSquare = WorldOfSweets.movePlayer(card, 0);
        int x = WorldOfSweets.players[0].getToken().getX();
        int y = WorldOfSweets.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray = {WorldOfSweets.gameboard.getSquareXLocation(playerSquare), WorldOfSweets.gameboard.getSquareYLocation(playerSquare)};
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    //US-26
    // Checks if player 1 moves to the second orange square after recieving a double orange card
    public void checkMoveToSecondOrangeSquare() throws Exception {
        card = new Card(CardColor.ORANGE, 2);
        WorldOfSweets = new WorldOfSweets();
        WorldOfSweets.gameboard = new Gameboard();
        WorldOfSweets.players = new Player[]{player, player};
        int playerSquare = WorldOfSweets.movePlayer(card, 0);
        int x = WorldOfSweets.players[0].getToken().getX();
        int y = WorldOfSweets.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray = {WorldOfSweets.gameboard.getSquareXLocation(playerSquare), WorldOfSweets.gameboard.getSquareYLocation(playerSquare)};
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    //US-17
    //Checks if the player's token moves to the grandma's house panel after landing on it
    public void checkLandOnGrandmasHouse() throws Exception {
        WorldOfSweets = new WorldOfSweets();
        WorldOfSweets.gameboard = new Gameboard();
        WorldOfSweets.players = new Player[]{player, player};
        int value = WorldOfSweets.gameboard.getNumberOfSquares();
        if (value >= WorldOfSweets.gameboard.getNumberOfSquares()) {
            WorldOfSweets.players[0].getToken().setCoords(WorldOfSweets.gameboard.grandmasHouse.getX(), WorldOfSweets.gameboard.grandmasHouse.getY());
        }
        int x = WorldOfSweets.players[0].getToken().getX();
        int y = WorldOfSweets.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray = {WorldOfSweets.gameboard.grandmasHouse.getX(), WorldOfSweets.gameboard.grandmasHouse.getY()};
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    //US-17
    //Checks if the player's token moves to the grandma's house panel after going past it
    public void checkLandPastGrandmasHouse() throws Exception {
        WorldOfSweets = new WorldOfSweets();
        WorldOfSweets.gameboard = new Gameboard();
        WorldOfSweets.players = new Player[]{player, player};
        int value = WorldOfSweets.gameboard.getNumberOfSquares() + 5;
        if (value >= WorldOfSweets.gameboard.getNumberOfSquares()) {
            WorldOfSweets.players[0].getToken().setCoords(WorldOfSweets.gameboard.grandmasHouse.getX(), WorldOfSweets.gameboard.grandmasHouse.getY());
        }
        int x = WorldOfSweets.players[0].getToken().getX();
        int y = WorldOfSweets.players[0].getToken().getY();
        int[] resultArray = {x, y};
        int[] expectedArray = {WorldOfSweets.gameboard.grandmasHouse.getX(), WorldOfSweets.gameboard.grandmasHouse.getY()};
        assertArrayEquals(expectedArray, resultArray);
    }

}
