#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Eggproducing.h"
#include "Meatproducing.h"
#include "ayam.h"

using namespace std;
const int a = 4;
const int b = 4;
const int c = 4;
const int d = 4;

ayam::ayam(int posX, int posY):FarmAnimal(posX, posY), Eggproducing(posX, posY), Meatproducing(posX, posY) {
    Full = FULLMAX;
    countTelurA = 0;
    //cout<<"Full : "<< Full<<endl;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
}

ayam::~ayam() {
    this->posX =0;
    this->posY =0;
    Full =0;
    countTelurA=0;
   // cout<<"One of your chickens has died"<<endl;
}

void ayam::move() {
    int x = rand()%(a+b-1);
    int y = rand()%(a+b-1);
    //cout<<" x , y "<<x<< " " <<y<<endl;
    this->posX+=x;
    this->posY +=y;
    while(this->posX>a) {
         x = rand()%(a+b-1);
        //cout<<" x "<<x<<endl;
        while (this->posY>b) {
            this->posY -=x;
        }
        this->posX -=x;
        if (this->posX <a) {
            this->posX = this->posX + a;
        }
    }
    
    Full--;
}

void ayam::talk() {
    cout<<"Petok petokkk"<<endl;
}

void ayam::eat() {
    countTelurA++;
    if (countTelurA > MAX)  {
	countTelurA = MAX;
    }
    Full =FULLMAX;
    
}

string ayam::getChar() {
    return "A";
}

string ayam::getProduct() {
    return "";
}

int ayam::getcountTelurA()const {
    return countTelurA;
}

int ayam::getFull() {
    return Full;
}

void ayam::setFull(int Full) {
    this->Full = Full;
}

void ayam::Print() {
    cout<<"Telur ada " <<countTelurA<<endl;
    cout<<"Full : "<< Full<<endl;
    cout<<"pos : "<< this->posX<<" " << this->posY<<endl;
}
    //cout<<"pos : "<< FarmAnimal::getPosX()<<" " << FarmAnimal::getPosY()<<endl;

/*void ayam::setPosX(int x) {
    posX = x;
}
void ayam::setPosY(int y) {
    posY = y;
}
int ayam ::getPosX() {
    return posX;
}
int ayam ::getPosY() {
    return posY;
}*/

        
       
