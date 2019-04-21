
import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Babi extends Farm_Animal{
    /** Babi Sprites. */
    private BufferedImage[] sprites;
    /** Pork Counter. */
    private int countPork;
    /** Is Currenty Babi Talking. */
    private boolean isTalk;
    /** Canvas. */
    private BufferedImage image;
    /** Buffered image for sprites frames. */
    private Graphics2D g;

    /**
     * Ctor.
     * @param  fm The Farm Map.
     */
    public Babi(FarmMap fm){
        super(fm);

        moveSpeed =0.05;
        maxSpeed =0.05;

        width =29;
        height =20;
        cwidth =20;
        cheight =20;

        isTalk = false;
        // load sprite
        try{
            BufferedImage sheet = ImageIO.read(getClass().getResourceAsStream("babi.png"));
            sprites = new BufferedImage[3];
            for(int i =0;i<sprites.length;i++){
                sprites[i] = sheet.getSubimage(1*width,0,width,height);
            }

        } catch (Exception e){
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
    public void move(){
        int x = ThreadLocalRandom.current().nextInt(-randX, randY + 1);
        int y =ThreadLocalRandom.current().nextInt(-randX, randY);
        if(!nothidup()){
            if(getX()+x>30 &&getX()+x<GamePanel.w-30&&getY()+y>10&&getY()+y<GamePanel.h-30){
                //dx += moveSpeed;
                setPosition(getX()+x,getY()+x);
            }
            // } else {
            //     setPosition(getX()-x*2,getY()-x*2);
            // }
            setFull(getFull()-0.01); 
        }
    }

    /**
     * Eat Action.
     * @param g Canvas.
     */
    public void eat(Graphics2D g){

        if (getFull() ==HUNGRY){
            setFull(FULLMAX);
            countPork =MAX;
        } 
    }

    /**
     * Get Ayam char.
     * @return Ayam char.
     */
    public String getChar(){
        return "Z";
    }

    /**
     * Talk action.
     */
    public void talk(){
        System.out.println(PIG);
    }

    /**
     * Get ayam talk string.
     * @return Ayam talk string.
     */
    public String getTalk(){
        return PIG;
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
    public void getProduct(){
        this.countPork =0;
    }

    /**
     * Update ayam status.
     */
    public String nameProduct(){
        return "Pork";
    }

    /**
     * Get ayam product when killed.
     * @return [description]
     */
    public String getEggandMilk(){
        return "x";
    }

    /**
     * Get ayam product when being interacted.
     * @return [description]
     */
    public void update(){
        move();
        //Print();

        eat(g);
        checkFarmMapCollision();
        setPosition(xtemp,ytemp);
        animation.update();
    }

    /**
     * Draw ayam.
     * @param g Canvas to draw into.
     */
    public void draw(Graphics2D g){
        if(notOnScreen()) return;
        setMapPosition();
        super.draw(g);
    }

    /**
     * Print ayam status.
     */
    public void Print(){
        System.out.println("Babi " + countPork + " Full : "+ getFull()+" pos :  "+ getX() +" "+getY());
    }
}