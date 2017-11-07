import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class TurnTest {


	Token token1;
	Token token2;
	Token token3;
	Token token4;

    @Before
    public void setup() {
        token1 = new Token(1, "player1");
        token2 = new Token(2, "player2");
        token3 = new Token(3, "player3");
		token4 = new Token(4, "player4");
		WorldOfSweets.pNames = new String[4];
		WorldOfSweets.pNames[0] = "player1";
		WorldOfSweets.pNames[1] = "player2";
		WorldOfSweets.pNames[2] = "player3";
		WorldOfSweets.pNames[3] = "player4";

    }


    @Test
    //US-11
    // Checks if turns will cycle from the first player to the second player
    public void checkFirstToSecondPlayerTurn() throws Exception {
        WorldOfSweets.currentPlayerIndex = 0;
        String playerTurn = WorldOfSweets.nextPlayer();
        assertEquals("player2", playerTurn);

    }

    @Test
    //US-11
    // Checks if turns will cycle from the last player to the first player
    public void checkFourthToFirstPlayerTurn() throws Exception {
        WorldOfSweets.currentPlayerIndex = 3;
        String playerTurn = WorldOfSweets.nextPlayer();
        assertEquals("player1", playerTurn);

    }

}