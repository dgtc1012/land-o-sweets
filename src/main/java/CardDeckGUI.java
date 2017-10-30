import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardDeckGUI extends JPanel implements ActionListener{

    static final int CARDHEIGHT = 120;
    static final int CARDWIDTH = 80;
    static final int MINSPACING = 10;
    static final int BLOCKSIZE = 40;
    static final int DECKSIZE_X = 3*CARDWIDTH+5*MINSPACING;
    static final int DECKSIZE_Y = CARDHEIGHT + CARDHEIGHT/2;

    DeckOfCards deck;
    String message;

    boolean gameInProgress;
    boolean cardDrawn;
    Card lastCard;

    Font bigFont;

    CardDeckGUI(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getX() >= MINSPACING + CARDWIDTH/2 && e.getX() < MINSPACING + CARDWIDTH/2 + CARDWIDTH && e.getY() >= MINSPACING && e.getY() < MINSPACING + CARDHEIGHT) {
                    doDraw();
                }
            }
        });

        setForeground(Color.BLACK);
        bigFont = new Font("Serif", Font.BOLD, 14);
        setPreferredSize( new Dimension(DECKSIZE_X, DECKSIZE_Y));
        lastCard = null;
        doNewGame();
    }

    public void actionPerformed(ActionEvent evt){

    }

    void doDraw(){
        if(!gameInProgress) {
            cardDrawn = false;
            lastCard = null;
            repaint();
            return;
        }
        cardDrawn = true;

        repaint();
    }

    void doNewGame(){
        if(gameInProgress){
            message = "You still have to finish the game!";
            repaint();
            return;
        }
        deck = new DeckOfCards();
        deck.shuffleDeck();
        message = WorldOfSweets.pNames[0] + "'s draw to start the game!";
        gameInProgress = true;
        lastCard = null;
        cardDrawn = false;
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(bigFont);
        g.drawString(message, MINSPACING, CARDHEIGHT + MINSPACING*4);
        drawCard(g, null, MINSPACING + CARDWIDTH/2, MINSPACING);
        if(gameInProgress && cardDrawn) {
            lastCard = newCard();
            drawCard(g, lastCard, MINSPACING + CARDWIDTH/2 + CARDWIDTH + MINSPACING, MINSPACING);
            cardDrawn = false;
        }
        else
            drawCard(g, lastCard, MINSPACING + CARDWIDTH/2 + CARDWIDTH + MINSPACING, MINSPACING);

        message = WorldOfSweets.nextPlayer() + "'s turn to draw";
    }

    Card newCard(){
        Card card = deck.drawCard();

        
        if(card == null){
            deck.populateDeck();
            deck.shuffleDeck();
            return deck.drawCard();

        }
        else{
            return card;
        }
    }

    void drawCard(Graphics g, Card card, int x, int y){
        if(card == null){
            g.setColor(Color.BLUE);
            g.fillRect(x, y, CARDWIDTH, CARDHEIGHT);
            g.setColor(Color.WHITE);
            g.drawRect(x+3, y+3, CARDWIDTH-7, CARDHEIGHT-7);
            g.drawRect(x+4, y+4, CARDWIDTH-9, CARDHEIGHT-9);
        }
        else{
            g.setColor(Color.WHITE);
            g.fillRect(x, y, CARDWIDTH, CARDHEIGHT);
            g.setColor(Color.BLUE);
            g.drawRect(x, y, CARDWIDTH-1, CARDHEIGHT-1);
            g.drawRect(x+1, y+1, CARDWIDTH-3, CARDHEIGHT-3);

            CardColor color = card.getColor();
            int value = card.getValue();

            if(color == CardColor.BLUE){
                if(value == 1){
                    g.setColor(Color.BLUE);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2-BLOCKSIZE/2), BLOCKSIZE, BLOCKSIZE);
                }
                else{
                    g.setColor(Color.BLUE);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2-BLOCKSIZE-MINSPACING/2), BLOCKSIZE, BLOCKSIZE);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2+5), BLOCKSIZE, BLOCKSIZE);
                }
            }
            else if(color == CardColor.GREEN){
                if(value == 1){
                    g.setColor(Color.GREEN);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2-BLOCKSIZE/2), BLOCKSIZE, BLOCKSIZE);
                }
                else{
                    g.setColor(Color.GREEN);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2-BLOCKSIZE-MINSPACING/2), BLOCKSIZE, BLOCKSIZE);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2+5), BLOCKSIZE, BLOCKSIZE);
                }
            }
            else if(color == CardColor.ORANGE){
                if(value == 1){
                    g.setColor(Color.ORANGE);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2-BLOCKSIZE/2), BLOCKSIZE, BLOCKSIZE);
                }
                else{
                    g.setColor(Color.ORANGE);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2-BLOCKSIZE-MINSPACING/2), BLOCKSIZE, BLOCKSIZE);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2+5), BLOCKSIZE, BLOCKSIZE);
                }
            }
            else if(color == CardColor.RED){
                if(value == 1){
                    g.setColor(Color.RED);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2-BLOCKSIZE/2), BLOCKSIZE, BLOCKSIZE);
                }
                else{
                    g.setColor(Color.RED);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2-BLOCKSIZE-MINSPACING/2), BLOCKSIZE, BLOCKSIZE);
                    g.fillRect(x+(CARDWIDTH/2-BLOCKSIZE/2), y+(CARDHEIGHT/2+5), BLOCKSIZE, BLOCKSIZE);
                }
            }
            else if(color == CardColor.YELLOW) {
                if (value == 1) {
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
}
