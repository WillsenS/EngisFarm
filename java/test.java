class test{
    public static void main(String[] args){
    Cell c = new Cell();
	Renderable p = new Renderable();
	Facility f = new Facility(p);
	ayam a = new ayam(1,3,p);
	babi b = new babi(8,9,p);
	kambing k = new kambing(2,3,p);
	bebek d = new bebek(6,7,p);
	sapi w = new sapi(4,5,p);
	domba r = new domba(12,3,p);
	p.render();
	//p.setElement(1,3,'A');
	a.Print();
	a.move(p);
	a.Print();
	//p.render();
	//a.Print();
	//a.talk();
	a.eat(p);
	a.Print();
	a.move(p);
	a.Print();
	//p.render();
	a.move(p);
	a.eat(p);
	a.eat(p);
	a.Print();
	a.move(p);
	a.Print();
	a.move(p);
	a.Print();
	a.move(p);
	a.Print();
	a.move(p);
	a.Print();
	//a.eat(p);
	System.out.println(a.getStatus());
	a.move(p);
	a.Print();
	p.render();
    }
}
