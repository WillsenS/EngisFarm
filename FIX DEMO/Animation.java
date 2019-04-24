import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.Timer;

public class Animation{
    private BufferedImage[] frames;
    private int currentFrame;

    private long start;
    private long delay;

    private boolean playedOnce;
    int[][] arr = new int[12][8];

    public Animation(){
        playedOnce =false;
    }

    public void setFrames(BufferedImage[] frames){
        this.frames = frames;
        currentFrame=0;
        start = System.nanoTime();
        playedOnce=false;
    }

    public void setDelay(long d){delay =d;}
    public void setFrame(int i){currentFrame =i;}
	public void update() {
		
		if(delay == -1) return;
		
		long elapsed = (System.nanoTime() - start) / 1000000;
		if(elapsed > delay) {
			currentFrame++;
			start = System.nanoTime();
		}
		if(currentFrame == frames.length) {
			currentFrame = 0;
			playedOnce = true;
        }
	}
	
	public int getFrame() { return currentFrame; }
	public BufferedImage getImage() { return frames[currentFrame]; }
    public boolean hasPlayedOnce() { return playedOnce; }

    public void gg(int x, int y, int p){
        String fileName = "level1-1.map";
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line1 = bufferedReader.readLine();
            String line2 = bufferedReader.readLine();

            for(int z=0; z<8; z++) {
                String line = bufferedReader.readLine();
                String[] parseline = line.split("\\s+");
                for(int r=0; r<12; r++){
                    arr[r][z] = Integer.parseInt(parseline[r]);
                }
            }
            // Always close files.
            bufferedReader.close();         
            fileReader.close();  
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }

        arr[x][y] = p;

        try {
            PrintWriter wwriter = new PrintWriter(fileName);
            wwriter.print("");
            wwriter.close();


            FileWriter writer = new FileWriter("level1-1.map", true);
            writer.write("12"); writer.write("\r\n");   // write new line
            writer.write("8"); writer.write("\r\n");
            for(int k=0; k<7; k++){
                for(int j=0; j<11; j++){
                    writer.write(String.valueOf(arr[j][k])); writer.write(" ");
                }
                writer.write(String.valueOf(arr[11][k])); writer.write("\r\n");
            }
            
            for(int j=0; j<11; j++){
                writer.write(String.valueOf(arr[j][7])); writer.write(" ");
            }
            writer.write(String.valueOf(arr[11][7])); writer.write("\r\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(){
        String fileName = "level1-1.map";

        try {
            PrintWriter wwriter = new PrintWriter(fileName);
            wwriter.print("");
            wwriter.close();


            FileWriter writer = new FileWriter("level1-1.map", true);
            writer.write("12"); writer.write("\r\n");   // write new line
            writer.write("8"); writer.write("\r\n");
            for(int k=0; k<7; k++){
                for(int j=0; j<11; j++){
                    writer.write("0"); writer.write(" ");
                }
                writer.write("0"); writer.write("\r\n");
            }
            
            for(int j=0; j<11; j++){
                writer.write("0"); writer.write(" ");
            }
            writer.write("0"); writer.write("\r\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public int getArr(int x, int y){
        return arr[x][y]; 
    }
}