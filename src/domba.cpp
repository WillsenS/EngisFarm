#include <iostream>
#include <string>
#include "FarmAnimal.h"

#include "Meatproducing.h"
#include "domba.h"

using namespace std;

const int a = 4;
const int b =4;
const int c = 10;
const int d =8;

domba::domba(int posX, int posY):FarmAnimal(posX, posY), Meatproducing(posX, posY) {
    Full = FULLMAX;
    countlambMeat = 0;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
}

domba::~domba() {
    this->posX = 0;
    this->posY = 0;
    Full = 0;
    countlambMeat = 0;
   // cout << "One of your lambs has died" << endl;
}

void domba::move(Cell&_c) {
    int xa = FarmAnimal::getPosX();
    int x = rand()%(a+b-1);
    int y = rand()%(a+b-1);
    _c.setElement(posX,posY,' ');
    //cout<<" x , y "<<x<< " " <<y<<endl;
    xa+=x;
    this->posY +=y;
    while(xa>a) {
         x = rand()%(a+b-1);
        //cout<<" x "<<x<<endl;
        while (this->posY>b) {
            this->posY -=x;
        }
        this->posX -=x;
        if (xa<a) {
            xa = xa + a;
        }
    }
    FarmAnimal::setPosX(xa);
    _c.setElement(posX,posY,'A');
    cout<<"pos MOVE : "<< this->posX<<" " << this->posY<<endl;
    
    Full--;
}

void domba::talk() {
    cout << "Mbekk~~" << endl;
}

void domba::eat(Cell& _c) {
    if (_c.getRumput(this->posX,this->posY)){
        Full = FULLMAX;
        countlambMeat++;
        if (countlambMeat >MAX) {
        countlambMeat = MAX;
        }
        _c.setElement(posX,posY,' ');
    }
}

string domba::getChar() {
    return "D";
}

string domba::getProduct() {
    return "";
}

//void setProduct(string lambMeat);
int domba::getcountlambMeat() const {
    return countlambMeat;
}

int domba::getFull() {
    return Full;
}

void domba::setFull(int Full) {
    this->Full=Full;
}

void domba::Print() {
    cout << "LM ada " << countlambMeat << endl;
    cout << "Full : " <<  Full << endl;
    cout << "pos : " <<  this->posX << " " << this->posY << endl;
}
