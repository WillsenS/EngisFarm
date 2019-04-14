#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "kambing.h"
#include "Milkproducing.h"
#include "Meatproducing.h"

using namespace std;

const int randX =3;
const int randY =3;

const char t_rumput ='#';
const char tempat ='-';
const char produk ='M';//susu kambing

kambing::kambing(int posX , int posY):FarmAnimal(posX, posY), Meatproducing(posX, posY), Milkproducing(posX, posY) {
    Full = FULLMAX;
    countgoatMilk=0;
    this->posX = FarmAnimal::getPosX();
    this->posY = FarmAnimal::getPosY();
    status = true;
    //_c.setElement(posX,posY,'G') ;
}

kambing::~kambing() {
    //_c.setElement(posX,posY,' ') ;
    this->posX = 0;
    this->posY = 0;
    Full =0;
    countgoatMilk=0;
    //cout<<"One of your goats has died"<<endl;
}

void kambing::move(Cell&_c) {
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
    _c.setElement(posX,posY,'G');
    //cout<<"pos MOVE : "<< this->posX<<" " << this->posY<<endl;
    
    Full--;
}
void kambing::talk() {
    cout<<"Mbekkkk mbeek"<<endl;
}

void kambing::eat(Cell& _c) {
    if ((_c.getRumput(this->posX,this->posY)==t_rumput)){
        Full = FULLMAX;
        countgoatMilk++;
        if (countgoatMilk > MAX) {
            countgoatMilk = MAX;
        }
        _c.kosongRumput(this->posX,this->posY);
    } else {
        move(_c);
        if (Full <= dead){
            status =false;
            _c.setElement(posX,posY,' ');
            cout<<"One of your goats has died"<<endl;
        }
    }
}

string kambing::getChar() {
    return "K";
}

void kambing::getProduct() {
    countgoatMilk = 0;
}

//void setProduct(string goatMilk);
int kambing::getCountGoatMilk() const {
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
