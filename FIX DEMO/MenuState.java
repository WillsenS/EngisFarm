import java.awt.*;
import java.awt.event.KeyEvent;
public class MenuState extends GameState{
    private Background bg;
    private int currentChoice =0;
    private String[] options ={
        "Play",
        "Quit"
    };

    private Color titleC;
    private Font titleF;

    private Font font;

    public MenuState(GameStateManager gsm){
        this.gsm = gsm;

        try {
            bg = new Background("Farm.jpg",0.5);
            bg.setVector(-0.1,0);

            titleC = new Color(128,0,0);
            titleF = new Font(
                "Century Gothic",
                Font.PLAIN,
                28);
            font = new Font("Arial",Font.PLAIN,12);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void init(){

    }
    public void update(){
        
        bg.update();
    }
    public void draw (Graphics2D g){
        bg.draw(g);

        g.setColor(titleC);
        g.setFont(titleF);
        g.drawString("Engi's Farm",80,70);

        //menu
        g.setFont(font);
        for(int i =0; i<options.length;i++){
            if ( i ==currentChoice){
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.RED);
            }

            g.drawString(options[i],145,140+i*15);
        }

    }
    private void select() {
        if(currentChoice == 0) {     
            gsm.setState(GameStateManager.playing);
        }
        if(currentChoice == 1) {
            System.exit(0);
        }
    }
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP) {
            currentChoice--;
            if(currentChoice == -1) {
                currentChoice = options.length - 1;
            }
        }
        if(k == KeyEvent.VK_DOWN) {
            currentChoice++;
            if(currentChoice == options.length) {
                currentChoice = 0;
            }
        }
    }
    public void keyReleased(int k){}
}