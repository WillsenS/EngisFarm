
import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Babi extends Farm_Animal{
    private BufferedImage[] sprites;
    private int countPork;

    private BufferedImage image;
    private Graphics2D g;

    public Babi(FarmMap fm){
        super(fm);

        moveSpeed =0.05;
        maxSpeed =0.05;

        width =29;
        height =20;
        cwidth =20;
        cheight =20;

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

    public void move(){
        int x = ThreadLocalRandom.current().nextInt(-randX, randY + 1);
        int y =ThreadLocalRandom.current().nextInt(-randX, randY);
        if(!nothidup()){
            if(getx()+x>30 &&getx()+x<GamePanel.w-30&&gety()+y>10&&gety()+y<GamePanel.h-30){
                //dx += moveSpeed;
                setPosition(getx()+x,gety()+x);
            }
            // } else {
            //     setPosition(getx()-x*2,gety()-x*2);
            // }
            setFull(getFull()-0.01); 
        }
        


    }
    public void eat(Graphics2D g){

        if (getFull() ==HUNGRY){
            setFull(FULLMAX);
            countPork =MAX;
        } 

        //g.drawImage(image,0,0,getx(),gety(),null);
       // g.setColor(Color.RED);
        //g.fillRect(0,0,getx(),gety());
        //System.out.println("eat");



    }

    public String getChar(){
        return "Z";
    }

    public void talk(){
        System.out.println(PIG);
    }

    public void getProduct(){
        this.countPork =0;
    }
    public String nameProduct(){
        return "Pork";
    }

    public String getEggandMilk(){
        return "x";
    }
    public void update(){
        move();
        //Print();

        eat(g);
        checkFarmMapCollision();
        setPosition(xtemp,ytemp);
        animation.update();
    }

    public void draw(Graphics2D g){
        if(notOnScreen()) return;
        setMapPosition();
        super.draw(g);
    }

    public void Print(){
        System.out.println("Babi " + countPork + " Full : "+ getFull()+" pos :  "+ getx() +" "+gety());
    }
}