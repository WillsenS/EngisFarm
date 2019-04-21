
import java.awt.image.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.*;
public class FarmMap {

    //position
    private double x;
    private double y;
    //bound
    private double xmin;
    private double xmax;
    private double ymin;
    private double ymax;

    //map
    private int[][] map;
    private int grassSize;
    private int row;
    private int col;
    private int width;
    private int height;

    // grass Set
    private BufferedImage grass;
    private int numGrass;
    private Grass[][] grasses;

    //drawing
    private int startRow;
    private int startCol;
    private int numRowDraw;
    private int numColDraw;

    public FarmMap(int grassSize){
        //System.out.println("constructor ");
        //System.out.println(grassSize);
        this.grassSize = grassSize;
        numRowDraw = GamePanel.h/grassSize+2;
        numColDraw = GamePanel.w/grassSize+2;

    }

    public void loadGrass(String s){
        try {
            grass = ImageIO.read(getClass().getResourceAsStream(s));
            System.out.println(grass.getWidth());
            numGrass = grass.getWidth()/grassSize;
            grasses = new Grass[2][numGrass];
            System.out.println(numGrass);
            BufferedImage subgrass;
            for(int col =0;col<numGrass;col++){
                subgrass = grass.getSubimage(col*grassSize,0,grassSize,grassSize);
                grasses[0][col] = new Grass(subgrass,Grass.GRASS);
                subgrass = grass.getSubimage(col*grassSize,grassSize,grassSize,grassSize);
                grasses[1][col] = new Grass(subgrass,Grass.NOGRASS);
                System.out.println(col);
            }
            System.out.println("success load grass");

        } catch (Exception e){
            System.out.println("failed load grass");
            e.printStackTrace();
        }
    }
	public void loadMap(String s) {
		
		try {
			
			InputStream in = getClass().getResourceAsStream(s);
			BufferedReader br = new BufferedReader(
						new InputStreamReader(in)
					);
			
			col = Integer.parseInt(br.readLine());
			row = Integer.parseInt(br.readLine());
            System.out.println(col + " " + row);
			map = new int[row][col];
			width = col * grassSize;
			height = row * grassSize;
			
			xmin = GamePanel.w - width;
			xmax = 0;
			ymin = GamePanel.h - height;
			ymax = 0;
			
			String delims = "\\s+";
			for(int ro = 0; ro < row; ro++) {
                System.out.println("read file");
				String line = br.readLine();
				String[] tokens = line.split(delims);
				for(int co = 0; co < col; co++) {
					map[ro][co] = Integer.parseInt(tokens[co]);
				}
			}
            System.out.println("syccess load Map");
			
		}
		catch(Exception e) {
            System.out.println("failed load map");
			e.printStackTrace();
		}
		
	}

    public int getGrassSize(){
        return grassSize;
    }
    public int getX(){
        return (int)x;
    }
    public int getY(){
        return(int)y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getType(int row,int col){
        int rc = map[row][col];
        int r = rc/numGrass;
        int c = rc%numGrass;
        return grasses[r][c].getType();
    }

    public void setPosition(double x ,double y){
        this.x+= (x-this.x)*0.07;
        this.y+= (y-this.y)*0.07;  

        fixBounds();  
        startCol =(int) -this.x /grassSize;
        startRow = (int) - this.y/grassSize;
    }

    private void fixBounds(){
        if(x<xmin) x= xmin;
        if(x>xmax) x = xmax;
        if(y<ymin) y = ymin;
        if(y>ymax) y = ymax;
    }

	public void draw(Graphics2D g) {
		
		for(
			int ro = startRow;
			ro < startRow + numRowDraw;
			ro++) {
			
			if(ro >= row) break;
			
			for(
				int co = startCol;
				co < startCol + numColDraw;
				co++) {
				
				if(co >= col) break;
				
				if(map[ro][co] == 0) continue;
				
				int rc = map[ro][co];
				int r = rc / numGrass;
				int c = rc % numGrass;
				
				g.drawImage(
					grasses[r][c].getImage(),
					(int)x + co * grassSize,
					(int)y + ro * grassSize,
					null
				);
				
			}
			
		}
    }
		
	
}