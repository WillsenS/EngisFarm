import java.util.concurrent.ThreadLocalRandom;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

public class Babi extends FarmAnimal implements LivingThings{
   char t_rumput ='@';
   char tempat ='x';

    final int randX = 1;
    final int randY = 1;

    //private int Full;
    private int posX;
    private int posY;
    private int countPork;

    //Renderable c;

    public Babi (int posX ,int posY,Renderable c){
       
        super(posX,posY);
       // c.setElement(posX,posY)
        //Cell c = new Cell();
        c.setElement(posX,posY,'Z');
        this.countPork =0;
        this.posX = posX;
        this.posY = posY;
        //this.Full = FULLMAX;


    }
    public void move (Renderable c ){
        int x = ThreadLocalRandom.current().nextInt(-randX, randY + 1);
        int y =ThreadLocalRandom.current().nextInt(-randX, randY);

        if (this.posX+x>=0 && this.posX+x<15&& this.posY+y>=0 && this.posY +y <15 && hidup() && c.getElement(this.posX+x,this.posY+y)== ' '){
            if (c.getTypeLand(this.posX+x,this.posY+y)==tempat && hidup()){
                c.setElement(posX,posY,' ');
                this.posX+=x;
                this.posY +=y;
                c.setElement(this.posX,this.posY,'Z');
                setFull(getFull()-1);
            } 
        } else {
            if(!hidup()) {
                c.setElement(this.posX,this.posY,' ');
        }
    }
    }
    public void talk() {
        System.out.println("Nguikk nguikk");
    }
    public void eat(Renderable c){
        if (!hidup()){
                //setStatus(false);
                c.setElement(this.posX,this.posY,' ');
        } else {
                if(c.getRumput(this.posX,this.posY)==t_rumput){
                this.countPork= MAX;
                setFull(FULLMAX);
                c.kosongRumput(this.posX,this.posY);
            } else {
                move(c);
            }

        }        

    }
    public String getChar() {
        return "Z";
    }

    public void getProduct() {
        this.countPork = 0;
    }
    public Integer getCountProduct() {
        return countPork;
    }
    /*public Integer getFull() {
        return Full;
    }*/

    /*public void setFull(int Full){
        this.Full = Full;
    }*/
    public void print() {
        System.out.println("babi " + countPork + " Full : "+ getFull()+"pos :  "+ posX +" "+ posY);
    }
}
