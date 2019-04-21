//package com.game.src.main;

import java.awt.event.KeyListener;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JFrame;

public class engi extends JPanel implements ActionListener,KeyListener {
    Timer tm = new Timer(5,this);
    public static final int w = 600; //width
    public static final int h = 400; //height
    public static final int s =2; //scale
    public final String TITLE ="Engi's Farm";
    

    int x=0,y =0,velX =0,velY =0;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //ImageIcon i = new ImageIcon("/home/vania/Desktop/player.jpg");
        // Image ix = i.getImage().xgetScaledInstance(5,5,Image.SCALE_DEFAULT);
        //i.paintIcon(this,g,20,20);
        g.setColor(Color.RED);
        g.fillRect(x,y,50,30);
    }

    public engi() {
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setBackground(Color.GREEN);
    }

    public void actionPerformed(ActionEvent e){
        if (x<0){
            velX =0;
            x =0;
        }
        if (x>w-70){
            velX =0;
            x =w-70;
        }
        if (y<0){
            velY =0;
            y = 0;
        }
        if(y>h-70){
            velY =0;
            y =h-70;
        }
        x = x +velX;
        y+=velY;
        repaint();

    }

    public void keyPressed(KeyEvent e){
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT){
            velX =-10;
            velY =0;
        }
        if(c == KeyEvent.VK_UP){
            velX =0;
            velY=-10;
        }
        if(c == KeyEvent.VK_RIGHT){
            velX =10;
            velY =0;
        }
        if (c ==KeyEvent.VK_DOWN){
            velX=0;
            velY =10;
        }

    }

    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){
        velX =0;
        velY=0;
    }

    public static void main(String args[]){
        engi game = new engi();
        JFrame jf = new JFrame();
        jf.setTitle("Engi's Farm");
        jf.setSize(w,h);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(game);


        
        //game.setPreferredSize(new Dimension(w*h,h*s));
        //game.set
    }


}