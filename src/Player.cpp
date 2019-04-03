#include <iostream>
#include "Player.h"
#include "Facility.h"
#include "Cell.h"
#include "LinkedList.h"
using namespace std;

//Constructor
Player::Player(int x, int y) {
	posX = x;
	posY = y;
	water = 0;	
	money = 0;
}

void Player::Move(int x, int y) {
	posX = x;
	posY = y;
}

void Player::Talk() {
	cout<<"Player : Halo"<<endl
}

void Player::Interact() {
	int WellX = Facility::getWellx();
	int WellY = Facility::getWelly();
	int MixerX = Facility::getMixerx();
	int MixerY = Facility::getMixery();
	int TruckX = Facility::getTruckx();
	int TruckY = Facility::getTrucky();

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
			//remove semua item di inventory
			//harganya brp?
		}
	}

	//Interact dengan Mixer
	if((((posX + 1) == MixerX) || ((posX - 1) == MixerX)) && (((posY + 1) == MixerY) || ((posY - 1) == MixerY))) {
		//campur bahannya
		//masukin inventory
	}	

	//Interact dengan FarmAnimal
}

void Player::Kill() {
	//kill animalnya
	//dapeting dagingnya
}

void Player::Grow() {
	char typeland = Cell::getElement(PosX,PosY);
	if (water > 0) {
		if (typeland == '-') {
			Cell::setElemet(PosX,posY,'#');
			water--;
		}
		else if (typeland == 'o') {
			Cell::setElemet(PosX,posY,'*');
			water--;
		}
		else if (typeland == 'x') {
			Cell::setElemet(PosX,posY,'@');
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




