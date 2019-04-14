#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Eggproducing.h"
#include "Meatproducing.h"
#include "bebek.h"

using namespace std;

const int randX =3;
const int randY =3;
const char t_rumput ='*';
const char tempat ='o';
const char produk ='L';//telur bebek

bebek :: bebek(int posX, int posY): FarmAnimal(posX, posY), Eggproducing(posX, posY), Meatproducing(posX, posY) {
    Full = FULLMAX;
    countTelurB =0;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
    status = true;
    //_c.setElement(posX,posY,'B') ;
}

bebek:: ~bebek() {
    //_c.setElement(posX,posY,' ')
    this->posX = 0;
    this->posY = 0;
    Full = 0;
    countTelurB= 0;
    //cout<<"One of your duck has died"<<endl;
    //FarmAnimal::~FarmAnimal();
}

void bebek::move(Cell&_c) {
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
    _c.setElement(posX,posY,'B');
    //cout<<"pos MOVE : "<< this->posX<<" " << this->posY<<endl;
    
    Full--;
}

void bebek::talk() {
    cout << "Qwek ... qwek" << endl;

}

void bebek::eat(Cell& _c) {
    if ((_c.getRumput(this->posX,this->posY)==t_rumput)){
        countTelurB++;
        Full = FULLMAX;
        if (countTelurB > MAX)  {
        countTelurB = MAX;
        }
        _c.kosongRumput(this->posX,this->posY);
    } else{
        move(_c);
        if (Full <= dead){
            status =false;
            _c.setElement(posX,posY,' ');
            cout<<"One of your ducks has died"<<endl;
        }
    }
}

string bebek::getChar() {
    return "b";
}

void bebek::getProduct() {
    countTelurB = 0;
}

//void setProduct(string telur);
int bebek::getCountTelur()const {
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
