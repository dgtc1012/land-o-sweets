import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.Graphics;
import javax.swing.border.BevelBorder;
public class Token extends JPanel{
    private static final JPanel square = new JPanel();
    public JLabel label;
    private static int x;
    private static int y;
    private static int width;
    private static int height;
    private static String name;
    public Token(int pNum, String pName){
        JLabel j = new JLabel(pName);
        x=20;
        y=20;
        width=50;
        height=50;
        name = pName;
        setBounds(x,y,width,height);
        setBorder(new BevelBorder(BevelBorder.RAISED));

        if (pNum == 1)
            setBackground(Color.BLUE);
        else if (pNum == 2)
            setBackground(Color.RED);
        else if (pNum == 3)
            setBackground(Color.GREEN);
        else
            setBackground(Color.YELLOW);
        add(j);
    }


    public void setCoords(int newX, int newY){
        x = newX;
        y = newY;
        setBounds(x,y,width,height);
    }
    public void setSize(int newW, int newH){
        width = newW;
        height = newH;
        setBounds(x,y,width,height);
    }
    public String getName(){
        return name;
    }




}
