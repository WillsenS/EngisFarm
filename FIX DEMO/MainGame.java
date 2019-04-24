import java.awt.event.KeyListener;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JFrame;

public class MainGame {

    public static void main(String args[]){
        JFrame jf = new JFrame("Engi's Farm");
        jf.setContentPane (new GamePanel());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.pack();
        jf.setVisible(true);
    }




}