import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class StartSquare extends JPanel{
    private Image img;

    public StartSquare(String img) {
        this(new ImageIcon(img).getImage());
    }

    public StartSquare(Image img) {
        this.img = img;
        Dimension size = new Dimension(80, 80);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        setBorder(new BevelBorder(BevelBorder.RAISED));
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}





