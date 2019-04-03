#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "kambing.h"
#include "Milkproducing.h"
#include "Meatproducing.h"

using namespace std;
const int a = 10;
const int b = 4;
const int c =5;
const int d = 6;

kambing::kambing(int posX , int posY):FarmAnimal(posX, posY), Meatproducing(posX, posY), Milkproducing(posX, posY) {
    Full = FULLMAX;
    countgoatMilk=0;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
}

kambing::~kambing() {
    this->posX = 0;
    this->posY = 0;
    Full =0;
    countgoatMilk=0;
    //cout<<"One of your goats has died"<<endl;
}

void kambing::move () {
    int x = rand()%(a+c-1);
    int y = rand()%(b+d-1);
    //cout<<" x , y "<<x<< " " <<y<<endl;
    this->posX+=x;
    this->posY +=y;
    while(this->posX>a) {
         x = rand()%(a+b-1);
        //cout<<" x "<<x<<endl;
        while (this->posY>b) {
            this->posY -=x;
        }
        this->posX -=x;
        if (this->posX <a) {
            this->posX = this->posX + a;
        }
    }
}
void kambing::talk() {
    cout<<"Mbekkkk mbeek"<<endl;
}

void kambing::eat() {
    Full = FULLMAX;
    countgoatMilk++;
    if (countgoatMilk > MAX) {
        countgoatMilk = MAX;
    }
}

string kambing::getChar() {
    return "K";
}

string kambing::getProduct() {
    return "";
}

//void setProduct(string goatMilk);
int kambing::getcountgoatMilk() const {
    return countgoatMilk;
}

int kambing::getFull() {
    return Full;
}

void kambing::setFull(int Full) {
    this->Full=Full;
}

void kambing::Print() {
    cout<<"GM ada " <<countgoatMilk<<endl;
    cout<<"Full : "<< Full<<endl;
    cout<<"pos : "<< this->posX << " " << this->posY<<endl;
}

/*void kambing::setPosX(int x) {
    posX = x;
}

void kambing::setPosY(int y) {
    posY= y;
}

int kambing ::getPosX() {
    return posX;
}

int kambing ::getPosY() {
    return posY;
}
*/
