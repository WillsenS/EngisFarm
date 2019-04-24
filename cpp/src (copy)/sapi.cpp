#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "sapi.h"
#include "Milkproducing.h"
#include "Meatproducing.h"

using namespace std;
const int randX =3;
const int randY =3;

const char t_rumput ='#';
const char tempat ='-';
const char produk ='U';//susu sapi

sapi::sapi(int posX, int posY):FarmAnimal(posX, posY), Meatproducing(posX, posY), Milkproducing(posX, posY){
    Full=FULLMAX;
    countcowMilk=0;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
    status = true;
   // _c.setElement(posX,posY,'C') ;
}

sapi::~sapi(){
    //_c.setElement(posX,posY,' ')
    this->posX = 0;
    this->posY = 0;
    Full = 0;
    countcowMilk = 0;
    status = false;
    
    //cout<<"One of your cows has died"<<endl;
}

void sapi::move(Cell&_c) {
    //int xa = FarmAnimal::getPosX();
    srand(time(NULL));
    int x = rand()%(randX) - 1;
    int y = rand()%(randY) - 1;
    _c.setElement(posX,posY,' ');
    cout<<" x , y "<<x<< " " <<y<<endl;
     if(posX+x>=0 && posX+x<15 && posY+y>=0 && posY+y<15 &&status){
             if(_c.getTypeLand(this->posX+x,this->posY+y)==tempat)
                {
                    this->posX+=x;
                    this->posY+=y;
                }
    
     }

    //FarmAnimal::setPosX(xa);
    _c.setElement(posX,posY,'C');
    //cout<<"pos MOVE : "<< this->posX<<" " << this->posY<<endl;
    
    Full--;
}
void sapi::talk(){
    cout<<"Moooo mooooo"<<endl;
}
void sapi::eat(Cell& _c){
    if ((_c.getRumput(this->posX,this->posY)== t_rumput)){
        Full=FULLMAX;
        countcowMilk++;
        if (countcowMilk >MAX){
            countcowMilk = MAX;
        }
        _c.kosongRumput(this->posX,this->posY);
    } else {
        move(_c);
        if (Full <= dead){
            status = false;
            _c.setElement(posX,posY,' ');
            cout<<"One of your cows has died"<<endl;
        }
    }
}

string sapi::getChar() {
    return "S";
}

void sapi::getProduct(){
    countcowMilk = 0;
}

//void setProduct(string cowMilk);
int sapi::getCountCowMilk() const{
    return countcowMilk;
}

int sapi::getFull(){
    return Full;
}

void sapi::setFull(int Full){
    this->Full=Full;
}

void sapi::Print(){
    cout<<"CM ada " <<countcowMilk<<endl;
    cout<<"Full : "<< Full<<endl;
    cout<<"pos : "<< this->posX<<" " << this->posY<<endl;
}

/*void sapi::setPosX(int x){
    posX = x;
}

void sapi::setPosY(int y){
    posY= y;
}

int sapi ::getPosX(){
    return posX;
}

int sapi ::getPosY(){
    return posY;
}
*/
