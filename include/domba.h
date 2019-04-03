#ifndef DOMBA_H
#define DOMBA_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Meatproducing.h"
using namespace std;
class domba : public Meatproducing{
    public:
        domba(int posX ,int posY);
        ~domba();
        void move ();
        void talk();
        void eat();
        string getProduct();
        //void setProduct(string lambMeat);
        int getcountlambMeat()const;
        int getFull();
        void setFull(int Full);
        void Print();
    private:
        bool hasEat;
        string lambMeat;
        int countlambMeat;
        int posX;
        int posY;
        int Full;
};
#endif
