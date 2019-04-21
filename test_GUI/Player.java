import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.lang.*;

/**
 * Player Class.
 */
public class Player extends MapObject{
    /** Water owned by Player. */
    private int water;
    /** Money owned by Player.*/
    private int money;
    /** Player inventory list. */
    Vector<String> inventory; 

    /** Kill action */
    public boolean kill;
    /** Mix action */
    public boolean mix;
    /** Grow action */
    public boolean grow;
    /** Interact action */
    public boolean interact;
    /** Talk action */
    public boolean talk;
    /** Sell action */
    public boolean sell;
    /** Filling Water Can action */
    public boolean fillingCan;
    /** Exit action */
    public boolean exit; 

    /** Player sprites. */
    private ArrayList<BufferedImage[]> sprites;
    private final int [] numFrames ={
        8, 8, 8, 8
    };

    /** Move Right action */
    private static final int RIGHT =1;
    /** Move Left action */
    private static final int LEFT =0;
    /** Move Up action */
    private static final int UP =2;
    /** Move Down action */
    private static final int DOWN =3;
    
    /** Max Water contant */
    private final int MAXWATER = 10;

    /**
     * Ctor
     * @param  fm The Farm Map
     */
    public Player (FarmMap fm) {
        super(fm);

        width = 20;
        height = 20;
        cwidth = 30;
        cheight = 30;

        moveSpeed = 5;
        maxSpeed = 1.6;
        stopSpeed = 0.4;

        water = 0;
        money = 0;
        inventory = new Vector<String>();
        kill = false;
        mix = false;
        grow = false;
        interact = false;
        talk = false;
        fillingCan=false;

        // load sprite
        try {
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("Player.png"));
            sprites = new ArrayList<BufferedImage[]>();
            for (int i =0; i <4;i++) {
                BufferedImage[] b = new BufferedImage[numFrames[i]];
                for (int j =0; j<numFrames[i];j++) {
                    b[j] = spritesheet.getSubimage(j*width,i*height,width,height);
                }
                sprites.add(b);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        animation = new Animation();
        currentAction =DOWN;
        animation.setFrames(sprites.get(DOWN));
        animation.setDelay(400);
    }

    /**
     * Set Kill action value.
     * @param k Action value.
     */
    public void setKill(boolean k) {
        kill = k;
    }

    /**
     * Set Sell action value.
     * @param s Action value.
     */
    public void setSell(boolean s) {
        sell = s;
    }

    /**
     * Set Grow action value.
     * @param g Action value.
     */
    public void setGrow(boolean g) {
        grow = g;
    }

    /**
     * Set Mix action value.
     * @param m Action value.
     */
    public void setMix(boolean m) {
        mix = m;
    }

    /**
     * Set Exit action value.
     * @param e Action value.
     */
    public void setExit(boolean e){
        exit = e;
    }

    /**
     * Set Interact action value.
     * @param i Action value.
     */
    public void setInteract (boolean i) {
        interact = i;
    }

    /**
     * Set Talk action value.
     * @param t Action value.
     */
    public void setTalk (boolean t) {
        talk = t;
    }

    /**
     * Set Fill Water Can action value.
     * @param f Action value.
     */
    public void setfillCan(boolean f) {
        fillingCan = f;
    }

    /**
     * Get the next Player position.
     */
    public void getNextPosition() {
        //if(getX()>=10 && getY>=0)
        // movement
        if(left) {
            if(super.getX()-moveSpeed>0) {
                x -= moveSpeed;
            }
        }
        else if(right) {
            if(super.getX()+moveSpeed<320) {
                x += moveSpeed;
                if(dx > maxSpeed) {
                    dx = maxSpeed;
                }
            }
            facingRight=true;
        }
        else if(up) {
            if(super.getY()-moveSpeed>0) {
                y -= moveSpeed;
                if(dy > maxSpeed) {
                    dy = maxSpeed;
                }
            }
        }
        else if(down) {
            if(super.getY()+moveSpeed<230) {
                y += moveSpeed;
                if(dy > maxSpeed) {
                    dy = maxSpeed;
                }
            }
        }
    }

    /**
     * Get Player's money.
     * @return Player's money.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Get Player's water quantity.
     * @return [description]
     */
    public int getWater() {
        return water;
    }

    /**
     * Do grow grass.
     */
    public void checkgrow(){
        if(grow){
            int px = (getX() / 30);
            int py = (getY() / 30);

            System.out.println("Px : " + px);
            System.out.println("Py : " + py);
            animation.growGrass(px,py,4);
        }
    }

    /**
     * Get Player's Invetory.
     * @return Player's Inventory.
     */
    public Vector<String> getInventory() {
        return inventory;
    }

    /**
     * Update Player status.
     * @param fa List of animals in farm.
     */
    public void update(ArrayList<Farm_Animal> fa) {
        getNextPosition();
        System.out.println("Pos Player x : " + getX());
        System.out.println("Pos Player y : " + getY());
        checkFarmMapCollision();
        setPosition(xtemp,ytemp);
        talk(fa);
        if (left) {
            if(currentAction!=LEFT) {
                currentAction=LEFT;
                animation.setFrames(sprites.get(LEFT));
                animation.setDelay(400);
                width =20;
            }
        } else if (down) {
            if(currentAction!=DOWN) {
                currentAction = DOWN;
                animation.setFrames(sprites.get(DOWN));
                animation.setDelay(400);
                width =20;
            }
        } else if(right) {
            if(currentAction!=RIGHT) {
                currentAction = RIGHT;
                facingRight =true;
                animation.setFrames(sprites.get(RIGHT));
                animation.setDelay(400);
                width =20;
            }            
        } else if(up) {
            if(currentAction!=UP) {
                currentAction = UP;
                animation.setFrames(sprites.get(UP));
                animation.setDelay(400);
                width =20;
            }             
        }
        animation.update();
    }
    
    /**
     * Exit the game.
     */
    public void exit() {
        if(exit) {
            animation.exit();
        }
    }

    /**
     * Draw Player.
     * @param g Canvas to draw.
     */
    public void draw(Graphics2D g) {
        setMapPosition();
        super.draw(g);
    }

    /**
     * Talk Action.
     * @param fa List of animals on farm.
     */
    public void talk(ArrayList<Farm_Animal> fa) {
        outloop:
        for(int i=0;i<fa.size();i++) {
            Farm_Animal e = fa.get(i);
            if (intersects(e) && talk) {
                e.talk();
                e.setIsTalk(true);
                talk = false;
                break outloop;
            }
        }
    }

    /**
     * Kill and Interact Action.
     * @param fa List of all animals on farm.
     */
    public void checkKill(ArrayList<Farm_Animal> fa) {
        for(int i=0;i<fa.size();i++) {
            Farm_Animal e = fa.get(i);
            if (intersects(e)) {
                if (kill) {
                    e.getProduct();
                    fa.remove(i);
                    inventory.add(e.nameProduct());                    
                }

                if (interact) {
                    if (!e.getEggandMilk().equals("x")) {
                        e.getProduct();
                        inventory.add(e.getEggandMilk());
                        interact = false;
                    }
                }
            }
        }
    }

    /**
     * Mix Action.
     */
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

    /**
     * Sell Action.
     */
    public void checkSell() {
        if(sell) {
            // if(isAdjacent(facility.getTruckX(),facility.getTruckY())) {
                while(!inventory.isEmpty()) {
                    if (inventory.contains("ChickenMeat")) {
                        money += 4;
                        inventory.remove("ChickenMeat");
                    } if(inventory.contains("ChickenEgg")) {
                        money += 3;
                        inventory.remove("ChickenEgg");
                    } if (inventory.contains("DuckMeat")) {
                        money += 4;
                        inventory.remove("DuckMeat");
                    } if(inventory.contains("DuckEgg")) {
                        money += 3;
                        inventory.remove("DuckEgg");
                    } if (inventory.contains("CowMeat")) {
                        money += 4;
                        inventory.remove("CowMeat");
                    } if(inventory.contains("CowMilk")) {
                        money += 3;
                        inventory.remove("CowMilk");
                    } if (inventory.contains("GoatMeat")) {
                        money += 4;
                        inventory.remove("GoatMeat");
                    } if(inventory.contains("GoatMilk")) {
                        money += 3;
                        inventory.remove("GoatMilk");
                    } if (inventory.contains("LambMeat")) {
                        money += 4;
                        inventory.remove("LambMeat");
                    } if(inventory.contains("Pork")) {
                        money += 4;
                        inventory.remove("Pork");
                    } if (inventory.contains("Sausage")) {
                        money += 10;
                        inventory.remove("Sausage");
                    } if(inventory.contains("BBQ")) {
                        money += 10;
                        inventory.remove("BBQ");
                    }if (inventory.contains("Omelette")) {
                        money += 10;
                        inventory.remove("Omelette");
                    }
                }
            }
        }

    /**
     * Fill Water Can Action.
     */
    public void fillCan() {
        if (this.water == 0 && fillingCan ) {
            this.water+=10;
            fillingCan = false;
        }
    }
}
