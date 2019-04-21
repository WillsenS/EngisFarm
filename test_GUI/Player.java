import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Player extends MapObject{
    private int water;
    private int money;
    Vector<String> inventory; 

	//private SpriteSheet playerSheet; 

    //actions
    public boolean kill;
    public boolean mix;
    public boolean grow;
    public boolean interact;


    private ArrayList<BufferedImage[]> sprites;
    private final int [] numFrames ={
        8,8,8,8
    };

    //actions
    //private static final int DOWN =1;
    private static final int RIGHT =1;
    private static final int LEFT =0;
    private static final int UP =2;
    private static final int DOWN =3;
    //private static final int KILL =2;
    // private static final int DOWN =0;
    // private static final int DOWN =0;
    // private static final int DOWN =0;
    
    //const
    private final int MAXWATER = 10;

    public Player (FarmMap fm){
        super(fm);

        width =20;
        height =20;
        cwidth = 30;
        cheight =30;

        moveSpeed =5;
        maxSpeed =1.6;
        stopSpeed =0.4;

        water = 0;
        money =0;
        inventory = new Vector<String>();
        //kill = false;
         kill = false;
         mix = false;
         grow = false;
         interact = false;    

        

        // load sprite
        try {
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("x.png"));
            sprites = new ArrayList<BufferedImage[]>();
            for (int i =0; i <4;i++){
                BufferedImage[] b = new BufferedImage[numFrames[i]];
                for (int j =0; j<numFrames[i];j++){
                    b[j] = spritesheet.getSubimage(j*width,i*height,width,height);
                }
                sprites.add(b);
            }


        } catch (Exception e){
            e.printStackTrace();
        }

		// BufferedImage playerSheetImage = loadImage("Player.png");
		// //System.out.println("loadSuccess");
		// playerSheet = new SpriteSheet(playerSheetImage);
		// playerSheet.loadSprites(20, 26);

        animation = new Animation();
        currentAction =DOWN;
        animation.setFrames(sprites.get(DOWN));
        animation.setDelay(400);

        
    }
    public void setKill(boolean k){
        this.kill =k;
    }
    public void setGrow(boolean g){
        grow = g;
    }
    public void setMix(boolean m){
        this.mix = m;
    }

    public void setInteract (boolean i){
        interact =i;
    }

    public void getNextPosition(){
        //if(getx()>=10 && gety>=0)
		// movement
		if(left) {
			x -= moveSpeed;
            //x=0;
		}
		else if(right) {
			x += moveSpeed;

			if(dx > maxSpeed) {
				dx = maxSpeed;
			}
            facingRight=true;
		}
		else if(up) {
			y -= moveSpeed;
			if(dy > maxSpeed) {
				dy = maxSpeed;
			}
		}
		else if(down) {
			y += moveSpeed;
			if(dy > maxSpeed) {
				dy = maxSpeed;
			}
		}

    }



    
    public int getMoney() {
        return money;
    }
    
    public int getWater(){
        return water;
    }

    public Vector<String> getInventory(){
        return inventory;
    }

    public void update(){
        getNextPosition();
        //checkKill();
        checkFarmMapCollision();
        setPosition(xtemp,ytemp);
        System.out.println(inventory);
        if (left){
            if(currentAction!=LEFT){
                currentAction=LEFT;
                animation.setFrames(sprites.get(LEFT));
                animation.setDelay(400);
                width =20;
            }
        } else if (down){
            if(currentAction!=DOWN){
                currentAction = DOWN;
                animation.setFrames(sprites.get(DOWN));
                animation.setDelay(400);
                width =20;
            }
        } else if(right){
            if(currentAction!=RIGHT){
                currentAction = RIGHT;
                facingRight =true;
                animation.setFrames(sprites.get(RIGHT));
                animation.setDelay(400);
                width =20;
            }            
        } else if(up){
            if(currentAction!=UP){
                currentAction = UP;
                animation.setFrames(sprites.get(UP));
                animation.setDelay(400);
                width =20;
            }             
        }



        animation.update();
    }
    

    public void draw(Graphics2D g){
        setMapPosition();
        super.draw(g);
    }

    public void checkKill(ArrayList<Farm_Animal> fa){
    //System.out.println("start trying again");
    for(int i=0;i<fa.size();i++){
        Farm_Animal e = fa.get(i);
        //System.out.println(kill);
        if (intersects(e)){
            if(kill){
                e.getProduct();
                fa.remove(i);
                inventory.add(e.nameProduct());                    
                }
        
            if(interact){
                if(!e.getEggandMilk().equals("x")){
                    System.out.println("1");
                    e.getProduct();
                    inventory.add(e.getEggandMilk());
                    interact = false;
                }

             }

        }

        }
    }
    public void checkMix() {
    	if(mix){
    		System.out.println("MIXX!");
        	if (inventory.contains("ChickenEgg") && inventory.contains("DuckEgg")) {
    			inventory.add("Omelette");
    			inventory.remove("ChickenEgg");
    			inventory.remove("DuckEgg");
    		}
    		if (inventory.contains("Pork") && inventory.contains("LambMeat")) {
    			inventory.add("BBQ");
    			inventory.remove("Pork");
    			inventory.remove("LambMeat");
    		}
    		if (inventory.contains("CowMeat") && inventory.contains("GoatMeat")) {
    			inventory.add("Sausage");
    			inventory.remove("CowMeat");
    			inventory.remove("GoatMeat");
    		}
        }
    }
	// private BufferedImage loadImage(String path)
	// {
	// 	try 
	// 	{
	// 		BufferedImage loadedImage = ImageIO.read(getClass().getResource(path));
		
	// 		BufferedImage formattedImage = new BufferedImage(loadedImage.getWidth(), loadedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
	// 		formattedImage.getGraphics().drawImage(loadedImage, 0, 0, null);

	// 		return formattedImage;
	// 	}
	// 	catch(IOException exception) 
	// 	{
	
	// 		exception.printStackTrace();
	// 		return null;
	// 	}
	// }


}
