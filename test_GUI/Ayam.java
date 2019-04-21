import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Ayam Class.
 */
public class Ayam extends Farm_Animal implements LivingThings {
    /** Ayam Sprites. */
    private BufferedImage[] sprites;
    /** Chicken Egg Counter. */
    private int countTelurA;
    /** Is Currenty Ayam Talking. */
    private boolean isTalk;
    /** Canvas. */
    private Graphics2D g;
    /** Buffered image for sprites frames. */
    private BufferedImage image;

    /**
     * Ctor.
     * @param  fm The Farm Map.
     */
    public Ayam(FarmMap fm) {
        super(fm);

        moveSpeed =0.05;
        maxSpeed =0.05;

        width =30;
        height =30;
        cwidth =20;
        cheight =20;

        // load sprite
        try{
            BufferedImage sheet = ImageIO.read(getClass().getResourceAsStream("chicken_eat.png"));
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

    /**
     * Move Action.
     */
    public void move() {
        int x = ThreadLocalRandom.current().nextInt(-randX, randY + 1);
        int y =ThreadLocalRandom.current().nextInt(-randX, randY);
        if(!nothidup()) {
            if(getX()+x>30 &&getX()+x<GamePanel.w-30&&getY()+y>10&&getY()+y<GamePanel.h-30) {
                setPosition(getX()+x,getY()+x);
            }
            setFull(getFull()-HUNGRY); 
        }
        
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
            else if(right) {
                dx += moveSpeed;
                if(dx > maxSpeed) {
                    dx = maxSpeed;
                }
            }
        setFull(getFull()-0.); 
    }

    /**
     * Eat Action.
     * @param g Canvas.
     */
    public void eat(Graphics2D g) {
        if(getFull()==HUNGRY) {
             setFull(FULLMAX);
             countTelurA =MAX;
        }
    }

    /**
     * Get Ayam char.
     * @return Ayam char.
     */
    public String getChar() {
        return "A";
    }

    /**
     * Talk action.
     */
    public void talk() {
        System.out.println(CHICKEN);
    }

    /**
     * Get ayam talk string.
     * @return Ayam talk string.
     */
    public String getTalk() {
        return CHICKEN;
    }

    /**
     * Get whether ayam is talking or not.
     * @return [description]
     */
    public boolean isTalk() {
        return isTalk;
    }

    /**
     * Set ayam talking condition.
     * @param val Condition to be applied.
     */
    public void setIsTalk(boolean val) {
        isTalk = val;
    }

    /**
     * Get ayam product.
     */
    public void getProduct() {
        this.countTelurA =0;
    }

    /**
     * Update ayam status.
     */
    public void update() {
        move();
        eat(g);
        Print();

        checkFarmMapCollision();
        setPosition(xtemp,ytemp);
        animation.update();
    }

    /**
     * Get ayam product when killed.
     * @return [description]
     */
    public String nameProduct() {
        return "ChickenMeat";
    }

    /**
     * Get ayam product when being interacted.
     * @return [description]
     */
    public String getEggandMilk() {
        return "ChickenEgg";
    }

    /**
     * Draw ayam.
     * @param g Canvas to draw into.
     */
    public void draw(Graphics2D g) {
        if(notOnScreen()) return;
        setMapPosition();
        super.draw(g);
    }

    /**
     * Print ayam status.
     */
    public void Print() {
        System.out.println("Ayam " + countTelurA + " Full : "+ getFull()+" pos :  "+ getX() +" "+getY());
    }
}