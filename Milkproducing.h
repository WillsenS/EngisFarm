#ifndef MILKPRODUCING_H
#define MILKPRODUCING_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
using namespace std;

class Milkproducing :public FarmAnimal {
    private :
        static int jlhMilkP ; // jumlah hewan penghasil susu
    public :
        Milkproducing(int x,int y);
        ~Milkproducing();
        static int getjlhMilkP();
};
#endif