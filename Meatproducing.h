#ifndef MEATPRODUCING_H
#define MEATPRODUCING_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
using namespace std;

class Meatproducing :public FarmAnimal {
    private :
        static int jlhMeatP ; // jumlah hewan daging
    public :
        Meatproducing(int x,int y);
        ~Meatproducing();
        static int getjlhMeatP();
};
#endif