#include <iostream>
#include "LinkedList.h"
#include "Player.h"
#include "Cell.h"
#include "Product.h"
using namespace std;

//Constructor
Player::Player(int x, int y, Cell& _c) {
    posX = x;
    posY = y;
    water = 0;  
    money = 0;
    _c.setElement(posX, posY, 'P');
    LinkedList<char> inventory = new LinkedList<char>();
}

Player::~Player() {
    cout<<"THE END"<<endl;
}

void Player::talk() {
    cout<<"Player : Halo"<<endl;
    cout<<"Player now in "<< posX << " " << posY <<endl;

}

void Player::print() {
    cout << "Player Info" << endl;
    cout << "Position: " << posX << ", " << posY << endl;
    cout << "Water: " << water << endl;
    cout << "Money: " << money << endl;
}

int Player::getPosX() {
    return posX;
}

int Player::getPosY() {
    return posY;
}

void Player::move (Cell& _c) {
    char cc;
    cout << "Select Move : ";
    cin >> cc;
    switch (cc){
        case 'w' :  
            if(posX-1>=0 && posX-1<15 && posY>=0 && posY<15){
                if(_c.getElement(posX-1, posY)==' '){
                    _c.setElement(posX, posY, ' ');
                    posX--;
                    _c.setElement(posX, posY, 'P');
                }else{
                    cout << "Ada Sesuatu" << endl;
                }
            }
            break;
        case 'a' :
            if(posX>=0 && posX<15 && posY-1>=0 && posY-1<15){ 
                if(_c.getElement(posX, posY-1)==' '){ 
                    _c.setElement(posX, posY, ' ');
                    posY--;
                    _c.setElement(posX, posY, 'P');
                }else{
                    cout << "Ada Sesuatu" << endl;
                }
            }
            break;
        case 's' :  
            if(posX+1>=0 && posX+1<15 && posY>=0 && posY<15){
                if(_c.getElement(posX+1, posY)==' '){
                    _c.setElement(posX, posY, ' ');
                    posX++;
                    _c.setElement(posX, posY, 'P');
                }else{
                    cout << "Ada Sesuatu" << endl;
                }
            }
            break;
        case 'd' :  
            if(posX>=0 && posX<15 && posY+1>=0 && posY+1<15){
                if(_c.getElement(posX, posY+1)==' '){
                    _c.setElement(posX, posY, ' ');
                    posY++;
                    _c.setElement(posX, posY, 'P');
                }else{
                    cout << "Ada Sesuatu" << endl;
                }
            }
            break;
        default:
            cout << "Invalid command" << endl;
    }
}

void Player::interact(Facility &_f) {
    int WellX = _f.getWellx();
    int WellY = _f.getWelly();
    // int MixerX = _f.getMixerx();
    // int MixerY = _f.getMixery();
    // int TruckX = _f.getTruckx();
    // int TruckY = _f.getTrucky();

    //Interact dengan well
    if((((posX + 1) == WellX) || ((posX - 1) == WellX)) || (((posY + 1) == WellY) || ((posY - 1) == WellY))) {
        water = 10;
    }
}

//  //Interact dengan Truck
//  if((((posX + 1) == TruckX) || ((posX - 1) == TruckX)) && (((posY + 1) == TruckY) || ((posY - 1) == TruckY))) {
//      if (LinkedList::isEmpty()) {
//          //Do Nothing / pesan error
//      }
//      else {
//          while !(LinkedList::isEmpty()) {
//              money += SideProduct::getProductValue(LinkedList::get(0));
//              LinkedList::remove(LinkedList::get(0));
//          }
//      }
//  }

//  //Interact dengan Mixer
//  if((((posX + 1) == MixerX) || ((posX - 1) == MixerX)) && (((posY + 1) == MixerY) || ((posY - 1) == MixerY))) {
//      //campur bahannya
//      //masukin inventory
//  }   

