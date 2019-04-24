import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Iterator;

public class TalkText {

    private Font font;

    public TalkText(){
        try{
            font = new Font("Arial",Font.PLAIN,10);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g, Farm_Animal animal) {
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(animal.getTalk() , animal.getX(), animal.getY());
    }
}