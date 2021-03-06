#ifndef BEBEK_H
#define BEBEK_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Eggproducing.h"
#include "Meatproducing.h"
#include "Cell.h"
using namespace std;

class bebek : public Eggproducing, public Meatproducing{
    public:
        bebek(int posX ,int posY);
        ~bebek();
        void move (Cell& _c);
        void talk();
        void eat(Cell&_c);
        string getChar();
        void getProduct();
        //void setProduct(string telur);
        int getCountTelur()const;
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
