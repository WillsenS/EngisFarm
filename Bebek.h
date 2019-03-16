#ifndef BEBEK_H
#define BEBEK_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"

class bebek : public FarmAnimal{
    public:
        bebek(int posX ,int posY);
        ~bebek();
        void Move (int posX , int posY);
        void Talk();
        void eat();
        string getProduct();
        void setProduct(string telur);
        static int getcountTelurB;
    private:
        bool hasEat;
        string telur;
        int countTelurB;
	int posX;
	int posY;
};
#endif
