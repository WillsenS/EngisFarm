#include <iostream>
#include <string>
#include "stdlib.h"
#include "FarmAnimal.h"
#include "Eggproducing.h"
#include "Meatproducing.h"
#include "ayam.h"


using namespace std;
const int a = 0;
const int b = 0;
const int c = 5;
const int d = 5;

ayam::ayam(int posX, int posY, Cell& _c):FarmAnimal(posX, posY), Eggproducing(posX, posY), Meatproducing(posX, posY) {
    Full = FULLMAX;
    countTelurA = 0;
    //cout<<"Full : "<< Full<<endl;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
    _c.setElement(posX,posY,'A') ;

}

ayam::~ayam() {
    this->posX =0;
    this->posY =0;
    Full =0;
    countTelurA=0;
   // cout<<"One of your chickens has died"<<endl;
}

void ayam::move(Cell&_c) {
    //int xa = FarmAnimal::getPosX();
    int x = rand()%(a+b-1);
    int y = rand()%(a+b-1);
    _c.setElement(posX,posY,' ');
    //cout<<" x , y "<<x<< " " <<y<<endl;
    this->posX+=x;
    this->posY +=y;
    while(this->posX>c || this->posY>d){
         this->posX -=2;
         this->posY -=1;
    }
    while (this->posX<a || this->posY<b){
            this->posX +=1;
            this->posY +=1;
        }
    
    //FarmAnimal::setPosX(xa);
    _c.setElement(posX,posY,'A');
    //cout<<"pos MOVE : "<< this->posX<<" " << this->posY<<endl;
    
    Full--;
}

void ayam::talk() {
    cout<<"Petok petokkk"<<endl;
}

void ayam::eat(Cell&_c) {
    if (_c.getRumput(this->posX,this->posY) == '*' ){
        countTelurA++;
        if (countTelurA > MAX)  {
        countTelurA = MAX;
        }
        Full =FULLMAX;
       // _c.setElement(posX,posY,'a');
        _c.kosongRumput(this->posX,this->posY);
        cout<<"Ayam makannn"<<endl;
    }
    
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

        
       
