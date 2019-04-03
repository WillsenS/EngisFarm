#ifndef EGGPRODUCING_H
#define EGGPRODUCING_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
using namespace std;
class Eggproducing :virtual public FarmAnimal{
    private :
        static int jlhEggP ;// jumlah hewan petelur
    public :
        Eggproducing(int x,int y);
        ~Eggproducing();
        static int getjlhEggP();
    
};
#endif