//  //Interact dengan FarmAnimal
//  {
//      //ayam(A)
//      if((Cell::getElement(posX+1,posY) == "A") || (Cell::getElement(posX-1,posY) == "A") || (Cell::getElement(posX,posY+1) == "A") || (Cell::getElement(posX,posY-1) == "A"))
//          ChickenEgg::ChickenEgg();
//          inventory.add(chicken::getProduct());
//      //bebek(B)
//      if((Cell::getElement(posX+1,posY) == "B") || (Cell::getElement(posX-1,posY) == "B") || (Cell::getElement(posX,posY+1) == "B") || (Cell::getElement(posX,posY-1) == "B"))
//          DuckEgg::DuckEgg();
//          inventory.add(bebek::getProduct());
//      //kambing(K)
//      if((Cell::getElement(posX+1,posY) == "K") || (Cell::getElement(posX-1,posY) == "K") || (Cell::getElement(posX,posY+1) == "K") || (Cell::getElement(posX,posY-1) == "K"))
//          GoatMilk::GoatMilk();
//          inventory.add(kambing::getProduct());
//      //Sapi(S)
//      if((Cell::getElement(posX+1,posY) == "S") || (Cell::getElement(posX-1,posY) == "S") || (Cell::getElement(posX,posY+1) == "S") || (Cell::getElement(posX,posY-1) == "S"))
//          CowMilk::CowMilk();
//          inventory.add(sapi::getProduct());
//  }
// }

// void Player::Kill() {
//  //kill animalnya
//  //dapeting dagingnya
//      //ayam(A)
//      if((Cell::getElement(posX+1,posY) == "A") || (Cell::getElement(posX-1,posY) == "A") || (Cell::getElement(posX,posY+1) == "A") || (Cell::getElement(posX,posY-1) == "A"))
//          ChickenMeat::ChickenMeat();
//          inventory.add("ChickenMeat");
//          ayam::~ayam();
//      //bebek(B)
//      if((Cell::getElement(posX+1,posY) == "B") || (Cell::getElement(posX-1,posY) == "B") || (Cell::getElement(posX,posY+1) == "B") || (Cell::getElement(posX,posY-1) == "B"))
//          DuckMeat::DuckMeat();
//          inventory.add("DuckMeat");
//          bebek::~bebek();
//      //babi(b)
//      if((Cell::getElement(posX+1,posY) == "b") || (Cell::getElement(posX-1,posY) == "b") || (Cell::getElement(posX,posY+1) == "b") || (Cell::getElement(posX,posY-1) == "b"))
//          Pork::Pork();
//          inventory.add("Pork");
//          babi::~babi();
//      //domba(D)
//      if((Cell::getElement(posX+1,posY) == "D") || (Cell::getElement(posX-1,posY) == "D") || (Cell::getElement(posX,posY+1) == "D") || (Cell::getElement(posX,posY-1) == "D"))
//          LambMeat::LambMeat();
//          inventory.add("LambMeat");
//          domba::~domba();
//      //kambing(K)
//      if((Cell::getElement(posX+1,posY) == "K") || (Cell::getElement(posX-1,posY) == "K") || (Cell::getElement(posX,posY+1) == "K") || (Cell::getElement(posX,posY-1) == "K"))
//          GoatMeat::GoatMeat();
//          inventory.add("GoatMeat");
//          kambing::~kambing();
//      //Sapi(S)
//      if((Cell::getElement(posX+1,posY) == "S") || (Cell::getElement(posX-1,posY) == "S") || (Cell::getElement(posX,posY+1) == "S") || (Cell::getElement(posX,posY-1) == "S"))
//          CowMeat::CowMeat();
//          inventory.add("CowMeat");
//          sapi::~sapi();
// }

void Player::Grow(Cell &_c) {
    if (water > 0) {
        //Mengisi petak cell dengan notasi rumput
        if(_c.getRumput(posX, posY) == ' '){
            _c.setRumput(posX, posY);
            water--;
        }
        else {
            //udah ada rumput, jadi do nothing/pesen error
            cout << "Can't grow anymore!" << endl; 
        }
    }
    else {
        //gaada air, sana pergi ke well
        cout << "Sufficient water!" << endl;
    }
    this->print();
}
