import java.awt.*;
import javax.swing.*;

public class CardDeckGUILayout extends JPanel {

    public CardDeckGUILayout() {


        //setBackground( new Color(100, 120, 10));
        //setLayout(new BorderLayout(3, 3));

        CardDeckGUI board = new CardDeckGUI();
        add(board, BorderLayout.CENTER);

        //JPanel buttonPanel = new JPanel();
        //buttonPanel.setBackground(Color.GRAY);
        //add(buttonPanel, BorderLayout.SOUTH);

        //setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    }
}
