import java.util.concurrent.ThreadLocalRandom;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

public class Bebek extends FarmAnimal implements LivingThings{
   char t_rumput ='*';
   char tempat ='o';
   char produk ='L';

    final int randX =1;
    final int randY =1;

    //private int Full;
    private int posX;
    private int posY;
    private int countTelurB;

    //Renderable c;

    public Bebek (int posX ,int posY,Renderable c){
       
        super(posX,posY);
       // c.setElement(posX,posY)
        //Cell c = new Cell();
        c.setElement(posX,posY,'B');
        this.countTelurB =0;
        this.posX = posX;
        this.posY = posY;
        //this.Full = FULLMAX;


    }
    public void move (Renderable c ){
        int x = ThreadLocalRandom.current().nextInt(-randX, randY + 1);
        int y =ThreadLocalRandom.current().nextInt(-randX, randY);
        //System.out.println("x : " + x);
        //System.out.println("y : " +y);
        
        if (this.posX+x>=0 && this.posX+x<15&& this.posY+y>=0 && this.posY +y <15 && hidup() && c.getElement(this.posX+x,this.posY+y)== ' '){
            if (c.getTypeLand(this.posX+x,this.posY+y)==tempat){
                c.setElement(posX,posY,' ');
                this.posX+=x;
                this.posY +=y;
                c.setElement(this.posX,this.posY,'B');
                setFull(getFull()-1);
                
            }
           // System.out.println(getFull());
            c.setElement(this.posX,this.posY,'B');
        } else {
            if(!hidup()){
                c.setElement(this.posX,this.posY,' ');
            }
            
        }
    }
    public void talk() {
        System.out.println("Qwekk qwekk");
    }
    public void eat(Renderable c){
        if (!hidup()){
                //setStatus(false);
                c.setElement(this.posX,this.posY,' ');
        } else {
            if(c.getRumput(this.posX,this.posY)==t_rumput){
                this.countTelurB = MAX;
                setFull(FULLMAX);
                c.kosongRumput(this.posX,this.posY);
            } else {
                move(c);
        }

        }        
        
    }
    public String getChar() {
        return "b";
    }

    public void getProduct() {
        this.countTelurB =0;
    }
    public Integer getCountProduct() {
        return countTelurB;
    }
    /*public Integer getFull() {
        return Full;
    }*/

    /*public void setFull(int Full){
        this.Full = Full;
    }*/
    public void print() {
        System.out.println("bebek " + countTelurB + " Full : "+ getFull()+"pos :  "+ posX +" "+ posY);
    }
}
