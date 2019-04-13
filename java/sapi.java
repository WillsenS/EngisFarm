import java.util.concurrent.ThreadLocalRandom;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

public class sapi extends FarmAnimal implements LivingThings{
   char t_rumput ='#';
   char tempat ='-';
   char produk ='U';

    final int randX =1;
    final int randY =1;

    //private int Full;
    private int posX;
    private int posY;
    private int countcowMilk;

    //Renderable c;

    public sapi (int posX ,int posY,Renderable c){
       
        super(posX,posY);
       // c.setElement(posX,posY)
        //Cell c = new Cell();
        c.setElement(posX,posY,'S');
        this.countcowMilk =0;
        this.posX = posX;
        this.posY = posY;
        //this.Full = FULLMAX;


    }
    public void move (Renderable c ){
        int x = ThreadLocalRandom.current().nextInt(-randX, randY + 1);
        int y =ThreadLocalRandom.current().nextInt(-randX, randY);
        //System.out.println("x : " + x);
        //System.out.println("y : " +y);
        
        if (this.posX+x>=0 && this.posY+y>=0 && this.posY +y <15 && hidup() && c.getElement(this.posX+x,this.posY+y)== ' '){
            
            if (c.getTypeLand(this.posX+x,this.posY+y)==tempat){
                c.setElement(posX,posY,' ');
                this.posX+=x;
                this.posY +=y;
                c.setElement(this.posX,this.posY,'S');
                setFull(getFull()-1);
                
            } 
            
            //System.out.println(getFull());
            //c.setElement(this.posX,this.posY,'S');
        } else {
            if (!hidup()){
                c.setElement(this.posX,this.posY,' ');
            }
            
        }
    }
    public void talk(){
        System.out.println("MOO MOO");
    }
    public void eat(Renderable c){
        if (!hidup()){
                //setStatus(false);
                c.setElement(this.posX,this.posY,' ');
        } else {
            if(c.getRumput(this.posX,this.posY)==t_rumput){
                this.countcowMilk =MAX;
                setFull(FULLMAX);
                c.kosongRumput(this.posX,this.posY);
         } else move(c);
        
        }
       
    }
    public String getChar(){
        return "S";
    }

    public void getProduct(){
        this.countcowMilk =0;
    }
    public Integer getCountProduct(){
        return countcowMilk;
    }
    /*public Integer getFull(){
        return Full;
    }*/

    /*public void setFull(int Full){
        this.Full = Full;
    }*/
    public void Print(){
        System.out.println("sapi " + countcowMilk + " Full : "+ getFull()+"pos :  "+ posX +" "+ posY);
    }
}
