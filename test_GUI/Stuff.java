import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Iterator;

public class Stuff{

    private Player player;

    private BufferedImage image;

    private Font font;

    private final int position =10;

    public Stuff(Player p){
        player =p;

        try{
            image =ImageIO.read(getClass().getResourceAsStream("g.png"));
            font = new Font("Arial",Font.PLAIN,10);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g){
        g.drawImage(image,0,position,null);
        g.setFont(font);
        g.setColor(Color.WHITE);

        g.drawString(Integer.toString(player.getMoney()) ,20,25);
        g.drawString(Integer.toString(player.getWater()) ,20,35);
        if(player.getInventory().isEmpty()){
            g.drawString("" ,20,35);
        } else {
            //int i = player.getInventory().size();
            int pos =45;
            for (int a =0;a<player.getInventory().size();a++){
                int x =10;
                g.drawString(player.getInventory().get(a) ,20,pos+=x);
            }
        }
    }
}