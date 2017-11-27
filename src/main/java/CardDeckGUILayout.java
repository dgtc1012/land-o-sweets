import javax.swing.*;
import java.awt.*;

public class CardDeckGUILayout extends JPanel implements java.io.Serializable {

    public CardDeckGUI board;

    public CardDeckGUILayout() {
        board = new CardDeckGUI();
        add(board, BorderLayout.CENTER);
    }

    public CardDeckGUI getBoard() {
        return board;
    }
}
