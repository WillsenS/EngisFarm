#ifndef MEATPRODUCING_H
#define MEATPRODUCING_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
using namespace std;

/**
 * Meatproducing class 
 * Class hewan penghasil daging,kelas turunan dari farm animal
 * @author 13517090
 * @since 2019.03.17
 */

class Meatproducing :virtual public FarmAnimal {
    private :
        static int jlhMeatP ; 
    public :
        Meatproducing(int x,int y);
        ~Meatproducing();
        static int getjlhMeatP();
};
#endif