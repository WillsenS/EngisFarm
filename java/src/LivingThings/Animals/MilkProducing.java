public class MilkProducing {
    private static int jlhMilkP =0;

    public MilkProducing(int x,int y){
        //super(x,y);
        MilkProducing.jlhMilkP++;
    }
    public static Integer getjlhMilkP() {
        return jlhMilkP;
    }
}