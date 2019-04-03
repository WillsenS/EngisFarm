#include <iostream>
#include "LinkedList.h"
#include "Player.h"
using namespace std;

//Constructor
Player::Player(int x, int y) {
	posX = x;
	posY = y;
	water = 0;	
	money = 0;
}

Player::~Player() {
	cout<<"THE END"<<endl;
}

void Player::Talk() {
	cout<<"Player : Halo"<<endl;
}

// void Player::Interact() {
// 	int WellX = Facility::getWellx();
// 	int WellY = Facility::getWelly();
// 	int MixerX = Facility::getMixerx();
// 	int MixerY = Facility::getMixery();
// 	int TruckX = Facility::getTruckx();
// 	int TruckY = Facility::getTrucky();

// 	//Interact dengan well
// 	if((((posX + 1) == WellX) || ((posX - 1) == WellX)) && (((posY + 1) == WellY) || ((posY - 1) == WellY))) {
// 		water = 10; //Anggap 1x isi bisa sirem sampe 10x
// 	}

// 	//Interact dengan Truck
// 	if((((posX + 1) == TruckX) || ((posX - 1) == TruckX)) && (((posY + 1) == TruckY) || ((posY - 1) == TruckY))) {
// 		if (LinkedList::isEmpty()) {
// 			//Do Nothing / pesan error
// 		}
// 		else {
// 			while !(LinkedList::isEmpty()) {
// 				money += SideProduct::getProductValue(LinkedList::get(0));
// 				LinkedList::remove(LinkedList::get(0));
// 			}
// 		}
// 	}

// 	//Interact dengan Mixer
// 	if((((posX + 1) == MixerX) || ((posX - 1) == MixerX)) && (((posY + 1) == MixerY) || ((posY - 1) == MixerY))) {
// 		//campur bahannya
// 		//masukin inventory
// 	}	

// 	//Interact dengan FarmAnimal
// 	{
// 		//ayam(A)
// 		if((Cell::getElement(posX+1,posY) == "A") || (Cell::getElement(posX-1,posY) == "A") || (Cell::getElement(posX,posY+1) == "A") || (Cell::getElement(posX,posY-1) == "A"))
// 			ChickenEgg::ChickenEgg();
// 			inventory.add(chicken::getProduct());
// 		//bebek(B)
// 		if((Cell::getElement(posX+1,posY) == "B") || (Cell::getElement(posX-1,posY) == "B") || (Cell::getElement(posX,posY+1) == "B") || (Cell::getElement(posX,posY-1) == "B"))
// 			DuckEgg::DuckEgg();
// 			inventory.add(bebek::getProduct());
// 		//kambing(K)
// 		if((Cell::getElement(posX+1,posY) == "K") || (Cell::getElement(posX-1,posY) == "K") || (Cell::getElement(posX,posY+1) == "K") || (Cell::getElement(posX,posY-1) == "K"))
// 			GoatMilk::GoatMilk();
// 			inventory.add(kambing::getProduct());
// 		//Sapi(S)
// 		if((Cell::getElement(posX+1,posY) == "S") || (Cell::getElement(posX-1,posY) == "S") || (Cell::getElement(posX,posY+1) == "S") || (Cell::getElement(posX,posY-1) == "S"))
// 			CowMilk::CowMilk();
// 			inventory.add(sapi::getProduct());
// 	}
// }

// void Player::Kill() {
// 	//kill animalnya
// 	//dapeting dagingnya
// 		//ayam(A)
// 		if((Cell::getElement(posX+1,posY) == "A") || (Cell::getElement(posX-1,posY) == "A") || (Cell::getElement(posX,posY+1) == "A") || (Cell::getElement(posX,posY-1) == "A"))
// 			ChickenMeat::ChickenMeat();
// 			inventory.add("ChickenMeat");
// 			ayam::~ayam();
// 		//bebek(B)
// 		if((Cell::getElement(posX+1,posY) == "B") || (Cell::getElement(posX-1,posY) == "B") || (Cell::getElement(posX,posY+1) == "B") || (Cell::getElement(posX,posY-1) == "B"))
// 			DuckMeat::DuckMeat();
// 			inventory.add("DuckMeat");
// 			bebek::~bebek();
// 		//babi(b)
// 		if((Cell::getElement(posX+1,posY) == "b") || (Cell::getElement(posX-1,posY) == "b") || (Cell::getElement(posX,posY+1) == "b") || (Cell::getElement(posX,posY-1) == "b"))
// 			Pork::Pork();
// 			inventory.add("Pork");
// 			babi::~babi();
// 		//domba(D)
// 		if((Cell::getElement(posX+1,posY) == "D") || (Cell::getElement(posX-1,posY) == "D") || (Cell::getElement(posX,posY+1) == "D") || (Cell::getElement(posX,posY-1) == "D"))
// 			LambMeat::LambMeat();
// 			inventory.add("LambMeat");
// 			domba::~domba();
// 		//kambing(K)
// 		if((Cell::getElement(posX+1,posY) == "K") || (Cell::getElement(posX-1,posY) == "K") || (Cell::getElement(posX,posY+1) == "K") || (Cell::getElement(posX,posY-1) == "K"))
// 			GoatMeat::GoatMeat();
// 			inventory.add("GoatMeat");
// 			kambing::~kambing();
// 		//Sapi(S)
// 		if((Cell::getElement(posX+1,posY) == "S") || (Cell::getElement(posX-1,posY) == "S") || (Cell::getElement(posX,posY+1) == "S") || (Cell::getElement(posX,posY-1) == "S"))
// 			CowMeat::CowMeat();
// 			inventory.add("CowMeat");
// 			sapi::~sapi();
// }

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
}
