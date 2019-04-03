#ifndef BABI_H
#define BABI_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Meatproducing.h"
using namespace std;
class babi : public Meatproducing{
    public:
        babi(int posX ,int posY);
        ~babi();
        void move ();
        void talk();
        void eat();
        string getChar();
        string getProduct();
        //void setProduct(string pork);
        int getcountPork() const;
        int getFull();
        void setFull(int Full);
        void Print();
    private:
        bool hasEat;
        string pork;
        int countPork;
        int posX;
        int posY;
        int Full;
};
#endif
