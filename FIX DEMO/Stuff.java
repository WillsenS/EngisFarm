import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Iterator;

public class Stuff{

    private Player player;

    private BufferedImage image, well, mix, truck;

    private Font font;

    private final int position =10;
    // private FarmMap farmMap;

    public Stuff(Player p){
        player =p;
        
        try{
            image =ImageIO.read(getClass().getResourceAsStream("g.png"));
            font = new Font("Arial",Font.PLAIN,9);

            well =ImageIO.read(getClass().getResourceAsStream("well.png"));
            mix =ImageIO.read(getClass().getResourceAsStream("mixer.jpg"));
            truck =ImageIO.read(getClass().getResourceAsStream("truck.jpg"));

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g){
        g.drawImage(image,0,position,null);
        g.drawImage(well,220,205,null);
        g.drawImage(mix,255,205,null);
        g.drawImage(truck,290,205,null);

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