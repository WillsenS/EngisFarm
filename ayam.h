#ifndef AYAM_H
#define AYAM_H

#include <iostream>
#include <string>
//#include "FarmAnimal.h"
#include "Eggproducing.h"
#include "Meatproducing.h"

/**
 * Ayamclass.
 * Class Ayam yang menunjukkan hal yang bisa dilakukan oleh ayam
 * @author 13517090
 * @since 2019.03.17
 */
using namespace std;
class ayam : public Eggproducing,public Meatproducing{
    public:
        ayam(int posX ,int posY); /// constructor
        ~ayam(); /// destructor
        void move ();
        void talk();
        void eat();
        string getProduct();
        //void setProduct(string telur);
        int getcountTelurA() const ; /// menghitung jumlah telur yang dihasilkan
        int getFull(); /// getter
        void setFull(int Full); ///setter
        //void Print();

    private:
        bool hasEat;
        string telur;
        int posX;
        int posY;
        int countTelurA;
        int Full;
};
#endif
