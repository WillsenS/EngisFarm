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

domba::domba(int posX ,int posY):Meatproducing(posX,posY),FarmAnimal(posX,posY){
    Full =FULLMAX;
    countlambMeat=0;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
}
domba::~domba(){
    this->posX =0;
    this->posY =0;
    Full =0;
    countlambMeat=0;
   // cout<<"One of your lambs has died"<<endl;
}
void domba::move (){
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
void domba::talk(){
    cout<<"Mbekk~~"<<endl;
}
void domba::eat(){
    Full = FULLMAX;
    countlambMeat++;
    if (countlambMeat >MAX){
	countlambMeat = MAX;
}
}
string domba::getProduct(){}
//void setProduct(string lambMeat);
int domba::getcountlambMeat() const{
    return countlambMeat;
}
int domba::getFull(){
    return Full;
}
void domba::setFull(int Full){
    this->Full=Full;
}
void domba::Print(){
    cout<<"LM ada " <<countlambMeat<<endl;
    cout<<"Full : "<< Full<<endl;
    cout<<"pos : "<< this->posX<<" " << this->posY<<endl;
}
