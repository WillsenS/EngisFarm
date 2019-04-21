
import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Ayam extends Farm_Animal {
    private BufferedImage[] sprites;
    private int countTelurA;

    private Graphics2D g;

    private BufferedImage image;

    public Ayam(FarmMap fm){
        super(fm);

        moveSpeed =1;
        maxSpeed =10;

        width =30;
        height =30;
        cwidth =20;
        cheight =20;

        // load sprite
        try{
            BufferedImage sheet = ImageIO.read(getClass().getResourceAsStream("chicken_eat.png"));
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
        double x = ThreadLocalRandom.current().nextDouble(-randX, randY + 1);
        double y =ThreadLocalRandom.current().nextDouble(-randX, randY);
        if(!nothidup()){
            if(getX()+x>30 &&getX()+x<GamePanel.w-30&&getY()+y>10&&getY()+y<GamePanel.h-30){
                //dx += moveSpeed;
                setPosition(getX()+x,getY()+x);
            }
            // } else {
            //     setPosition(getX()-x*2,getY()-x*2);
            // }
            setFull(getFull()-HUNGRY); 
        }
        


    }
    public void eat(Graphics2D g){
        if(getFull()==HUNGRY){
             setFull(FULLMAX);
             countTelurA =MAX;

        }


    }

    public String getChar(){
        return "A";
    }

    public void talk(){
        System.out.println(CHICKEN);
    }

    public String getTalk(){
        return CHICKEN;
    }

    public void getProduct(){
        this.countTelurA =0;
    }

    public void update(){
        move();
        eat(g);
        //talk();
        //Print();
        checkFarmMapCollision();
        setPosition(xtemp,ytemp);
        animation.update();
    }
    public String nameProduct(){
        return "ChickenMeat";
    }
    public String getEggandMilk(){
        return "ChickenEgg";
    }
    public void draw(Graphics2D g){
        if(notOnScreen()) return;
        setMapPosition();
        // if (eat){
        //     g.setRGB(getx(),gety(),30,30,Color.WHITE);
        // }
        super.draw(g);
    }

    public void Print(){
        System.out.println("Ayam " + countTelurA + " Full : "+ getFull()+" pos :  "+ getX() +" "+getY());
    }
}