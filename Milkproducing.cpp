#include <iostream>
#include <string>
#include "Milkproducing.h"

using namespace std;
int Milkproducing :: jlhMilkP =0;

Milkproducing::Milkproducing(int x,int y) : FarmAnimal(x,y){
    jlhMilkP++;
}
Milkproducing::~Milkproducing(){
    //cout<<"One of your Milkproducing animal has died"<<endl;
}
int Milkproducing:: getjlhMilkP(){
    return jlhMilkP;

}
 