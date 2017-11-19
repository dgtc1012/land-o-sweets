import javax.swing.*;
import java.awt.*;

public class Timer {
    private final int xLoc;
    private final int yLoc;
    private final int width;
    private final int height;

    private int seconds;
    private int minutes;
    private int hours;
    private String time;
    JLabel gui;
    JLabel label;
    private Font timerFont;
    private Font textFont;

    public Timer(int x, int y) {
        xLoc = x;
        yLoc = y;
        width = 200;
        height = 80;

        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;

        timerFont = new Font("Serif", Font.BOLD, 40);
        textFont = new Font("Serif", Font.BOLD, 30);

        //label = new JLabel("<html><div style='text-align: center;'>" + "Timer Elapsed:" + "</div></html>");
        label = new JLabel("Time Elapsed:");
        label.setBackground(Color.WHITE);
        label.setFont(textFont);
        label.setBounds(xLoc - 15, yLoc - 45, width * 2, height);

        gui = new JLabel();
        gui.setBackground(Color.WHITE);
        gui.setFont(timerFont);
        gui.setBounds(xLoc, yLoc, width * 2, height);

        paintTimer(this.seconds, this.minutes, this.hours);
    }

    public Timer(int x, int y, int sec, int min, int hrs) {
        xLoc = x;
        yLoc = y;
        width = 200;
        height = 80;

        this.seconds = sec;
        this.minutes = min;
        this.hours = hrs;

        timerFont = new Font("Serif", Font.BOLD, 40);
        textFont = new Font("Serif", Font.BOLD, 30);

        //label = new JLabel("<html><div style='text-align: center;'>" + "Timer Elapsed:" + "</div></html>");
        label = new JLabel("Time Elapsed:");
        label.setBackground(Color.WHITE);
        label.setFont(textFont);
        label.setBounds(xLoc - 15, yLoc - 45, width * 2, height);

        gui = new JLabel();
        gui.setBackground(Color.WHITE);
        gui.setFont(timerFont);
        gui.setBounds(xLoc, yLoc, width * 2, height);

        paintTimer(this.seconds, this.minutes, this.hours);
    }

    public void paintTimer(int sec, int min, int hr) {
        this.time = "";
        if (hr < 10) {
            this.time = this.time + "0" + hr;
        } else {
            this.time = this.time + hr;
        }
        if (min < 10) {
            this.time = this.time + ":0" + min;
        } else {
            this.time = this.time + ":" + min;
        }
        if (sec < 10) {
            this.time = this.time + ":0" + sec;
        } else {
            this.time = this.time + ":" + sec;
        }
        gui.setText(this.time);
    }

    public int getSeconds() {
        return this.seconds;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getHours() {
        return this.hours;
    }

    public int incrementTime() {
        if (this.seconds == 59) {
            this.seconds = 0;
            if (this.minutes == 59) {
                this.minutes = 0;
                this.hours++;
            } else {
                this.minutes++;
            }
        } else {
            this.seconds++;
        }

        paintTimer(this.seconds, this.minutes, this.hours);

        return this.seconds + this.minutes * 60 + this.hours * 60 * 60;
    }
}
