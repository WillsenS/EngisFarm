#include <iostream>
#include <string>
#include "stdlib.h"
#include "FarmAnimal.h"
#include "Eggproducing.h"
#include "Meatproducing.h"
#include "ayam.h"
#include <ctime>

using namespace std;

const int randX =3;
const int randY =3;

const char t_rumput ='*';
const char tempat ='o';
const char produk ='O';


ayam::ayam(int posX, int posY):FarmAnimal(posX, posY), Eggproducing(posX, posY), Meatproducing(posX, posY) {
    Full = FULLMAX;
    countTelurA = 0;
    //cout<<"Full : "<< Full<<endl;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
    status =true;


}

ayam::~ayam() {
   // _c.setElement(posX,posY,' ')
    this->posX =0;
    this->posY =0;
    Full =0;
    countTelurA=0;
   // cout<<"One of your chickens has died"<<endl;
}

void ayam::move(Cell&_c) {
    //int xa = FarmAnimal::getPosX();
    srand(time(NULL));
    int x = rand()%(randX) - 1;
    int y = rand()%(randY) - 1;
    _c.setElement(posX,posY,' ');
    cout<<" x , y "<<x<< " " <<y<<endl;
     if(posX+x>=0 && posX+x<15 && posY+y>=0 && posY+y<15&&status){
             if(_c.getTypeLand(this->posX+x,this->posY+y)==tempat)
                {
                    this->posX+=x;
                    this->posY+=y;
                }
    
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
    if (_c.getRumput(this->posX,this->posY) == t_rumput){
        countTelurA++;
        if (countTelurA > MAX)  {
        countTelurA = MAX;
        }
        Full =FULLMAX;
       // _c.setElement(posX,posY,'a');
        _c.kosongRumput(this->posX,this->posY);
        //cout<<"Ayam makannn"<<endl;
    } else{
        move(_c);
        if (Full <= dead){
            status =false;
            _c.setElement(posX,posY,' ');
            cout<<"One of your chickens has died"<<endl;
        }
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

        
       
