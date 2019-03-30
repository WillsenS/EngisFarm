#ifndef BEBEK_H
#define BEBEK_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Eggproducing.h"
#include "Meatproducing.h"
using namespace std;

class bebek : public Eggproducing,public Meatproducing{
    public:
        bebek(int posX ,int posY);
        ~bebek();
        void move ();
        void talk();
        void eat();
        string getProduct();
        //void setProduct(string telur);
        int getcountTelurB()const;
        int getFull();
        void setFull(int Full);
        void Print();
    private:
        bool hasEat;
        string telur;
        int countTelurB;
        int posX;
        int posY;
        int Full;
};
#endif
