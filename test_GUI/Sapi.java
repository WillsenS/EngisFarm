
import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Sapi extends Farm_Animal implements LivingThings{
    private BufferedImage[] sprites;
    private int countMilk;
    private boolean isTalk;

    private BufferedImage image;
    private Graphics2D g;

    public Sapi(FarmMap fm) {
        super(fm);

        moveSpeed =0.05;
        maxSpeed =0.05;

        width =33;
        height =30;
        cwidth =20;
        cheight =20;

        isTalk = false;
        // load sprite
        try{
            BufferedImage sheet = ImageIO.read(getClass().getResourceAsStream("cow.png"));
            sprites = new BufferedImage[3];
            for(int i =0;i<sprites.length;i++) {
                sprites[i] = sheet.getSubimage(1*width,0,width,height);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        animation = new Animation();
        animation.setFrames(sprites);
        animation.setDelay(300);

        left = true;

    }

    public void move() {
        int x = ThreadLocalRandom.current().nextInt(-randX, randY + 1);
        int y =ThreadLocalRandom.current().nextInt(-randX, randY);
        if(!nothidup()) {

        
            if(getX()<=30||getX()>=GamePanel.w-30) {
                right = true;
                left = false;

            } 
            // movement
            if(left) {
                dx -= moveSpeed;
                if(dx < -maxSpeed) {
                    dx = -maxSpeed;
                }
            }
        }
    }

    public void eat(Graphics2D g){
        if (getFull() == HUNGRY){
            setFull(FULLMAX);
            countMilk =MAX;

        }
        setFull(getFull()-0.1); 
    }

    public String getChar(){
        return "S";
    }

    public void talk(){
        System.out.println(COW);
    }

    public String getTalk(){
        return COW;
    }

    public boolean isTalk() {
        return isTalk;
    }

    public void setIsTalk(boolean val) {
        isTalk = val;
    }

    public void getProduct(){
        this.countMilk =0;
    }

    public String nameProduct(){
        return "CowMeat";
    }

    public String getEggandMilk(){
        return "CowMilk";
    }

    public void update(){
        move();
        //Print();

        //eat(g);
        checkFarmMapCollision();
        setPosition(xtemp,ytemp);
        animation.update();
    }

    public void draw(Graphics2D g) {
        if(notOnScreen()) return;
        setMapPosition();
        super.draw(g);
    }

    public void Print(){
        System.out.println("Sapi " + countMilk + " Full : "+ getFull()+" pos :  "+ getX() +" "+getY());
    }
}