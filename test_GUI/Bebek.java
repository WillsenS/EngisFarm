
import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Bebek extends Farm_Animal {
    private BufferedImage[] sprites;
    private int countTelurB;
    private boolean isTalk;

    private Graphics2D g;

    private BufferedImage image;

    public Bebek(FarmMap fm){
        super(fm);

        moveSpeed =1;
        maxSpeed =10;

        width =30;
        height =30;
        cwidth =20;
        cheight =20;

        isTalk = false;
        // load sprite
        try{
            BufferedImage sheet = ImageIO.read(getClass().getResourceAsStream("duck.png"));
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
    public void eat(Graphics2D g){
        if (getFull() ==HUNGRY){
            setFull(FULLMAX);
            countTelurB =MAX;    
        }
        //super.draw(g);

        //animation.update();


    }

    public String getChar(){
        return "D";
    }

    public void talk(){
        System.out.println(DUCK);
    }

    public String getTalk(){
        return DUCK;
    }

    public boolean isTalk() {
        return isTalk;
    }

    public void setIsTalk(boolean val) {
        isTalk = val;
    }


    public void getProduct(){
        this.countTelurB =0;
    }

    public String nameProduct(){
        return "DuckMeat";
    }
    public String getEggandMilk(){
        return "DuckEgg";
    }

    public void update(){
        move();
        //talk();
        //Print();
        eat(g);
        checkFarmMapCollision();
        setPosition(xtemp,ytemp);
        animation.update();
    }

    public void draw(Graphics2D g){
        if(notOnScreen()) return;
        setMapPosition();
        // if (eat){
        //     g.setRGB(getX(),getY(),30,30,Color.WHITE);
        // }
        super.draw(g);
    }

    public void Print(){
        System.out.println("Bebek " + countTelurB + " Full : "+ getFull()+" pos :  "+ getX() +" "+getY());
    }
}