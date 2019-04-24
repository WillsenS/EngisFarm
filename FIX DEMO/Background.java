import java.awt.image.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.*;

public class Background{

    private BufferedImage image;

    private double x;
    private double y;
    private double dx;
    private double dy;

    private double moveScale;

    public Background(String s,double ms){
        try {
            image = ImageIO.read(getClass().getResourceAsStream(s));
            moveScale =ms;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setPosition(double x,double y){
        this.x = x;
        this.y =y;
    }

    public void setVector (double dx,double dy){
        this.dx = dx;
        this.dy =dy;
    }

    

    public void update(){
        x+=dx;
        y+=dy;
    }
    public void draw(Graphics2D g){
        g.drawImage(image,(int)x,(int)y,null);
        if(x < 0) {
            g.drawImage(
                image,
                (int)x + GamePanel.WIDTH,
                (int)y,
                null
            );
        }
        if(x > 0) {
            g.drawImage(
                image,
                (int)x - GamePanel.WIDTH,
                (int)y,
                null
            );
        }
    }
    

}