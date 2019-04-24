import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class PlayingState extends GameState{
    private FarmMap map;
    private Player player;

    private Stuff stuff;
    private TalkText talkText;

    private ArrayList<Farm_Animal> farmAnimal;

    public PlayingState (GameStateManager gsm) {
        this.gsm = gsm;
        init();
    }

    public void init() {
        map = new FarmMap(30);
        map.loadGrass("Grass.jpg");
        map.loadMap("level1-1.map");
        map.setPosition(0,0);

        //player
        player = new Player (map);
        player.setPosition(100,100);

        // initialize animals
        farmAnimal = new ArrayList<Farm_Animal>();
        Ayam a;
        a = new Ayam(map);
        a.setPosition(110,110);
        farmAnimal.add(a);

        Sapi s;
        s = new Sapi(map);
        s.setPosition(90,20);
        farmAnimal.add(s);
    
        Babi b;
        b = new Babi(map);
        b.setPosition(70,90);
        farmAnimal.add(b);

        Bebek d;
        d = new Bebek(map);
        d.setPosition(100,90);
        farmAnimal.add(d);

        Domba sh;
        sh = new Domba(map);
        sh.setPosition(120,70);
        farmAnimal.add(sh);
    
        Kambing k;
        k = new Kambing(map);
        k.setPosition(110,90);
        farmAnimal.add(k);

        stuff = new Stuff(player);
        talkText = new TalkText();
    }

    public  void update() {

        map.loadGrass("Grass.jpg");
        map.loadMap("level1-1.map");

        player.update(farmAnimal);
        
        // check killing 
        player.checkKill(farmAnimal);
        player.checkMix();
        player.checkSell();
        player.fillCan();
        player.checkgrow();
        player.exit();

        for(int i=0;i<farmAnimal.size();i++) {
            farmAnimal.get(i).update();
            if(farmAnimal.get(i).isDead()) {
                farmAnimal.remove(i);
                i--;
            }

        }

        if(farmAnimal.size()==0) {
            System.exit(0);
        }
    }

    public  void draw(Graphics2D g) {
        int R = 200;
        int G = 128;
        int B = 100;
        Color randomColor = new Color(R, G, B);
        g.setColor(randomColor);
        g.fillRect(0,0,GamePanel.w,GamePanel.h);
        map.draw(g);
        player.draw(g);
        for(int i=0;i<farmAnimal.size();i++){
            Farm_Animal animal = farmAnimal.get(i);
            animal.draw(g);
            if(animal.isTalk()) {
                talkText.draw(g, farmAnimal.get(i));
                TimerTask timerTask = new TimerTask() {

                    @Override
                    public void run() {
                        System.out.println("TimerTask executing counter is: ");
                        animal.setIsTalk(false);
                    }
                };

                Timer timer = new Timer("MyTimer");

                timer.schedule(timerTask, 1000);
            }
        }

        //draw stuff
        stuff.draw(g);
    }

    public  void keyPressed(int k) {
        if(k == KeyEvent.VK_LEFT) player.setLeft(true);
        if(k == KeyEvent.VK_RIGHT) player.setRight(true);
        if(k == KeyEvent.VK_UP) player.setUp(true);
        if(k == KeyEvent.VK_DOWN) player.setDown(true);
        if(k == KeyEvent.VK_K) player.setKill(true);
        if(k == KeyEvent.VK_I) player.setInteract(true);
        if(k == KeyEvent.VK_M) player.setMix(true);
        if(k == KeyEvent.VK_T) player.setTalk(true);
        if(k == KeyEvent.VK_S) player.setSell(true);
        if(k == KeyEvent.VK_C) player.setfillCan(true);
        if(k == KeyEvent.VK_G) player.setGrow(true);
        if(k == KeyEvent.VK_ESCAPE) player.setExit(true);
    }

    public  void keyReleased(int k) {
        if(k == KeyEvent.VK_LEFT) player.setLeft(false);
        if(k == KeyEvent.VK_RIGHT) player.setRight(false);
        if(k == KeyEvent.VK_UP) player.setUp(false);
        if(k == KeyEvent.VK_DOWN) player.setDown(false);
        if(k == KeyEvent.VK_K) player.setKill(false);
        if(k == KeyEvent.VK_I) player.setInteract(false);
        if(k == KeyEvent.VK_M) player.setMix(false);
        if(k == KeyEvent.VK_T) player.setTalk(false);
        if(k == KeyEvent.VK_S) player.setSell(false);
        if(k == KeyEvent.VK_C) player.setfillCan(false);
        if(k == KeyEvent.VK_G) player.setGrow(false);
        if(k == KeyEvent.VK_ESCAPE) player.setExit(false); 
    }
}