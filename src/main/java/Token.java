import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.Graphics;
import javax.swing.border.BevelBorder;

public class Token extends JPanel {
    private static final JPanel square = new JPanel();
    public JLabel label;
    private final int num;
    private static int x;
    private static int y;
    private static int width;
    private static int height;
    private static String name;
    private Image img;

    public Token(int pNum, String pName) {
        JLabel j = new JLabel(pName);
        x = 20;
        y = 20;
        width = 20;
        height = 39;
        name = pName;
        num = pNum;
        setBounds(x, y, width, height);
        //setBorder(new BevelBorder(BevelBorder.RAISED));

        if (pNum == 1)
            img = new ImageIcon("src/main/resources/images/p1.jpg").getImage();
        else if (pNum == 2)
            img = new ImageIcon("src/main/resources/images/p2.jpg").getImage();
        else if (pNum == 3)
            img = new ImageIcon("src/main/resources/images/p3.jpg").getImage();
        else
            img = new ImageIcon("src/main/resources/images/p4.jpg").getImage();
        //add(j);
    }

    public void setCoords(int newX, int newY) {
        if (num == 1){
            x = newX;
            y = newY;
        }else if (num == 2){
            x = newX+20;
            y = newY;
        }else if (num == 3){
            x = newX;
            y = newY+15;
        }else{
            x = newX+20;
            y = newY+15;
        }
        setBounds(x, y, width, height);
    }

    public void setSize(int newW, int newH) {
        width = newW;
        height = newH;
        setBounds(x, y, width, height);
    }

    public String getName() {
        return name;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }



}
