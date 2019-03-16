#ifndef SAPI_H
#define SAPI_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"

class sapi : public FarmAnimal{
    public:
        sapi(int posX ,int posY);
        ~sapi();
        void Move (int posX , int posY);
        void Talk();
        void eat();
        string getProduct();
        void setProduct(string cowMilk);
        static int getcountcowMilk;
    private:
        bool hasEat;
        string cowMilk;
        int countcowMilk;
	int posX;
	int posY;
};
#endif
