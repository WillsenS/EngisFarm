#ifndef KAMBING_H
#define KAMBING_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"

class kambing : public FarmAnimal{
    public:
        kambing(int posX ,int posY);
        ~kambing();
        void Move (int posX , int posY);
        void Talk();
        void eat();
        string getProduct();
        void setProduct(string goatMilk);
        static int getcountcowMilk;
    private:
        bool hasEat;
        string goatMilk;
        int countgoatMilk;
	int posX;
	int posY;
};
#endif
