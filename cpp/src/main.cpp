#include <iostream>
#include <string>
#include "Player.h"
#include "Facility.h"
#include "Cell.h"
#include "LinkedList.h"
//#include "LivingThings.h"
#include "Eggproducing.h"
#include "Milkproducing.h"
#include "Meatproducing.h"
#include "FarmAnimal.h"
#include "sapi.h"
#include "ayam.h"
#include "bebek.h"
#include "domba.h"
#include "babi.h"
#include "kambing.h"
#include "GoatMilk.h"
#include "GoatMeat.h"
#include "Pork.h"
#include "ChickenEgg.h"
#include "ChickenMeat.h"
#include "DuckEgg.h"
#include "DuckMeat.h"
#include "LambMeat.h"
#include "CowMilk.h"
#include "CowMeat.h"

using namespace std;

// int main(){
    // Player p (2,3);
    // Facility f();
    // // hewan
    // ayam a(1,5);
    // //ayam a1(1,1);
    // kambing k(4,5);
    // babi b (9,12);
    // sapi s (4,8);
    // domba d (12,7);
    // bebek r (2,8);
    // r.move();
    
    // cout<<"Pos X ayam : "<<a.getPosX()<<endl;
    // a.move();
    // //a1.move();
    // a.Print();
    // cout<<"Pos X ayam move : "<<a.getPosX()<<endl;

    // a.eat();
    // p.move(4,5);
    // p.talk();
    
    // //p.Kill();
    // a.Print();
// }
//Constructor


/*void Player::talk() {
	cout<<"Player : Halo"<<endl;
    cout<<"Pos Player : "<<x<< " "<< y<<endl;
}*/

/*void Player::Interact() {
	int WellX = f.getWellX();
	int WellY = f.getWellY();
	int MixerX = f::getMixerX();
	int MixerY = f::getMixerY();
	int TruckX = f::getTruckX();
	int TruckY = f::getTruckY();

	//Interact dengan well
	if((((posX + 1) == WellX) || ((posX - 1) == WellX)) && (((posY + 1) == WellY) || ((posY - 1) == WellY))) {
		water = 10; //Anggap 1x isi bisa sirem sampe 10x
	}

	//Interact dengan Truck
	if((((posX + 1) == TruckX) || ((posX - 1) == TruckX)) && (((posY + 1) == TruckY) || ((posY - 1) == TruckY))) {
		if (LinkedList::isEmpty()) {
			//Do Nothing / pesan error
		}
		else {
			while !(LinkedList::isEmpty()) {
				money += SideProduct::getProductValue(LinkedList::get(0));
				LinkedList::remove(LinkedList::get(0));
			}
		}
	}

	//Interact dengan Mixer
	if((((posX + 1) == MixerX) || ((posX - 1) == MixerX)) && (((posY + 1) == MixerY) || ((posY - 1) == MixerY))) {
		//campur bahannya
		//masukin inventory
	}	

	//Interact dengan FarmAnimal
	{
		//ayam(A)
		if((Cell::getElement(posX+1,posY) == "A") || (Cell::getElement(posX-1,posY) == "A") || (Cell::getElement(posX,posY+1) == "A") || (Cell::getElement(posX,posY-1) == "A"))
			ChickenEgg::ChickenEgg();
			LinkedList::add(chicken::getProduct());
		//bebek(B)
		if((Cell::getElement(posX+1,posY) == "B") || (Cell::getElement(posX-1,posY) == "B") || (Cell::getElement(posX,posY+1) == "B") || (Cell::getElement(posX,posY-1) == "B"))
			DuckEgg::DuckEgg();
			LinkedList::add(bebek::getProduct());
		//kambing(K)
		if((Cell::getElement(posX+1,posY) == "K") || (Cell::getElement(posX-1,posY) == "K") || (Cell::getElement(posX,posY+1) == "K") || (Cell::getElement(posX,posY-1) == "K"))
			GoatMilk::GoatMilk();
			LinkedList::add(kambing::getProduct());
		//Sapi(S)
		if((Cell::getElement(posX+1,posY) == "S") || (Cell::getElement(posX-1,posY) == "S") || (Cell::getElement(posX,posY+1) == "S") || (Cell::getElement(posX,posY-1) == "S"))
			CowMilk::CowMilk();
			LinkedList::add(sapi::getProduct());
	}
}

void Player::Kill() {
	//kill animalnya
	//dapeting dagingnya
		//ayam(A)
		if((Cell::getElement(posX+1,posY) == "A") || (Cell::getElement(posX-1,posY) == "A") || (Cell::getElement(posX,posY+1) == "A") || (Cell::getElement(posX,posY-1) == "A"))
			ChickenMeat::ChickenMeat();
			LinkedList::add("ChickenMeat");
			ayam::~ayam();
		//bebek(B)
		if((Cell::getElement(posX+1,posY) == "B") || (Cell::getElement(posX-1,posY) == "B") || (Cell::getElement(posX,posY+1) == "B") || (Cell::getElement(posX,posY-1) == "B"))
			DuckMeat::DuckMeat();
			LinkedList::add("DuckMeat");
			bebek::~bebek();
		//babi(b)
		if((Cell::getElement(posX+1,posY) == "b") || (Cell::getElement(posX-1,posY) == "b") || (Cell::getElement(posX,posY+1) == "b") || (Cell::getElement(posX,posY-1) == "b"))
			Pork::Pork();
			LinkedList::add("Pork");
			babi::~babi();
		//domba(D)
		if((Cell::getElement(posX+1,posY) == "D") || (Cell::getElement(posX-1,posY) == "D") || (Cell::getElement(posX,posY+1) == "D") || (Cell::getElement(posX,posY-1) == "D"))
			LambMeat::LambMeat();
			LinkedList::add("LambMeat");
			domba::~domba();
		//kambing(K)
		if((Cell::getElement(posX+1,posY) == "K") || (Cell::getElement(posX-1,posY) == "K") || (Cell::getElement(posX,posY+1) == "K") || (Cell::getElement(posX,posY-1) == "K"))
			GoatMeat::GoatMeat();
			LinkedList::add("GoatMeat");
			kambing::~kambing();
		//Sapi(S)
		if((Cell::getElement(posX+1,posY) == "S") || (Cell::getElement(posX-1,posY) == "S") || (Cell::getElement(posX,posY+1) == "S") || (Cell::getElement(posX,posY-1) == "S"))
			CowMeat::CowMeat();
			LinkedList::add("CowMeat");
			sapi::~sapi();
}

void Player::Grow() {
	char typeland = Cell::getElement(posX,posY);
	if (water > 0) {
		if (typeland == '-') {
			Cell::setElement(posX,posY,'#');
			water--;
		}
		else if (typeland == 'o') {
			Cell::setElement(posX,posY,'*');
			water--;
		}
		else if (typeland == 'x') {
			Cell::setElement(posX,posY,'@');
			water--;
		}
		else {
		//udah ada rumput, jadi do nothing/pesen error
		}
	}
	else {
	//gaada air, sana pergi ke well
	}
}*/
