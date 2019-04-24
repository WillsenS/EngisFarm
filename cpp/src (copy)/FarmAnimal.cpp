#include <iostream>
#include <string>
//#include "LivingThings.h"
#include "FarmAnimal.h"

using namespace std;

int FarmAnimal::countAnimal = 0;

FarmAnimal::FarmAnimal(int x, int y) {
    posX = x;
    posY = y;
    //cout<<" pos awal : "<<posX<<" "<<posY<<endl;
    countAnimal++;   
    this->status = true;
}

FarmAnimal::~FarmAnimal() {
    cout << "One of your animals has died" << endl;
    countAnimal--;
}

int FarmAnimal::getCountAnimal() {
    return countAnimal;
}

void FarmAnimal::setPosX(int x) {
    posX = x;
}

void FarmAnimal::setPosY(int y) {
    posY = y;
}

int FarmAnimal::getPosX() {
    return posX;
}

int FarmAnimal::getPosY() {
    return posY;
}
bool FarmAnimal::getStatus(){
    return status;
}
void FarmAnimal::setStatus(bool cek){
    this->status = cek;
}
