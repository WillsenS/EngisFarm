#include <iostream>
#include <string>
#include "FarmAnimal.h"

#include "Meatproducing.h"
#include "domba.h"

using namespace std;

const int randX =3;
const int randY =3;

const char t_rumput ='@';
const char tempat ='x';

domba::domba(int posX, int posY):FarmAnimal(posX, posY), Meatproducing(posX, posY) {
    Full = FULLMAX;
    countlambMeat = 0;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
    status = true;
    //_c.setElement(posX,posY,'S') ;
}

domba::~domba() {
    //_c.setElement(posX,posY,' ')
    this->posX = 0;
    this->posY = 0;
    Full = 0;
    countlambMeat = 0;
   // cout << "One of your lambs has died" << endl;
}

void domba::move(Cell&_c) {
    //int xa = FarmAnimal::getPosX();
    srand(time(NULL));
    int x = rand()%(randX) - 1;
    int y = rand()%(randY) - 1;
    //_c.setElement(posX,posY,' ');
    cout<<" x , y "<<x<< " " <<y<<endl;
     if(posX+x>=0 && posX+x<15 && posY+y>=0 && posY+y<15&&status){
             if(_c.getTypeLand(this->posX+x,this->posY+y)==tempat)
                {
                    this->posX+=x;
                    this->posY+=y;
                }
    
     }

    //FarmAnimal::setPosX(xa);
    _c.setElement(posX,posY,'S');
    //cout<<"pos MOVE : "<< this->posX<<" " << this->posY<<endl;
    
    Full--;
}

void domba::talk() {
    cout << "Mbekk~~" << endl;
}

void domba::eat(Cell& _c) {
    if((_c.getRumput(this->posX,this->posY)== t_rumput)){
        Full = FULLMAX;
        countlambMeat++;
        if (countlambMeat >MAX) {
        countlambMeat = MAX;
        }
        _c.kosongRumput(this->posX,this->posY);
    } else {
        move(_c);
        if (Full <= dead){
            status =false;
            _c.setElement(posX,posY,' ');
            cout<<"One of your lambs has died"<<endl;
        }        
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
