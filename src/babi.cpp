#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Meatproducing.h"
#include "babi.h"
using namespace std;

const int randX =3;
const int randY =3;

const char t_rumput ='@';
const char tempat ='x';


babi::babi(int posX ,int posY):FarmAnimal(posX,posY), Meatproducing(posX,posY) {
    Full =FULLMAX;
    countPork=0;
    this->posX = FarmAnimal::getPosX();
    status = true;

}

babi::~babi() {
    //_c.setElement(posX,posY,' ')
    this->posX =0;
    this->posY =0;
    Full =0;
    countPork=0;
    //cout<<"One of your pigs has died"<<endl;
}

void babi::move(Cell&_c) {
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
    _c.setElement(posX,posY,'P');
    //cout<<"pos MOVE : "<< this->posX<<" " << this->posY<<endl;
    
    Full--;

}

void babi::talk() {
    cout<<"Nguikkk nguikk"<<endl;
}

void babi::eat(Cell& _c) {
    //char a = _c.getElement(this->posX,this->posY);
    if ((_c.getRumput(this->posX,this->posY)==t_rumput)){
        Full = FULLMAX;
        countPork++;
        if (countPork >MAX) {
        countPork = MAX;
        }
        _c.kosongRumput(this->posX,this->posY);
    } else{
        move(_c);
        if (Full <= dead){
            status =false;
            _c.setElement(posX,posY,' ');
            cout<<"One of your pigs has died"<<endl;
        }
    } 
    

}

string babi::getChar() {
    return "B";
}

string babi::getProduct() {
    return "";
}

//void setProduct(string pork);
int babi::getcountPork() const {
    return countPork;
}

int babi::getFull() {
    return Full;
}

void babi::setFull(int Full) {
    this->Full=Full;
}

void babi::Print() {
    cout<<"pig ada " <<countPork<<endl;
    cout<<"Full : "<< Full<<endl;
    cout<<"pos : "<< this->posX<<" " << this->posY<<endl;
}

/*void babi::setPosX(int x) {
    posX = x;
}

void babi::setPosY(int y) {
    posX = x;
}

int babi ::getPosX() {
    return posX;
}

int babi ::getPosY() {
    return posY;
}
*/
