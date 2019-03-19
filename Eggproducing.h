#ifndef EGGPRODUCING_H
#define EGGPRODUCING_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
using namespace std;
/**
 * Eggproducing class 
 * Class hewan penghasil telur ,kelas turunan dari farm animal
 * @author 13517090
 * @since 2019.03.17
 */
class Eggproducing :virtual public FarmAnimal{
    private :
        static int jlhEggP ;/* menghitung jumlah hewan petelur*/
    public :
        Eggproducing(int x,int y);/* constructor*/
        ~Eggproducing();/*destructor*/
        static int getjlhEggP();
    
};
#endif