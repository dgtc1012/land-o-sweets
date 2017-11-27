import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WorldOfSweets {

    public static String[] pNames;
    public static Player[] players;
    public static Player currentPlayer;
    public static int currentPlayerIndex = -1;
    public static Gameboard gameboard;
    public static BufferedReader br = null;
    public static boolean loadBol = false;
    public static boolean saveBol = false;
    public static Thread aiThread = null;
    public static boolean aiRunning = true;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        boolean loaded = false;
        Object[] options = {"New Game", "Load Game"};
        int choice = JOptionPane.showOptionDialog(null,
                "Would you like to start a new game or load a previous one?",
                "World of Sweets",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            getPlayers();
        } else if (choice == 1) {
            loaded = loadGame(0);
        } else {
            System.exit(0);
        }

        if (!loaded && choice == 1)
            getPlayers();

        gameboard = new Gameboard();

        if (choice == 1 && loaded)
            loadGame(1);

        // If there's an AI player, a thread is created to check when it is that player's turn
        // When it's the AI player's turn, the mouse listener on the card deck is activated
        for (int i = 0; i < players.length; i++) {
            if (players[i].isAiPlayer()) {
                aiThread = new Thread(() -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        while (aiRunning) {
                            //do stuff
                            if (currentPlayer.isAiPlayer()) {
                                gameboard.cardDeck.board.getMouseListeners()[0].mouseClicked(null);
                            }
                            if (Thread.interrupted()) {
                                return;
                            }
                            try {
                                Thread.sleep(600);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                });
                aiThread.start();
                break;
            }
        }
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    if (!saveBol) {
                        Thread.sleep(1000);
                        int time = gameboard.timer.incrementTime();
                    }
                } catch (InterruptedException iex) {
                    //ignore
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException iex) {
            //ignore
        }
    }

    public static int getBoardLength() {
        return gameboard.getNumberOfSquares();
    }

    /**
     * Gets the player information: number of players and their names and assigns token to them
     */
    public static void getPlayers() {
        String[] options = {"2", "3", "4"};
        Object selected = JOptionPane.showInputDialog(null, "How many Players?", "Selection", JOptionPane.DEFAULT_OPTION, null, options, "0");
        JFrame f = new JFrame("Players");
        JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
        JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
        JPanel p = new JPanel();
        JPanel aiPanel = new JPanel(new GridLayout(0, 1, 2, 2));
        JTextField p1Name = new JTextField(15);
        JTextField p2Name = new JTextField(15);
        JTextField p3Name = new JTextField(15);
        JTextField p4Name = new JTextField(15);
        JRadioButton ai = new JRadioButton();
        JRadioButton ai2 = new JRadioButton();
        JRadioButton ai3 = new JRadioButton();
        JRadioButton ai4 = new JRadioButton();
        ai.setText("AI?");
        ai2.setText("AI?");
        ai3.setText("AI?");
        ai4.setText("AI?");
        if (selected != null) {
            if (selected.toString().equalsIgnoreCase("2")) {
                labels.add(new JLabel("Player 1", SwingConstants.RIGHT));
                controls.add(p1Name);
                labels.add(new JLabel("Player 2", SwingConstants.RIGHT));
                controls.add(p2Name);
                aiPanel.add(ai);
                aiPanel.add(ai2);
                p.add(labels, BorderLayout.WEST);
                p.add(controls, BorderLayout.CENTER);
                p.add(aiPanel, BorderLayout.CENTER);
                JOptionPane.showMessageDialog(
                        f, p, "Player Names", JOptionPane.QUESTION_MESSAGE);
                pNames = new String[2];

                Player p1 = new Player(1, p1Name.getText(), ai.isSelected());
                pNames[0] = p1.getToken().getName();
                Player p2 = new Player(2, p2Name.getText(), ai2.isSelected());
                pNames[1] = p2.getToken().getName();

                p1.getToken().setCoords(20, 480);
                p2.getToken().setCoords(60, 480);
                players = new Player[2];
                players[0] = p1;
                players[1] = p2;

            } else if (selected.toString().equalsIgnoreCase("3")) {
                labels.add(new JLabel("Player 1", SwingConstants.RIGHT));
                controls.add(p1Name);
                labels.add(new JLabel("Player 2", SwingConstants.RIGHT));
                controls.add(p2Name);
                labels.add(new JLabel("Player 3", SwingConstants.RIGHT));
                controls.add(p3Name);
                aiPanel.add(ai);
                aiPanel.add(ai2);
                aiPanel.add(ai3);
                p.add(labels, BorderLayout.WEST);
                p.add(controls, BorderLayout.CENTER);
                p.add(aiPanel);
                JOptionPane.showMessageDialog(
                        f, p, "Player Names", JOptionPane.QUESTION_MESSAGE);
                pNames = new String[3];
                Player p1 = new Player(1, p1Name.getText().toString(), ai.isSelected());
                pNames[0] = p1.getToken().getName();
                Player p2 = new Player(2, p2Name.getText().toString(), ai2.isSelected());
                pNames[1] = p2.getToken().getName();
                Player p3 = new Player(3, p3Name.getText().toString(), ai3.isSelected());
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
                aiPanel.add(ai);
                aiPanel.add(ai2);
                aiPanel.add(ai3);
                aiPanel.add(ai4);
                p.add(labels, BorderLayout.WEST);
                p.add(controls, BorderLayout.CENTER);
                p.add(aiPanel);
                JOptionPane.showMessageDialog(
                        f, p, "Player Names", JOptionPane.QUESTION_MESSAGE);
                pNames = new String[4];
                Player p1 = new Player(1, p1Name.getText().toString(), ai.isSelected());
                pNames[0] = p1.getToken().getName();
                Player p2 = new Player(2, p2Name.getText().toString(), ai2.isSelected());
                pNames[1] = p2.getToken().getName();
                Player p3 = new Player(3, p3Name.getText().toString(), ai3.isSelected());
                pNames[2] = p3.getToken().getName();
                Player p4 = new Player(4, p4Name.getText().toString(), ai4.isSelected());
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

    /**
     * Determines what player is up next
     *
     * @return Name of next player
     */
    public static String nextPlayer() {
        if (currentPlayerIndex == pNames.length - 1) {
            currentPlayerIndex = 0;
            return pNames[currentPlayerIndex];
        } else {
            currentPlayerIndex++;
            return pNames[currentPlayerIndex];
        }
    }

    /**
     * Figures out index of next player up
     *
     * @return Int representing index of next player for pNames array
     */
    public static int nextPlayerIndex() {
        if (currentPlayerIndex == pNames.length - 1) {
            return 0;
        } else {
            return currentPlayerIndex + 1;
        }
    }

    /**
     * Moves player token
     *
     * @param c     card drawn to tell us where to move
     * @param index Index of player to move
     * @return
     */
    public static int movePlayer(Card c, int index) {
        int value = players[index].newCardDrawn(c.getValue(), c.getColor());
        if (value >= gameboard.getNumberOfSquares()) {

            players[index].getToken().setCoords(gameboard.grandmasHouse.getX(), gameboard.grandmasHouse.getY());
            if (aiThread != null) {
                aiThread.interrupt();
            }
            JOptionPane.showMessageDialog(null, pNames[index] + ". You win!!!");
            System.exit(0);
        }        //when someone reaches Grandmas House
        if (value > -1)
            players[index].getToken().setCoords(gameboard.getSquareXLocation(value), gameboard.getSquareYLocation(value));
        return value;
    }

    //Loads the game file
    public static boolean loadGame(int choice) throws IOException, ClassNotFoundException {

        loadBol = true;
        if (choice == 0) {
            String directory = "src/main/resources/gameFiles/";
            String ext = ".txt";
            String filename;
            File file;
            while (true) {

                filename = JOptionPane.showInputDialog("Enter the filename for your game without the extension");

                if (filename == null) {
                    return false;
                }

                filename = directory + filename;
                filename += ext;
                file = new File(filename);

                if (!file.exists()) {
                    JOptionPane.showMessageDialog(null, "That file does not exist");
                } else {
                    break;
                }
            }

            br = new BufferedReader(new FileReader(file));

            int numOfPlayers = Integer.parseInt(br.readLine());
            String playerStr;
            String[] playerSplit;
            pNames = new String[numOfPlayers];
            players = new Player[numOfPlayers];

            //Restores players
            for (int x = 0; x < numOfPlayers; x++) {

                pNames[x] = br.readLine();
                playerStr = br.readLine();
                playerSplit = playerStr.split("-");
                players[x] = new Player(x + 1, pNames[x], Integer.parseInt(playerSplit[0]), getColor(playerSplit[1]), Integer.parseInt(playerSplit[2]), Integer.parseInt(playerSplit[3]), Integer.parseInt(playerSplit[4]), Boolean.parseBoolean(playerSplit[5]));
            }

            currentPlayerIndex = Integer.parseInt(br.readLine());
            currentPlayer = players[currentPlayerIndex];
        } else {
            //Restores deck and timer
            ArrayList<Card> temp = new ArrayList<Card>();
            int deckSize = Integer.parseInt(br.readLine());
            String cardStr;

            for (int x = 0; x < players.length; x++)
                players[x].getToken().setCoords(gameboard.getSquareXLocation(players[x].getCurrentSquareValue()), gameboard.getSquareYLocation(players[x].getCurrentSquareValue()));

            for (int x = 0; x < deckSize; x++) {
                cardStr = br.readLine();

                String[] cardSplit = cardStr.split("-");
                temp.add(new Card(getColor(cardSplit[0]), Integer.parseInt(cardSplit[1])));
            }

            gameboard.cardDeck.board.deck.setDeck(temp);
            String lastCardStr = br.readLine();
            String[] lastCardSplit = lastCardStr.split("-");
            gameboard.cardDeck.board.lastCard = new Card(getColor(lastCardSplit[0]), Integer.parseInt(lastCardSplit[1]));
            gameboard.cardDeck.board.doDraw(true);
            String timeStr = br.readLine();
            String[] timeSplit = timeStr.split(":");
            gameboard.timer.setTime(Integer.parseInt(timeSplit[2]), Integer.parseInt(timeSplit[1]), Integer.parseInt(timeSplit[0]));
        }

        return true;

    }

    //Changes the string color to CardColor
    private static CardColor getColor(String color) {

        switch (color) {

            case "RED":
                return CardColor.RED;
            case "BLUE":
                return CardColor.BLUE;
            case "YELLOW":
                return CardColor.YELLOW;
            case "GREEN":
                return CardColor.GREEN;
            case "ORANGE":
                return CardColor.ORANGE;
            default:
                return null;
        }
    }
}
