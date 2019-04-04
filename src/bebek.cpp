#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Eggproducing.h"
#include "Meatproducing.h"
#include "bebek.h"

using namespace std;

const int a = 4;
const int b = 4;
const int c = 4;
const int d = 4;

bebek :: bebek(int posX, int posY): FarmAnimal(posX, posY), Eggproducing(posX, posY), Meatproducing(posX, posY) {
    Full = FULLMAX;
    countTelurB =0;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
}

bebek:: ~bebek() {
    this->posX = 0;
    this->posY = 0;
    Full = 0;
    countTelurB= 0;
    //cout<<"One of your duck has died"<<endl;
    //FarmAnimal::~FarmAnimal();
}

void bebek::move(Cell&_c) {
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

void bebek::talk() {
    cout << "Qwek ... qwek" << endl;

}

void bebek::eat(Cell& _c) {
    if (_c.getRumput(this->posX,this->posY)){
        countTelurB++;
        Full = FULLMAX;
        if (countTelurB > MAX)  {
        countTelurB = MAX;
        }
        _c.setElement(posX,posY,' ');
    }
}

string bebek::getChar() {
    return "b";
}

string bebek::getProduct() {
    return "";
}

//void setProduct(string telur);
int bebek::getcountTelurB()const {
    return countTelurB;
}

int bebek::getFull() {
    return Full;
}

void bebek::setFull(int Full) {
    this->Full = Full;
}

void bebek::Print() {
    cout << "Telur b ada " << countTelurB<< endl;
    cout << "Full : " <<  Full << endl;
    cout << "pos : " <<  this->posX << " " <<  this->posY << endl;
}

/*void bebek::setPosX(int x) {
    posX = x;
}

void bebek::setPosY(int y) {
    posX = x;
}

int bebek ::getPosX() {
    return posX;
}

int bebek ::getPosY() {
    return posY;
}
*/
