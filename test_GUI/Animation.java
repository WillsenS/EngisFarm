import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.Timer;

/**
 * Animation Class.
 */
public class Animation {
    /** Animation's frames buffer. */
    private BufferedImage[] frames;
    /** Animetion's current frame. */
    private int currentFrame;
    /** Start time */
    private long start;
    /** Update delay. */
    private long delay;

    private boolean playedOnce;
    int[][] arr = new int[12][8];

    /**
     * Ctor
     */
    public Animation(){
        playedOnce =false;
    }

    /**
     * Set buffered frames.
     * @param frames Buffered frames.
     */
    public void setFrames(BufferedImage[] frames){
        this.frames = frames;
        currentFrame=0;
        start = System.nanoTime();
        playedOnce=false;
    }

    /**
     * Set delay.
     * @param d Delay input.
     */
    public void setDelay(long d){delay =d;}

    /**
     * Set current frame.
     * @param i frames index.
     */
    public void setFrame(int i){currentFrame =i;}

    /**
     * Updates animation frame.
     */
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

    /**
     * Get current frame index.
     * @return Frame index.
     */
    public int getFrame() { return currentFrame; }

    /**
     * Return current frame.
     * @return Current frame.
     */
    public BufferedImage getImage() { return frames[currentFrame]; }

    /**
     * Check whether framse has played once.
     * @return True if 
     */
    public boolean hasPlayedOnce() { return playedOnce; }

    /**
     * Grow grass according to external file.
     * @param x
     * @param y
     * @param p
     */
    public void growGrass(int x, int y, int p){
        String fileName = "level1-1.map";

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

    /**
     * Clean on exit
     */
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
}