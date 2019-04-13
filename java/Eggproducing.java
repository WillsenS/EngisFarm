public class Eggproducing  {
    private static int jlhEggP =0;

    public Eggproducing(int x,int y){
        //super(x,y);
        this.jlhEggP++;
    }
    public static Integer getjlhEggP(){
        return jlhEggP;
    }
}