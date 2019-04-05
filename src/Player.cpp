#include <iostream>
#include <cstring>
#include "LinkedList.cpp"
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
    LinkedList<string> inventory;
}

Player::~Player() {
    // cout<<"THE END"<<endl;
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
    inventory.print();
}

int Player::getPosX() {
    return posX;
}

int Player::getPosY() {
    return posY;
}

int Player::getMoney() {
    return money;
}

int Player::getWater() {
    return water;
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

int Player::getInteractType(Facility &_f) {
    if (isAdjacent(_f.getWellX(), _f.getWellY()) ||
        isAdjacent(_f.getMixerX(), _f.getMixerY()) ||
        isAdjacent(_f.getTruckX(), _f.getTruckY())) {
        return 0;
    }

    return 1;
}

bool Player::isAdjacent(int x, int y ) {
    if (((posX + 1) == x) ||
        ((posX - 1) == x) ||
        ((posY + 1) == y) ||
        ((posY - 1) == y)) {
        return true;
    }

    return false;
}

void Player::interact(Facility &_f) {
    int interactType = this->getInteractType(_f);
    if (interactType == 0) {
        this->interactFacility(_f);
    } else {
        // Interact Animal
    }
}

void Player::interactFacility(Facility &_f) {
    if (isAdjacent(_f.getWellX(), _f.getWellY())) {
        water = 10;
    } else if (isAdjacent(_f.getMixerX(), _f.getMixerY())) {
        // Interact Mixed
    } else if (isAdjacent(_f.getTruckX(), _f.getTruckY())) {
        if(inventory.isEmpty()){
            cout << "Inventory Kosong" << endl;
        }else{
            string isi;
            while(!inventory.isEmpty()){
                isi = inventory.get(0);
                inventory.remove(isi);
                if ( strcmp(isi.c_str(),"ChickenMeat")==0 ){
                    money += 4;
                }else if(strcmp(isi.c_str(), "ChickenEgg") == 0){
                    money += 3;
                }else if(strcmp(isi.c_str(), "DuckMeat") == 0){
                    money += 5;
                }else if(strcmp(isi.c_str(), "DuckEgg") == 0){
                    money += 4;
                }else if(strcmp(isi.c_str(), "CowMeat") == 0){
                    money += 6;
                }else if(strcmp(isi.c_str(), "CowMilk") == 0){
                    money += 4;
                }else if(strcmp(isi.c_str(), "GoatMeat") == 0){
                    money += 5;
                }else if(strcmp(isi.c_str(), "GoatMilk") == 0){
                    money += 3;
                }else if(strcmp(isi.c_str(), "LambMeat") == 0){
                    money += 5;
                }else if(strcmp(isi.c_str(), "Omelette") == 0){
                    money += 3;
                }else if(strcmp(isi.c_str(), "Pork") == 0){
                    money += 5;
                }else if(strcmp(isi.c_str(), "Sausage") == 0){
                    money += 5;
                }
            }
            cout << "Truck Succes" << endl;
        }
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

void Player::Kill(Cell &_c/*,  vector<FarmAnimal*>& animals*/) {
 //kill animalnya
 //dapeting dagingnya
    int cc;
    cout << "Select Side to Kill" << endl;
    cout << "1. Atas    2. Bawah" << endl;
    cout << "3. Kiri    4. Kanan" << endl;
    cin >> cc;
    switch(cc){
        case 1 :
            cekhewan(posX-1, posY, _c);
<<<<<<< HEAD
            animals.setStatus(false);
=======
            // vector<FarmAnimal*>::iterator it;
            // for(it = animals.begin(); it!=animals.end(); ++it){
            //     if(animals.posX == this->posX-1 && animals.posY == this->posY){
            //         (*it)->setStatus(0);
            //     }
            // }
>>>>>>> truck, kill belum bisa
            break;
        case 2 :
            cekhewan(posX+1, posY, _c);
            break;
        case 3 :
            cekhewan(posX, posY-1, _c);
            break;
        case 4 :
            cekhewan(posX, posY+1, _c);
            break;
        default :
            cout << "Command Salah" << endl;
    }
     
}

void Player::cekhewan(int x, int y, Cell &_c){
    //ayam(A)
     if(_c.getElement(x,y) == 'A'){
         ChickenMeat a = ChickenMeat();
         inventory.add("ChickenMeat");
        //  ayam::~ayam();
     }
     //bebek(B)
     else if(_c.getElement(x,y) == 'B'){
         DuckMeat a = DuckMeat();
         inventory.add("DuckMeat");
        //  bebek::~bebek();
     } 
     //babi(b)
     else if(_c.getElement(x,y) == 'Z'){
         Pork a = Pork();
         inventory.add("Pork");
        //  babi::~babi();
     } 
     //domba(D)
     else if(_c.getElement(x,y) == 'D'){
         LambMeat a = LambMeat();
         inventory.add("LambMeat");
        //  domba::~domba();
     }
     //kambing(G)
     else if(_c.getElement(x,y) == 'G'){
         GoatMeat a = GoatMeat();
         inventory.add("GoatMeat");
        //  kambing::~kambing();
     }
     //Sapi(C)
     else if(_c.getElement(x,y) == 'C'){
         CowMeat a = CowMeat();
         inventory.add("CowMeat");
        //  sapi::~sapi();
     }else{
         cout << "Kosong" << endl;
     }   
     this->print();
}

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
        cout << "insufficient water!" << endl;
    }
    this->print();
}
