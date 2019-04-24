import java.awt.image.*;
import java.awt.*;
public class Grass{
    private BufferedImage image;
    private int type;

    //grass type

    public static final int GRASS =0;
    public static final int NOGRASS =1;
    public static final int BLOCKED =2;

    public Grass (BufferedImage image,int type){
        this.image = image;
        this.type = type;
    }

    public BufferedImage getImage(){
        return image;
    }
    public int getType(){
        return type;
    }


}