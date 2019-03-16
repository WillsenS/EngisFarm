#ifndef DOMBA_H
#define DOMBA_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"

Class domba : public FarmAnimal{
    public:
        domba(int posX ,int posY);
        ~domba();
        void Move (int posX , int posY);
        void Talk();
        void eat();
        string getProduct();
        void setProduct(string lambMeat);
        static int getcountlambMeat;
    private:
        bool hasEat;
        string lambMeat;
        int countlambMeat;
	int posX;
	int posY;
};
#endif
