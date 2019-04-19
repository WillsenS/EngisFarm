public abstract class FarmAnimal{
    private static int countAnimal;
    private int posX;
    private int posY;
    //Renderable p;

    private int Full;
    protected boolean status;
    protected int id;

    protected final int MAX =1;
    protected final int FULLMAX =5;
    protected final int dead =0;

    public FarmAnimal(int x, int y){

        this.posX = x;
        this.posY=y;
        //p.setElement(x,y);
        FarmAnimal.countAnimal++;
        this.status = true;
        this.id = FarmAnimal.countAnimal;
        this.Full =FULLMAX;
    }

    public static Integer getCountAnimal(){
        return countAnimal;
    }
    public Integer getPosX(){
        return this.posX;
    }
    public Integer getPosY(){
        return this.posY;
    }
    public void setPosX(int x){
        this.posX = x;
    }
    public void setPosY(int y){
        this.posY =y;
    }
    public boolean getStatus(){
        return this.status;
    }
    public void setStatus(boolean cek){
        this.status = cek;
    }
    public Integer getID(){
        return this.id;
    }
    public Integer getFull(){
        return this.Full;
    }
    public void setFull(int f){
        this.Full = f;
    }
    public boolean hidup(){
         if (this.Full<=dead){
             setStatus(false);
             return false;
         } 
         else return true;
                
    }
        // dtor
    abstract void eat(Renderable c);
    abstract String getChar();
    abstract void getProduct();
    abstract Integer getCountProduct();
    abstract void Print();
    //abstract void setFull(int Full);
    abstract void move(Renderable c);
    

}