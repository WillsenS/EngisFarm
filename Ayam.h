#ifndef AYAM_H
#define AYAM_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"

class Ayam : public FarmAnimal{
    public:
        Ayam(int posX ,int posY);
        ~Ayam();
        void Move (int posX , int posY);
        void Talk();
        void eat();
        string getProduct();
        void setProduct(string telur);
        static int getcountTelurA;
    private:
        bool hasEat;
        string telur;
	int posX;
	int posY;
        int countTelurA;
};
#endif
