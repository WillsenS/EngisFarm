#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Eggproducing.h"
using namespace std;

int Eggproducing::jlhEggP = 0;

Eggproducing::Eggproducing(int x, int y) : FarmAnimal(x,y) {
    jlhEggP++;
}

Eggproducing::~Eggproducing() {
    //cout<<"One of your eggproducing animal has died"<<endl;
    //jlhEggP--;
}

int Eggproducing::getjlhEggP() {
    return jlhEggP;
}