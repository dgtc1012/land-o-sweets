/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Justin Keenan, Dannah Gersh
 */
public class Gameboard {

    boolean strategic;
    boolean usingBoomerang;
    String boomerangPlayer;
    int boomerangPlayerIndex;

    int startloc_x = 100;
    int startloc_y = 500;
    int squareSize = 40;
    int colorindex = 0;
    int numberOfRows = 5;
    int squaresBtwnRows = 2;
    int boardWidth = 16;
    int numberOfSquares = boardWidth * numberOfRows + squaresBtwnRows * (numberOfRows - 1);
    JLayeredPane lPane;
    Container content;
    Map<String, JLabel> labels = new HashMap<>();
    Timer timer;
    public CardDeckGUILayout cardDeck;

    /**
     * Creates new form WorldOfCandy
     */
    public Gameboard() {
        initComponents();

        for (int i = 0; i < WorldOfSweets.players.length; i++) {

            lPane.add(WorldOfSweets.players[i].getToken(), new Integer(i + 5));

        }
        content.add(lPane, BorderLayout.CENTER);
        _frame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        usingBoomerang = false;

        _frame = new JFrame();
        for (int i = 1; i <= numberOfSquares; i++) {
            squares.add(new JPanel());
        }

        start = new StartSquare(new ImageIcon("src/main/resources/images/rainbow2.jpg").getImage());
        grandmasHouse = new GrannysHouse(new ImageIcon("src/main/resources/images/rainbow1.jpg").getImage());
        deckArea = new JPanel();

        _frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        _frame.setSize(1250, 700);
        _frame.setLayout(null);

        lPane = new JLayeredPane();
        lPane.setBounds(0, 0, 1250, 700);
        lPane.setPreferredSize(new Dimension(1250, 700));
        content = _frame.getContentPane();

        GroupLayout startLayout = new GroupLayout(start);
        start.setLayout(startLayout);
        startLayout.setHorizontalGroup(
                startLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        startLayout.setVerticalGroup(
                startLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        lPane.add(start, new Integer(1));
        start.setBounds(20, 480, 80, 80);

        int xLoc = startloc_x;
        int yLoc = startloc_y;
        int rowCount = 1;
        int colCount = 0;
        boolean rowDirection = false; //false = row is building to the right, true, row is building to the left
        for (int i = 0; i < numberOfSquares; i++) {
            switch (colorindex) {
                case 0:
                    squares.get(i).setBackground(Color.red);
                    colorindex++;
                    break;
                case 1:
                    squares.get(i).setBackground(Color.yellow);
                    colorindex++;
                    break;
                case 2:
                    squares.get(i).setBackground(Color.blue);
                    colorindex++;
                    break;
                case 3:
                    squares.get(i).setBackground(Color.green);
                    colorindex++;
                    break;
                case 4:
                    squares.get(i).setBackground(Color.orange);
                    colorindex = 0;
                    break;
                default:
                    break;
            }

            switch (i) {
                case 77:
                    squares.set(i, new SpecialSquare(1));
                    colorindex--;
                    break;
                case 61:
                    squares.set(i, new SpecialSquare(2));
                    colorindex--;
                    break;
                case 45:
                    squares.set(i, new SpecialSquare(3));
                    colorindex--;
                    break;
                case 29:
                    squares.set(i, new SpecialSquare(4));
                    colorindex--;
                    break;
                case 13:
                    squares.set(i, new SpecialSquare(5));
                    colorindex--;
                    break;
                default:
                    break;
            }

            squares.get(i).setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
            squares.get(i).setPreferredSize(new Dimension(squareSize, squareSize));

            GroupLayout sqLayout = new GroupLayout(squares.get(i));
            squares.get(i).setLayout(sqLayout);

            sqLayout.setHorizontalGroup(
                    sqLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGap(0, 0, Short.MAX_VALUE)
            );
            sqLayout.setVerticalGroup(
                    sqLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGap(0, 0, Short.MAX_VALUE)
            );

            lPane.add(squares.get(i), new Integer(1));

            squares.get(i).setBounds(xLoc, yLoc, squareSize, squareSize);

            if (rowCount < boardWidth && !rowDirection) {
                rowCount++;
                xLoc += squareSize;
            } else if (rowCount < boardWidth && rowDirection) {
                rowCount++;
                xLoc -= squareSize;
            } else if (colCount < squaresBtwnRows) {
                colCount++;
                yLoc -= squareSize;
            } else {
                rowCount = 1;
                colCount = 0;
                rowDirection = !rowDirection;
                yLoc -= squareSize;
            }
        }

        GroupLayout grandmasHouseLayout = new GroupLayout(grandmasHouse);
        grandmasHouse.setLayout(grandmasHouseLayout);
        grandmasHouseLayout.setHorizontalGroup(
                grandmasHouseLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        grandmasHouseLayout.setVerticalGroup(
                grandmasHouseLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        lPane.add(grandmasHouse, new Integer(1));
        grandmasHouse.setBounds(xLoc + squareSize, yLoc + 20, 80, 80);

        //Current deck settings
        deckArea.setPreferredSize(new Dimension(300, 180));

        lPane.add(deckArea, new Integer(1));
        deckArea.setBounds(800, 360, 300, 180);
        cardDeck = new CardDeckGUILayout();
        deckArea.add(cardDeck);

        // This part handles showing the player names, their token, and squares left to the end
        int y = 190;
        for (int i = 0; i < WorldOfSweets.players.length; i++) {
            String msg;
            if (WorldOfSweets.gameModeStrategic) {
                msg = WorldOfSweets.players[i].getToken().getName() + "- " + (numberOfSquares - WorldOfSweets.players[i].getCurrentSquareValue()) + " Squares remaining and " + WorldOfSweets.players[i].getBoomerangs() + " Boomerangs remaining!";
            } else {
                msg = WorldOfSweets.players[i].getToken().getName() + "- " + (numberOfSquares - WorldOfSweets.players[i].getCurrentSquareValue()) + " Squares remaining!";
            }
            JLabel label = new JLabel(msg, JLabel.LEFT);
            label.setBounds(845, y, 400, 30);
            label.setIcon(new ImageIcon(WorldOfSweets.players[i].getToken().getImage().getScaledInstance(20, 30, Image.SCALE_SMOOTH)));
            lPane.add(label);
            labels.put(WorldOfSweets.players[i].getToken().getName(), label);
            y += 40;
        }

        // Timer aspect
        timer = new Timer(875, 100);
        _frame.add(timer.gui);
        _frame.add(timer.label);


        //Adds save button
        saveButton = new JButton("Save and Quit");
        saveButton.setBounds(855, 550, 170, 25);
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {
                    save();
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
        _frame.add(saveButton);

        boomerangButton = new JButton("Do you want to use a boomerang?");
        boomerangButton.setBounds(800, 350, 300, 25);
        boomerangButton.addMouseListener(new MouseAdapter() {
                                             @Override
                                             public void mouseClicked(MouseEvent e) {
                                                 try {
                                                     useBoomerang(null, false);
                                                 } catch (Exception exc) {
                                                     exc.printStackTrace();
                                                 }
                                             }
                                         }
        );

        if (WorldOfSweets.getGameMode()) {
            _frame.add(boomerangButton);
        }
    }// </editor-fold>//GEN-END:initComponents

    //use a boomerang
    protected void useBoomerang(String name, boolean aiPlayer) {
        if (usingBoomerang) {
            JOptionPane.showMessageDialog(_frame, "You are already using a boomerang, pick a card!");
        } else if (WorldOfSweets.players[WorldOfSweets.getCurrentPlayerIndex()].getBoomerangs() == 0) {
            JOptionPane.showMessageDialog(_frame, "You have already used all of your boomerangs!");
        } else {
            int numPlayers = WorldOfSweets.players.length;

            int curPlayer = WorldOfSweets.getCurrentPlayerIndex();
            Object[] options = new Object[numPlayers - 1];

            int j = 0;
            for (int i = 0; i < numPlayers; i++) {
                if (i != curPlayer) {
                    options[j] = WorldOfSweets.pNames[i];
                    j++;
                }
            }

            if (name == null) {
                boomerangPlayer = (String) JOptionPane.showInputDialog(_frame,
                        "Who do you want to use your boomerang on?",
                        "World of Sweets",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
            } else {
                WorldOfSweets.aiRunning = false;
                boomerangPlayer = name;
            }

            if (boomerangPlayer != null && boomerangPlayer.length() > 0) {
                usingBoomerang = true;
                WorldOfSweets.players[WorldOfSweets.currentPlayerIndex].decrementBoomerangCount();
                String msg;
                if (WorldOfSweets.gameModeStrategic) {
                    msg = WorldOfSweets.players[WorldOfSweets.currentPlayerIndex].getToken().getName() + "- " + (numberOfSquares - WorldOfSweets.players[WorldOfSweets.currentPlayerIndex].getCurrentSquareValue()) + " Squares remaining and " + WorldOfSweets.players[WorldOfSweets.currentPlayerIndex].getBoomerangs() + " Boomerangs remaining!";
                } else {
                    msg = WorldOfSweets.players[WorldOfSweets.currentPlayerIndex].getToken().getName() + "- " + (numberOfSquares - WorldOfSweets.players[WorldOfSweets.currentPlayerIndex].getCurrentSquareValue()) + " Squares remaining!";
                }
                WorldOfSweets.gameboard.labels.get(WorldOfSweets.players[WorldOfSweets.currentPlayerIndex].getToken().getName()).setText(msg);

                for (int i = 0; i < numPlayers; i++) {
                    if (WorldOfSweets.pNames[i].equalsIgnoreCase(boomerangPlayer)) {
                        boomerangPlayerIndex = i;
                    }
                }
            }
            if (aiPlayer) {
                cardDeck.board.getMouseListeners()[0].mouseClicked(null);
            }
        }
    }

    public int getBoomerangPlayerIndex() {
        return this.boomerangPlayerIndex;
    }

    //Saves the nesscassy information to a .txt file
    private void save() throws IOException, InterruptedException {

        String directory = "src/main/resources/gameFiles/";
        WorldOfSweets.saveBol = true;
        String ext = ".txt";
        String filename;
        File file = null;
        boolean skip = false;
        while (true) {
            WorldOfSweets.aiRunning = false;
            filename = JOptionPane.showInputDialog("Enter the filename for this new game save without the extension");

            if (filename == null) {
                skip = true;
                WorldOfSweets.saveBol = false;
                WorldOfSweets.aiRunning = true;
                break;
            }

            filename = directory + filename;
            filename += ext;
            file = new File(filename);

            if (file.exists()) {
                JOptionPane.showMessageDialog(null, "That file already exists");
            } else {
                WorldOfSweets.saveBol = false;
                break;
            }
        }

        if (!skip) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            int numOfPlayers = WorldOfSweets.pNames.length;

            bw.write(String.valueOf(numOfPlayers));
            bw.newLine();

            for (int x = 0; x < numOfPlayers; x++) {

                bw.write(WorldOfSweets.pNames[x]);
                bw.newLine();
                bw.write(WorldOfSweets.players[x].toString());
                bw.newLine();
            }

            bw.write(String.valueOf(WorldOfSweets.currentPlayerIndex));
            bw.newLine();
            bw.write(cardDeck.board.deck.toString());
            bw.newLine();
            bw.write(cardDeck.board.lastCard.toString());
            bw.newLine();
            bw.write(timer.getHours() + ":" + timer.getMinutes() + ":" + timer.getSeconds());
            bw.close();
            JOptionPane.showMessageDialog(null, "Game Saved");
            System.exit(0);
        }
    }

    //Deck event handler
    private void deckMouseClicked(MouseEvent evt) {//GEN-FIRST:event_deckMouseClicked
        // TODO add your handling code here:
    }

    public int getNumberOfSquares() {
        return numberOfSquares;
    }

    public Color getSquareColor(int index) {
        return squares.get(index).getBackground();
    }

    public int getSquareXLocation(int index) {
        return squares.get(index).getX();
    }

    public int getSquareYLocation(int index) {
        return squares.get(index).getY();
    }

    public JPanel getSquare(int index) {
        return squares.get(index);
    }

    // Variables declaration
    private JFrame _frame;
    private JPanel deckArea;
    public JPanel start;
    public JPanel grandmasHouse;
    private JButton saveButton;
    private JButton boomerangButton;
    ArrayList<JPanel> squares = new ArrayList<JPanel>();
    ////////////////////////////////////////////////////////////////

    // End of variables declaration//GEN-END:variables
}
