class test{
    public static void main(String[] args){
        Cell c = new Cell();
        Renderable p = new Renderable();
        Facility f = new Facility(p);
        p.render();
    }
}