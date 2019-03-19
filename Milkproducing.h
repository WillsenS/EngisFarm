#ifndef MILKPRODUCING_H
#define MILKPRODUCING_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"

using namespace std;

/**
 * Milkproducing class 
 * Class hewan penghasil susu ,kelas turunan dari farm animal
 * @author 13517090
 * @since 2019.03.17
 */

class Milkproducing :public FarmAnimal {
    private :
        static int jlhMilkP ;
    public :
        Milkproducing(int x,int y);
        ~Milkproducing();
        static int getjlhMilkP();
};
#endif