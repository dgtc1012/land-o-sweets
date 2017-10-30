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

 	public static Token[] players;
 	public static String[] pNames;
    public static void main(String[] args) {
    	getPlayers();
    	new Gameboard();
        

    }
    public static int currentPlayerIndex = -1;
    public static void getPlayers() {
    
    String[] options = {"2", "3", "4"};
    Object selected = JOptionPane.showInputDialog(null, "How many Players?", "Selection", JOptionPane.DEFAULT_OPTION, null, options, "0");
    JFrame f = new JFrame("Players");
    JPanel labels = new JPanel(new GridLayout(0,1,2,2));
    JPanel controls = new JPanel(new GridLayout(0,1,2,2));
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
        	pNames= new String[2];

        	Token p1 = new Token(1, p1Name.getText().toString());
        	pNames[0]=p1.getName();
        	Token p2 = new Token(2, p2Name.getText().toString());
        	pNames[1]=p2.getName();


        	p1.setCoords(0, 600);
           	p2.setCoords(60, 600);
           	players = new Token[2];
           	players[0]=p1;
           	players[1]=p2;
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
        	pNames= new String[3];
           	Token p1 = new Token(1, p1Name.getText().toString());
           	pNames[0]=p1.getName();
        	Token p2 = new Token(2, p2Name.getText().toString());
        	pNames[1]=p2.getName();
        	Token p3 = new Token(3, p3Name.getText().toString());
        	pNames[2]=p3.getName();
        	p1.setCoords(0, 600);
           	p2.setCoords(60, 600);
           	p3.setCoords(120, 600);
        	players = new Token[]{p1, p2, p3};
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
        	pNames= new String[4];
            Token p1 = new Token(1, p1Name.getText().toString());
            pNames[0]=p1.getName();
        	Token p2 = new Token(2, p2Name.getText().toString());
        	pNames[1]=p2.getName();
        	Token p3 = new Token(3, p3Name.getText().toString());
        	pNames[2]=p3.getName();
        	Token p4 = new Token(4, p4Name.getText().toString());
        	pNames[3]=p4.getName();
        	p1.setCoords(0, 600);
           	p2.setCoords(60, 600);
           	p3.setCoords(120, 600);
           	p4.setCoords(180, 600);
        	players = new Token[]{p1, p2, p3, p4};
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


public static Token getNextPlayer() {
    if (currentPlayerIndex == players.length - 1) {
        currentPlayerIndex = 0;
        return players[currentPlayerIndex];
    } else {
        currentPlayerIndex++;
        return players[currentPlayerIndex];
    }
}
}
