import javax.swing.*;
import java.awt.*;

public class CardDeckGUILayout extends JPanel {

    public CardDeckGUILayout() {
        CardDeckGUI board = new CardDeckGUI();
        add(board, BorderLayout.CENTER);
    }
}
