import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CardDeckGUI extends JPanel implements ActionListener, java.io.Serializable {

    static final int CARDHEIGHT = 120;
    static final int CARDWIDTH = 80;
    static final int MINSPACING = 10;
    static final int BLOCKSIZE = 40;
    static final int DECKSIZE_X = 3 * CARDWIDTH + 5 * MINSPACING;
    static final int DECKSIZE_Y = CARDHEIGHT + CARDHEIGHT / 2;

    public DeckOfCards deck;
    String message;
    String currentPlayer;

    boolean gameInProgress;
    boolean cardDrawn;
    public Card lastCard;
    boolean firstTurn;
    Font bigFont;

    CardDeckGUI() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e == null || e.getX() >= MINSPACING + CARDWIDTH / 2 && e.getX() < MINSPACING + CARDWIDTH / 2 + CARDWIDTH && e.getY() >= MINSPACING && e.getY() < MINSPACING + CARDHEIGHT) {
                    currentPlayer = WorldOfSweets.nextPlayer();
                    doDraw(false);
                    int nextPlayerIndex = WorldOfSweets.nextPlayerIndex();
                    WorldOfSweets.currentPlayer = WorldOfSweets.players[nextPlayerIndex];
                    message = WorldOfSweets.pNames[nextPlayerIndex] + "'s turn to draw";
                }
            }
        });
        setForeground(Color.BLACK);
        bigFont = new Font("Serif", Font.BOLD, 14);
        setPreferredSize(new Dimension(DECKSIZE_X, DECKSIZE_Y));
        lastCard = null;
        firstTurn = true;
        message = WorldOfSweets.pNames[0] + "'s draw to start the game!";
        doNewGame();
    }


    public void actionPerformed(ActionEvent evt) {
    }


    /**
     * Calls repaint() for cards if game in progress
     */
    void doDraw(boolean loaded) {
        if (!gameInProgress) {
            cardDrawn = false;
            lastCard = null;
            repaint();
        } else if (loaded) { //Case for the openeing to a loaded game.
            cardDrawn = false;
            message = WorldOfSweets.pNames[WorldOfSweets.nextPlayerIndex()] + "'s turn to draw";
            currentPlayer = WorldOfSweets.pNames[WorldOfSweets.currentPlayerIndex];
            repaint();
        } else {
            cardDrawn = true;
            repaint();
        }
    }

    /**
     * Initiates a new game
     */
    void doNewGame() {
        if (gameInProgress) {
            message = "You still have to finish the game!";
            repaint();
            return;
        }
        deck = new DeckOfCards();
        deck.shuffleDeck();
        gameInProgress = true;
        lastCard = null;
        cardDrawn = false;
        WorldOfSweets.currentPlayer = WorldOfSweets.players[0];
        repaint();
    }

    /**
     * Handles painting the visuals of the card deck
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(bigFont);
        g.drawString(message, MINSPACING * 5, CARDHEIGHT + MINSPACING * 4);
        try {
            drawCard(g, null, MINSPACING + CARDWIDTH / 2, MINSPACING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (gameInProgress && cardDrawn) {
            lastCard = newCard();
            try {
                drawCard(g, lastCard, MINSPACING + CARDWIDTH / 2 + CARDWIDTH + MINSPACING, MINSPACING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            cardDrawn = false;
            WorldOfSweets.movePlayer(lastCard, WorldOfSweets.currentPlayerIndex);
        } else {
            try {
                drawCard(g, lastCard, MINSPACING + CARDWIDTH / 2 + CARDWIDTH + MINSPACING, MINSPACING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Draws a new card from the deck
     *
     * @return The card drawn
     */
    Card newCard() {
        Card card = deck.drawCard();
        if (card == null) {
            deck.populateDeck();
            deck.shuffleDeck();
            return deck.drawCard();
        } else {
            return card;
        }
    }

    /**
     * Handles drawing the newly drawn card onto the screen, determining the value/color/symbol of the card
     *
     * @param g
     * @param card
     * @param x
     * @param y
     * @throws IOException
     */
    void drawCard(Graphics g, Card card, int x, int y) throws IOException {

        if (card == null) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, CARDWIDTH, CARDHEIGHT);
            g.setColor(Color.WHITE);
            g.drawRect(x + 3, y + 3, CARDWIDTH - 7, CARDHEIGHT - 7);
            g.drawRect(x + 4, y + 4, CARDWIDTH - 9, CARDHEIGHT - 9);
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, CARDWIDTH, CARDHEIGHT);
            g.setColor(Color.BLUE);
            g.drawRect(x, y, CARDWIDTH - 1, CARDHEIGHT - 1);
            g.drawRect(x + 1, y + 1, CARDWIDTH - 3, CARDHEIGHT - 3);

            CardColor color = card.getColor();
            int value = card.getValue();

            if (color == null) {
                // Skip Card
                if (value == Constants.SKIP) {
                    g.drawString("SKIP!", x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2));
                } else if (value == Constants.LICORICE) { // GoToLicorice Card
                    BufferedImage image = ImageIO.read(new File("src/main/resources/images/licorice.jpg"));
                    g.drawImage(image, x + 20, y + (CARDHEIGHT / 2 - BLOCKSIZE / 2), null);
                } else if (value == Constants.ICECREAM) { // GoToIcecream Card
                    BufferedImage image = ImageIO.read(new File("src/main/resources/images/icecream.jpg"));
                    g.drawImage(image, x + 20, y + (CARDHEIGHT / 2 - BLOCKSIZE / 2), null);
                } else if (value == Constants.GINGERBREAD) { // GoToGingerbread Card
                    BufferedImage image = ImageIO.read(new File("src/main/resources/images/gingerbread.jpg"));
                    g.drawImage(image, x + 20, y + (CARDHEIGHT / 2 - BLOCKSIZE + 5), null);
                } else if (value == Constants.CUPCAKE) { // GoToCupcake Card
                    BufferedImage image = ImageIO.read(new File("src/main/resources/images/cupcake.jpg"));
                    g.drawImage(image, x + 20, y + (CARDHEIGHT / 2 - BLOCKSIZE + 10), null);
                } else if (value == Constants.PEPPERMINT) { // GoToPeppermint Card
                    BufferedImage image = ImageIO.read(new File("src/main/resources/images/peppermint.jpg"));
                    g.drawImage(image, x + 20, y + (CARDHEIGHT / 2 - BLOCKSIZE / 2), null);
                }
            } else if (color == CardColor.BLUE) {
                if (value == Constants.SINGLE) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 - BLOCKSIZE / 2), BLOCKSIZE, BLOCKSIZE);
                } else {
                    g.setColor(Color.BLUE);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 - BLOCKSIZE - MINSPACING / 2), BLOCKSIZE, BLOCKSIZE);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 + 5), BLOCKSIZE, BLOCKSIZE);
                }
            } else if (color == CardColor.GREEN) {
                if (value == Constants.SINGLE) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 - BLOCKSIZE / 2), BLOCKSIZE, BLOCKSIZE);
                } else {
                    g.setColor(Color.GREEN);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 - BLOCKSIZE - MINSPACING / 2), BLOCKSIZE, BLOCKSIZE);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 + 5), BLOCKSIZE, BLOCKSIZE);
                }
            } else if (color == CardColor.ORANGE) {
                if (value == Constants.SINGLE) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 - BLOCKSIZE / 2), BLOCKSIZE, BLOCKSIZE);
                } else {
                    g.setColor(Color.ORANGE);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 - BLOCKSIZE - MINSPACING / 2), BLOCKSIZE, BLOCKSIZE);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 + 5), BLOCKSIZE, BLOCKSIZE);
                }
            } else if (color == CardColor.RED) {
                if (value == Constants.SINGLE) {
                    g.setColor(Color.RED);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 - BLOCKSIZE / 2), BLOCKSIZE, BLOCKSIZE);
                } else {
                    g.setColor(Color.RED);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 - BLOCKSIZE - MINSPACING / 2), BLOCKSIZE, BLOCKSIZE);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 + 5), BLOCKSIZE, BLOCKSIZE);
                }
            } else if (color == CardColor.YELLOW) {
                if (value == Constants.SINGLE) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 - BLOCKSIZE / 2), BLOCKSIZE, BLOCKSIZE);
                } else {
                    g.setColor(Color.YELLOW);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 - BLOCKSIZE - MINSPACING / 2), BLOCKSIZE, BLOCKSIZE);
                    g.fillRect(x + (CARDWIDTH / 2 - BLOCKSIZE / 2), y + (CARDHEIGHT / 2 + 5), BLOCKSIZE, BLOCKSIZE);
                }
            }
        }
    }

    //Returns the deck
    ArrayList<Card> getDeck() {
        return deck.getDeck();

    }

    //Gets the last flipped card
    Card getLastCard() {
        return lastCard;
    }
}
