
import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class Babi extends Farm_Animal{
    private BufferedImage[] sprites;
    private int countProduct;
    private boolean isTalk;

    private BufferedImage image;
    private Graphics2D g;
    int[][] arr = new int[12][8];
    public Babi(FarmMap fm){
        super(fm);

        moveSpeed =0.05;
        maxSpeed =0.05;

        width =29;
        height =20;
        cwidth =20;
        cheight =20;
        FULLMAX = 70;

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
            // setFull(getFull()-0.01); 
        }
        


    }
    public void eat(Graphics2D g){

        int py = (getY() / 30);
        int px = (getX() / 30);
        read();
        // System.out.println("Px : " + px);
        // System.out.println("Py : " + py);
        // System.out.println(arr[px][py]);
        // System.out.println("Hungry : " + HUNGRY);
        // System.out.println("getFull : " + getFull());
        
        if (getFull()==HUNGRY && arr[px][py]==4){
            setFull(FULLMAX);
            countProduct =MAX;
            arr[px][py]=0;
            write();
            animation.gg(px,py,0);
        }
        setFull(getFull()-0.5); 
    }

    public String getChar(){
        return "Z";
    }

    public void talk(){
        System.out.println(PIG);
    }

    public String getTalk(){
        return PIG;
    }

    public boolean isTalk() {
        return isTalk;
    }

    public void setIsTalk(boolean val) {
        isTalk = val;
    }


    public void getProduct(){
        this.countProduct =0;
    }
    public String nameProduct(){
        return "Pork";
    }
    public void setProduct(int x){
        this.countProduct =x;
    }

    public String getEggandMilk(){
        return "x";
    }
    public int getCountProduct() {
        return this.countProduct;
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
        System.out.println("Babi " + countProduct + " Full : "+ getFull()+" pos :  "+ getX() +" "+getY());
    }

    public void read(){
        String fileName = "level1-1.map";
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line1 = bufferedReader.readLine();
            String line2 = bufferedReader.readLine();

            for(int z=0; z<8; z++) {
                String line = bufferedReader.readLine();
                String[] parseline = line.split("\\s+");
                for(int r=0; r<12; r++){
                    arr[r][z] = Integer.parseInt(parseline[r]);
                }
            }
            // Always close files.
            bufferedReader.close();  
            fileReader.close();       
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    public void write(){
        String fileName = "level1-1.map";
        try {
            PrintWriter wwriter = new PrintWriter(fileName);
            wwriter.print("");
            wwriter.close();


            FileWriter writer = new FileWriter("level1-1.map", true);
            writer.write("12"); writer.write("\r\n");   // write new line
            writer.write("8"); writer.write("\r\n");
            for(int k=0; k<7; k++){
                for(int j=0; j<11; j++){
                    writer.write(String.valueOf(arr[j][k])); writer.write(" ");
                }
                writer.write(String.valueOf(arr[11][k])); writer.write("\r\n");
            }
            
            for(int j=0; j<11; j++){
                writer.write(String.valueOf(arr[j][7])); writer.write(" ");
            }
            writer.write(String.valueOf(arr[11][7])); writer.write("\r\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}