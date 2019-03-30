#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Meatproducing.h"

using namespace std;

int Meatproducing::jlhMeatP =0;

Meatproducing::Meatproducing(int x,int y) : FarmAnimal(x,y){
    jlhMeatP++;
}

Meatproducing::~Meatproducing(){
    //cout<<"One of your meat producing animal has died"<<endl;
}

int Meatproducing::getjlhMeatP(){
    return jlhMeatP;
}