import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class WorldOfSweets {

    //public static Token[] playerTokens;
    public static String[] pNames;
    public static Player[] players;
    public static int currentPlayerIndex = -1;
    public static Gameboard gameboard;


    public static void main(String[] args) {
        getPlayers();
        gameboard = new Gameboard();
    }

    public static int getBoardLength(){
        return gameboard.getNumberOfSquares();
    }

    public static void getPlayers() {

        String[] options = {"2", "3", "4"};
        Object selected = JOptionPane.showInputDialog(null, "How many Players?", "Selection", JOptionPane.DEFAULT_OPTION, null, options, "0");
        JFrame f = new JFrame("Players");
        JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JPanel p = new JPanel();
        JTextField p1Name = new JTextField(15);
        JTextField p2Name = new JTextField(15);
        JTextField p3Name = new JTextField(15);
        JTextField p4Name = new JTextField(15);
        if (selected != null) {
            if (selected.toString().equalsIgnoreCase("2")) {

                labels.add(new JLabel("Player 1", SwingConstants.RIGHT));
                controls.add(p1Name);
                labels.add(new JLabel("Player 2", SwingConstants.RIGHT));
                controls.add(p2Name);
                p.add(labels, BorderLayout.WEST);
                p.add(controls, BorderLayout.CENTER);
                JOptionPane.showMessageDialog(
                        f, p, "Player Names", JOptionPane.QUESTION_MESSAGE);
                pNames = new String[2];

                Player p1 = new Player(1, p1Name.getText().toString());
                pNames[0] = p1.getToken().getName();
                Player p2 = new Player(2, p2Name.getText().toString());
                pNames[1] = p2.getToken().getName();


                p1.getToken().setCoords(20, 480);
                p2.getToken().setCoords(60, 480);
                players = new Player[2];
                players[0] = p1;
                players[1] = p2;
                //players = new Token[]{p1, p2};

            } else if (selected.toString().equalsIgnoreCase("3")) {
                labels.add(new JLabel("Player 1", SwingConstants.RIGHT));
                controls.add(p1Name);
                labels.add(new JLabel("Player 2", SwingConstants.RIGHT));
                controls.add(p2Name);
                labels.add(new JLabel("Player 3", SwingConstants.RIGHT));
                controls.add(p3Name);
                p.add(labels, BorderLayout.WEST);
                p.add(controls, BorderLayout.CENTER);
                JOptionPane.showMessageDialog(
                        f, p, "Player Names", JOptionPane.QUESTION_MESSAGE);
                pNames = new String[3];
                Player p1 = new Player(1, p1Name.getText().toString());
                pNames[0] = p1.getToken().getName();
                Player p2 = new Player(2, p2Name.getText().toString());
                pNames[1] = p2.getToken().getName();
                Player p3 = new Player(3, p3Name.getText().toString());
                pNames[2] = p3.getToken().getName();
                p1.getToken().setCoords(20, 480);
                p2.getToken().setCoords(60, 480);
                p3.getToken().setCoords(20, 520);
                players = new Player[]{p1, p2, p3};
            } else if (selected.toString().equalsIgnoreCase("4")) {

                labels.add(new JLabel("Player 1", SwingConstants.RIGHT));
                controls.add(p1Name);
                labels.add(new JLabel("Player 2", SwingConstants.RIGHT));
                controls.add(p2Name);
                labels.add(new JLabel("Player 3", SwingConstants.RIGHT));
                controls.add(p3Name);
                labels.add(new JLabel("Player 4", SwingConstants.RIGHT));
                controls.add(p4Name);
                p.add(labels, BorderLayout.WEST);
                p.add(controls, BorderLayout.CENTER);
                JOptionPane.showMessageDialog(
                        f, p, "Player Names", JOptionPane.QUESTION_MESSAGE);
                pNames = new String[4];
                Player p1 = new Player(1, p1Name.getText().toString());
                pNames[0] = p1.getToken().getName();
                Player p2 = new Player(2, p2Name.getText().toString());
                pNames[1] = p2.getToken().getName();
                Player p3 = new Player(3, p3Name.getText().toString());
                pNames[2] = p3.getToken().getName();
                Player p4 = new Player(4, p4Name.getText().toString());
                pNames[3] = p4.getToken().getName();
                p1.getToken().setCoords(20, 480);
                p2.getToken().setCoords(60, 480);
                p3.getToken().setCoords(20, 520);
                p4.getToken().setCoords(60, 520);
                players = new Player[]{p1, p2, p3, p4};
            }
        } else {
            System.exit(1);
        }

    }

    public static String nextPlayer() {
        if (currentPlayerIndex == pNames.length - 1) {
            currentPlayerIndex = 0;
            return pNames[currentPlayerIndex];
        } else {
            currentPlayerIndex++;
            return pNames[currentPlayerIndex];
        }
    }
    public static int nextPlayerIndex() {
        if (currentPlayerIndex == pNames.length - 1) {
            return 0;
        } else {
            return currentPlayerIndex+1;
        }
    }
    public static int movePlayer(Card c, int index){
        int value = players[index].newCardDrawn(c.getValue(), c.getColor());
        if (value >= gameboard.getNumberOfSquares()){

          players[index].getToken().setCoords(gameboard.grandmasHouse.getX(), gameboard.grandmasHouse.getY());
          JOptionPane.showMessageDialog(null, pNames[index] + ". You win!!!");
          System.exit(0);
        }        //when someone reaches Grandmas House
        if (value>-1)
            players[index].getToken().setCoords(gameboard.getSquareXLocation(value), gameboard.getSquareYLocation(value));
        return value;
    }


}
