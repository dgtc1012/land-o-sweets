import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class SpecialSquare extends JPanel{
    private Image img;

    public SpecialSquare(int num) {
        if (num == 1)
            img = new ImageIcon("src/main/resources/images/cupcake.jpg").getImage();
        else if (num == 2)
            img = new ImageIcon("src/main/resources/images/gingerbread.jpg").getImage();
        else if (num == 3)
            img = new ImageIcon("src/main/resources/images/icecream.jpg").getImage();
        else if (num == 4)
            img = new ImageIcon("src/main/resources/images/licorice.jpg").getImage();
        else  
            img = new ImageIcon("src/main/resources/images/peppermint.jpg").getImage();
    
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public Image getImage(){
        return img;
    }

}




