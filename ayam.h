#ifndef AYAM_H
#define AYAM_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Eggproducing.h"
#include "Meatproducing.h"
using namespace std;
class Ayam : public Eggproducing,public Meatproducing{
    public:
        Ayam(int posX ,int posY);
        ~Ayam();
        void move (int posX , int posY);
        void talk();
        void eat();
        string getProduct();
        void setProduct(string telur);
        int getcountTelurA() const ;
        int getFull();

    private:
        bool hasEat;
        string telur;
        int posX;
        int posY;
        int countTelurA;
        int Full;
};
#endif
