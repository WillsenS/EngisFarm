public class MeatProducing {
    private static int jlhMeatP =0;

    public MeatProducing(int x,int y){
        //super(x,y);
        MeatProducing.jlhMeatP++;
    }
    public static Integer getjlhMeatP() {
        return jlhMeatP;
    }
}