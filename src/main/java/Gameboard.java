/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.BorderLayout;
/**
 *
 * @author Justin Keenan, Dannah Gersh
 */
public class Gameboard {


    int startloc_x = 100;
    int startloc_y = 500;
    int squareSize = 40;
    int colorindex = 0;
    int numberOfRows = 5;
    int squaresBtwnRows = 2;
    int boardWidth = 16;
    int numberOfSquares = boardWidth*numberOfRows+squaresBtwnRows*(numberOfRows-1);
    JLayeredPane lPane;
    Container content;

    /**
     * Creates new form WorldOfCandy
     */
    public Gameboard() {
        initComponents();
        //getPlayers();

        for (int i =0; i< WorldOfSweets.players.length; i++){

            lPane.add(WorldOfSweets.players[i].getToken(), new Integer(i+5));

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

        _frame = new JFrame();
        for(int i = 1; i<=numberOfSquares; i++){
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

        //_frame.add(start);
        lPane.add(start, new Integer(1));
        start.setBounds(20, 480, 80, 80);

        int xLoc = startloc_x;
        int yLoc = startloc_y;
        int rowCount = 1;
        int colCount = 0;
        boolean rowDirection = false; //false = row is building to the right, true, row is building to the left
        for(int i = 0; i<numberOfSquares; i++){
            switch (colorindex){
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
                    colorindex=0;
                    break;
                default:
                    break;
            }

            if(i == (numberOfSquares+1)/2){
                squares.get(i).setBackground(Color.magenta);
                if(colorindex>0){
                    colorindex = colorindex-1;
                }
                else{
                    colorindex = 4;
                }
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

            //_frame.add(squares.get(i));
            lPane.add(squares.get(i), new Integer(1));

            squares.get(i).setBounds(xLoc, yLoc, squareSize, squareSize);

            if(rowCount < boardWidth && !rowDirection){
                rowCount++;
                xLoc += squareSize;
            }
            else if(rowCount < boardWidth && rowDirection){
                rowCount++;
                xLoc -= squareSize;
            }
            else if(colCount < squaresBtwnRows){
                colCount++;
                yLoc -= squareSize;
            }
            else{
                rowCount=1;
                colCount=0;
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

        //_frame.add(grandmasHouse);
        lPane.add(grandmasHouse, new Integer(1));
        grandmasHouse.setBounds(xLoc+squareSize, yLoc+20, 80, 80);

        //Current deck settings
        deckArea.setPreferredSize(new Dimension(300, 180));

        //_frame.add(deckArea);
        lPane.add(deckArea, new Integer(1));
        deckArea.setBounds(780, 360, 300, 180);
        CardDeckGUILayout cardDeck = new CardDeckGUILayout();
        deckArea.add(cardDeck);
    }// </editor-fold>//GEN-END:initComponents

//Deck event handler
    private void deckMouseClicked(MouseEvent evt) {//GEN-FIRST:event_deckMouseClicked
        // TODO add your handling code here:
    }

    public int getNumberOfSquares(){
        return numberOfSquares;
    }
    public Color getSquareColor(int index){
        return squares.get(index).getBackground();
    }

    public int getSquareXLocation(int index){
        return squares.get(index).getX();
    }

    public int getSquareYLocation(int index){
        return squares.get(index).getY();
    }

    // Variables declaration
    private JFrame _frame;
    private JPanel deckArea;
    private JPanel start;
    public JPanel grandmasHouse;
    ArrayList<JPanel> squares = new ArrayList<JPanel>();
    ////////////////////////////////////////////////////////////////

    // End of variables declaration//GEN-END:variables
}
