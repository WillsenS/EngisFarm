#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Meatproducing.h"
#include "babi.h"
using namespace std;

const int a = 10;
const int b = 4;
const int c =5;
const int d = 6;

babi::babi(int posX ,int posY):Meatproducing(posX,posY),FarmAnimal(posX,posY){
    Full =FULLMAX;
    countPork=0;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
}
babi::~babi(){
    this->posX =0;
    this->posY =0;
    Full =0;
    countPork=0;
    //cout<<"One of your pigs has died"<<endl;
}
void babi::move (){
    int x = rand()%(a+c-1);
    int y = rand()%(b+d-1);
    //cout<<" x , y "<<x<< " " <<y<<endl;
    this->posX+=x;
    this->posY +=y;
    while(this->posX>a){
         x = rand()%(a+b-1);
        //cout<<" x "<<x<<endl;
        while (this->posY>b){
            this->posY -=x;
        }
        this->posX -=x;
        if (this->posX <a){
            this->posX = this->posX + a;
        }
    }
    
    
}
void babi::talk(){
    cout<<"Nguikkk nguikk"<<endl;
}
void babi::eat(){
    Full = FULLMAX;
    countPork++;
    if (countPork >MAX){
	countPork = MAX;
	}
}
string babi::getProduct(){}
//void setProduct(string pork);
int babi::getcountPork() const{
    return countPork;
}
int babi::getFull(){
    return Full;
}
void babi::setFull(int Full){
    this->Full=Full;
}
void babi::Print(){
    cout<<"pig ada " <<countPork<<endl;
    cout<<"Full : "<< Full<<endl;
    cout<<"pos : "<< this->posX<<" " << this->posY<<endl;
}
/*void babi::setPosX(int x){
    posX = x;
}
void babi::setPosY(int y){
    posX = x;
}
int babi ::getPosX(){
    return posX;
}
int babi ::getPosY(){
    return posY;
}*/
