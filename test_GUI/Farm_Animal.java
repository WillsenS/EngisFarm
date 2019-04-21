
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
public abstract class Farm_Animal extends MapObject{
    private double Full;
    protected boolean status;
    protected int id;

    protected final int MAX =1;
    protected final double FULLMAX =100;
    protected final int dead = 0;
    protected final int HUNGRY = 1;

    protected final int randX =1;
    protected final int randY =1;

    protected BufferedImage image;

    protected final String CHICKEN ="Petok -petokkk";
    protected final String COW ="MOOOOO";
    protected final String DUCK ="quekk quekk";
    protected final String SHEEP ="Mbekkkkkkkkkkk";
    protected final String GOAT="Mbek mbekk";
    protected final String PIG ="Nguikk nguik";

    protected boolean eat;


    public Farm_Animal(FarmMap fm){
        super(fm);
        Full = FULLMAX;
        status = false;
    }

    public boolean isDead(){
        return status;
    }
    public boolean getStatus(){
        return this.status;
    }
    public void setStatus(boolean cek){
        this.status = cek;
    }
    public Double getFull(){
        return this.Full;
    }
    public void setFull(double f){
        this.Full = f;
    }
    public boolean nothidup(){
         if (this.Full<=dead){
             setStatus(true);
             return true;
         } 
         else return false;
                
    }
	public void update() {}
    abstract void eat(Graphics2D g);
    abstract String getChar();
    abstract void getProduct();
    //abstract Integer getCountProduct();
    abstract void talk();
    abstract void Print();
    abstract String nameProduct(); 
    abstract String getEggandMilk();
    abstract String getTalk();
    abstract boolean isTalk();
    abstract void setIsTalk(boolean val);
    //abstract void setFull(int Full);
    abstract void move();
}