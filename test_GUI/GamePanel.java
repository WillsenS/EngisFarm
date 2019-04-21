import java.awt.Canvas;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;

import java.awt.*;
import java.awt.event.*;

import java.awt.event.KeyListener;
import java.awt.Graphics;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements Runnable,KeyListener{
    private static final long serialVersionUID = 1L;
    public static int alpha = 0xFFFF00B3;
    public static final int w = 320;
    public static final int h =240;
    public static final int s =3;// scale

    public static final String title ="Engi's Farm";

    //thread
    private Thread thread;
    public boolean running;
    private int FPS =60;
    private long targetTime = 1000/FPS; // time

    //image
    private BufferedImage image; 
    private Graphics2D g;

    //game state

    private GameStateManager gsm;

    public GamePanel(){
        super();
        //JFrame jf = new JFrame();
        setPreferredSize(new Dimension(w*s,h*s));
        setFocusable(true);
        requestFocus();

    }

    public void addNotify(){
        super.addNotify();
        if(thread ==null){
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    private void init(){
        image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        running =true;

        gsm = new GameStateManager();
    }

    public void run(){
        init();

        long start;
        long elapsed;
        long wait;

        //game loop        
        while (running){
            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime()-start;
            wait = targetTime-elapsed/1000000;
            if (wait<0) wait =5;
            try{
                Thread.sleep(wait);
            } catch(Exception e){
                e.printStackTrace();
            }

        }


    }

    private void update(){
        gsm.update();
    }
    private void draw(){
        gsm.draw(g);
    }
    private void drawToScreen(){
        Graphics g2 = getGraphics();
        g2.drawImage(image,0,0,w*s,h*s,null); /// image size
        g2.dispose();
    }


    public void keyTyped(KeyEvent key){}
    public void keyPressed(KeyEvent key){
        gsm.keyPressed(key.getKeyCode());
    }
    public void keyReleased(KeyEvent key){
		gsm.keyReleased(key.getKeyCode());
    }






}