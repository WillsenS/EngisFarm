#ifndef SAPI_H
#define SAPI_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Milkproducing.h"
#include "Meatproducing.h"
#include "Cell.h"
using namespace std;
class sapi : public Meatproducing,public Milkproducing{
    public:
        sapi(int posX ,int posY);
        ~sapi();
        void move (Cell& _c);
        void talk();
        void eat(Cell&_c);
        string getChar();
        void getProduct();
        //void setProduct(string cowMilk);
        int getCountCowMilk()const;
        int getFull();
        void setFull(int Full);
        void Print();
    private:
        bool hasEat;
        string cowMilk;
        int countcowMilk;
        int posX;
        int posY;
        int Full;
};
#endif
