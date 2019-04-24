import java.util.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.lang.*;

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
    public boolean talk;
    public boolean sell;
    public boolean fillingCan;
    public boolean exit; 

    private ArrayList<BufferedImage[]> sprites;
    private final int[] numFrames = {
		2, 8, 1, 2, 4, 2, 5
	};

    //actions
    private static final int IDLE=0;
    private static final int WALKING =1;
    private static final int LEFT =2;
    private static final int UP =3;
    private static final int DOWN =4;
    private static final int RIGHT =5;
    private static final int KILL =6;
    // private static final int DOWN =0;
    // private static final int DOWN =0;
    
    //const
    private final int MAXWATER = 10;

    public Player (FarmMap fm) {
        super(fm);

        width = 30;
	height = 30;
	cwidth = 20;
	cheight = 20;

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
            BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("playersprites.gif"));
            sprites = new ArrayList<BufferedImage[]>();
			for(int i = 0; i < 7; i++) {
				
				BufferedImage[] bi =
					new BufferedImage[numFrames[i]];
				
				for(int j = 0; j < numFrames[i]; j++) {
					
					if(i != KILL) {
						bi[j] = spritesheet.getSubimage(
								j * width,
								i * height,
								width,
								height
						);
					}
					else {
						bi[j] = spritesheet.getSubimage(
								j * width * 2,
								i * height,
								width * 2,
								height
						);
					}
					
				}
				
				sprites.add(bi);
				
			}
			
		}
         catch (Exception e) {
            e.printStackTrace();
        }

        animation = new Animation();
        currentAction =DOWN;
        animation.setFrames(sprites.get(IDLE));
        animation.setDelay(400);

        
    }
    public void setKill(boolean k) {
        kill = k;
    }

    public void setSell(boolean k) {
        sell = k;
    }

    public void setGrow(boolean g) {
        grow = g;
    }

    public void setMix(boolean m) {
        mix = m;
    }

    public void setExit(boolean e){
        exit = e;
    }

    public void setInteract (boolean i) {
        interact = i;
    }

    public void setTalk (boolean i) {
        talk = i;
    }

    public void setfillCan(boolean i) {
        fillingCan =i;
    }

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

    public int getMoney() {
        return money;
    }

    public int getWater() {
        return water;
    }

    public void checkgrow(){
        if(grow && water>0){
            int px = (getX() / 30);
            int py = (getY() / 30);

            // System.out.println("Px : " + px);
            // System.out.println("Py : " + py);
            if(animation.getArr(px,py) == 0){
                animation.gg(px,py,4);
                water -= 1;
            }
        }
    }

    public Vector<String> getInventory() {
        return inventory;
    }

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
                animation.setFrames(sprites.get(WALKING));
                animation.setDelay(400);
                width =30;
            }
        } else if (down) {
            if(currentAction!=DOWN) {
                currentAction = DOWN;
                animation.setFrames(sprites.get(WALKING));
                animation.setDelay(400);
                width =30;
            }
        } else if(right) {
            if(currentAction!=RIGHT) {
                currentAction = RIGHT;
                facingRight =true;
                animation.setFrames(sprites.get(WALKING));
                animation.setDelay(400);
                width =30;
            }            
        } else if(up) {
            if(currentAction!=UP) {
                currentAction = UP;
                animation.setFrames(sprites.get(WALKING));
                animation.setDelay(400);
                width =30;
            }             
        }
	else if(kill) {
		if(currentAction != KILL) {
			currentAction = KILL;
			animation.setFrames(sprites.get(KILL));
			animation.setDelay(50);
			width = 60;
		}
		}
        animation.update();
    }
    

    public void exit() {
        if(exit) {
            animation.exit();
        }
    }

    public void draw(Graphics2D g) {
        setMapPosition();
        super.draw(g);
    }

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

    public void checkKill(ArrayList<Farm_Animal> fa) {
        for(int i=0;i<fa.size();i++) {
            Farm_Animal e = fa.get(i);
            //System.out.println(kill);
            if (intersects(e)) {
                if (kill) {
                    e.getProduct();
                    fa.remove(i);
                    inventory.add(e.nameProduct());                    
                    }

                if (interact) {
                    if (!e.getEggandMilk().equals("x")) {
                        //System.out.println("1");
                        e.setProduct(0);
                        e.Print();
                        inventory.add(e.getEggandMilk());
                        interact = false;
                    }
                }
            }
        }
    }

    public void checkMix() {
        if(getX()>240 && getX()<270 && getY()>190 && getY()<240){
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
    }
    
    public void checkSell() {
        if(getX()>275 && getX()<315 && getY()>190 && getY()<240){
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
        }

    public void fillCan() {
        if(getX()>205 && getX()<235 && getY()>190 && getY()<240){
            if (this.water == 0 && fillingCan ) {
                this.water+=10;
                fillingCan = false;
            }
        }
    }
}
