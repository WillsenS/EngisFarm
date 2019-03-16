#ifndef BABI_H
#define BABI_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"

class babi : public FarmAnimal{
    public:
        babi(int posX ,int posY);
        ~babi();
        void Move (int posX , int posY);
        void Talk();
        void eat();
        string getProduct();
        void setProduct(string pork);
        static int getcountPork;
    private:
        bool hasEat;
        string pork;
        int countPork;
	int posX;
	int posY;
};
#endif
