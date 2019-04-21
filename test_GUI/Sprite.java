import java.awt.image.BufferedImage;

public class Sprite
{
	protected int width, height;
	protected int[] pixels;
	// position
	// protected double x;
	// protected double y;
	
	// // bounds
	// protected int xmin;
	// protected int ymin;
	// protected int xmax;
	// protected int ymax;

	public Sprite(SpriteSheet sheet, int startX, int startY, int width, int height) 
	{
		this.width = width;
		this.height = height;

		pixels = new int[width*height];
		sheet.getImage().getRGB(startX, startY, width, height, pixels, 0, width);
	}

	public Sprite(BufferedImage image) 
	{
		width = image.getWidth();
		height = image.getHeight();

		pixels = new int[width*height];
		image.getRGB(0, 0, width, height, pixels, 0, width);
	}

	public Sprite() {}


	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public int[] getPixels()
	{
		return pixels;
	}
	// public void setPosition(double x, double y) {
		
	// 	this.x += (x - this.x) * tween;
	// 	this.y += (y - this.y) * tween;
		
	// 	fixBounds();
		
	// 	colOffset = (int)-this.x / tileSize;
	// 	rowOffset = (int)-this.y / tileSize;
		
	// }
	
	// private void fixBounds() {
	// 	if(x < xmin) x = xmin;
	// 	if(y < ymin) y = ymin;
	// 	if(x > xmax) x = xmax;
	// 	if(y > ymax) y = ymax;
	// }
}