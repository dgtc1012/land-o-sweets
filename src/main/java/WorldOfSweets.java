import javax.swing.*;

public class WorldOfSweets {
    public static void main(String[] args) {
        JFrame window = new JFrame("World-o-Sweets Card Deck");
        CardDeckGUILayout content = new CardDeckGUILayout();
        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(120, 70);
        window.pack();
        window.setResizable(true);
        window.setVisible(true);
    }
}
