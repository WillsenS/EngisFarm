import java.awt.*;

import java.util.ArrayList;
public class GameStateManager {

    private ArrayList<GameState> gS;
    private int currentS;

    public static final int menu =0;
    public static final int playing =1;
    public static final int exit =2;

    public GameStateManager (){
        gS = new ArrayList<GameState>();
        currentS = menu;
        gS.add(new MenuState(this));
        gS.add(new PlayingState(this));
        //gS.add(new ExiState(this));
    }

    public void setState(int s){
        currentS = s;
        gS.get(currentS).init();
    }

    public void update(){
        gS.get(currentS).update();
    }

    public void draw (java.awt.Graphics2D g){
        gS.get(currentS).draw(g);
    }

    public void keyPressed (int k){
        gS.get(currentS).keyPressed(k);
    }

    public void keyReleased(int k){
        gS.get(currentS).keyReleased(k);
    }
}