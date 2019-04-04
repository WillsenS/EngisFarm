#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "sapi.h"
#include "Milkproducing.h"
#include "Meatproducing.h"

using namespace std;
const int a = 10;
const int b = 4;
const int c = 5;
const int d = 6;

sapi::sapi(int posX, int posY):FarmAnimal(posX, posY), Meatproducing(posX, posY), Milkproducing(posX, posY){
    Full=FULLMAX;
    countcowMilk=0;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
}

sapi::~sapi(){
    this->posX = 0;
    this->posY = 0;
    Full = 0;
    countcowMilk = 0;
    
    //cout<<"One of your cows has died"<<endl;
}

void sapi::move(Cell&_c) {
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

void sapi::talk(){
    cout<<"Moooo mooooo"<<endl;
}
void sapi::eat(Cell& _c){
    if (_c.getRumput(this->posX,this->posY)){
        Full=FULLMAX;
        countcowMilk++;
        if (countcowMilk >MAX){
            countcowMilk = MAX;
        }
        _c.setElement(posX,posY,' ');
    }
}

string sapi::getChar() {
    return "S";
}

string sapi::getProduct(){
    return "";
}

//void setProduct(string cowMilk);
int sapi::getcountcowMilk() const{
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
