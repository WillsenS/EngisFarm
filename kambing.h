#ifndef KAMBING_H
#define KAMBING_H

#include <iostream>
#include <string>
#include "FarmAnimal.h"
#include "Milkproducing.h"
#include "Meatproducing.h"
using namespace std;

class kambing : public Meatproducing,public Milkproducing{
    public:
        kambing(int posX ,int posY);
        ~kambing();
        void move ();
        void talk();
        void eat();
        string getProduct();
        //void setProduct(string goatMilk);
        int getcountcowMilk() const;
        int getFull();
        void setFull(int Full);
    private:
        bool hasEat;
        string goatMilk;
        int countgoatMilk;
        int posX;
        int posY;
        int Full;
};
#endif
