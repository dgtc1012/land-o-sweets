import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.*;
import java.util.Scanner;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
public class tRunner {



    public static void main(String[] args) {
        JFrame f = new JFrame("test");
        f.getContentPane().setLayout(null);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.white);


        Scanner s =  new Scanner(System.in);
        System.out.println("Welcome to Land-o-Sweets! How many players would like to play?");
        int total =  s.nextInt();
        s.nextLine();
        if ((total > 4) || (total < 2)){
            System.out.println("Only 2 - 4 players can play. Try again: ");
            total =  s.nextInt();
            s.nextLine();
        }

        System.out.println("What is the name of player 1?");
        String p1Name = s.nextLine();
        Token p1 = new Token(1, p1Name);
        p1.setCoords(10, 200);
        f.add(p1);

        System.out.println("What is the name of player 2?");
        String p2Name = s.nextLine();
        Token p2 = new Token(2, p2Name);
        p2.setCoords(150, 20);
        f.add(p2);

        if (total >= 3){
            System.out.println("What is the name of player 3?");
            String p3Name = s.nextLine();
            Token p3 = new Token(3, p3Name);
            p3.setCoords(200, 400);
            f.add(p3);
        }
        if (total == 4){
            System.out.println("What is the name of player 4?");
            String p4Name = s.nextLine();
            Token p4 = new Token(4, p4Name);
            p4.setCoords(420, 300);
            f.add(p4);
        }

        GrannysHouse gh = new GrannysHouse(new ImageIcon("C:/Users/maurice/IdeaProjects/1530/src/rainbow1.jpg").getImage());
        StartSquare ss = new StartSquare(new ImageIcon("C:/Users/maurice/IdeaProjects/1530/src/rainbow2.jpg").getImage());
        ss.setBounds(300,300, 81, 79);


        f.add(gh);
        f.add(ss);
        f.pack();



        f.setVisible(true);
    }


}