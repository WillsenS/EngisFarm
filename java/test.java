class test{
    public static void main(String[] args){
    Cell c = new Cell();
	Renderable p = new Renderable();
	Facility f = new Facility(p);
	Ayam a = new Ayam(1,3,p);
	Babi b = new Babi(8,9,p);
	Kambing k = new Kambing(2,3,p);
	Bebek d = new Bebek(6,7,p);
	Sapi w = new Sapi(4,5,p);
	Domba r = new Domba(12,3,p);
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
