
import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Domba extends Farm_Animal {
    private BufferedImage[] sprites;
    private int countLambMeat;
    private boolean isTalk;

    private BufferedImage image;
    private Graphics2D g;

    public Domba(FarmMap fm){
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
            BufferedImage sheet = ImageIO.read(getClass().getResourceAsStream("sheep.png"));
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
        if(getFull()==HUNGRY){
            setFull(FULLMAX);
            countLambMeat =MAX;
        }
        //g.drawImage(image,0,0,getX(),getY(),null);
       // g.setColor(Color.RED);
        //g.fillRect(0,0,getX(),getY());
        //System.out.println("eat");



    }

    public String getChar(){
        return "D";
    }

    public void talk(){
        System.out.println(SHEEP);
    }

    public String getTalk(){
        return SHEEP;
    }

    public boolean isTalk() {
        return isTalk;
    }

    public void setIsTalk(boolean val) {
        isTalk = val;
    }


    public void getProduct(){
        this.countLambMeat =0;
    }

    public String nameProduct(){
        return "LambMeat";
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
        System.out.println("Domba " + countLambMeat + " Full : "+ getFull()+" pos :  "+ getX() +" "+getY());
    }
}