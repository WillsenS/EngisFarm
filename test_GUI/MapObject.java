import java.awt.Rectangle;
public abstract class MapObject{

    protected FarmMap farmMap;
    protected int farmSize;
    protected double xmap;
    protected double ymap;

    protected double x;
    protected double y;
    protected double dx;
    protected double dy;

    protected int width;
    protected int height;

    //collision box
    protected int cwidth;
    protected int cheight;

    //collision
    protected int currRow;
    protected int currCol;
    protected double xdest;
    protected double ydest;
    protected double xtemp;
    protected double ytemp;

    protected boolean topLeft;
    protected boolean topRight;
    protected boolean bottomLeft;
    protected boolean bottomRight;

    //animation
    protected Animation animation;
    protected int currentAction;
    protected int previousAction;
    protected boolean facingRight;


    //movement of object
    protected boolean left;
    protected boolean right;
    protected boolean up;
    protected boolean down;

    // movement attribute
    protected double moveSpeed;
    protected double maxSpeed;
    protected double stopSpeed;

    public MapObject(FarmMap fm){
        farmMap =fm;
        farmSize=fm.getGrassSize();

    }

    // checking collide between player and other objects
    public boolean intersects(MapObject o){
        Rectangle r1 = new Rectangle((int)x -cwidth,(int)y -cheight,cwidth,cheight);
        Rectangle r2 = o.getRectangle();
        return r1.intersects(r2);
    }

    public Rectangle getRectangle(){
        return new Rectangle((int)x -cwidth,(int)y -cheight,cwidth,cheight);
    }

    public void calculateCorners(double x,double y){
        int leftGrass =(int)(x-cwidth/2)/farmSize;
        int rightGrass =(int)(x+cwidth/2-1)/farmSize;
        int topGrass =(int)(y-cheight/2)/farmSize;
        int bottom =(int)(y+cheight/2-1)/farmSize;

        int gl = farmMap.getType(topGrass,leftGrass);
        int gr = farmMap.getType(topGrass,rightGrass);
        int bl = farmMap.getType(bottom,leftGrass);
        int br = farmMap.getType(bottom,rightGrass);

        topLeft =gl == Grass.BLOCKED;
        topRight =gr == Grass.BLOCKED;
        bottomLeft =bl == Grass.BLOCKED;
        bottomRight =br == Grass.BLOCKED;
           }

    public void checkFarmMapCollision(){
        currCol = (int)x /farmSize;
        currRow = (int)y /farmSize;

        xdest = x+dx;
        ydest = y+dy;

        xtemp =x;
        ytemp =y;

        calculateCorners(x,ydest);
        if(dy<0){
            if(topLeft||topRight){
                dy =0;
                ytemp =currRow*farmSize +cheight/2;
            }
            else{
                ytemp+=dy;
            }
        }
        calculateCorners(xdest,y);
        if(dx<0){
            if(topLeft||bottomLeft){
                dx =0;
                xtemp =currRow*farmSize +cwidth/2;
            }
            else{
                xtemp+=dx;
            }
        } 
        if(dx>0){
            if(topRight||bottomRight){
                dx =0;
                xtemp =currRow*farmSize +cwidth/2;
            }
        }         

    }
	public int getX() { return (int)x; }
	public int getY() { return (int)y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getCWidth() { return cwidth; }
	public int getCHeight() { return cheight; }
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void setMapPosition() {
		xmap = farmMap.getX();
		ymap = farmMap.getY();
	}

	
	public void setLeft(boolean b) { left = b; }
	public void setRight(boolean b) { right = b; }
	public void setUp(boolean b) { up = b; }
	public void setDown(boolean b) { down = b; }

	public boolean notOnScreen() {
		return x + xmap + width < 0 ||
			x + xmap - width > GamePanel.w ||
			y + ymap + height < 0 ||
			y + ymap - height > GamePanel.h;
	}
	public void draw(java.awt.Graphics2D g) {
		if(facingRight) {
			g.drawImage(
				animation.getImage(),
				(int)(x + xmap - width / 2),
				(int)(y + ymap - height / 2),
				null
			);
		}
		else {
			g.drawImage(
				animation.getImage(),
				(int)(x + xmap - width / 2 + width),
				(int)(y + ymap - height / 2),
				-width,
				height,
				null
			);
		}
	}
	

}